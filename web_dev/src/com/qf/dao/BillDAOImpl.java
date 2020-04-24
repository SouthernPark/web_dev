package com.qf.dao;

import com.qf.bean.Bill;

import java.sql.Connection;
import java.util.List;

public class BillDAOImpl extends BaseDAO<Bill> implements BillDAO {

	@Override
	public void insert(Connection conn, Bill bill) {
		String sql = "insert into Bill(amount,serviceID)values(?,?)";
		update(conn, sql, bill.getAmount(), bill.getServiceID());
	}

	@Override
	public void deleteByBillNo(Connection conn, int billNo) {
		String sql = "delete from Bill where billNo=?";
		update(conn, sql, billNo);

	}

	@Override
	public void update(Connection conn, Bill bill) {
		String sql = "update Bill set billNo=?,amount=?,serviceID=? where billNo=?";
		update(conn, sql, bill.getBillNo(), bill.getAmount(), bill.getServiceID(), bill.getBillNo());

	}

	@Override
	public Bill getBillByBillNo(Connection conn, int billNo) {
		String sql = "select * from Bill where billNo = ?";
		Bill bill = getInstance(conn, sql, billNo);
		return bill;
	}

	@Override
	public List<Bill> getAll(Connection conn) {
		String sql = "select * from Bill";
		List<Bill> list = getForList(conn, sql);
		return list;
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from Bill";
		return getValue(conn, sql);
	}

}
