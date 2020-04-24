package com.qf.servlet;

import com.qf.bean.Resident;
import com.qf.dao.ResidentDAO;
import com.qf.dao.ResidentDAOImpl;
import com.qf.util.JDBCUtils;
import com.qf.util.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

public class ResidentLoginServlet extends HttpServlet {
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
            HttpSession session = req.getSession(false);
            System.out.println(session);
            resp.addHeader("pragma","no-cache");
            if(session!=null && session.getAttribute("login") != null){
                if("r".equals(session.getAttribute("login"))){
                    resp.sendRedirect("./residentPage.html");
                }
                else{
                    req.getRequestDispatcher("index.jsp").forward(req,resp);
                }
            }
            else{
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //else the user

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        //build connection with mysql
        Connection conn = JDBCUtils.getConnection();
        //get Dao instance
        ResidentDAO rd = new ResidentDAOImpl();
        Resident res = rd.emailPassword(conn, email, password);

        //假设用户名为admin, 密码为admin
        //判断用户是否存在  (但还是有admin admin的)
        //登录成功
        //if there is such a resident, then jump to welcome page for resident
        if(res!= null){

            //once the user login we give it a session
            HttpSession session = req.getSession();
            //login in the session to represent the user has already login
            session.setAttribute("login", "r");
            //email as the identity for the resident
            session.setAttribute("email", email);
            System.out.println("用户登录成功" + session.getId());
            //jump to resident to welcome page
            resp.sendRedirect("./residentPage.html");
        }
        else{
            req.setAttribute("msg", "用户名密码错误");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
