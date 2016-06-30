package com.hking.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/***
 * 生成验证码的公用类
 * @author MR.XIAO
 *
 */
public class VerifyCodeGeneratorUtil {
	
		
		/***
		 * 生成验证码的随机字符
		 */
		private char[] codes = new char[]{'2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
				'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
		
		/***
		 * 验证码宽度
		 */
		private int width;
		
		/***
		 * 验证码高度
		 */
		private int height;
		
		/***
		 * 验证码字符个数
		 */
		private int charSize;
		
		/***
		 * 字体样式
		 */
		private Font fontStyle;
		
		/***
		 * 生成的验证码
		 */
		private String verifyCode;
		
		/***
		 * 默认构造方法
		 */
		public VerifyCodeGeneratorUtil() {
			this.width = 70;
			this.height = 20;
			this.charSize = 4;
			this.fontStyle = new Font("Times New Roman", Font.BOLD, 16);
		}
		
		
		/**自定义构造函数
		 * @param width 验证码宽度
		 * @param height 验证码高度
		 * @param charSize 验证码字符个数
		 */
		public VerifyCodeGeneratorUtil(int width, int height,
				int charSize) {
			this.width = width;
			this.height = height;
			this.charSize = charSize;
			this.fontStyle = new Font("Times New Roman", Font.BOLD, 16);
		}
		
		
		
		/**自定义构造函数
		 * @param width 验证码宽度
		 * @param height 验证码高度
		 * @param charSize 验证码字符个数
		 * @param fontSize 字号
		 */
		public VerifyCodeGeneratorUtil(int width, int height,
				int charSize, int fontSize) {
			this.width = width;
			this.height = height;
			this.charSize = charSize;
			this.fontStyle = new Font("Times New Roman", Font.BOLD, fontSize);
		}


		/***
		 * 生成验证码图片
		 * @return 验证码图片
		 */
		public BufferedImage getVerifyCodeImage(){
			
			//取随机产生的认证码
			char[] rands = new char[charSize];
			for (int i = 0; i < charSize; i++) {
				int randCode = (int)(Math.random() * codes.length);
				rands[i] = codes[randCode];
			}
			
			//设置验证码字符串
			verifyCode = new String(rands);
			
			//在内存中创建图象
			BufferedImage verifyImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
			
			//获取图形上下文
			Graphics g = verifyImage.getGraphics();
			
			//设定背景色
			g.setColor(Color.white);
			
			g.fillRect(0, 0, width, height);
			
			//画边框
			//g.setColor(Color.black);
			//g.drawRect(0, 0, width-1, height-1);
			
			
			//将认证码显示到图象中
			char[] randCodes = verifyCode.toCharArray();
			
			//设置字母颜色
			Color color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
			g.setColor(color);
			
			//设置字母字体
			g.setFont(fontStyle);
			
			for (int i = 0; i < randCodes.length; i++) {
				
				String s = String.valueOf(randCodes[i]);
				
				int x = 4 + (width / charSize - 16) / 2 + i * width / charSize;
				int y = 14 + (height - 16) / 2 + 
					(Math.random() > 0.5 ? -1 : 1) * (int)(Math.random() * 6);
				
				g.drawString(s, x, y);
			}
			
			g.drawLine((int)(Math.random() * width), (int)(Math.random() * height), (int)(Math.random() * width), (int)(Math.random()*height));
			
			//图象生效
			g.dispose();
			
			return verifyImage;
		}
		
		/***
		 * 获取生成的验证码
		 * @return 验证码字符串
		 */
		public String getVerifyCode() {
			return verifyCode;
		}
}
