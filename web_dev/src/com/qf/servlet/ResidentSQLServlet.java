package com.qf.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.bean.Resident;
import com.qf.dao.ResidentDAOImpl;
import com.qf.dao.ServiceDAOImpl;
import com.qf.util.DateUtil;
import com.qf.util.JDBCUtils;
import com.qf.util.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;

public class ResidentSQLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.set response format to json
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        //2.get the elements in the query string
        String queryString = req.getQueryString();
        HashMap<String, String> params = UrlUtil.queryStringParse(queryString);
        //method should be select update, delete
        String method = params.get("method");

        Resident resident = new Resident();
        ResidentDAOImpl dao = new ResidentDAOImpl();
        Connection conn = JDBCUtils.getConnection();

        if (method != null){
            if(method.equals("selectAll")){
                List<Resident> all = dao.getAll(conn);
                if(all==null){
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message", null);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                else{
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message",all);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                out.flush();
                out.close();
            }
            else if(method.equals("delete")){
                dao.deleteByResidentID(conn, Integer.parseInt(params.get("residentID")));
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message",null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
