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
@WebServlet(name = "ListadoDeNoticiasParaInvitados", urlPatterns = {"/ListadoDeNoticiasParaInvitados"})
public class ListadoDeNoticiasParaInvitados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorNoticia g = new GestorNoticia();

        ArrayList<Noticia> lista = g.ObtenerNoticiasParaInvitados();
        request.setAttribute("listadeNoticias", lista);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/NoticiasParaInvitados.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorNoticia g = new GestorNoticia();

        ArrayList<Noticia> lista = g.ObtenerNoticiasParaInvitados();
        request.setAttribute("listadeNoticias", lista);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/NoticiasParaInvitados.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
