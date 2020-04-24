package com.qf.dao;

import com.qf.bean.Bill;

import java.sql.Connection;
import java.util.List;

/**
 * Used to specify common operations on table Bill
 * 
 * @author Shihao.Liang
 *
 */
public interface BillDAO {

	/**
	 * insert bill into the table
	 * 
	 * @param conn
	 * @param bill
	 */
	void insert(Connection conn, Bill bill);

	/**
	 * delete data by billNo
	 * 
	 * @param conn
	 * @param billNo
	 */
	void deleteByBillNo(Connection conn, int billNo);

	/**
	 * update the data based on billNo
	 * 
	 * @param conn
	 * @param bill
	 */
	void update(Connection conn, Bill bill);

	/**
	 * get the data by billNo
	 * 
	 * @param conn
	 * @param billNo
	 * @return
	 */
	Bill getBillByBillNo(Connection conn, int billNo);

	/**
	 * get all the data in this table
	 * 
	 * @param conn
	 * @return
	 */
	List<Bill> getAll(Connection conn);

	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);
}
