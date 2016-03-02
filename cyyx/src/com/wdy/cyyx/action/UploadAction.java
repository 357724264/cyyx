package com.wdy.cyyx.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.util.ImageMarkLogoByIcon;
import com.wdy.cyyx.util.PicUtil;

public class UploadAction extends BaseAction {
	public static String STATIC_URL = "http://localhost/";

	private static final String UPLOAD_FOLD = "up";
	public static final int ZONE_PIC_SMALL_PIC_WEIGHT = 100;
	private int width;
	private int length;
	private int swidth;
	private int slength;
	private int type;
	private File file;
	private String fileFileName;
	private File upfile;
	private String upfileFileName;
	private String tt;

	private Long limit;

	/**
	 * 上传接口 返回值为上传图片的缩略图<br/>
	 * eg.上传后原始图xxxxxxx.png->缩略图xxxxx_tail.png<br/>
	 * swidth 缩略图宽度<br/>
	 * slength 缩略图长度
	 */
	@Override
	public String execute() throws Exception {
		System.err.println("-------------");
		if (file == null) {
			file = upfile;
			fileFileName = upfileFileName;
		}

		if (limit != null) {
			if ((file.length() / 1024) > limit) {
				return ajax("{\"success\":false,\"msg\":\"上传文件不能大于" + limit
						+ "KB\"}", "text/html");
			}
		}

		String path = getRequest().getRealPath("");
		String bigurl = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String dDir = UPLOAD_FOLD + "/" + sf.format(now) + "/";
		File dir = new File(path + "/" + dDir);
		dir.mkdirs();
		String fExt = fileFileName.substring(fileFileName.lastIndexOf("."));
		StringBuilder fileSb = new StringBuilder();
		fileSb.append(System.currentTimeMillis());
		bigurl = dDir + fileSb + fExt;
		try {
			File f = this.getFile();
			if (this.getFileFileName().endsWith(".exe")) {
				return ajaxJsonErrorMessage("对不起,你上传的文件格式不允许!!!");
			}
			FileInputStream inputStream = new FileInputStream(f);
			FileOutputStream outputStream = new FileOutputStream(path + "/"
					+ dDir + fileSb + fExt);
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, length);
			}
			inputStream.close();
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxJsonErrorMessage("对不起,文件上传失败了!!!!");
		}
		if (tt == null) {

			// 如果生成缩略图
			BufferedImage bi = ImageIO.read(file);
			// int height = bi.getHeight();
			int width = bi.getWidth();
			// 做缩略图
			String newFileName = fileSb + "_tail";
			int smallWidth = ZONE_PIC_SMALL_PIC_WEIGHT;
			int smallHeigth = ZONE_PIC_SMALL_PIC_WEIGHT;
			System.err.println(swidth + "    " + slength);
			if (swidth != 0) {
				smallWidth = swidth;
			}
			if (slength != 0) {
				smallHeigth = slength;
			}
			if (width > smallWidth) {
				PicUtil.saveImageAsJpg(path + "/" + dDir + fileSb + fExt, path
						+ "/" + dDir + newFileName + fExt, smallWidth,
						smallHeigth);
				// result = upInfo.resultPartern.replaceAll("`dir`",
				// dDir+fileSb.toString().replaceAll("\\.",
				// "-1.")).replaceAll("`file`", srcFileName);
			} else {
				// PicUtil.saveImageAsJpg(path + "/" + dDir + fileSb, path + "/"
				// + dDir + newFileName + fExt, width, bi.getHeight());
			}
			ImageMarkLogoByIcon.resize(path + "/" + dDir + fileSb + fExt, path
					+ "/" + dDir + newFileName + "-small" + fExt, 64, 64, true);
			// 林浩旋修改 返回圖片URL 錯誤問題 使用相對路徑
			// return ajax("{\"success\":true,\"url\":\"" + dDir + "/"
			// + newFileName + fExt + "\",\"bigurl\":\"" + bigurl + "\"}",
			// "text/html");
			return ajax("{\"success\":true,\"url\":\"" + bigurl
					+ "\",\"bigurl\":\"" + bigurl + "\"}", "text/html");
		} else {
			// return ajax("{\"success\":true,\"file_path\":\"" + STATIC_URL
			// + bigurl + "\",\"msg\":\"上传成功\"}", "text/html");
			return ajax("{\"state\":\"SUCCESS\",\"url\":\"" + bigurl + "\"}",
					"text/html");

		}

	}

	private String Filedata;

	public String getFiledata() {
		return Filedata;
	}

	public void setFiledata(String filedata) {
		Filedata = filedata;
	}

	public String pics() throws Exception {
		String path = getRequest().getRealPath("");
		String bigurl = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String dDir = UPLOAD_FOLD + "/" + sf.format(now) + "/";
		File dir = new File(path + "/" + dDir);
		dir.mkdirs();
		this.fileFileName = getRequest().getParameter("Filename");
		// System.out.println(fileFileName);
		// System.out.println(Filename);
		// System.out.println(Filedata);
		// System.out.println(Upload);

		String fExt = fileFileName.substring(fileFileName.lastIndexOf("."));
		StringBuilder fileSb = new StringBuilder();
		fileSb.append(System.currentTimeMillis());
		bigurl = dDir + fileSb + fExt;
		try {
			this.setFile(new File(Filedata));
			File f = this.getFile();
			if (this.getFileFileName().endsWith(".exe")) {
				return ajaxJsonErrorMessage("对不起,你上传的文件格式不允许!!!");
			}
			FileInputStream inputStream = new FileInputStream(f);
			FileOutputStream outputStream = new FileOutputStream(path + "/"
					+ dDir + fileSb + fExt);
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, length);
			}
			inputStream.close();
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxJsonErrorMessage("对不起,文件上传失败了!!!!");
		}
		if (tt == null) {

			// 如果生成缩略图
			BufferedImage bi = ImageIO.read(file);
			// int height = bi.getHeight();
			int width = bi.getWidth();
			// 做缩略图
			String newFileName = fileSb + "_tail";
			int smallWidth = ZONE_PIC_SMALL_PIC_WEIGHT;
			int smallHeigth = ZONE_PIC_SMALL_PIC_WEIGHT;
			if (swidth != 0) {
				smallWidth = swidth;
			}
			if (slength != 0) {
				smallHeigth = slength;
			}
			PicUtil.saveImageAsJpg(path + "/" + dDir + fileSb + fExt, path
					+ "/" + dDir + newFileName + fExt, smallWidth, smallHeigth);
			// if (width > smallWidth) {
			// PicUtil.saveImageAsJpg(path + "/" + dDir + fileSb + fExt, path
			// + "/" + dDir + newFileName + fExt, smallWidth,
			// smallHeigth);
			// } else {
			// PicUtil.saveImageAsJpg(path + "/" + dDir + fileSb, path + "/"
			// + dDir + newFileName + fExt, width, bi.getHeight());
			// }
			// 林浩旋修改 返回圖片URL 錯誤問題 使用相對路徑
			// return ajax("{\"success\":true,\"url\":\"" + dDir + "/"
			// + newFileName + fExt + "\",\"bigurl\":\"" + bigurl + "\"}",
			// "text/html");
			return ajax("{\"success\":true,\"url\":\"" + bigurl
					+ "\",\"bigurl\":\"" + bigurl + "\"}", "text/html");

		} else {
			return ajax("{\"success\":true,\"url\":\"" + STATIC_URL + bigurl
					+ "\"}", "text/html");

			// return ajax("{\"state\":\"SUCCESS\",\"url\":\""+STATIC_URL +
			// bigurl+"\"}", "text/html");
		}

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSwidth() {
		return swidth;
	}

	public void setSwidth(int swidth) {
		this.swidth = swidth;
	}

	public int getSlength() {
		return slength;
	}

	public void setSlength(int slength) {
		this.slength = slength;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public File getUpfile() {
		return upfile;
	}

	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}

	public String getUpfileFileName() {
		return upfileFileName;
	}

	public void setUpfileFileName(String upfileFileName) {
		this.upfileFileName = upfileFileName;
	}

}
