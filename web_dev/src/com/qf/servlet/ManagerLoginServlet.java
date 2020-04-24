package com.qf.servlet;

import com.qf.bean.Staff;
import com.qf.dao.StaffDAOImpl;
import com.qf.util.JDBCUtils;
import com.qf.util.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

public class ManagerLoginServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String queryString = req.getQueryString();

        if(queryString!=null){
            if(req.getSession(false)==null){
                resp.sendRedirect("./index.jsp");
            }
            else{
                req.getSession(false).invalidate();
                //invalidate session and redirect to logout.html
                resp.sendRedirect("./index.jsp");
            }
        }
        else{
            //get session
            HttpSession session = req.getSession(false);
            System.out.println(session);
            resp.addHeader("pragma","no-cache");
            //whether the driver has already log in
            if(session!=null && session.getAttribute("login") != null){
                if("m".equals(session.getAttribute("login"))){
                    //if the manager already log in jump to welcome page
                    resp.sendRedirect("./service.html");
                }
                else{
                    //else jump to login page index3.jsp
                    req.getRequestDispatcher("index3.jsp").forward(req,resp);
                }
            }
            else{
                //else jump to login page index3.jsp
                req.getRequestDispatcher("index3.jsp").forward(req,resp);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost()");
        String staffNo = req.getParameter("staffNo");
        String password = req.getParameter("password");

        //build connection with mysql
        Connection conn = JDBCUtils.getConnection();

        //manager is also a staff
        StaffDAOImpl dao = new StaffDAOImpl();
        Staff manager = dao.staffNoPass(conn, staffNo, password);

        if(manager!=null){
            String position = manager.getPosition();
            //if it is not a driver
            if(!"manager".equals(position)){
                req.setAttribute("msg", "You are not a manager!!");
                req.getRequestDispatcher("index3.jsp").forward(req,resp);
            }
            else{
                //once the user login we give it a session
                HttpSession session = req.getSession();
                //login in the session to represent the user has already login
                session.setAttribute("login", "m");
                session.setAttribute("staffNo", staffNo);

                System.out.println("用户登录成功" + session.getId());
                //jump to resident to welcome page
                resp.sendRedirect("./service.html");
            }
        }
        else {
            req.setAttribute("msg", "用户名密码错误");
            req.getRequestDispatcher("index3.jsp").forward(req,resp);
        }

    }
}
