package com.qf.servlet;

import com.qf.bean.Resident;
import com.qf.bean.Service;
import com.qf.dao.ResidentDAO;
import com.qf.dao.ResidentDAOImpl;
import com.qf.dao.ServiceDAO;
import com.qf.dao.ServiceDAOImpl;
import com.qf.util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class RoutePlanServlet extends HttpServlet {
    private static List<Resident> list;
    private static double currentLat;
    private static double currentLng;
    private static final int VOLUMN = 100;
    private static int volumn;
    private static int index;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoutePlan.allocateCommonTask();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



}
