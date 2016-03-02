package com.wdy.cyyx.action.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import org.apache.struts2.components.DoubleListUIBean;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.ElseIf;
import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Jflog;
import com.wdy.cyyx.entity.Jfstat;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.entity.Withdraw;
import com.wdy.cyyx.service.JflogService;
import com.wdy.cyyx.service.JfstatService;
import com.wdy.cyyx.service.WithdrawService;
import com.wdy.cyyx.util.StringUtils;

public class JfstatAction extends BaseAction {

	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	@Resource
	private JfstatService jfstatService;
	@Resource
	private JflogService jflogService;
	@Resource
	private WithdrawService withdrawService;

	private Withdraw withdraw;

	private Integer id;
	private Date date;
	private String type;
	private int systemid;// 商家id

	private String begin;
	private String end;
	
	

	// 每日总数统计
//	private double integral;// 截止当天，总发放积分
//	private double convert;//截止当天，总共已兑换多少积分
//	private double extract;// 截止当天，总共已提现多少 积分
//	private double balance;// 截止当天，总共还余多少积分没提现

	// 获取最新的总统计
	@Override
	public String execute() throws Exception {
		
		Date date = new Date();
		long time = date.getTime();
		Jfstat jfstat = new Jfstat();
		
		SystemClass systemClass = getAdminSystemClass();
		systemid = (Integer) getAdmin_name();
			
		// 截止当天，总发放积分
				QueryParam jfparam = new QueryParam(2).add("systemid", systemid).add("tt", 0);
				List<Jflog> jflistall = jflogService.getList(jfparam, 0, 0, "id","desc", false);
				double zffjf = 0;

				if (jflistall != null) {
					for (Jflog jfl : jflistall) {
						zffjf = zffjf + jfl.getPoint();
					}
				}
				
		
		// 截止当天，总共已提现多少 积分
				QueryParam txparam = new QueryParam(2).add("systemid", systemid).add("stat", 1);
				List<Withdraw> wdlistall = withdrawService.getList(txparam, 0, 0,
						"createDate", "desc", false);
				
				double zcgtx = 0;// 总成功提现
				if (wdlistall != null) {
					for (Withdraw wd : wdlistall) {
						zcgtx = zcgtx + wd.getMoney();
					}
				}
				
		
		//截止当天，总共购物兑换积分多少
				QueryParam dhparam = new QueryParam(2).add("systemid", systemid).add("tt", -2);
				List<Jflog> dhlistall = jflogService.getList(dhparam, 0, 0, "id", "desc", false);
				
				double zcgdh = 0;
				if(dhlistall != null){
					for(Jflog jfdx : dhlistall){
						zcgdh = zcgdh + jfdx.getPoint();
					}
				}
				
				
		// 截止当天，总共还余多少积分没提现
				double zyjf = 0;
				zyjf = -1 * (zffjf - zcgtx - zcgdh);
				if(zyjf==-0){
					zyjf=0;
				}
				
				jfstat.setJfbalance(zyjf);
				jfstat.setJfconvert(zcgdh);
				jfstat.setJfextract(zcgtx);
				jfstat.setJfintegral(zffjf);
				jfstat.setSystemid(systemid);
				jfstat.setCreatDate(time);
				
			jfstatService.save(jfstat);
			setAttribute("jfstat", jfstat);
			
//		return "jfstat";
//	}
//
//	/**
//	 * 构建统计表格
//	 * 
//	 * @return
//	 */
//	public String list() throws Exception{
		Long bb = null;
		Long ee = null;
		String stat="0";
		QueryParam params = new QueryParam(2);
		
		if(!StringUtils.isEmpty(begin)){
			bb=sdf.parse(begin).getTime();
		}
		if(!StringUtils.isEmpty(end)){
			ee=sdf.parse(end).getTime();
		}
		if(!StringUtils.isEmpty(type)){
				stat=type;
		}
		
		
//		SystemClass systemClass = getAdminSystemClass();
//		systemid = (Integer) getAdmin_name();
		if(stat.equals("tx")){//提现
			params.add("systemid", systemid).add("stat", 1);
			if (pn == 0 || pn == 1 || ps == 0) {
				pn = 1;
				int pc = withdrawService.getLikestatics(pro, keyword, params,
						"createDate", bb, ee);
				if (pc % ADMIN_PAGE_SIZE == 0) {
					ps = pc / ADMIN_PAGE_SIZE;
				} else {
					ps = pc / ADMIN_PAGE_SIZE + 1;
				}
			}
			List<Withdraw> txlist = withdrawService.getStaticsLikeList(pro, keyword, params, 
					"createDate", bb, ee,  ADMIN_PAGE_SIZE * (pn - 1),
					ADMIN_PAGE_SIZE, "createDate", "desc");
			
			setAttribute("txlist", txlist);
			setAttribute("ps", ps);
			setAttribute("pn", pn);
		}else if(stat.equals("dh")||stat.equals("fl")){//  兑换积分 或 获得积分
			
			if(stat.equals("dh")){
				params.add("systemid", systemid).add("tt", -2);
			}else if(stat.equals("fl")){
				params.add("systemid", systemid).add("tt", 0);
			}
			if (pn == 0 || pn == 1 || ps == 0) {
				pn = 1;
				int pc = jflogService.getLikestatics(pro, keyword, params,
						"createDate", bb, ee);
				if (pc % ADMIN_PAGE_SIZE == 0) {
					ps = pc / ADMIN_PAGE_SIZE;
				} else {
					ps = pc / ADMIN_PAGE_SIZE + 1;
				}
			}
			
			List<Jflog> jflist = jflogService.getStaticsLikeList(pro, keyword, params, 
					"createDate", bb, ee,  ADMIN_PAGE_SIZE * (pn - 1),
					ADMIN_PAGE_SIZE, "createDate", "desc");
			
			setAttribute("jflist", jflist);
			setAttribute("ps", ps);
			setAttribute("pn", pn);
		}
		
		
		
		return "jfstat";
		
//		
//		int str = type.indexOf("—"); 
//		String sd = type.substring(0,str-1);                //  获取 "2015/01/01"
//		String ed = type.substring(str+1,type.length()+1); 
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
//		Date date1 = sdf.parse(sd);                         //  转为date类型
//		Date date2 = sdf.parse(ed);
//		Long startday=date1.getTime();							//转为long类型，用于保存
//		Long endday=date2.getTime();
		

//		// 用于获取当前日期零点的毫秒数
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.HOUR_OF_DAY, 0);
//		cal.set(Calendar.SECOND, 0);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.MILLISECOND, 0);
//		long zero = cal.getTimeInMillis(); // 当前日期零点的毫秒数

	
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

//	public double getIntegral() {
//		return integral;
//	}
//
//	public void setIntegral(double integral) {
//		this.integral = integral;
//	}
//
//	public double getExtract() {
//		return extract;
//	}
//
//	public void setExtract(double extract) {
//		this.extract = extract;
//	}
//
//	public double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Withdraw getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Withdraw withdraw) {
		this.withdraw = withdraw;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
//
//	public double getConvert() {
//		return convert;
//	}
//
//	public void setConvert(double convert) {
//		this.convert = convert;
//	}

	
	

	
}
