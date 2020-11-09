/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Actividad_Socio;

import Clases.Actividad_x_Socio;
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
@WebServlet(name = "ListadoAtividadSocio", urlPatterns = {"/ListadoAtividadSocio"})
public class ListadoAtividadSocio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean permitido = (boolean) request.getSession().getAttribute("usr");
        if (permitido) {
            try {
                int IdSocio = Integer.parseInt(request.getParameter("id"));

                GestordeActividadesxSocio g = new GestordeActividadesxSocio();

                ArrayList<Actividad_x_Socio> lista = g.ObtenerSocioEnParticularConSusActividades(IdSocio);

                int Id = lista.get(0).getId_Socio();

                request.setAttribute("IdSocioActividad", Id);
                request.setAttribute("ActividadesdelSocio", lista);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadodeActividadesdeUnSocio.jsp");
                rd.forward(request, response);
            } catch (Exception e) {

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadodeActividadesdeUnSocio.jsp");
                rd.forward(request, response);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
