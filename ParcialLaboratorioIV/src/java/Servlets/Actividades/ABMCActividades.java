/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Actividades;

import Clases.Actividad;
import Clases.Actividad_x_Socio;
import Gestor.GestorActividad;
import Gestor.GestorReporte;
import Gestor.GestorSocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ABMActividades", urlPatterns = {"/ABMActividades"})
public class ABMCActividades extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
        boolean permitido = (boolean) request.getSession().getAttribute("usr");
        if (modo.equals("editar") && permitido) {
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
        } else if (modo.equals("eliminar") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorActividad g = new GestorActividad();
            g.EliminarActividad(id);

            response.sendRedirect("ListadoDeActividades?modo=veractividades");
        } else if (modo.equals("versocios") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));

            GestorReporte g = new GestorReporte();

            ArrayList<Actividad_x_Socio> lista = g.ObtenerSociosDeUnaActividad(id);

            request.setAttribute("ListadeSociosPorActividad", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/SociosDeUnaActividad.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
        if (modo.equals("editar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String Actividad = request.getParameter("txtActividad");
            float precio = Float.parseFloat(request.getParameter("txtPrecio"));

            GestorActividad g = new GestorActividad();

            Actividad a = new Actividad(id, Actividad, precio);

            g.ActualizarActividad(a);
            response.sendRedirect("ListadoDeActividades?modo=veractividades");
        }
        if (modo.equals("buscar")) {
            String nombre = request.getParameter("txtActividadBuscada");
            GestorActividad g = new GestorActividad();
            ArrayList<Actividad> lista = g.ObtenerActividadEnParticularPorNombre(nombre);

            request.setAttribute("ActiviadaBuscadaPorNombre", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ActividadBuscada.jsp");
            rd.forward(request, response);
        }
        if (modo.equals("agregar")) {
            String nombre = request.getParameter("txtActividad");
            int precio = Integer.parseInt(request.getParameter("txtPrecio"));

            GestorActividad g = new GestorActividad();

            Actividad a = new Actividad(0, nombre, precio);

            g.AgregarActividad(a);

            response.sendRedirect("ListadoDeActividades?modo=veractividades");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
