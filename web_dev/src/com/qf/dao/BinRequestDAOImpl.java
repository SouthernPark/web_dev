package com.qf.dao;

import com.qf.bean.BinRequest;

import java.sql.Connection;
import java.util.List;

public class BinRequestDAOImpl extends BaseDAO<BinRequest> implements BinRequestDAO {

	@Override
	public void insert(Connection conn, BinRequest binRequest) {
		String sql = "insert into BinRequest(serviceID,binVolumn,binAmount,serviceType)values(?,?,?,?)";
		update(conn, sql, binRequest.getServiceID(), binRequest.getBinVolumn(), binRequest.getBinAmount(),binRequest.getServiceType());
	}

	@Override
	public void deleteByServiceID(Connection conn, int serviceID) {
		String sql = "delete from BinRequest where serviceID=?";
		update(conn,sql,serviceID);
	}

	@Override
	public void update(Connection conn, BinRequest binRequest) {
		String sql = "update BinRequest set serviceID=?,binVolumn=?,binAmount=?,serviceType=? where serviceID=?";
		update(conn,sql,binRequest.getServiceID(),binRequest.getBinVolumn(),binRequest.getBinAmount(),binRequest.getServiceType(),binRequest.getServiceID());
		
	}

	@Override
	public BinRequest getBinRequestByServiceID(Connection conn, int serviceID) {
		String sql = "select * from BinRequest where serviceID=?";
		BinRequest binRequest = getInstance(conn, sql, serviceID);
		return binRequest;
	}

	@Override
	public List<BinRequest> getAll(Connection conn) {
		String sql = "select * from BinRequest";
		List<BinRequest> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from BinRequest";
		return getValue(conn, sql);
	}

}
