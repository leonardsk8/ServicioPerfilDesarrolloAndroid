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
import model.dto.HistoryVO;
import model.dto.PersonVO;
import model.generico.GenericoDAO;
import model.generico.IConsultaGenerica;
import model.generico.ResultSetGenerico;

/**
 *
 * @author leonardo
 */
public class HistoryDAO extends GenericoDAO implements IConsultaGenerica<HistoryVO>{

    public HistoryDAO(Conexion con) {
        super(con);
    }
    
    public List<HistoryVO> consultEvery() throws SQLException{
        String sql = "select * from history";
        return consultar(sql, null, this);
    }

    @Override
    public HistoryVO consulta(ResultSetGenerico cursor) {
        HistoryVO history = new HistoryVO();
        
        try {            
            history.setUser_user_identification(cursor.getString("user_user_identification"));
            history.setUser_car_actual(cursor.getBoolean("user_car_actual"));
            history.setCar_car_plate(cursor.getString("car_car_plate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return history;
    }
    public String insert(HistoryVO history){
        String query = "INSERT INTO history "
                + "(user_user_identification, car_car_plate, user_car_actual) "
                + "VALUES (?,?,?)";
        String answer;
        try {
            answer = insertar(query,history,this);
        } catch (SQLException ex) {
            answer=ex.getMessage();
            ex.printStackTrace();
        }        
        return answer;
    }

    @Override
    public PreparedStatement registro(PreparedStatement ps, HistoryVO obj) throws SQLException  {
        ps.setString(1, obj.getUser_user_identification());
        ps.setString(2, obj.getCar_car_plate());
        ps.setBoolean(3, obj.getUser_car_actual());
        return ps;
    }

    public void deleteEvery() {
        try {
            String sql = "delete from history";
            super.deleteEvery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

  
    
}
