/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conexion;
import model.dao.CarDAO;
import model.dao.HistoryDAO;
import model.dao.PersonDAO;
import model.dto.CarVO;
import model.dto.HistoryVO;
import model.dto.PersonVO;

/**
 *
 * @author leonardo
 */
public class Read extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        printData(out);
    }
    
    private void printData(PrintWriter out) {
        Conexion con = new Conexion();
        CarDAO car = new CarDAO(con);
        HistoryDAO history = new HistoryDAO(con);
        PersonDAO person = new PersonDAO(con);
        List<CarVO> listCars;
        List<PersonVO> listPerson;
        List<HistoryVO> listHistory;
        try {
            listCars = car.consultEvery();
            listPerson = person.consultEvery();
            listHistory = history.consultEvery();
            out.println("<br><h1>TABLE CAR</h1>");
            for (CarVO carList:listCars) {
                out.println("Placa: "+carList.getCar_plate()+" Marca: "+carList.getCar_brand()
                +" Modelo: "+carList.getCar_model()+" Puertas: "+carList.getCar_doors()+" Color ruedas:"
                +carList.getCar_color_wheels()+" Color Capo: "+carList.getCar_color_hoods()
                +" Color puertas: "+carList.getCar_color_doors());
                out.println("<br>");
            }
            out.println("<br><h1>TABLE PERSON</h1>");
            for(PersonVO personList: listPerson){
                out.println("IIdentificación: "+personList.getUser_identification()+" Nombre:"+
                        personList.getUser_name()+" Apellido: "+personList.getUser_surname()
                +" Nacimiento: "+personList.getUser_birth()+" Profesión: "+personList.getUser_profession()+
                        " Salario: "+personList.getUser_salary());
                out.println("<br>");
            }
            out.println("<br><h1>TABLE HISTORY</h1>");
            for(HistoryVO historyList: listHistory){
                out.println("User: "+historyList.getUser_user_identification()+" Car: "+historyList.
                        getCar_car_plate()+" Actual: "+historyList.getUser_car_actual());
                out.println("<br>");
            }
            
            out.println("<br>");out.println("<br>");out.println("<br>");
            //En caso de consumir en android se utilizarian estos
            out.println(new Gson().toJson(listCars));
            out.println(new Gson().toJson(listPerson));
            out.println(new Gson().toJson(listHistory));
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        con.closeCon();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
