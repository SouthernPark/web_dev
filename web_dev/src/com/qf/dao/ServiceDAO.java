package com.qf.dao;

import com.qf.bean.Service;

import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.util.List;

/**
 * used to specify common operations on table Service
 * @author Shihao.Liang
 *
 */
public interface ServiceDAO {
	/**
	 * insert service into the table
	 * 
	 * @param conn
	 * @param service
	 */
	void insert(Connection conn, Service service);

	void insertWitoutID(Connection conn, Service service);
	
	/**
	 * delete data by serviceID
	 * 
	 * @param conn
	 * @param serviceID
	 */
	void deleteByServiceID(Connection conn, int serviceID);
	
	/**
	 * update the data based on serviceID
	 * 
	 * @param conn
	 * @param service
	 */
	void update(Connection conn, Service service);


	
	/**
	 * get the data by serviceID
	 * 
	 * @param conn
	 * @param serviceID
	 * @return
	 */
	Service getServiceByServiceID(Connection conn, int serviceID);
	
	/**
	 * get all the data in this table
	 * 
	 * @param conn
	 * @return
	 */
	List<Service> getAll(Connection conn);

	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);

	int getResidentIDByEmail(Connection conn, String email);

	List<Service> getByResidentEmail(Connection conn, String email);

	String getAddressByEmail(Connection conn, String email);

	List<Service> getServiceByStaffNo(Connection conn, String staffNo);

}
