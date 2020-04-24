package com.qf.util;

import com.qf.bean.Resident;
import com.qf.dao.ResidentDAOImpl;

import java.sql.Connection;

public class RegisterCheckUtil {
    public static String registerCheck(String password, String password_confirm, String email, String longitude, String latitude, String binVolume){
        String registerMsg =null;
        registerMsg = PasswordUtil.passwordValidation(password);
        if(registerMsg!=null){
            return registerMsg;
        }
        if(!password.equals(password_confirm)){
            //if the two passwords not equal
            registerMsg = "The two passwords are not equal";
            return registerMsg;
        }

        try{
            double longi = Double.parseDouble(longitude);
            double lati = Double.parseDouble(latitude);
        }catch (NumberFormatException e){
            System.out.println(e.getStackTrace());
            //if is not double,
            registerMsg = "The longitude and latitude should be number";
            return registerMsg;
        }

        try{
            int bin = Integer.parseInt(binVolume);
        }catch (NumberFormatException e){
            //if biVolumn is not a number
            System.out.println(e.getStackTrace());
            registerMsg = "The bin volume should be a number";
            return registerMsg;
        }

        //check whether the email has already exist
        ResidentDAOImpl dao = new ResidentDAOImpl();
        Connection conn = JDBCUtils.getConnection();
        Resident dResident = dao.email(conn,email);
        System.out.println(dResident);

        //there should not be a resident with same email address
        if(dResident != null){
            registerMsg = "The email has already been used";
            return registerMsg;
        }

        return null;
    }
}
