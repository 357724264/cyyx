package com.wdy.cyyx.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.entity.Wxmenu;

@Entity
@Table(name = "cyyx_wxmenu")
public class Wxmenu implements Serializable, Comparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cid;
	private String dataOwner;
	private Long opertime;
	private String alias;
	private String type;
	private String displayName;
	private String keyword;
	private String url;
	private Integer indx;
	private Integer bid;
	private Wxmenu wxmenu;
	private Set<Wxmenu> menus = new HashSet<Wxmenu>();

	private SystemClass systemClass;

	private String nodeid;

	private String appid;
	private String appsecret;

	@Id
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getDataOwner() {
		return dataOwner;
	}

	public void setDataOwner(String dataOwner) {
		this.dataOwner = dataOwner;
	}

	public Long getOpertime() {
		return opertime;
	}

	public void setOpertime(Long opertime) {
		this.opertime = opertime;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIndx() {
		return indx;
	}

	public void setIndx(Integer indx) {
		this.indx = indx;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wxmenu")
	public Wxmenu getWxmenu() {
		return wxmenu;
	}

	public void setWxmenu(Wxmenu wxmenu) {
		this.wxmenu = wxmenu;
	}

	@OneToMany(mappedBy = "wxmenu")
	public Set<Wxmenu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Wxmenu> menus) {
		this.menus = menus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "systemClass")
	public SystemClass getSystemClass() {
		return systemClass;
	}

	public void setSystemClass(SystemClass systemClass) {
		this.systemClass = systemClass;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	@Transient
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Wxmenu a = (Wxmenu) o;
		return this.cid.compareTo(a.getCid());
	}
	@Transient
	public String getHiddenCid(){
		return cid.substring(cid.indexOf("_")+1,cid.length());
	}
}
