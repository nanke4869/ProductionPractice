package com.b16112112.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b16112112.dao.DeviceDao;
import com.b16112112.dao.RealTimeDao;
import com.b16112112.model.Device;
import com.b16112112.model.Page;
import com.b16112112.model.RealTime;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class RealTimeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1389647752114060670L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("toRealTimeListView".equals(method)) {
			realTimeList(request, response);
		}else if("getRealTimeList".equals(method)) {
			getRealTimeList(request, response);
		}
	}

	private void realTimeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/realTimeList.jsp").forward(request, response);
	}
	private void getRealTimeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String devID = request.getParameter("devID");
		Integer currentPage = Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		RealTime realtime = new RealTime();
		realtime.setDevID(devID);
		RealTimeDao realDao = new RealTimeDao();
		List<RealTime> realList = realDao.getRealTimeList(realtime,new Page(currentPage, pageSize));
		realDao.closeCon();
		JsonConfig jsonConfig = new JsonConfig();
		String realListString = JSONArray.fromObject(realList,jsonConfig).toString();
		System.out.println(realListString);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(realListString);
	}

}
