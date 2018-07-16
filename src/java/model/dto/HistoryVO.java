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
public class HistoryVO {
    private String user_user_identification;
    private String car_car_plate;
    private boolean user_car_actual;

    public String getUser_user_identification() {
        return user_user_identification;
    }

    public void setUser_user_identification(String user_user_identification) {
        this.user_user_identification = user_user_identification;
    }

    public String getCar_car_plate() {
        return car_car_plate;
    }

    public void setCar_car_plate(String car_car_plate) {
        this.car_car_plate = car_car_plate;
    }

    public boolean getUser_car_actual() {
        return user_car_actual;
    }

    public void setUser_car_actual(boolean user_car_actual) {
        this.user_car_actual = user_car_actual;
    }
    
    
   
}
