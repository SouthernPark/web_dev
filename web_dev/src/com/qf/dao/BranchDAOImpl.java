package com.qf.dao;

import com.qf.bean.Branch;

import java.sql.Connection;
import java.util.List;

public class BranchDAOImpl extends BaseDAO<Branch> implements BranchDAO {

	@Override
	public void insert(Connection conn, Branch branch) {
		String sql = "insert into Branch(branchNo,address,zip,telNo,recyclingCenterAddress)";
		update(conn, sql, branch.getBranchNo(), branch.getAddress(), branch.getZip(), branch.getTelNo(),
				branch.getRecyclingCenterAddress());

	}

	@Override
	public void deleteByBranchNo(Connection conn, int branchNo) {
		String sql = "delete from Branch where branchNo=?";
		update(conn,sql,branchNo);
	}

	@Override
	public void update(Connection conn, Branch branch) {
		String sql = "update Branch set branchNo=?,address=?,zip=?,telNo=?,recyclingCenterAddress=? where branchNo=?";
		update(conn,sql,branch.getBranchNo(),branch.getAddress(),branch.getZip(),branch.getTelNo(),branch.getRecyclingCenterAddress(),branch.getBranchNo());
	}

	@Override
	public Branch getBranchByBranchNo(Connection conn, int branchNo) {
		String sql = "select * from Branch where branchNo=?";
		Branch branch = getInstance(conn, sql, branchNo);
		return branch;
	}

	@Override
	public List<Branch> getAll(Connection conn) {
		String sql = "select * from Branch";
		List<Branch> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from Branch";
		return getValue(conn, sql);
	}

}
