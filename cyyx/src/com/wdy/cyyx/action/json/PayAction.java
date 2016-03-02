package com.wdy.cyyx.action.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.unionpay.acp.sdk.SDKConstants;
import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.common.WxPayReqData;
import com.wdy.cyyx.entity.Address;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Grounp;
import com.wdy.cyyx.entity.Jflog;
import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.entity.Order;
import com.wdy.cyyx.entity.Order.OrderType;
import com.wdy.cyyx.entity.Order.PaymentStatus;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.AddressService;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.GrounpService;
import com.wdy.cyyx.service.JflogService;
import com.wdy.cyyx.service.MygrounpService;
import com.wdy.cyyx.service.OrderService;
import com.wdy.cyyx.service.ProductService;
import com.wdy.cyyx.util.OrderUtil;
import com.wdy.cyyx.util.StringUtils;
import com.wdy.cyyx.util.WxPayUtil;
import com.wdy.cyyx.util.WxSignature;

public class PayAction extends BaseAction {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private String thesize;
	private String address;
	private String gid;// 团购id
	private String phone;
	private String name;
	private int num;
	private String tt;// 领取的类型
	private String ptype;
	private String addressid;
	private Integer pid;

	@Resource
	private MygrounpService mygrounpService;
	@Resource
	private ProductService productService;
	@Resource
	private CustomerService customerService;
	@Resource
	private GrounpService grounpService;
	@Resource
	private OrderService orderService;
	@Resource
	private AddressService addressService;
	@Resource
	private JflogService jflogService;

	public String tuan() throws Exception {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);

		if (StringUtils.isEmpty(addressid)) {
			return ajaxJsonErrorMessage("请选择一个地址!");
		}
		Address address = addressService.get(addressid);
		if (address == null || address.getUserid() != userid) {
			return ajaxJsonErrorMessage("地址选择错误!");
		}

		if (StringUtils.isEmpty(ptype)) {
			return ajaxJsonErrorMessage("请选择支付方式");
		}
		Customer customer = customerService.get(userid);
		Mygrounp mygrounp = null;
		Product product = null;
		if (StringUtils.isNotEmpty(gid)) {
			mygrounp = mygrounpService.get(gid);
			if (mygrounp == null) {
				return ajaxJsonErrorMessage("不存在该团!");
			}
			product = productService.get(mygrounp.getProductid());
			// 如果是领取的单，要判断一下是不是可以领取了
			if (tt != null && tt.equals("zutuan")) {
				if (mygrounp.getMasterid() != userid
						|| (mygrounp.getNum() < mygrounp.getMinnum())) {
					return ajaxJsonErrorMessage("尚未符合领取要求!");
				}
				if (mygrounp.getIsget() == 1 && mygrounp.getOrderid() != null) {
					return ajaxJsonSuccessMessage(mygrounp.getOrderid());
				}
			}
		} else {
			product = productService.get(pid);
		}
		
		SystemClass owner = getFrontSystemClass();
		String ordersn = OrderUtil.creatSn(userid + "");
		Calendar calendar = Calendar.getInstance();

		Order order = new Order();
		if (ptype.equals("wx")) {
			order.setPaytype(0);
		} else if (ptype.equals("point")) {
			order.setPaytype(1);
		} else if (ptype.equals("free")) {// 免费领取的
			order.setPaytype(2);
		} else {
			return ajaxJsonErrorMessage("支付方式错误");
		}

