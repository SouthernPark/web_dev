package com.qf.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.bean.Driver;
import com.qf.bean.Staff;
import com.qf.dao.DriverDAOImpl;
import com.qf.util.JDBCUtils;
import com.qf.util.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DriverSQLServlet extends HttpServlet {

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

        //3. initialise a driver instance
        Driver driver = new Driver();
        DriverDAOImpl dao = new DriverDAOImpl();
        Connection conn = JDBCUtils.getConnection();

        if (method != null){
            if (method.equals("selectAll")){
                List<Driver> all = dao.getAll(conn);
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
            else if(method.equals("update")){
                driver.setStaffNo(params.get("staffNo"));
                driver.setCarAllowance(params.get("carAllowance"));
                driver.setWorkState(params.get("workState"));
                driver.setTaskForDriver(params.get("taskForDriver"));
                dao.update(conn, driver);

                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();

            }
            else if(method.equals("select")){
                Driver dri = dao.getDriverByStaffNo(conn, params.get("staffNo"));
                if(dri==null){
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message", null);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));

                }
                else{
                    List<Object> list = new ArrayList<Object>();
                    list.add(dri);
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message",list);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                out.flush();
                out.close();
            }
            else if(method.equals("insert")){
                driver.setStaffNo(params.get("staffNo"));
                driver.setCarAllowance("100");
                driver.setWorkState("Available");
                if(params.get("taskForDriver")!=null){
                    driver.setTaskForDriver(params.get("taskForDriver"));
                }
                dao.insert(conn, driver);

                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();

            }
            else if(method.equals("delete")){
                dao.deleteByStaffNo(conn, params.get("staffNo"));

                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if (method.equals("serviceFinished")){
                int serviceID = Integer.parseInt(params.get("serviceID"));
                dao.serviceFinish(conn, serviceID, params.get("staffNo"));
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
