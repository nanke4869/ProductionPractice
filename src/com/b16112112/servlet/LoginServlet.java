package com.b16112112.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.b16112112.dao.UserDao;
import com.b16112112.model.User;
import com.b16112112.util.StringUtil;
/**
 * 登录验证servlet
 * @author mengying
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("Logout".equals(method)) {
			logout(request,response);
			return;
		}
		//获取用户输入的验证码
		String vcode = request.getParameter("vcode");
		String name = request.getParameter("account");
		String password = request.getParameter("password");
		//获取session中的验证码
		String loginCpacha = request.getSession().getAttribute("loginCpacha").toString();
		if(StringUtil.isEmpty(vcode)) {
			response.getWriter().write("vcodeError");
			return;
		}
		if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())) {
			response.getWriter().write("vcodeError");
			return;
		}
		//验证码验证通过，对比用户名密码是否正确
		UserDao userDao = new UserDao();
		User user = userDao.login(name, password);
		userDao.closeCon();
		if(user == null) {
			response.getWriter().write("loginError");
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		response.getWriter().write("loginSuccess");
		//说明用户名密码正确
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
