/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Noticias;

import Clases.Noticia;
import Gestor.GestorNoticia;
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
@WebServlet(name = "ListadoNoticia", urlPatterns = {"/ListadoNoticia"})
public class ListadoNoticia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorNoticia g = new GestorNoticia();
        String modo = request.getParameter("modo");
                boolean permitido = (boolean) request.getSession().getAttribute("usr");
                System.out.println(permitido);
        if (modo.equals("noticias")) {
            ArrayList<Noticia> lista = g.ObtenerNoticias();
            request.setAttribute("listadeNoticias", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeNoticias.jsp");
            rd.forward(request, response);
        } else if (modo == null || modo.isEmpty()) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
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
