package com.qf.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.bean.Service;
import com.qf.dao.DriverDAOImpl;
import com.qf.dao.ServiceDAOImpl;
import com.qf.util.DateUtil;
import com.qf.util.JDBCUtils;
import com.qf.util.UrlUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ServiceSQLServlet extends HttpServlet {
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

        //3.实例化Service对象
        Service ser = new Service();

        ServiceDAOImpl dao = new ServiceDAOImpl();
        Connection conn = JDBCUtils.getConnection();
        if (method!=null){
            if(method.equals("selectAll")){
                List<Service> all = dao.getAll(conn);
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
                //allocate tasks to the driver
                ser.setServiceID(Integer.parseInt(params.get("serviceID")));
                ser.setStaffNo(params.get("staffNo"));
                ser.setServiceStatus(params.get("serviceStatus"));
                dao.update(conn, ser);
                //change the status of the driver
                DriverDAOImpl Ddao = new DriverDAOImpl();
                Connection conn1 = JDBCUtils.getConnection();
                Ddao.updateStatusByStaffNo(conn1, params.get("staffNo"));

                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("select"))
            {
                ser.setServiceID(Integer.parseInt(params.get("serviceID")));
                Service selectedSer = dao.getServiceByServiceID(conn, ser.getServiceID());
                System.out.println(selectedSer);
                if(selectedSer==null){
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message", null);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                else{
                    List<Object> list = new ArrayList<Object>();
                    list.add(selectedSer);
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message",list);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                out.flush();
                out.close();
            }
            else if(method.equals("insert")){
                setServiceAttribute(params, ser);
                dao.insert(conn,ser);
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("delete")){
                dao.deleteByServiceID(conn,Integer.parseInt(params.get("serviceID")));
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("getServiceByEmail")){
                HttpSession session = req.getSession(false);
                String email = (String) session.getAttribute("email");
                List<Service> all = dao.getByResidentEmail(conn, email);
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
            }
            else if(method.equals("insertService")){
                HttpSession session = req.getSession(false);
                String email = (String) session.getAttribute("email");
                int residentID = dao.getResidentIDByEmail(conn, email);
                ser.setResidentID(residentID);
                ser.setServiceType("urgent");
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                ser.setServiceDate(timestamp);
                ser.setServiceStatus("waiting");
                Connection conn1 = JDBCUtils.getConnection();
                String address = dao.getAddressByEmail(conn1, email);
                ser.setServiceAddress(address);
                Connection conn2 = JDBCUtils.getConnection();
                dao.insertWitoutID(conn2, ser);

                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("getServiceByStaffNo")){
                HttpSession session = req.getSession();
                String staffNo = (String) session.getAttribute("staffNo");
                List<Service> all = dao.getServiceByStaffNo(conn, staffNo);
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

            else if(method.equals("getAddressByServiceID")){
                System.out.println(Integer.parseInt(params.get("serviceID")));
                Service service = dao.getServiceByServiceID(conn, Integer.parseInt(params.get("serviceID")));
                String address = service.getServiceAddress();
                System.out.println(address);
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", address);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
            }
        }


    }

    private void setServiceAttribute(HashMap<String, String> params, Service ser) {
        ser.setServiceID(Integer.parseInt(params.get("serviceID")));
        ser.setServiceType(params.get("serviceType"));
        Timestamp timestamp = DateUtil.strToTimestamp(params.get("serviceDate"));
        ser.setServiceDate(timestamp);
        ser.setServiceStatus(params.get("serviceStatus"));
        ser.setStaffNo(params.get("staffNo"));
        ser.setResidentID(Integer.parseInt(params.get("residentID")));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
