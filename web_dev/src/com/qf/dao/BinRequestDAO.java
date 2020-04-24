package com.qf.dao;

import com.qf.bean.BinRequest;

import java.sql.Connection;
import java.util.List;

/**
 * used to specify common operations on table BinRequest
 * 
 * @author Shiaho.Liang
 *
 */
public interface BinRequestDAO {

	/**
	 * insert binRequest into the table
	 * 
	 * @param conn
	 * @param binRequest
	 */
	void insert(Connection conn, BinRequest binRequest);

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
	 * @param binRequest
	 */
	void update(Connection conn, BinRequest binRequest);

	/**
	 * get the data by serviceID
	 * 
	 * @param conn
	 * @param serviceID
	 * @return
	 */
	BinRequest getBinRequestByServiceID(Connection conn, int serviceID);

	/**
	 * get all the data in this table
	 * 
	 * @param conn
	 * @return
	 */
	List<BinRequest> getAll(Connection conn);

	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);

}
