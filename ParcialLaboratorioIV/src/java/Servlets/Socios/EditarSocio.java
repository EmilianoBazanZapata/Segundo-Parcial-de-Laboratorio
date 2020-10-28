/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Socios;

import Clases.Socio;
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
@WebServlet(name = "EditarSocio", urlPatterns = {"/EditarSocio"})
public class EditarSocio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorSocio g = new GestorSocio();
            ArrayList<Socio> lista = g.ObtenerSocioEnParticular(id);

            String Nombre = lista.get(0).getNombre();
            String Apellido = lista.get(0).getApellido();
            int Dni = lista.get(0).getDni();
            int Id = lista.get(0).getId_socio();

            request.setAttribute("NombreSocio", Nombre);
            request.setAttribute("ApellidoSocio", Apellido);
            request.setAttribute("DniSocio", Dni);
            request.setAttribute("IdSocio", Id);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditarSocio.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
        }
        try {
            
        } catch (Exception e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("txtNombreSocio");
        String apellido = request.getParameter("txtApellidoSocio");
        int dni = Integer.parseInt(request.getParameter("txtDni"));

        GestorSocio g = new GestorSocio();

        Socio a = new Socio(id, nombre, apellido, dni);

        g.ActualizarSocio(a);

        response.sendRedirect("ListadoDeSocios");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
