/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Actividad_Socio;

import Clases.Actividad;
import Clases.Actividad_x_Socio;
import Clases.Socio;
import Gestor.GestordeActividadesxSocio;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AgregarActividadAunSocio", urlPatterns = {"/AgregarActividadAunSocio"})
public class AgregarActividadAunSocio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idActividad = Integer.parseInt(request.getParameter("cboActividades"));
        int idSocio = Integer.parseInt(request.getParameter("id"));
        
        Socio s = new Socio();
        s.setId_socio(0);
        Actividad a = new Actividad();
        a.setId_actividad(0);
        
        Actividad_x_Socio ac = new Actividad_x_Socio(idActividad,idSocio,s,a);
        
        
        GestordeActividadesxSocio g = new GestordeActividadesxSocio();
        g.AgregarSocio(ac);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios");
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
