package com.qf.dao;

import com.qf.bean.Vehicle;

import java.sql.Connection;
import java.util.List;

/**
 * used to specify common operations on table Vehicle
 * @author Shihao.Liang
 *
 */
public interface VehicleDAO {
	
	/**
	 * insert vehicle into the table
	 * 
	 * @param conn
	 * @param vehicle
	 */
	void insert(Connection conn, Vehicle vehicle);
	
	/**
	 * delete data by vehicleID
	 * 
	 * @param conn
	 * @param vehicleID
	 */
	void deleteByVehicleID(Connection conn, int vehicleID);
	
	/**
	 * update the data based on vehicleID
	 * 
	 * @param conn
	 * @param vehicle
	 */
	void update(Connection conn, Vehicle vehicle);
	
	/**
	 * get the data by vehicleID
	 * 
	 * @param conn
	 * @param vehicleID
	 * @return
	 */
	Vehicle getVehicleByVehicleID(Connection conn, int vehicleID);
	
	/**
	 * get all the data in this table
	 * 
	 * @param conn
	 * @return
	 */
	List<Vehicle> getAll(Connection conn);

	/**
	 * get the count
	 * 
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);
	
}
