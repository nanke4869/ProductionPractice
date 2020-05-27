package com.b16112112.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.b16112112.model.Page;
import com.b16112112.model.RealTime;
import com.b16112112.util.StringUtil;
public class RealTimeDao extends BaseDao {
	public List<RealTime> getRealTimeList(RealTime rt, Page page){
		List<RealTime> ret = new ArrayList<RealTime>();
		String sql = "select * from t_motor ";
		if(!StringUtil.isEmpty(rt.getDevID())) {
			sql += "where devID like '%" + rt.getDevID() + "'";
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql);
		try {
			while(resultSet.next()) {
				RealTime d = new RealTime();
				d.setDevID(resultSet.getString("devID"));
				d.setIndoorTemp(resultSet.getString("indoorTemp"));
				d.setNoise(resultSet.getString("noise"));
				d.setAphaseVolt(String.valueOf(resultSet.getDouble("AphaseVolt")));
				d.setBphaseVolt(String.valueOf(resultSet.getDouble("BphaseVolt")));
				d.setCphaseVolt(String.valueOf(resultSet.getDouble("CphaseVolt")));
				d.setABphaseVolt(String.valueOf(resultSet.getDouble("ABphaseVolt")));
				d.setBCphaseVolt(String.valueOf(resultSet.getDouble("BCphaseVolt")));
				d.setACphaseVolt(String.valueOf(resultSet.getString("ACphaseVolt")));
				d.setAphaseCurrent(String.valueOf(resultSet.getString("AphaseCurrent")));
				d.setBphaseCurrent(String.valueOf(resultSet.getString("BphaseCurrent")));
				d.setCphaseCurrent(String.valueOf(resultSet.getString("CphaseCurrent")));
				d.setThreephaseCurrentSum(String.valueOf(resultSet.getString("threephaseCurrentSum")));
				d.setAphaseHasPower(String.valueOf(resultSet.getString("AphaseHasPower")));
				d.setBphaseHasPower(String.valueOf(resultSet.getString("BphaseHasPower")));
				d.setCphaseHasPower(String.valueOf(resultSet.getString("CphaseHasPower")));
				d.setTotalActivePower(String.valueOf(resultSet.getString("totalActivePower")));
				d.setAphaseReactivePower(String.valueOf(resultSet.getString("AphaseReactivePower")));
				d.setBphaseReactivePower(String.valueOf(resultSet.getString("BphaseReactivePower")));
				d.setCphaseReactivePower(String.valueOf(resultSet.getString("CphaseReactivePower")));
				d.setTotalReactivePower(String.valueOf(resultSet.getString("totalReactivePower")));
				d.setPhaseAPowerFactor(String.valueOf(resultSet.getString("phaseAPowerFactor")));
				d.setPhaseBPowerFactor(String.valueOf(resultSet.getString("phaseBPowerFactor")));
				d.setPhaseCPowerFactor(String.valueOf(resultSet.getString("phaseCPowerFactor")));
				d.setTotalPowerFactor(String.valueOf(resultSet.getString("totalPowerFactor")));
				d.setPowerFrequency(String.valueOf(resultSet.getString("powerFrequency")));
				d.setPhaseATotalElectConsump(String.valueOf(resultSet.getString("phaseATotalElectConsump")));
				d.setPhaseBTotalElectConsump(String.valueOf(resultSet.getString("phaseBTotalElectConsump")));
				d.setPhaseCTotalElectConsump(String.valueOf(resultSet.getString("phaseCTotalElectConsump")));
				d.setTotalElectrConsump(String.valueOf(resultSet.getString("totalElectrConsump")));
				d.setNBSignalStrength(String.valueOf(resultSet.getString("NBSignalStrength")));
				d.setAphaseLineTemp(String.valueOf(resultSet.getString("AphaseLineTemp")));
				d.setBphaseLineTemp(String.valueOf(resultSet.getString("BphaseLineTemp")));
				d.setCphaseLineTemp(String.valueOf(resultSet.getString("CphaseLineTemp")));
				ret.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
