package com.b16112112.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.b16112112.model.User;

/**
 * 
 * @author HP
 *用户数据库操作封装
 */
public class UserDao extends BaseDao {
	public User login(String name, String password) {
		String sql = "select * from t_user where loginname = '" + name + "' and password = '" + password + "'";
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("uid"));
				user.setName(resultSet.getString("loginname"));
				user.setPassword(resultSet.getString("password"));
				user.setStatus(resultSet.getInt("status"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
