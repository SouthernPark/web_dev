package com.qf.dao;

import com.qf.bean.Resident;

import java.sql.Connection;
import java.util.List;


/**
 * used to specify common operations on table Resident
 * @author Shihao.Liang
 *
 */
public interface ResidentDAO {
	/**
	 * insert resident into the table
	 * 
	 * @param conn
	 * @param resident
	 */
	void insert(Connection conn, Resident resident);
	
	/**
	 * delete data by residentID
	 * 
	 * @param conn
	 * @param residentID
	 */
	void deleteByResidentID(Connection conn, int residentID);
	
	/**
	 * update the data based on residentID
	 * 
	 * @param conn
	 * @param resident
	 */
	void update(Connection conn, Resident resident);
	
	/**
	 * get the data by residentID
	 * 
	 * @param conn
	 * @param residentID
	 * @return
	 */
	Resident getResidentByResidentID(Connection conn, int residentID);
	
	/**
	 * get all the data in this table
	 * 
	 * @param conn
	 * @return
	 */
	List<Resident> getAll(Connection conn);

	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);

	Resident emailPassword(Connection conn, String email, String password);

	Resident email(Connection conn, String email);


	
}
