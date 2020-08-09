package com.example.diustudentsupport.pojo;

import java.io.Serializable;

public class TeacherInfo implements Serializable {
    int _id;
    String _name;
    String _teacher_initial;
    String _employee_id;
    String _designation;
    String _department;
    String _faculty;
    String _personal_web_page;
    String _email;
    String _cell_phone_no;

    // total 10

    public TeacherInfo(){
    }
    public TeacherInfo(int id, String name, String teacher_initial, String employee_id, String designation,
                       String department, String faculty, String personal_web_page, String email, String _cell_phone_no){
        this._id = id;
        this._name = name;
        this._teacher_initial = teacher_initial;
        this._employee_id = employee_id;
        this._designation = designation;
        this._department = department;
        this._faculty = faculty;
        this._personal_web_page = personal_web_page;
        this._email = email;
        this._cell_phone_no = _cell_phone_no;

    }
    public TeacherInfo(String name, String teacher_initial, String employee_id, String designation,
                       String department, String faculty, String personal_web_page, String email, String _cell_phone_no){
        this._name = name;
        this._teacher_initial = teacher_initial;
        this._employee_id = employee_id;
        this._designation = designation;
        this._department = department;
        this._faculty = faculty;
        this._personal_web_page = personal_web_page;
        this._email = email;
        this._cell_phone_no = _cell_phone_no;
    }

    public int getID(){
        return this._id;
    }
    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }
    public void setName(String name){
        this._name = name;
    }

    public String getTeacherInitial(){
        return this._teacher_initial;
    }
    public void setTeacherInitial(String teacherInitial){
        this._teacher_initial = teacherInitial;
    }

    public String getEmployeeID(){
        return this._employee_id;
    }
    public void setEmployeeID(String employeeID){
        this._employee_id = employeeID;
    }

    public String getDesignation(){
        return this._designation;
    }
    public void setDesignation(String designation){
        this._designation = designation;
    }

    public String getDepartment(){
        return this._department;
    }
    public void setDepartment(String department){
        this._department = department;
    }

    public String getFaculty(){
        return this._faculty;
    }
    public void setFaculty(String faculty){
        this._faculty = faculty;
    }

    public String getPWebPage(){
        return this._personal_web_page;
    }
    public void setPWebPage(String personal_web_page){
        this._personal_web_page = personal_web_page;
    }

    public String getEmail(){
        return this._email;
    }
    public void setEmail(String email){
        this._email = email;
    }

    public String getCellPhone(){
        return this._cell_phone_no;
    }
    public void setCellPhone(String cell_phone_no){
        this._cell_phone_no = cell_phone_no;
    }

}
