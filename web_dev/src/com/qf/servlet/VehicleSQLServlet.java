package com.qf.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.bean.Vehicle;
import com.qf.dao.VehicleDAOImpl;
import com.qf.util.JDBCUtils;
import com.qf.util.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleSQLServlet extends HttpServlet {
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

        Vehicle vehicle = new Vehicle();
        VehicleDAOImpl dao = new VehicleDAOImpl();
        Connection conn = JDBCUtils.getConnection();

        if(method!=null){
            if (method.equals("selectAll")){
                List<Vehicle> all = dao.getAll(conn);
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
                vehicle.setVehicleID(Integer.parseInt(params.get("vehicleID")));
                vehicle.setType(params.get("type"));
                vehicle.setBranchNo(Integer.parseInt(params.get("branchNo")));
                dao.update(conn, vehicle);
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("insert")){
                vehicle.setVehicleID(Integer.parseInt(params.get("vehicleID")));
                vehicle.setType(params.get("type"));
                if(params.get("branchNo")!=null){
                    vehicle.setBranchNo(Integer.parseInt(params.get("branchNo")));
                }
                dao.insert(conn, vehicle);

                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }

            else if(method.equals("delete")){
                dao.deleteByVehicleID(conn, Integer.parseInt(params.get("vehicleID")));
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }

            else if(method.equals("select")){
                Vehicle vehi = dao.getVehicleByVehicleID(conn, Integer.parseInt(params.get("vehicleID")));
                List<Object> list = new ArrayList<Object>();
                if(vehi==null){
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message", null);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                else{
                    HashMap<Object, Object> map = new HashMap<>();
                    list.add(vehi);
                    map.put("message",list);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                out.flush();
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
