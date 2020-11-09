/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Reportes;

import Clases.DTOActividadesConMasGanancias;
import Clases.DTOTotalGanado;
import Clases.Factura;
import Gestor.GestorFactura;
import Gestor.GestorReporte;
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
@WebServlet(name = "ActividadesConMasGanancias", urlPatterns = {"/ActividadesConMasGanancias"})
public class ActividadesConMasGanancias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
        boolean permitido = (boolean) request.getSession().getAttribute("usr");
        if (modo.equals("reporte") && permitido) {
            GestorReporte g = new GestorReporte();
            ArrayList<DTOActividadesConMasGanancias> lista = g.ObtenerActividadesConMasGanancias();

            request.setAttribute("ActividadesConMasGanancias", lista);

            GestorFactura gf = new GestorFactura();
            ArrayList<DTOTotalGanado> monto = gf.TotalGanado();
            request.setAttribute("monto", monto);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Reportes.jsp");
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
    }// </editor-fold>

}
