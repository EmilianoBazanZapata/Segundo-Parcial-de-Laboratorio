/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Socios;

import Clases.Actividad;
import Clases.DTOTotalGanado;
import Clases.Socio;
import Gestor.GestorFactura;
import Gestor.GestorSocio;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emiliano
 */
@WebServlet(name = "ListadoDeSocios", urlPatterns = {"/ListadoDeSocios"})
public class ListadoDeSocios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        GestorSocio g = new GestorSocio();
//
//        ArrayList<Socio> lista = g.ObtenerSociosActivos();
//        request.setAttribute("listadeSocios", lista);
//
//        GestorFactura gf = new GestorFactura();
//        ArrayList<DTOTotalGanado> monto = gf.TotalGanado();
//        request.setAttribute("monto", monto);
//
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios.jsp");
//        rd.forward(request, response);
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);

        } catch (Exception e) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorSocio g = new GestorSocio();

        ArrayList<Socio> lista = g.ObtenerSociosActivos();
        request.setAttribute("listadeSocios", lista);

        GestorFactura gf = new GestorFactura();
        ArrayList<DTOTotalGanado> monto = gf.TotalGanado();
        request.setAttribute("monto", monto);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios.jsp");
        rd.forward(request, response);

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
