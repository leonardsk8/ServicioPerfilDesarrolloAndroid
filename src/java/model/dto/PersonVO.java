/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author leonardo
 */
public class PersonVO {
    private String user_identification;
    private String user_name;
    private String user_surname;
    private String user_birth;
    private String user_profession;
    private double user_salary;
    private boolean user_married;

    public double getUser_salary() {
        return user_salary;
    }

    public void setUser_salary(double user_salary) {
        this.user_salary = user_salary;
    }

    
    public String getUser_identification() {
        return user_identification;
    }

    public void setUser_identification(String user_identification) {
        this.user_identification = user_identification;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_profession() {
        return user_profession;
    }

    public void setUser_profession(String user_profession) {
        this.user_profession = user_profession;
    }

    public boolean isUser_married() {
        return user_married;
    }

    public void setUser_married(boolean user_married) {
        this.user_married = user_married;
    }
    
    
}
