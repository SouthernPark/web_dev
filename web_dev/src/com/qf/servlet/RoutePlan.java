package com.qf.servlet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import com.qf.bean.Resident;
import com.qf.bean.Service;
import com.qf.dao.ResidentDAO;
import com.qf.dao.ResidentDAOImpl;
import com.qf.dao.ServiceDAO;
import com.qf.dao.ServiceDAOImpl;
import com.qf.util.JDBCUtils;

public class RoutePlan {
	private static List<Resident> list;
	private static double currentLat;
	private static double currentLng;
	private static final int VOLUMN = 100;
	private static int volumn;
	private static int index;

	/**
	 * this function is used to get connection to the database and get the list of
	 * all residents
	 */
	public static void init() {
		// connect to database
		Connection conn = JDBCUtils.getConnection();

		ResidentDAO rd = new ResidentDAOImpl();
		// get list of all residents
		list = rd.getAll(conn);
		System.out.println(list.size());
		System.out.println(list.get(0).toString());
		currentLat = 53.4109964;
		currentLng = -2.9991283;
		volumn = 0;
		index = 1;

	}
	
	public static void allocateCommonTask() {
		init();
		

		// initialize service DAO
		ServiceDAO sd = new ServiceDAOImpl();
		
		Service s = null;
		System.out.println(list.size());
		
		String tasks = "";

		System.out.println(list.size());
		
		while(!list.isEmpty()) {
			String str = calculateDistance(list, currentLat, currentLng);
			if(str.equals("")) {
				System.out.println(tasks);
				s = new Service();
				s.setServiceType("Common");
				s.setServiceDate(new Timestamp(System.currentTimeMillis()));
				s.setResidentID(1);
				s.setServiceStatus("waiting");
				s.setServiceAddress(tasks);
				// initialize connection
				Connection conn = JDBCUtils.getConnection();
				sd.insertWitoutID(conn, s);
				
				tasks = "";
				s = null;
				volumn = 0;
				currentLat = 53.4109964;
				currentLng = -2.9991283;
			} else if (tasks.equals("")) {
				tasks += str;
			} else {
				tasks += "|";
				tasks += str;
			}
			
			if (list.isEmpty() && !tasks.equals("")) {
				s = new Service();
				s.setServiceType("Common");
				s.setServiceDate(new Timestamp(System.currentTimeMillis()));
				s.setResidentID(1);
				s.setServiceStatus("waiting");
				s.setServiceAddress(tasks);
				// initialize connection
				Connection conn = JDBCUtils.getConnection();
				sd.insertWitoutID(conn, s);
				
				s = null;
			}
		}
	}

	/**
	 * this method is used to calculate the min distance and return the
	 * corresponding address
	 * 
	 * @param
	 * @return
	 */



	public static String calculateDistance(List<Resident> list, double lat, double lng) {
		int min = -1;
		double minDistance = Integer.MAX_VALUE;
		double relative = Math.pow(lat - 53.4109964, 2) + Math.pow(lng - -2.9991283, 2);

		// calculate distance
		for (int i = 0; i < list.size(); i++) {
			double temp = Math.pow(lat - list.get(i).getLatitude(), 2) + Math.pow(lng - list.get(i).getLongitude(), 2);
			if (temp < minDistance) {
				minDistance = temp;
				min = i;
			}
		}

		volumn += list.get(min).getBinVolume();

		if (volumn > VOLUMN) {
			return "";
		}

		// get address
		String address = list.get(min).getAddress();

		currentLat = list.get(min).getLatitude();
		currentLng = list.get(min).getLongitude();

		// System.out.println("remove: " + list.get(min));
		list.remove(min);

		return address;

	}
}
