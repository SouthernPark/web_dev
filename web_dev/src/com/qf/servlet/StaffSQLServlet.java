package com.qf.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.bean.Service;
import com.qf.bean.Staff;
import com.qf.dao.StaffDAOImpl;
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

public class StaffSQLServlet extends HttpServlet {
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

        //3.initialise a staff instance, get dao, get sql connection
        Staff staff = new Staff();
        StaffDAOImpl dao = new StaffDAOImpl();
        Connection conn = JDBCUtils.getConnection();

        if(method != null){
            if(method.equals("selectAll")){
                List<Staff> all = dao.getAll(conn);
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
                setStaffAttribute(params, staff);
                dao.update(conn, staff);

                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("select")){
                Staff sta = dao.getStaffByStaffNo(conn, params.get("staffNo"));
                if(sta==null){
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message", null);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                else{
                    List<Object> list = new ArrayList<Object>();
                    list.add(sta);
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message",list);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                out.flush();
                out.close();

            }
            else if(method.equals("insert")){
                setStaffAttribute(params, staff);
                dao.insert(conn, staff);
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else  if(method.equals("delete")){
                dao.deleteByStaffNo(conn, params.get("staffNo"));
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
        }

    }

    private void setStaffAttribute(HashMap<String, String> params, Staff staff) {
        staff.setStaffNo(params.get("staffNo"));
        staff.setName(params.get("name"));
        staff.setPosition(params.get("position"));
        staff.setSalary(Double.parseDouble(params.get("salary")));
        staff.setPhoneNo(Integer.parseInt(params.get("phoneNo")));
        staff.setBranchNo(Integer.parseInt(params.get("branchNo")));
        staff.setPassword(params.get("password"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
