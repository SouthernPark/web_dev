package com.qf.dao;

import com.qf.util.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ��װ����������ݱ��ͨ�ò���
 * 
 * @author ������
 *
 */
public abstract class BaseDAO <T> {
	
	private Class<T> clazz = null;
	
	{
		// ��ȡ��ǰBaseDAO������̳еĸ����еķ���
		Type genericSuperClass = this.getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) genericSuperClass;
		
		Type[] typeArguments = paramType.getActualTypeArguments(); // ��ȡ����ķ���
		clazz = (Class<T>) typeArguments[0]; // ���͵ĵ�һ������
	}
	
	// ���ڲ�ѯ����ֵ��ͨ�÷���������count()
	public <E> E getValue(Connection conn, String sql, Object...args) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			rs = ps.executeQuery();
			if(rs.next()) {
				return (E) rs.getObject(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;		
	}

	// ͨ�õĲ�ѯ���������ڷ��ض������
	public List<T> getForList(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			rs = ps.executeQuery();
			// ��ȡ�����Ԫ����
			ResultSetMetaData rsmd = rs.getMetaData();
			// ͨ��ResultSetMetaData��ȡ������е�����
			int columnCount = rsmd.getColumnCount();
			// �������϶���
			ArrayList<T> list = new ArrayList<T>();
			while (rs.next()) {
				T t = clazz.newInstance();
				// ����һ�������е�ÿһ����
				for (int i = 0; i < columnCount; i++) {
					// ��ȡ��ֵ
					Object columnValue = rs.getObject(i + 1);

					// ��ȡÿ���е�����
					// String columnName = rsmd.getColumnName(i + 1);
					// ��ȡÿ���еı���
					String columnLabel = rsmd.getColumnLabel(i + 1);
					// ��stud����ָ����columnName���ԣ���ֵΪcolumnValue,ͨ������
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);
			}
			// ���û�鵽list��size��0
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}

		return null;
	}

	// ͨ�õĲ�ѯ���������ڷ������ݱ��е�һ����¼
	public T getInstance(Connection conn, String sql, Object... args){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//set the place holder
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			//run the sql
			rs = ps.executeQuery();
			// get the result
			ResultSetMetaData rsmd = rs.getMetaData();
			// ͨ��ResultSetMetaData��ȡ������е�����
			int columnCount = rsmd.getColumnCount();
			if (rs.next()) {
				T t = clazz.newInstance();
				// ����һ�������е�ÿһ����
				for (int i = 0; i < columnCount; i++) {
					// ��ȡ��ֵ
					Object columnValue = rs.getObject(i + 1);

					// ��ȡÿ���е�����
					// String columnName = rsmd.getColumnName(i + 1);
					// ��ȡÿ���еı���
					String columnLabel = rsmd.getColumnLabel(i + 1);
					// ��stud����ָ����columnName���ԣ���ֵΪcolumnValue,ͨ������
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}

	// ͨ�õ���ɾ�Ĳ�������������
	public int update(Connection conn, String sql, Object... args) {
		// Ԥ����sql���
		PreparedStatement ps = null;
		try {
			// Ԥ����sql��䣬����PreparedStatement��ʵ��
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
