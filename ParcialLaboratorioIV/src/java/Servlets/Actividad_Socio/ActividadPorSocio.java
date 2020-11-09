package Servlets.Actividad_Socio;

import Gestor.GestorSocio;
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

@WebServlet(name = "ActividadPorSocio", urlPatterns = {"/ActividadPorSocio"})
public class ActividadPorSocio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
        if (modo.equals("dardebaja")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int idActividad = Integer.parseInt(request.getParameter("idActividad"));
            GestordeActividadesxSocio g = new GestordeActividadesxSocio();

            g.DardeBajaActividaddeUnSocio(id, idActividad);

            response.sendRedirect("ListadoDeSocios?modo=versocios");
        } else if (modo.equals("activar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int idActividad = Integer.parseInt(request.getParameter("idActividad"));
            GestordeActividadesxSocio g = new GestordeActividadesxSocio();

            g.ReactivarActividaddeUnSocio(id, idActividad);

            response.sendRedirect("ListadoDeSocios?modo=versocios");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
