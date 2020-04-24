package com.qf.dao;

import com.qf.bean.Driver;
import com.qf.bean.Staff;

import java.sql.Connection;
import java.util.List;

/**
 * used to specify common operations on table Staff
 * @author Shihao.Liang
 *
 */
public interface StaffDAO {
	
	/**
	 * insert staff into the table
	 * 
	 * @param conn
	 * @param staff
	 */
	void insert(Connection conn, Staff staff);
	
	/**
	 * delete data by staffNo
	 * 
	 * @param conn
	 * @param staffNo
	 */
	void deleteByStaffNo(Connection conn, String staffNo);
	
	/**
	 * update the data based on staffNo
	 * 
	 * @param conn
	 * @param staff
	 */
	void update(Connection conn, Staff staff);
	
	/**
	 * get the data by staffNo
	 * 
	 * @param conn
	 * @param staffNo
	 * @return
	 */
	Staff getStaffByStaffNo(Connection conn, String staffNo);
	
	/**
	 * get all the data in this table
	 * 
	 * @param conn
	 * @return
	 */
	List<Staff> getAll(Connection conn);

	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);

	Staff staffNoPass(Connection conn, String staffNo, String password);

}
