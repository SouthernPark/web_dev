package com.qf.dao;

import com.qf.bean.Staff;

import java.sql.Connection;
import java.util.List;

public class StaffDAOImpl extends BaseDAO<Staff> implements StaffDAO {

	@Override
	public void insert(Connection conn, Staff staff) {
		String sql = "insert into Staff(staffNo,name,position,salary,phoneNo,branchNo,password)values(?,?,?,?,?,?,?)";
		update(conn, sql, staff.getStaffNo(), staff.getName(), staff.getPosition(), staff.getSalary(),
				staff.getPhoneNo(), staff.getBranchNo(),staff.getPassword());
	}

	@Override
	public void deleteByStaffNo(Connection conn, String staffNo) {
		String sql = "delete from Staff where staffNo=?";
		update(conn, sql, staffNo);
	}

	@Override
	public void update(Connection conn, Staff staff) {
		String sql = "update Staff set staffNo=?,name=?,position=?,salary=?,phoneNo=?,branchNo=?,password=? where staffNo=?";
		update(conn, sql, staff.getStaffNo(), staff.getName(), staff.getPosition(), staff.getSalary(),
				staff.getPhoneNo(), staff.getBranchNo(), staff.getPassword(),staff.getStaffNo());

	}

	@Override
	public Staff getStaffByStaffNo(Connection conn, String staffNo) {
		String sql = "select * from Staff where staffNo = ?";
		Staff staff = getInstance(conn, sql, staffNo);
		return staff;
	}

	@Override
	public List<Staff> getAll(Connection conn) {
		String sql = "select * from Staff";
		List<Staff> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from Staff";
		return getValue(conn, sql);
	}

	@Override
	public Staff staffNoPass(Connection conn, String staffNo, String password) {
		String sql = "select * from staff where staffNo=? and password=? ";

		Staff staff = getInstance(conn, sql, staffNo, password);

		return staff;
	}
}
