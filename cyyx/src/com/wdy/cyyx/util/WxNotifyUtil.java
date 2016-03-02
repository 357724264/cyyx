package com.wdy.cyyx.util;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Mygrounp;

public class WxNotifyUtil {
	public static String grounpOktoMaster(Mygrounp mygrounp,
			String accessToken, String weixinid, String templateid)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.custom().build();
		if (accessToken == null) {
			return null;
		}
		URL url = new URL(
				"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
						+ accessToken);
		HttpPost post = HttpClientConnectionManager.getPostMethod(url
				.toString());
		StringEntity s = new StringEntity(
				"{\"touser\":\""
						+ weixinid
						+ "\",\"template_id\":\""
						+ templateid
						+ "\",\"url\":\""
						+ mygrounp.getSystemid()
						+ "."
						+ Const.BASE_URL
						+ "/center!mygrounp.action\",\"topcolor\":\"#FF0000\",\"data\":{\"first\": {\"value\":\"您的一个组团商品已经够人了！快去填写地址免费领取吧\",\"color\":\"#173177\"},\"Pingou_ProductName\":{\"value\":\""
						+ mygrounp.getProductname()
						+ "\",\"color\":\"#173177\"},\"Weixin_ID\":{\"value\":\""
						+ mygrounp.getMastername()
						+ "\",\"color\":\"#173177\"},\"remark\":{\"value\":\"点击查看\",\"color\":\"#173177\"}}}",
				"UTF-8");
		s.setContentEncoding("UTF-8");
		s.setContentType("application/json");
		post.setEntity(s);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		HttpResponse response = httpClient.execute(post);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		System.err.println(jsonStr);
		return null;
	}

}
