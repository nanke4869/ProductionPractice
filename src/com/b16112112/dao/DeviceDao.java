package com.b16112112.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.b16112112.model.Device;
import com.b16112112.model.Page;
import com.b16112112.util.StringUtil;

public class DeviceDao extends BaseDao {
	public List<Device> getDeviceList(Device dev, Page page){
		List<Device> ret = new ArrayList<Device>();
		String sql = "select * from t_dev_motor ";
		if(!StringUtil.isEmpty(dev.getDevID())) {
			sql += "where devID like '%" + dev.getDevID() + "'";
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql);
		try {
			while(resultSet.next()) {
				Device d = new Device();
				d.setDevID(resultSet.getString("devID"));
				int type = resultSet.getInt("devType");
				if(type==0) d.setDevType("三相异步");
				int status = resultSet.getInt("online");
				if(status == 0) d.setOnline("离线");
				d.setLocationName(resultSet.getString("locationName"));
				d.setLongitude(resultSet.getDouble("longitude"));
				d.setLatitude(resultSet.getDouble("latitude"));
				d.setCreate_date(resultSet.getString("create_date"));
				ret.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
