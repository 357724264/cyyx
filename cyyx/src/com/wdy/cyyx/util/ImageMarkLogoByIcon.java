package com.wdy.cyyx.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 图片水印
 */
public class ImageMarkLogoByIcon {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String srcImgPath = "d:/bg.jpg";
		String iconPath = "d:/qr.png";
		String targerPath = "d:/test/img_mark_icon.jpg";
		String head = "d://ico.png";
		String name = "帅哥锐";
		String kh = "帅无止境，你懂吗？";
		String targerPath2 = "d:/test/img_mark_icon_rotate.jpg";
		// 给图片添加水印
		ImageMarkLogoByIcon.markImageByIcon(head, name, kh, iconPath,
				srcImgPath, targerPath);
		// 给图片添加水印,水印旋转-45
		// ImageMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath,
		// targerPath2,-45);
		// downloadImg();
		// String filePath = "d:/test/ico.png";
		// String dest = filePath.substring(0, filePath.lastIndexOf("."))
		// + "-small" + filePath.substring(filePath.lastIndexOf("."));
		// System.err.println(dest);
		// resize("d:/test/ico.png",dest, 62, 62, true);
	}

	public static void downloadImg(String imgurl, String destPath)
			throws IOException {
		URL url = new URL(imgurl);
		File outFile = new File(destPath);
		OutputStream os = new FileOutputStream(outFile);
		InputStream is = url.openStream();
		byte[] buff = new byte[1024];
		while (true) {
			int readed = is.read(buff);
			if (readed == -1) {
				break;
			}
			byte[] temp = new byte[readed];
			System.arraycopy(buff, 0, temp, 0, readed);
			os.write(temp);
		}
		is.close();
		os.close();
	}

	/**
	 * 给图片添加水印
	 * 
	 * @param iconPath
	 *            水印图片路径
	 * @param srcImgPath
	 *            源图片路径
	 * @param targerPath
	 *            目标图片路径
	 */
	public static void markImageByIcon(String head, String name, String kh,
			String iconPath, String srcImgPath, String targerPath) {
		markImageByIcon(head, name, kh, iconPath, srcImgPath, targerPath, null);
	}

	/**
	 * 图片缩放
	 * 
	 * @param filePath
	 *            图片路径
	 * @param height
	 *            高度
	 * @param width
	 *            宽度
	 * @param bb
	 *            比例不对时是否需要补白
	 */
	public static void resize(String filePath, String destPath, int height,
			int width, boolean bb) {
		try {
			double ratio = 0; // 缩放比例
			File f = new File(filePath);

			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height,
					BufferedImage.SCALE_SMOOTH);
			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				g.dispose();
				itemp = image;
			}
			ImageIO.write((BufferedImage) itemp, "jpg", new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * 
	 * @param iconPath
	 *            水印图片路径
	 * @param srcImgPath
	 *            源图片路径
	 * @param targerPath
	 *            目标图片路径
	 * @param degree
	 *            水印图片旋转角度
	 */
	public static void markImageByIcon(String head, String name, String kh,
			String iconPath, String srcImgPath, String targerPath,
			Integer degree) {
		OutputStream os = null;
		try {
			System.err.println("srcImgPath====="+srcImgPath);
			Image srcImg = ImageIO.read(new File(srcImgPath));
			System.err.println(":===============");

			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
					srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

			// 得到画笔对象
			// Graphics g= buffImg.getGraphics();
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(
					srcImg.getScaledInstance(srcImg.getWidth(null),
							srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
					null);

			if (null != degree) {
				// 设置水印旋转
				g.rotate(Math.toRadians(degree),
						(double) buffImg.getWidth() / 2,
						(double) buffImg.getHeight() / 2 - 170);
			}

			// 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
			ImageIcon imgIcon = new ImageIcon(iconPath);
			ImageIcon imgHead = new ImageIcon(head);

			// 得到Image对象。
			Image img = imgIcon.getImage();
			Image headico = imgHead.getImage();

			float alpha = 1f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));

			// 表示水印图片的位置
			g.drawImage(img, 116, 420, null);
			g.drawImage(headico, 30, 230, null);
			Font font = new Font("黑体", Font.BOLD, 25);
			g.setFont(font);
			g.setColor(new Color(0, 0, 0));
			g.drawString(name, 120, 253);
			Font khfont = new Font("雅黑", Font.BOLD, 20);
			g.setFont(khfont);
			g.setColor(new Color(204, 50, 153));
			g.drawString(kh, 120, 280);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			os = new FileOutputStream(targerPath);

			// 生成图片
			ImageIO.write(buffImg, "JPG", os);
			System.out.println("图片完成添加Icon印章。。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}