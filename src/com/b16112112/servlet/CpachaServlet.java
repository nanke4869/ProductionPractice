package com.b16112112.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b16112112.util.CpachaUtil;

/**
 * 
 * @author HP
   * 验证码servlet
 */ 

public class CpachaServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4919529414762301338L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("loginCapcha".equals(method)) {
			generateLoginCpacha(request, response);
			return;
		}
		response.getWriter().write("error method");
	}
	private void generateLoginCpacha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建验证码生成器对象
		CpachaUtil cpachautil = new CpachaUtil();
		//生成验证码
		String generatorVCode = cpachautil.generatorVCode();
		//将验证码保存在session域中,以便判断验证码是否正确
		request.getSession().setAttribute("loginCpacha", generatorVCode);
		//生成验证码图片
		BufferedImage vImg = cpachautil.generatorRotateVCodeImage(generatorVCode, true);
		//输出图像
		ImageIO.write(vImg, "gif", response.getOutputStream());
	}
}
