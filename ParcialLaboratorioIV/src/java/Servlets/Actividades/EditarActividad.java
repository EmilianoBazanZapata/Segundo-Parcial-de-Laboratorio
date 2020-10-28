/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Actividades;

import Clases.Actividad;
import Gestor.GestorActividad;
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
@WebServlet(name = "EditarActividad", urlPatterns = {"/EditarActividad"})
public class EditarActividad extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        GestorActividad g = new GestorActividad();

        ArrayList<Actividad> lista = g.ObtenerActividadEnParticular(id);

        int idActividad = lista.get(0).getId_actividad();
        String Actividad = lista.get(0).getActividad();
        float Precio = lista.get(0).getPrecio();

        request.setAttribute("IdActividad", idActividad);
        request.setAttribute("Actividad", Actividad);
        request.setAttribute("Precio", Precio);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditarActividad.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String Actividad = request.getParameter("txtActividad");
        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
        
        GestorActividad g = new GestorActividad();
        
        Actividad a = new Actividad(id,Actividad,precio);
        
        g.ActualizarActividad(a);
        response.sendRedirect("ListadoDeActividades");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
