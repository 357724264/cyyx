package com.wdy.cyyx.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wdy.cyyx.dao.MygrounpDao;
import com.wdy.cyyx.entity.Mygrounp;

@Repository
public class MygrounpDaoImpl extends BaseDaoImpl<Mygrounp, String> implements
		MygrounpDao {
	// tt 组团类型 1:进行中还不可以领取产品的 2：可以领取产品的 3：已经领取产品的 4：已经结束的
	public List<Mygrounp> getMyGroup(Integer masterid, Integer systemid,
			Integer tt, int start, int limit, String orderby, String order) {
		long now = new Date().getTime();

		String hql = "from Mygrounp g where g.iszg=1 and";
		if (masterid != null) {
			hql += " g.masterid=" + masterid;
		} else {
			hql += " g.systemid=" + systemid;
		}
		if (tt != null) {
			if (tt.intValue() == 1) {
				hql += " and g.num<g.minnum and endTime>" + now;
			}
			if (tt.intValue() == 2) {
				hql += " and g.num>=g.minnum and g.isget=0";
			}
			if (tt.intValue() == 3) {
				hql += " and g.isget=1";
			}
			if (tt.intValue() == 4) {
				hql += " endTime<" + now;
			}
		}
		hql += " order by g." + orderby + " " + order;
		return this.getSession().createQuery(hql).setFirstResult(start)
				.setMaxResults(limit).list();

	}

	public List<Mygrounp> getUserJoinGroup(int userid, int tt, int pn, int ps) {
		long now = new Date().getTime();
		String hql = "select mg from Mygrounp mg,Grounp g where g.userid="
				+ userid + " and mg.id=g.grounpid";

		if (tt == -1) {
			hql += " and mg.endTime<" + now;
		} else if (tt == 0) {
			hql += " and mg.endTime>" + now;
		}
		hql += " order by mg.createDate desc";
		return this.getSession().createQuery(hql).setFirstResult(ps * (pn - 1))
				.setMaxResults(ps).list();
	}

}
