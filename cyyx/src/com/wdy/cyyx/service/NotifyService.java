package com.wdy.cyyx.service;

import com.wdy.cyyx.entity.Mygrounp;

public interface NotifyService {
	/**
	 * 组团成功，通知团长去领货
	 * 
	 * @param mygrounp
	 *            团
	 * @param appid
	 *            appid
	 * @param appkey
	 * @param templateid
	 *            模板id
	 * @throws Exception
	 */
	public void grounpOktoMaster(Mygrounp mygrounp, String appid,
			String appSecret, String templateid, String weixinid) throws Exception;
}
