package com.qf.dao;

import com.qf.bean.Driver;
import com.qf.util.JDBCUtils;

import java.sql.Connection;
import java.util.List;

public class DriverDAOImpl extends BaseDAO<Driver> implements DriverDAO {

	@Override
	public void insert(Connection conn, Driver driver) {
		String sql = "insert into Driver(staffNo,carAllowance,workState,taskForDriver)values(?,?,?,?)";
		update(conn, sql, driver.getStaffNo(), driver.getCarAllowance(), driver.getWorkState(),driver.getTaskForDriver());
	}

	@Override
	public void deleteByStaffNo(Connection conn, String staffNo) {
		String sql = "delete from Driver where staffNo=?";
		update(conn, sql, staffNo);
	}

	@Override
	public void update(Connection conn, Driver driver) {
		String sql = "update Driver set staffNo=?,carAllowance=?,workState=?,taskForDriver=? where staffNo=?";
		update(conn, sql, driver.getStaffNo(), driver.getCarAllowance(), driver.getWorkState(), driver.getTaskForDriver(), driver.getStaffNo());
	}

	@Override
	public Driver getDriverByStaffNo(Connection conn, String staffNo) {
		String sql = "select * from Driver where staffNo = ?";
		Driver driver = getInstance(conn, sql, staffNo);
		return driver;
	}

	@Override
	public List<Driver> getAll(Connection conn) {
		String sql = "select * from Driver";
		List<Driver> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from Driver";
		return getValue(conn, sql);
	}

	@Override
	public void serviceFinish(Connection conn,int serviceID, String staffNo) {
		String sql = "update service set serviceStatus='finished' where serviceID=?";
		update(conn, sql, serviceID);

		Connection conn1 = JDBCUtils.getConnection();
		String sql1 = "update driver set workState='available' where staffNo=?";
		update(conn1, sql1, staffNo);
	}

	@Override
	public void updateStatusByStaffNo(Connection conn, String staffNo) {
		String sql = "update driver set workState='Busy' where staffNo=?" ;
		update(conn,sql,staffNo);
	}
}
