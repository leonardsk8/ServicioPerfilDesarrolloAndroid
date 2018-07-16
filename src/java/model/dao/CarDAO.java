/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.dto.CarVO;
import model.dto.PersonVO;
import model.generico.GenericoDAO;
import model.generico.IConsultaGenerica;
import model.generico.ResultSetGenerico;

/**
 *
 * @author leonardo
 */
public class CarDAO extends GenericoDAO implements IConsultaGenerica<CarVO>{
    
    public CarDAO(Conexion con) {
        super(con);
    }
    
    public List<CarVO> consultEvery() throws SQLException{
        String sql = "select * from car";
        return consultar(sql, null, this);
    }

    @Override
    public CarVO consulta(ResultSetGenerico cursor) {
        CarVO car = new CarVO();
        try{
        car.setCar_plate(cursor.getString("car_plate"));    
        car.setCar_brand(cursor.getString("car_brand"));
        car.setCar_model(cursor.getString("car_model"));
        car.setCar_type(cursor.getString("car_type"));
        car.setCar_doors(cursor.getInt("car_doors"));
        car.setCar_color_wheels(cursor.getString("car_color_wheels"));
        car.setCar_color_hoods(cursor.getString("car_color_hoods"));
        car.setCar_color_doors(cursor.getString("car_color_doors"));
        
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return car;
    }

    @Override
    public PreparedStatement registro(PreparedStatement ps, CarVO obj) throws SQLException {
        ps.setString(1,obj.getCar_plate());
        ps.setString(2,obj.getCar_brand());
        ps.setString(3,obj.getCar_model());
        ps.setInt(4,obj.getCar_doors());
        ps.setString(5,obj.getCar_type());
        ps.setString(6, obj.getCar_color_wheels());
        ps.setString(7, obj.getCar_color_hoods());
        ps.setString(8, obj.getCar_color_doors());
        return ps;
    }

    public String insert(CarVO car) {
        String query = "INSERT INTO car"
                + "(car_plate, car_brand, car_model,car_doors,car_type,car_color_wheels,car_color_hoods,car_color_doors) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        String answer;
        try {
            answer = insertar(query,car,this);
        } catch (SQLException ex) {
            answer=ex.getMessage();
            ex.printStackTrace();
        }        
        return answer;
    }

    public void deleteEvery() {
        try {
            String sql = "delete from car";
            super.deleteEvery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

  
 
    
    
    
}
