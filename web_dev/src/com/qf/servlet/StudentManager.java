package com.qf.servlet;

import com.qf.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private StudentManager(){}
    //饿汉式单列设计  类一旦加载就会实例换StudentManager
    private final static StudentManager manager = new StudentManager();
    //通过StudentManager.getManager() 获得studentManager对象
    public static StudentManager getManager(){
        return manager;
    }


    private static List<Student> students = new ArrayList<Student>();

    //通过StudentManager 对象来获得students
    public List<Student> getStudents(){
        return students;
    }

    public Student userIsExist(String userName, String password){

        for (Student stu:students){
            if (stu.getUserName().equals(userName) && stu.getPassword().equals(password)){
                return stu;
            }
        }
        return null;
    }

    public boolean isUserExist(String userName){

        for (Student stu:students){
            if (stu.getUserName().equals(userName) ){
                return true;
            }
        }
        return false;
    }




}
