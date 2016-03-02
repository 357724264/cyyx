package com.wdy.cyyx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_commanddefault")
public class Commanddefault implements Serializable {//默认的命令

	private int cid;
	private String alias;
	private Integer replycid; // 使用哪个回复�? weixinreplydefault 的cid
	private String type; // 占无作用
	private Integer nodeid;
	private String dataOwner; // 系统
	private String command; // 请求指令 register是未注册就使用（暂时没用�? subscribe是欢迎语
							// default是默�?
	private Long opertime;
	private String displayName; // 备注

	private String sys;
	private SystemClass systemClass;

	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getReplycid() {
		return replycid;
	}

	public void setReplycid(Integer replycid) {
		this.replycid = replycid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNodeid() {
		return nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

	public String getDataOwner() {
		return dataOwner;
	}

	public void setDataOwner(String dataOwner) {
		this.dataOwner = dataOwner;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Long getOpertime() {
		return opertime;
	}

	public void setOpertime(Long opertime) {
		this.opertime = opertime;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSys() {
		return sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "systemClass")
	public SystemClass getSystemClass() {
		return systemClass;
	}

	public void setSystemClass(SystemClass systemClass) {
		this.systemClass = systemClass;
	}

}
