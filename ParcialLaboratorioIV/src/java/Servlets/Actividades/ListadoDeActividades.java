/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Actividades;

import Clases.Actividad;
import Clases.DTOTotalGanado;
import Clases.Socio;
import Gestor.GestorActividad;
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
@WebServlet(name = "ListadoDeActividades", urlPatterns = {"/ListadoDeActividades"})
public class ListadoDeActividades extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
         boolean permitido = (boolean) request.getSession().getAttribute("usr");
        if (modo == null || modo.isEmpty()) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }
        else if (modo.equals("veractividades")&& permitido) {
            GestorActividad g = new GestorActividad();

            ArrayList<Actividad> lista = g.ObtenerActividades();
            request.setAttribute("listadeactividades", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeActividades.jsp");
            rd.forward(request, response);
        }
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
