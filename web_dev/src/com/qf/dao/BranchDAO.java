package com.qf.dao;

import com.qf.bean.Branch;

import java.sql.Connection;
import java.util.List;

/**
 * used to specify common operations on table Branch
 * @author Shihao.Liang
 *
 */
public interface BranchDAO {
	
	/**
	 * insert branch into the table
	 * @param conn
	 * @param branch
	 */
	void insert(Connection conn, Branch branch);
	
	/**
	 * delete data by branchNo
	 * @param conn
	 * @param branchNo
	 */
	void deleteByBranchNo(Connection conn, int branchNo);
	
	/**
	 * update the data based on branchNp
	 * @param conn
	 * @param branch
	 */
	void update(Connection conn, Branch branch);
	
	/**
	 * get the data by branchNo
	 * @param conn
	 * @param branchNo
	 * @return
	 */
	Branch getBranchByBranchNo(Connection conn, int branchNo);
	
	/**
	 * get all the data in this table
	 * @param conn
	 * @return
	 */
	List<Branch> getAll(Connection conn);
	
	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);
}
