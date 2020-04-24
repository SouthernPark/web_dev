package com.qf.servlet;


import com.qf.bean.Resident;
import com.qf.dao.ResidentDAOImpl;
import com.qf.util.JDBCUtils;
import com.qf.util.PasswordUtil;
import com.qf.util.RegisterCheckUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;

public class ResidentRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("location", "jumpRegister");
        System.out.println("doGet");
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("location", "jumpRegister");
        //message to remainder the resident
        String registerMsg = null;
        HttpSession session = req.getSession(false);
        //1.获取参数
        String userName = req.getParameter("usernamesignup");
        session.setAttribute("userName", userName);

        String password = req.getParameter("passwordsignup");
        session.setAttribute("password", password);
        String password_confirm = req.getParameter("passwordsignup_confirm");
        session.setAttribute("password_conform", password_confirm);

        String email = req.getParameter("emailsignup");
        session.setAttribute("email", email);

        String address = req.getParameter("address");
        session.setAttribute("address", address);

        String binVolume = req.getParameter("binVolume");
        session.setAttribute("binVolume", binVolume);

        String latitude = req.getParameter("latitude");
        session.setAttribute("latitude", latitude);

        String longitude = req.getParameter("longitude");
        session.setAttribute("longitude", longitude);

        /* deal with password */
        //test the format of the password
        registerMsg = RegisterCheckUtil.registerCheck(password, password_confirm, email, longitude, latitude, binVolume);

        if(registerMsg!=null){
            req.setAttribute("registerMsg", registerMsg);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        else{
            //return a date in format of YYYY-MM-dd
            Timestamp dateJoined = new Timestamp(System.currentTimeMillis());
            double lati = Double.parseDouble(latitude);
            double longi = Double.parseDouble(longitude);
            int bin = Integer.parseInt(binVolume);
            Resident resident = new Resident(userName, email, dateJoined, password, address, lati, longi, bin);
            Connection conn = JDBCUtils.getConnection();
            ResidentDAOImpl dao = new ResidentDAOImpl();
            dao.insert(conn, resident);
            req.setAttribute("msg", "Register Successfully.");
            //set location to null to make it in the login form
            req.setAttribute("location",null);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
