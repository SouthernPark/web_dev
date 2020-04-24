package com.qf.util;

import java.sql.*;

/**
 * �������ݿ�Ĺ�����
 * 
 * @author ������
 *
 */
public class JDBCUtils {


	public static Connection getConnection() {
		final String driverClass = "com.mysql.cj.jdbc.Driver";
		final String url = "jdbc:mysql://localhost:3306/web_dev?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";

		final String user = "root";
		final String password = "root";

		Connection conn = null;

		try {
			Class.forName(driverClass);

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * �ر����Ӻ�statement
	 * 
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, Statement ps) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ر�����,statement�ͽ����
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ͨ�õ���ɾ�Ĳ���
	 * 
	 * @param sql
	 * @param args
	 * @throws SQLException
	 */
	public int update(String sql, Object... args) {
		// ��ȡ���ݿ�����
		Connection conn = null;
		// Ԥ����sql���
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			// ���ռλ��
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			// ִ��
			// ִ�гɹ�����1
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			JDBCUtils.closeResource(conn, ps);
		}
		return 0;

	}

}
