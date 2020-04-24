package com.qf.dao;

import com.qf.bean.Driver;

import java.sql.Connection;
import java.util.List;

/**
 * used to specify common operations on table Driver
 * 
 * @author Shihao.Liang
 */
public interface DriverDAO {

	/**
	 * insert driver into the table
	 * 
	 * @param conn
	 * @param driver
	 */
	void insert(Connection conn, Driver driver);
	
	/**
	 * delete data by staffNo
	 * @param conn
	 * @param staffNo
	 */
	void deleteByStaffNo(Connection conn, String staffNo);
	
	/**
	 * update the data based on staffNo
	 * @param conn
	 * @param driver
	 */
	void update(Connection conn, Driver driver);

	void updateStatusByStaffNo(Connection conn, String staffNo);
	
	/**
	 * get the data by staffNo
	 * @param conn
	 * @param staffNo
	 * @return
	 */
	Driver getDriverByStaffNo(Connection conn, String staffNo);

	void serviceFinish(Connection conn, int serviceID, String staffNo);


	/**
	 * get all the data in this table
	 * 
	 * @param conn
	 * @return
	 */
	List<Driver> getAll(Connection conn);
	
	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);



}
