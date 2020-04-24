package com.qf.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.bean.Bill;
import com.qf.bean.Resident;
import com.qf.bean.Service;
import com.qf.dao.BillDAOImpl;
import com.qf.dao.ResidentDAOImpl;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillSQLServlet extends HttpServlet {
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

        //3. initialise a bill instance
        Bill bill = new Bill();
        BillDAOImpl dao = new BillDAOImpl();
        Connection conn = JDBCUtils.getConnection();
        if(method!=null){
            if(method.equals("selectAll")){
                List<Bill> all = dao.getAll(conn);
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
                bill.setBillNo(Integer.parseInt(params.get("billNo")));
                bill.setAmount(Double.parseDouble(params.get("amount")));
                bill.setServiceID(Integer.parseInt(params.get("serviceID")));
                dao.update(conn, bill);
                //return json
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("insert")){
                HttpSession session = req.getSession(false);
                ResidentDAOImpl rdao = new ResidentDAOImpl();
                String email = (String) session.getAttribute("email");
                Resident r = rdao.email(conn, email);

                bill.setAmount(100);
                bill.setServiceID(12); //can not get service ID
                dao.insert(conn, bill);
                //return json
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("delete")){
                dao.deleteByBillNo(conn, Integer.parseInt(params.get("billNo")));
                //return json
                HashMap<Object, Object> map = new HashMap<>();
                map.put("message", null);
                map.put("status",0);
                out.println(JSON.toJSONString(map));
                out.flush();
                out.close();
            }
            else if(method.equals("select")){
                Bill bi = dao.getBillByBillNo(conn, Integer.parseInt(params.get("billNo")));
                List<Object> list = new ArrayList<Object>();
                if(bi==null){
                    //return json
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("message", null);
                    map.put("status",0);
                    out.println(JSON.toJSONString(map));
                }
                else{
                    HashMap<Object, Object> map = new HashMap<>();
                    list.add(bi);
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
