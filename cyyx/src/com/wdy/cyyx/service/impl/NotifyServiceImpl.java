package com.wdy.cyyx.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.service.NotifyService;
import com.wdy.cyyx.service.WxmenuService;
import com.wdy.cyyx.util.WxNotifyUtil;

@Service
public class NotifyServiceImpl implements NotifyService {
	@Resource
	private WxmenuService wxmenuService;

	@Resource
	private TaskExecutor taskExecutor;

	@Override
	public void grounpOktoMaster(final Mygrounp mygrounp, String appid,
			String appSecret, final String templateid, final String weixinid)
			throws Exception {
		final String accessToken = wxmenuService.getAccessToken(appid,
				appSecret);
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					WxNotifyUtil.grounpOktoMaster(mygrounp, accessToken,
							weixinid, templateid);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
