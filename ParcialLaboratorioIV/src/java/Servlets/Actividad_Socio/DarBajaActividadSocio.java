/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Actividad_Socio;

import Gestor.GestordeActividadesxSocio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emiliano
 */
@WebServlet(name = "DarBajaActividadSocio", urlPatterns = {"/DarBajaActividadSocio"})
public class DarBajaActividadSocio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        GestordeActividadesxSocio g = new GestordeActividadesxSocio();
        System.out.println(idActividad);
        g.DardeBajaActividaddeUnSocio(id,idActividad);
        
        response.sendRedirect("ListadoDeSocios");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
