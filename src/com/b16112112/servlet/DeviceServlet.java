package com.b16112112.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b16112112.dao.DeviceDao;
import com.b16112112.model.Device;
import com.b16112112.model.Page;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
/**
 * 
 * @author HP
 * 设备信息
 */
public class DeviceServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -208025153925240695L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("toDeviceListView".equals(method)) {
			deviceList(request, response);
		}else if("getDeviceList".equals(method)) {
			getDeviceList(request, response);
		}
	}

	private void deviceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/deviceList.jsp").forward(request, response);
	}
	private void getDeviceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String devID = request.getParameter("devID");
		Integer currentPage = Integer.parseInt(request.getParameter("page"));
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		Device device = new Device();
		device.setDevID(devID);
		DeviceDao deviceDao = new DeviceDao();
		List<Device> deviceList = deviceDao.getDeviceList(device,new Page(currentPage, pageSize));
		deviceDao.closeCon();
		JsonConfig jsonConfig = new JsonConfig();
		String deviceListString = JSONArray.fromObject(deviceList,jsonConfig).toString();
		System.out.println(deviceListString);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(deviceListString);
	}
}
