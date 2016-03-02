package com.wdy.cyyx.service;

import java.util.List;

import com.wdy.cyyx.entity.Mygrounp;

public interface MygrounpService extends BaseService<Mygrounp, String> {

	/**
	 * 获取用户团长的组团或者某个公司的产品组团情况
	 * 
	 * @param masterid
	 *            团长ID
	 * @param tt
	 *            组团类型 1:进行中还不可以领取产品的 2：可以领取产品的 3：已经领取产品的 4：已经结束的
	 * @param start
	 * @param limit
	 * @param now
	 *            需要对比的现在时间
	 * @return
	 */
	public List<Mygrounp> getMyGroup(Integer masterid, Integer systemid,
			Integer tt, int start, int limit, String orderby, String order);

	public List<Mygrounp> getUserJoinGroup(int userid, int tt, int pn, int ps);
}
