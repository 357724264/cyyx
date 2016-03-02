package com.wdy.cyyx.action.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.unionpay.acp.sdk.SDKConstants;
import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.common.WxPayReqData;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Grounp;
import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.entity.Order;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.entity.Order.OrderType;
import com.wdy.cyyx.entity.Order.PaymentStatus;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.GrounpService;
import com.wdy.cyyx.service.MygrounpService;
import com.wdy.cyyx.service.ProductService;
import com.wdy.cyyx.util.SixtyOneRadixUtil;
import com.wdy.cyyx.util.WxPayUtil;
import com.wdy.cyyx.util.WxSignature;

public class MygrounpAction extends BaseAction {

	@Resource
	private MygrounpService mygrounpService;
	@Resource
	private CustomerService customerService;
	@Resource
	private GrounpService grounpService;
	@Resource
	private ProductService productService;

	private int pn;
	private int pid;
	private String lm;
	private String sm;
	private int tt;

	public String create() throws Exception {// 创建一个团

		Product product = productService.get(pid);
		SystemClass owner = getFrontSystemClass();

		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);

		// 先判断用户是不是已经创建过该产品的团了
		Mygrounp mygrounp = mygrounpService.get(SixtyOneRadixUtil.change(userid
				+ "-" + pid));
		if (mygrounp != null && mygrounp.getIszg() == 1) {
			// 已经组过的团
			return ajaxJsonErrorMessage("您已经组过该团了，请在会员中心找到您的团");
		}
		if (mygrounp == null) {
			mygrounp = new Mygrounp();
		}

		Customer master = customerService.get(userid);

		mygrounp.setCreateDate(new Date().getTime());
		System.err.println(userid + "-" + pid);
		mygrounp.setId(SixtyOneRadixUtil.change(userid + "-" + pid));
		mygrounp.setLeavemessage(lm);
		mygrounp.setFailpay(product.getSbmoney());
		mygrounp.setSharemessqage(sm);
		if (product.getZgmoney() != null && product.getZgmoney() > 0) {
			mygrounp.setIszg(0);
			mygrounp.setZgmoney(0.00);
		} else {
			// 需要支付的组团
			mygrounp.setZgmoney(product.getZgmoney());
			mygrounp.setIszg(1);
		}

		mygrounp.setZgmoney(product.getZgmoney());
		mygrounp.setMasterid(userid);
		mygrounp.setMastername(master.getName());
		mygrounp.setMasterpic(master.getPic());
		mygrounp.setProductid(pid);
		mygrounp.setSystemid(getSystemName());

		// 算出结束时间，如果最长时间在产品结束时间内，则结束时间为最长时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, product.getZltime());
		Date zlDate = calendar.getTime();
		if (zlDate.getTime() > product.getEndtime()) {
			mygrounp.setEndTime(product.getEndtime());
		} else {
			mygrounp.setEndTime(zlDate.getTime());
		}
		mygrounp.setProductname(product.getName());
		mygrounp.setPic(product.getPic());
		mygrounp.setMinnum(product.getMinnum());
		String id = mygrounpService.save(mygrounp);

		// 判断这个团是不是需要付款
		if (product.getZgmoney() != null && product.getZgmoney() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			// 需要付款的
			calendar.add(Calendar.HOUR, 3);
			// 微信预订单
			String preid = WxPayUtil.unifiedorder(new WxPayReqData(owner
					.getAppId(), owner.getMchid(), "shop", "attach", id,
					(int) (product.getZgmoney() * 100), "182.254.226.146", sdf
							.format(new Date()),
					sdf.format(calendar.getTime()), "http://" + owner.getCid()
							+ "." + Const.BASE_URL
							+ "/json/mygrounp!wxnotify.action", master
							.getWeixinid(), owner.getWxpaySecret()));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("appId", owner.getAppId());
			map.put("nonceStr", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
			map.put("package", "prepay_id=" + preid);
			map.put("signType", "MD5");
			map.put("timeStamp", "1");
			String paySign = WxSignature.getSign(map, owner.getWxpaySecret());
			return ajaxJson("{\"success\":true,\"preid\":\"" + preid
					+ "\",\"paySign\":\"" + paySign + "\",\"message\":\"" + id
					+ "\"}");
		}
		return ajaxJsonSuccessMessage(id);
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
		Mygrounp mygrounp = mygrounpService.get(orderid);
		if (mygrounp != null && mygrounp.getIszg() == 0) {
			mygrounp.setPayret(reqXml);
			mygrounp.setIszg(1);
			mygrounpService.update(mygrounp);
			getResponse()
					.getWriter()
					.print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
		}
		return null;
	}

	public String list() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		list = mygrounpService.getMyGroup(userid, null, tt == 0 ? null : tt,
				FRONT_PAGE_SIZE * (pn - 1), FRONT_PAGE_SIZE, "createDate",
				"desc");
		return LIST;
	}

	public String users() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		list = grounpService.getList(new QueryParam(1).add("masterid", userid),
				15 * (pn - 1), 15, "createDate",
				"desc", false);
		return "users";
	}

	public String join() {
		if (tt > 0) {
			tt = 0;
		}
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		list = mygrounpService
				.getUserJoinGroup(userid, tt, pn, FRONT_PAGE_SIZE);
		return "join";
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getLm() {
		return lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

	public String getSm() {
		return sm;
	}

	public void setSm(String sm) {
		this.sm = sm;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

}
