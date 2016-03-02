package com.wdy.cyyx.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

import com.wdy.cyyx.util.TwoDimensionCode;

public class SecureAction extends BaseAction {

	private String bf;
	private Integer w;
	private Integer h;
	private Integer n;

	public String qrcode() throws IOException {
		// 设置响应的类型格式为图片格式
		getResponse().setContentType("image/jpeg");
		// 禁止图像缓存。
		getResponse().setHeader("Pragma", "no-cache");
		getResponse().setHeader("Cache-Control", "no-cache");
		getResponse().setDateHeader("Expires", 0);
		TwoDimensionCode handler = new TwoDimensionCode();
		BufferedImage buffImg = handler.qRCodeCommon(
				URLDecoder.decode(bf, "UTF-8"), "png", 7);
		ImageIO.write(buffImg, "png", getResponse().getOutputStream());
		return null;
	}

	public String getBf() {
		return bf;
	}

	public void setBf(String bf) {
		this.bf = bf;
	}

	public Integer getW() {
		return w;
	}

	public void setW(Integer w) {
		this.w = w;
	}

	public Integer getH() {
		return h;
	}

	public void setH(Integer h) {
		this.h = h;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

}
