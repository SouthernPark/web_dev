package com.qf.dao;

import com.qf.bean.Resident;

import java.sql.Connection;
import java.util.List;

public class ResidentDAOImpl extends BaseDAO<Resident> implements ResidentDAO {

	@Override
	public void insert(Connection conn, Resident resident) {
		String sql = "insert into Resident(residentID,name,email,dateJoined,password,branchNo,address,latitude,longitude,binVolume)values(?,?,?,?,?,?,?,?,?,?)";
		update(conn, sql, resident.getResidentID(), resident.getName(), resident.getEmail(), resident.getDateJoined(),
				resident.getPassword(), resident.getBranchNo(), resident.getAddress(), resident.getLatitude(),
				resident.getLongitude(),resident.getBinVolume());
	}

	@Override
	public void deleteByResidentID(Connection conn, int residentID) {
		String sql = "delete from Resident where residentID=?";
		update(conn, sql, residentID);
	}

	@Override
	public void update(Connection conn, Resident resident) {
		String sql = "update Resident set residentID=?,name=?,email=?,dateJoined=?,password=?,branchNo=?,address=?,latitude=?,longitude=?,binVolume=? where residentID=?";
		update(conn, sql, resident.getResidentID(), resident.getName(), resident.getEmail(), resident.getDateJoined(),
				resident.getPassword(), resident.getBranchNo(), resident.getAddress(), resident.getLatitude(),
				resident.getLongitude(), resident.getBinVolume(), resident.getResidentID());
	}

	@Override
	public Resident getResidentByResidentID(Connection conn, int residentID) {
		String sql = "select * from Resident where residentID = ?";
		Resident resident = getInstance(conn, sql, residentID);
		return resident;
	}

	@Override
	public List<Resident> getAll(Connection conn) {
		String sql = "select * from Resident";
		List<Resident> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from Resident";
		return getValue(conn, sql);
	}

	@Override
	public Resident emailPassword(Connection conn, String email, String password) {
		String sql = "select * from resident where email=? AND password=?";

		Resident resident=getInstance(conn, sql, email, password);

		return resident;
	}

	@Override
	public Resident email(Connection conn, String email) {
		String sql = "select * from resident where email=?";
		Resident resident=getInstance(conn, sql, email);
		return resident;
	}
}
