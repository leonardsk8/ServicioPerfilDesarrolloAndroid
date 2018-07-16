package model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Connection con;
    public Conexion() {
    }

    public Connection getConexion() {
        try{
            String urlDatabase =  "jdbc:postgresql://35.232.205.145:5432/android";
            Class.forName("org.postgresql.Driver").newInstance();
	    con = DriverManager.getConnection(urlDatabase,"leonard","123456leo");
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
                System.out.println(e.getMessage());
        }
        return con;
    } 
    public void closeCon(){
        try {
            if(con!=null & con.isReadOnly())
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}