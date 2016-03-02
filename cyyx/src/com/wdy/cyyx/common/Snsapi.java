package com.wdy.cyyx.common;

import org.json.JSONML;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class Snsapi {
	private String access_token;
	private int expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	private String unionid;

	public Snsapi() {
		// TODO Auto-generated constructor stub
	}

	public Snsapi(JSONObject object) {
		this.access_token = object.getString("access_token");
		this.expires_in = object.getInt("expires_in");
		this.refresh_token = object.getString("refresh_token");
		this.openid = object.getString("openid");
		this.scope = object.getString("scope");
//		this.unionid = object.getString("unionid");
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
