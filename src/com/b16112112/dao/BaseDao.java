package com.b16112112.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.b16112112.util.DBUtil;

/**
 * 基础dao，封装基本操作
 * @author mengying
 *
 */
public class BaseDao {
	private DBUtil dbUtil = new DBUtil();
	/**
	 * 关闭数据库连接，释放资源
	 */
	public void closeCon() {
		dbUtil.Close();
	}
	/**
	 * 基础查询，多条查询
	 */
	public ResultSet query(String sql){
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			return prepareStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
