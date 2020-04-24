package com.qf.dao;

import com.qf.bean.Resident;
import com.qf.bean.Service;
import com.qf.util.JDBCUtils;

import java.sql.Connection;
import java.util.List;

public class ServiceDAOImpl extends BaseDAO<Service> implements ServiceDAO {

	@Override
	public void insert(Connection conn, Service service) {
		String sql = "insert into Service(serviceID,serviceType,serviceDate,residentID,serviceStatus, staffNo, serviceAddress)values(?,?,?,?,?,?,?)";
		update(conn, sql, service.getServiceID(), service.getServiceType(), service.getServiceDate(),
				service.getResidentID(), service.getServiceStatus(), service.getStaffNo(), service.getServiceAddress());
	}

	@Override
	public void insertWitoutID(Connection conn, Service service) {
		String sql = "insert into Service(serviceType,serviceDate,residentID,serviceStatus, serviceAddress)values(?,?,?,?,?)";
		update(conn, sql, service.getServiceType(), service.getServiceDate(),
				service.getResidentID(), service.getServiceStatus(), service.getServiceAddress());
	}

	@Override
	public void deleteByServiceID(Connection conn, int serviceID) {
		String sql = "delete from Service where serviceID=?";
		update(conn, sql, serviceID);
	}

	@Override
	public void update(Connection conn, Service service) {
		String sql = "update Service set serviceID=?,serviceStatus=?, staffNo=? where serviceID=?";
		update(conn, sql, service.getServiceID(), service.getServiceStatus(),service.getStaffNo(),service.getServiceID());
	}

	@Override
	public Service getServiceByServiceID(Connection conn, int serviceID) {
		String sql = "select * from Service where serviceID = ?";
		Service service = getInstance(conn, sql, serviceID);
		return service;
	}

	@Override
	public List<Service> getAll(Connection conn) {
		String sql = "select * from Service";
		List<Service> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from Service";
		return getValue(conn, sql);
	}

	@Override
	public List<Service> getByResidentEmail(Connection conn, String email) {
		//first get the resident ID according to the email
		ResidentDAOImpl dao = new ResidentDAOImpl();
		Resident res = dao.email(conn, email);
		if(res!=null){
			int residentID = res.getResidentID();
			String sql = "select * from service where residentID=?";
			Connection conn1 = JDBCUtils.getConnection();
			List<Service> list = getForList(conn1, sql, residentID);
			return list;
		}
		return null;
	}

	@Override
	public int getResidentIDByEmail(Connection conn, String email) {
		//first get the resident ID according to the email
		ResidentDAOImpl dao = new ResidentDAOImpl();
		Resident res = dao.email(conn, email);
		if(res!=null){
			int residentID = res.getResidentID();
			return residentID;
		}
		return 0;
	}

	@Override
	public String getAddressByEmail(Connection conn, String email) {
		//first get the resident ID according to the email
		ResidentDAOImpl dao = new ResidentDAOImpl();
		Resident res = dao.email(conn, email);

		if(res != null){
			String address = res.getAddress();
			return address;
		}
		return null;
	}

	@Override
	public List<Service> getServiceByStaffNo(Connection conn, String staffNo) {
		String sql = "select * from service where staffNo=?";
		List<Service> list = getForList(conn, sql, staffNo);
		return list;
	}


}
