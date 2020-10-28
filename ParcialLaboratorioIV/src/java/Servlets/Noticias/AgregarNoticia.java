/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Noticias;

import Clases.Actividad;
import Clases.Noticia;
import Gestor.GestorActividad;
import Gestor.GestorNoticia;
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
@WebServlet(name = "AgregarNoticia", urlPatterns = {"/AgregarNoticia"})
public class AgregarNoticia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorActividad g = new GestorActividad();
        ArrayList<Actividad> lista = g.ObtenerActividades();

        request.setAttribute("Actividades", lista);
        out.println(lista);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AgregarNoticia.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("txtTitulo");
        String noticia = request.getParameter("txtNoticia");

        int idActividad = Integer.parseInt(request.getParameter("cboActividades"));

        Actividad a = new Actividad();
        a.setId_actividad(idActividad);
        boolean actividad = true;

        Noticia n = new Noticia(0, titulo, noticia, a,actividad);

        GestorNoticia g = new GestorNoticia();

        g.AgregarNoticia(n);

        response.sendRedirect("ListadoNoticia");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
