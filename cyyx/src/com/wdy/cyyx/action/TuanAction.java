package com.wdy.cyyx.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.hibernate.NonUniqueResultException;

import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.common.WxUser;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Grounp;
import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.GrounpService;
import com.wdy.cyyx.service.MygrounpService;
import com.wdy.cyyx.service.NotifyService;
import com.wdy.cyyx.service.ProductService;
import com.wdy.cyyx.util.WxMenuUtils;

@ParentPackage("front")
public class TuanAction extends BaseAction {

	private Integer id;
	private String tid;// 团id
	private Integer pid;
	private String lm;// 留言
	private String gid;
	private String addid;
	@Resource
	private ProductService productService;
	@Resource
	private MygrounpService mygrounpService;
	@Resource
	private GrounpService grounpService;
	@Resource
	private CustomerService customerService;
	@Resource
	private NotifyService notifyService;

	@Override
	public String execute() throws Exception {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		// 先判断该团是不是存在
		System.err.println("tid===" + tid);
		Mygrounp mygrounp = mygrounpService.get(tid);
		SystemClass systemClass = getFrontSystemClass();
		if (mygrounp == null) {
			// 跳转到“找不到”页面
			return "";
		}
		Customer customer = customerService.get(userid);
		if (customer.getIssub() == 0) {// 如果没有关注，发送给微信，看一下关注了没有
			System.err.println("goto check");
			WxUser wxUser = WxMenuUtils
					.getUserInfo(
							wxmenuService.getAccessToken(
									systemClass.getAppId(),
									systemClass.getAppSecret()), customer
									.getWeixinid());
			if (wxUser != null && wxUser.getIsSubscribe()) {
				customer.setIssub(1);
				customerService.update(customer);
			}

		}

		setAttribute("customer", customer);
		// 如果团没有过期，而且用户有没有参加过同类产品，那么久助力参团
		if (mygrounp.getEndTime() > new Date().getTime()
				&& !userid.equals(mygrounp.getMasterid())
				&& customer.getIssub() == 1) {// 如果不是团长,同时团还没有过期，同时用户关注了公众号
			// 判断用户是不是已经参过该产品[注意：不是该团]的团了
			boolean hasjoin = true;
			try {
				Grounp grounp = grounpService.get(
						new QueryParam(2).add("userid", userid).add(
								"productid", mygrounp.getProductid()), false);
				if (grounp == null) {// 如果没有参过该产品的团的
					hasjoin = false;
				} else {// 找出用户参加过的团
					if (!grounp.getGrounpid().equals(mygrounp.getId())) {
						Mygrounp othergroup = mygrounpService.get(grounp
								.getGrounpid());
						setAttribute("othergroup", othergroup);
					}
				}
			} catch (NonUniqueResultException e) {
				// 如果报错了，证明已经参过团了，不做任何事情
			}

			if (!hasjoin) {// 如果没有参过该产品的团
				Grounp newgrounp = new Grounp();
				newgrounp.setCreateDate(new Date().getTime());
				newgrounp.setGrounpid(tid);
				newgrounp.setId(tid + "-" + userid);
				newgrounp.setProductid(mygrounp.getProductid());
				newgrounp.setUserid(userid);
				newgrounp.setUsername(customer.getName());
				newgrounp.setMasterid(mygrounp.getMasterid());
				newgrounp.setUserpic(customer.getPic());
				// if (getSession(Const.SESSION_TUAN_UPID) != null) {
				// 保存在session里面的内容格式是【团id-分享人id】
				// 先判断保存的是不是分享这个团的
				String uid = getRequest().getParameter("uid");
				if (uid != null) {
					newgrounp.setRecommenid(Integer.parseInt(uid));
				}
				// }
				grounpService.save(newgrounp);

				// 参团人数加1
				mygrounp.setNum(mygrounp.getNum() + 1);
				mygrounpService.update(mygrounp);
				// 魅力值加1
				Customer master = customerService.get(mygrounp.getMasterid());
				master.setCharm(master.getCharm() + 1);
				customerService.update(master);
				// 如果人数够了，通知用户，可以直接购买了
				if (mygrounp.getNum() == mygrounp.getMinnum()) {
					notifyService.grounpOktoMaster(mygrounp,
							systemClass.getAppId(), systemClass.getAppSecret(),
							systemClass.getGrounpOkTemplateId(),
							master.getWeixinid());
				}

			}
		}

		// 所有该团的团友
		List<Grounp> list = grounpService.getList(
				new QueryParam(1).add("grounpid", tid), 0, 0, "createDate",
				"desc", false);
		// 产品信息
		Product product = productService.get(mygrounp.getProductid());
		setAttribute("product", product);
		setAttribute("list", list);
		setAttribute("mygrounp", mygrounp);
		return "tuan";
	}

	public String to() {// 我要组团
		Product product = productService.get(pid);
		setAttribute("product", product);
		return "to";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getLm() {
		return lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getAddid() {
		return addid;
	}
	
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
	}
}
