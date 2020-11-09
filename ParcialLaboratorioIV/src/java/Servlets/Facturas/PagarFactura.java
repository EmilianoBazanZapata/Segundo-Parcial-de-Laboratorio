/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Facturas;

import Clases.Actividad;
import Clases.Factura;
import Clases.Forma_de_Pago;
import Gestor.GestorFactura;
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
@WebServlet(name = "PagarFactura", urlPatterns = {"/PagarFactura"})
public class PagarFactura extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean permitido = (boolean) request.getSession().getAttribute("usr");
        if (permitido) {

            try {
                int id = Integer.parseInt(request.getParameter("id"));

                GestorFactura g = new GestorFactura();

                ArrayList<Factura> listadeFactura = g.TotalApagarPorSocio(id);

                float total = listadeFactura.get(0).getMonto_total();
                int idSocio = listadeFactura.get(0).getSocio().getId_socio();
                String nombre = listadeFactura.get(0).getSocio().getNombre();
                String apellido = listadeFactura.get(0).getSocio().getApellido();
                int dni = listadeFactura.get(0).getSocio().getDni();

                request.setAttribute("total", total);
                request.setAttribute("IdSocio", id);
                request.setAttribute("IdSocio", idSocio);
                request.setAttribute("NombreSocio", nombre);
                request.setAttribute("ApellidoSocio", apellido);
                request.setAttribute("DniSocio", dni);

                ArrayList<Forma_de_Pago> lista = g.ObtenerFormasdePago();

                request.setAttribute("Forma_de_Pago", lista);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/PagarFactura.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios");
                rd.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idformapado = Integer.parseInt(request.getParameter("cboFormadePago"));
        GestorFactura g = new GestorFactura();
        g.PagarActividades(id, idformapado);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios?modo=versocios");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
