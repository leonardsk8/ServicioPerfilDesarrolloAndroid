/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
public class Synchronization extends HttpServlet {

    
    Conexion con;
    int cont;
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
        con = new Conexion();
        cont = 0;
        String jsonPerson = request.getParameter("jsonPerson"); 
        String jsonCar = request.getParameter("jsonCar");
        String jsonHistory = request.getParameter("jsonHistory");
        Type typePerson = new TypeToken<List<PersonVO>>()
                {}.getType();
        Type typeCar = new TypeToken<List<CarVO>>()
                {}.getType();
        Type typeHistory = new TypeToken<List<HistoryVO>>()
                {}.getType();
        List<PersonVO> listPersons= new Gson().fromJson(jsonPerson, typePerson);
        List<CarVO> listCars= new Gson().fromJson(jsonCar, typeCar);
        List<HistoryVO> listHistory= new Gson().fromJson(jsonHistory, typeHistory);
        delete();
        synchronizatedPersons(listPersons);
        synchronizatedCars(listCars);
        synchronizatedHistory(listHistory);
        con.closeCon();
        out.println("success: "+cont+"/3");
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

    private void synchronizatedPersons(List<PersonVO> listPersons) {
        
        PersonDAO dao = new PersonDAO(con);
        dao.deleteEvery();
        for (PersonVO person:listPersons) {
            dao.insert(person);
        }
        cont++;
    }

    private void synchronizatedCars(List<CarVO> listCars) {
        CarDAO dao = new CarDAO(con);
        dao.deleteEvery();
        for(CarVO car:listCars){
            dao.insert(car);
        }
        cont++;
    }

    private void synchronizatedHistory(List<HistoryVO> listHistory) {
        HistoryDAO dao = new HistoryDAO(con);
        dao.deleteEvery();
        for(HistoryVO history:listHistory){
            dao.insert(history);
        }
        cont++;
    }

    private void delete() {
       
        HistoryDAO daoHis = new HistoryDAO(con);
        CarDAO daoCar = new CarDAO(con);
        PersonDAO daoPer = new PersonDAO(con);
        daoHis.deleteEvery();
        daoCar.deleteEvery();
        daoPer.deleteEvery();
    }

}
