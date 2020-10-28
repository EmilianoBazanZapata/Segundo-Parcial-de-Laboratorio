/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Actividades;

import Clases.Actividad_x_Socio;
import Gestor.GestorReporte;
import Gestor.GestordeActividadesxSocio;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "VerSocios", urlPatterns = {"/VerSocios"})
public class VerSocios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        GestorReporte g = new GestorReporte();

        ArrayList<Actividad_x_Socio> lista = g.ObtenerSociosDeUnaActividad(id);
        
        request.setAttribute("ListadeSociosPorActividad", lista);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/SociosDeUnaActividad.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
