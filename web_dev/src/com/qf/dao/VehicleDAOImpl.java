package com.qf.dao;

import com.qf.bean.Vehicle;

import java.sql.Connection;
import java.util.List;

public class VehicleDAOImpl extends BaseDAO<Vehicle> implements VehicleDAO {

	@Override
	public void insert(Connection conn, Vehicle vehicle) {
		String sql = "insert into Vehicle(vehicleID,type,branchNo)values(?,?,?)";
		update(conn, sql, vehicle.getVehicleID(), vehicle.getType(), vehicle.getBranchNo());

	}

	@Override
	public void deleteByVehicleID(Connection conn, int vehicleID) {
		String sql = "delete from Vehicle where vehicleID=?";
		update(conn, sql, vehicleID);
	}

	@Override
	public void update(Connection conn, Vehicle vehicle) {
		String sql = "update Vehicle set vehicleID=?,type=?,branchNo=? where vehicleID=?";
		update(conn, sql, vehicle.getVehicleID(), vehicle.getType(), vehicle.getBranchNo(), vehicle.getVehicleID());

	}

	@Override
	public Vehicle getVehicleByVehicleID(Connection conn, int vehicleID) {
		String sql = "select * from Vehicle where vehicleID = ?";
		Vehicle vehicle = getInstance(conn, sql, vehicleID);
		return vehicle;
	}

	@Override
	public List<Vehicle> getAll(Connection conn) {
		String sql = "select * from Vehicle";
		List<Vehicle> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from Vehicle";
		return getValue(conn, sql);
	}

}