		order.setNum(num);
		order.setPaymentStatus(PaymentStatus.unpaid);
		if (tt.equals("tuangou")) {// 用户直接团购的
			order.setOrderType(OrderType.tuangou);
			if (ptype.equals("wx")) {// 如果是微信支付的
				order.setMoney(product.getTgmoney() * num);
				order.setPoint(0.00);
				if (mygrounp != null) {// 如果那人是直接下单的
					// 获取本次订单的上级
					Grounp grounp = grounpService.get(mygrounp.getId() + "-"
							+ userid);
					if (grounp != null && grounp.getRecommenid() != null) {
						Customer upuser = customerService.get(grounp
								.getRecommenid());
						order.setUpuserid(upuser.getCid());
						order.setUpusercomm(product.getTgmoney() * num
								* product.getJfOne() / 100);
					}
				}else if(pid!=null){
					try {
						// 获取本次订单的上级
						Grounp grounp = grounpService.get(new QueryParam(2).add("productid", pid).add("userid", userid), false);
						if (grounp != null && grounp.getRecommenid() != null) {
							Customer upuser = customerService.get(grounp
									.getRecommenid());
							order.setUpuserid(upuser.getCid());
							order.setUpusercomm(product.getTgmoney() * num
									* product.getJfOne() / 100);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}

			} else {// 积分支付
				order.setMoney(0.00);
				order.setPoint(product.getTgmoney() * num);
				if (product.getTgmoney() * num > customer.getPoint()) {
					return ajaxJsonErrorMessage("积分不足!");
				}
				order.setPaymentStatus(PaymentStatus.paid);
			}

		} else if (tt.equals("zutuan")) {// 组团成功不用直接送的
			order.setPaymentStatus(PaymentStatus.paid);
			order.setOrderType(OrderType.zutuan);
			order.setMoney(0);
			order.setNum(1);
		} else if (tt.equals("pingdan")) {// 组团不成功的价格
			order.setOrderType(OrderType.pingdan);
			if (mygrounp.getFailpay() <= 0) {
				order.setPaymentStatus(PaymentStatus.paid);
			}
			order.setMoney(mygrounp.getFailpay());
			// order.setMoney(product.getZlmoney());
			order.setNum(1);
		} else {
			return ajaxJsonErrorMessage("订单类型错误!");
		}

		order.setAddress(address.getAddress());
		order.setOrderSn(ordersn);

		order.setUserid(userid);
		order.setWeixinid(customer.getWeixinid());
		order.setCreateDate(calendar.getTime().getTime());
		order.setPhone(address.getPhone());
		order.setName(address.getName());
		order.setOrigin(gid);
		order.setSystemid(owner.getCid());
		order.setPage(product.getPic());
		order.setPageName(product.getName());
		order.setSize(thesize);
		orderService.save(order);
		if (order.getPaytype() == 0) {// 微信支付
			calendar.add(Calendar.HOUR, 3);
			// 微信预订单
			String preid = WxPayUtil.unifiedorder(new WxPayReqData(owner
					.getAppId(), owner.getMchid(), "shop", "attach", order
					.getId(), (int) (order.getMoney() * 100),
					"182.254.226.146", sdf.format(order.getCreateDate()), sdf
							.format(calendar.getTime()), "http://"
							+ owner.getCid() + "." + Const.BASE_URL
							+ "/json/pay!wxnotify.action", customer
							.getWeixinid(), owner.getWxpaySecret()));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("appId", owner.getAppId());
			map.put("nonceStr", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
			map.put("package", "prepay_id=" + preid);
			map.put("signType", "MD5");
			map.put("timeStamp", "1");
			String paySign = WxSignature.getSign(map, owner.getWxpaySecret());
			return ajaxJson("{\"success\":true,\"preid\":\"" + preid
					+ "\",\"paySign\":\"" + paySign + "\",\"oid\":\""
					+ order.getId() + "\"}");
		} else if (order.getPaytype() == 1) {
			customer.setPoint(customer.getPoint() - order.getPoint());
			customerService.update(customer);
			// 记录一下积分
			Jflog jflog = new Jflog();
			jflog.setContent("消费支出");
			jflog.setCreateDate(new Date().getTime());
			jflog.setExtendstr(order.getId());
			jflog.setPoint(order.getPoint());
			jflog.setSystemid(owner.getCid());
			jflog.setTt(-2);
			jflog.setUserid(customer.getCid());
			jflogService.save(jflog);
			return ajaxJsonSuccessMessage(order.getId());
		} else if (order.getPaytype() == 2) {
			mygrounp.setOrderid(order.getId());
			mygrounp.setIsget(1);
			mygrounpService.update(mygrounp);
			return ajaxJsonSuccessMessage(order.getId());
		}
		return ajaxJsonErrorMessage("订单错误！");

	}

	public String wxnotify() throws Exception {

		String reqXml = "";
		Map<String, String> reqParam = new HashMap<String, String>();
		String encoding = getRequest()
				.getParameter(SDKConstants.param_encoding);
		try {
			InputStream inputStream = getRequest().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			// 获取请求参数中所有的信息
			String tempStr = "";
			while ((tempStr = reader.readLine()) != null) {
				reqXml += tempStr;
			}
			reader.close();
			inputStream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Map valideData = WxPayUtil.doXMLParse(reqXml);
		System.err.println("out_trade_no=" + valideData.get("out_trade_no"));
		String orderid = (String) valideData.get("out_trade_no");
		Order order = orderService.get(orderid);
		if (order.getPaymentStatus() == PaymentStatus.unpaid) {
			order.setPaymentStatus(PaymentStatus.paid);
			order.setPayret(valideData.toString());
			order.setPayDate(new Date().getTime());
			orderService.update(order);

			// 支付成功，给上级佣金
			// if (order.getUpuserid() != null) {
			// Customer upuser = customerService.get(order.getUpuserid());
			// upuser.setPoint(upuser.getPoint() + order.getUpusercomm());
			// customerService.update(upuser);
			// }
			if (order.getOrderType() != OrderType.tuangou) {
				if (order.getOrigin() != null) {
					Mygrounp mygrounp = mygrounpService.get(order.getOrigin());
					mygrounp.setIsget(1);
					mygrounp.setOrderid(order.getId());
					mygrounpService.update(mygrounp);
				}
			}

			getResponse()
					.getWriter()
					.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
		}
		return null;
	}

	public String getThesize() {
		return thesize;
	}

	public void setThesize(String thesize) {
		this.thesize = thesize;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

}
