package Servlets.Administrador;

import Gestor.GestorAdministrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VerificarAdministrador", urlPatterns = {"/VerificarAdministrador"})
public class VerificarAdministrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("txtUsuario");

        //por alguna razon colocaba otro nombre y no detectaba el parametro que recibia 
        String contraseña = request.getParameter("algo");

        GestorAdministrador g = new GestorAdministrador();

        boolean verificado = g.VerificarUsuario(usuario, contraseña);
        boolean permitido;
        if (verificado) {
            permitido = true;
            request.getSession().setAttribute("usr", permitido);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios?modo=versocios");
            rd.forward(request, response);
        } else {
            permitido = false;
            request.getSession().setAttribute("usr", permitido);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
