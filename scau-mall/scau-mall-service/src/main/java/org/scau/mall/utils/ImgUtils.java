package org.scau.mall.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImgUtils {
	
	public static void drawImage(String content, OutputStream out, String format) throws IOException {
		int width = 665;
        int height = 1350;
        // RGB形式,自定义背景
        BufferedImage bgBufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //BufferedImage bgBufImage = ImageIO.read(bgImgUrl);
        Graphics2D bgBufImageGraphics = bgBufImage.createGraphics();
        // 设置背景色
        bgBufImageGraphics.setBackground(Color.WHITE);
        //通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
         bgBufImageGraphics.clearRect(0, 0, width, height);

         //底部设置、粉红色。
         Color color = new Color(18, 60 , 118);
         bgBufImageGraphics.setBackground(color);//.getHSBColor(213f, 84f, 43f)
         bgBufImageGraphics.clearRect(0, 1300, width, 50);
         //bgBufImageGraphics.drawLine(0, height, 0, height);

     // 设置画笔,设置Paint属性 ==>设置标题文字
        bgBufImageGraphics.setPaint(Color.black);
        Font font = new Font("PingFangSC-Medium", Font.BOLD, 28);
        bgBufImageGraphics.setFont(font);
        bgBufImageGraphics.drawString("专业经纪人为您服务！", 25, 1080);
        bgBufImageGraphics.drawString("长按二维码，立即赚钱", 25, 1120);
        URL url = ImgUtils.class.getClassLoader().getResource("bg_up.png");
        //File picImg = new File("C:\\Users\\John\\Desktop\\贷款\\图片\\bg_up.png");
		// 通过url获取File的绝对路径
		File picImg = new File(url.getFile());
        //File qrCodeImg = new File("D:"+File.separator+"csdn.jpg");
        //商品图片
        BufferedImage posterBufImage = ImageIO.read(picImg);
        //读取本地图片 二维码
        BufferedImage qrCodeImage = EncodeImgZxing.encodeImg(content);
        //二维码
        bgBufImageGraphics.drawImage(qrCodeImage, 385, 1000, 220, 210, null);
        //商品图片
        bgBufImageGraphics.drawImage(posterBufImage, 0, 0, 665, 960, null);
        bgBufImageGraphics.dispose();
        //FileOutputStream out = new FileOutputStream("C:\\Users\\John\\Desktop\\贷款\\图片\\qrcode.png");
        ImageIO.write(bgBufImage, format, out);
        System.out.println("生成成功");
	}
	
	public static void drawImageLogo(String content, OutputStream out) throws IOException {
		int width = 665;
        int height = 1300;
        // RGB形式,自定义背景
        BufferedImage bgBufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //BufferedImage bgBufImage = ImageIO.read(bgImgUrl);
        Graphics2D bgBufImageGraphics = bgBufImage.createGraphics();
        // 设置背景色
        bgBufImageGraphics.setBackground(Color.WHITE);
        //通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
         bgBufImageGraphics.clearRect(0, 0, width, height);
         
         //底部设置、粉红色。
         bgBufImageGraphics.setBackground(Color.BLACK);
         bgBufImageGraphics.clearRect(0, 1250, width, 50);

     // 设置画笔,设置Paint属性 ==>设置标题文字
        bgBufImageGraphics.setPaint(Color.black);
        Font font = new Font("PingFangSC-Medium", Font.BOLD, 28);
        bgBufImageGraphics.setFont(font);
        bgBufImageGraphics.drawString("专业经纪人为您服务！", 25, 1080);
        bgBufImageGraphics.drawString("长按二维码，立即赚钱", 25, 1120);
        URL url = ImgUtils.class.getClassLoader().getResource("bg_up.png");
        //File picImg = new File("C:\\Users\\John\\Desktop\\贷款\\图片\\bg_up.png");
		// 通过url获取File的绝对路径
		File picImg = new File(url.getFile());
        //File qrCodeImg = new File("D:"+File.separator+"csdn.jpg");
		url = ImgUtils.class.getClassLoader().getResource("qrcode.jpg");
        //File picImg = new File("C:\\Users\\John\\Desktop\\贷款\\图片\\bg_up.png");
		// 通过url获取File的绝对路径
		File qrcode_centre = new File(url.getFile());
        //商品图片
        BufferedImage posterBufImage = ImageIO.read(picImg);
        //读取本地图片 二维码
        BufferedImage qrCodeImage = EncodeImgZxing.encodeImg(content);
        BufferedImage qrCodeLogoImage = EncodeImgZingLogo.encodeImgLogo(qrCodeImage, qrcode_centre);
        //二维码
        bgBufImageGraphics.drawImage(qrCodeLogoImage, 385, 1000, 220, 210, null);
        //商品图片
        bgBufImageGraphics.drawImage(posterBufImage, 0, 0, 665, 960, null);
        bgBufImageGraphics.dispose();
        //FileOutputStream out = new FileOutputStream("C:\\Users\\John\\Desktop\\贷款\\图片\\qrcode.png");
        ImageIO.write(bgBufImage, "png", out);
        System.out.println("生成成功");
	}
	
//	public static void main(String[] args) {
//		try {
//			drawImage("http://127.0.0.1:8081/test/middle", new FileOutputStream("C:\\Users\\John\\Desktop\\贷款\\图片\\qrcode_new.png"), "jpeg");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
