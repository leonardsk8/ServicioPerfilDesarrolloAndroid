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
import model.dto.PersonVO;
import model.generico.GenericoDAO;
import model.generico.IConsultaGenerica;
import model.generico.ResultSetGenerico;

/**
 *
 * @author leonardo
 */
public class PersonDAO extends GenericoDAO implements IConsultaGenerica<PersonVO>{

//    Conexion con;
//    {
//     con = new Conexion();
//    }
    public PersonDAO(Conexion con) {
        super(con);
    }
    
    public List<PersonVO> consultEvery() throws SQLException{
        String sql = "select * from user_db";
        return consultar(sql, null, this);
    }
    
    public String insert(PersonVO person) {
        String query = "INSERT INTO user_db"
                + "(user_identification, user_name, user_surname,user_birth,user_profession,user_married,user_salary) "
                + "VALUES (?,?,?,?,?,?,?)";
        String answer;
        try {
            answer = insertar(query,person,this);
        } catch (SQLException ex) {
            answer=ex.getMessage();
            ex.printStackTrace();
        }
       return answer;
    }

    @Override
    public PersonVO consulta(ResultSetGenerico cursor) {
        PersonVO person = new PersonVO();
        try {            
            person.setUser_identification(cursor.getString("user_identification"));
            person.setUser_name(cursor.getString("user_name"));
            person.setUser_surname(cursor.getString("user_surname"));
            person.setUser_birth(cursor.getString("user_birth"));
            person.setUser_profession(cursor.getString("user_profession"));
            person.setUser_married(cursor.getBoolean("user_married"));
            person.setUser_salary(cursor.getDouble("user_salary"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    @Override
    public PreparedStatement registro(PreparedStatement ps, PersonVO obj) throws SQLException {
        ps.setString(1, obj.getUser_identification());
        ps.setString(2, obj.getUser_name());
        ps.setString(3, obj.getUser_surname());
        ps.setString(4, obj.getUser_birth());
        ps.setString(5, obj.getUser_profession());
        ps.setBoolean(6, obj.isUser_married());
        ps.setDouble(7, obj.getUser_salary());
        return ps;
    }

    public void deleteEvery() {
        try {
            String sql = "delete from user_db";
            super.deleteEvery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    


   
    
    
    
}
