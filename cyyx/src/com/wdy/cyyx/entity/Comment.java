package com.wdy.cyyx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wdy.cyyx.util.StringUtils;

/**
 * 评论，可要可不要
 * @author eric.huang
 *
 */
@Entity
@Table(name = "cyyx_comment")
public class Comment {
	private int cid;
	private String content;
	private int point;
	private Date createDate;
	private String name;
	private Integer uid;
	private int touid;
	private String images;
	private String ctype;
	private Integer typeid;
	private String recontent;
	private Date reDate;

	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public int getTouid() {
		return touid;
	}

	public void setTouid(int touid) {
		this.touid = touid;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	@Transient
	public String[] getPics() {
		if (StringUtils.isEmpty(getImages())) {
			return null;
		}
		String[] pics = getImages().split(",");
		int length = pics.length;
		for (int i = 0; i < length; i++) {
			String pic = pics[i];
			pics[i] = pic.substring(0, pic.lastIndexOf(".")) + "_tail"
					+ pic.substring(pics[i].lastIndexOf("."), pic.length());
		}
		return pics;
	}

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}

	public Date getReDate() {
		return reDate;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}

}
