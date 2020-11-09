/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Socios;

import Clases.Actividad;
import Clases.DTOPagosDeUnSocio;
import Clases.DTOTotalGanado;
import Clases.Factura;
import Clases.Forma_de_Pago;
import Clases.Socio;
import Gestor.GestorActividad;
import Gestor.GestorFactura;
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

/**
 *
 * @author Emiliano
 */
@WebServlet(name = "Socio", urlPatterns = {"/ABMSocio"})
public class ABMCSocio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
        boolean permitido = (boolean) request.getSession().getAttribute("usr");
        
        if (modo.equals("editar") && permitido) {

            int id = Integer.parseInt(request.getParameter("id"));
            GestorSocio g = new GestorSocio();
            ArrayList<Clases.Socio> lista = g.ObtenerSocioEnParticular(id);

            String Nombre = lista.get(0).getNombre();
            String Apellido = lista.get(0).getApellido();
            int Dni = lista.get(0).getDni();
            int Id = lista.get(0).getId_socio();

            request.setAttribute("NombreSocio", Nombre);
            request.setAttribute("ApellidoSocio", Apellido);
            request.setAttribute("DniSocio", Dni);
            request.setAttribute("IdSocio", Id);
            request.setAttribute("permitido", permitido);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditarSocio.jsp");
            rd.forward(request, response);

        } else if (modo.equals("eliminar") && permitido) {

            int id = Integer.parseInt(request.getParameter("id"));
            GestorSocio g = new GestorSocio();
            g.DardeBajaSocio(id);

            response.sendRedirect("ListadoDeSocios?modo=versocios");
        } else if (modo.equals("agregaractividad") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorActividad g = new GestorActividad();

            ArrayList<Actividad> lista = g.ObtenerActividades();

            request.setAttribute("Actividades", lista);
            request.setAttribute("IdSocio", id);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ActividadporSocio.jsp");
            rd.forward(request, response);
        } else if (modo.equals("listadodeactividades") && permitido) {
            try {
                int IdSocio = Integer.parseInt(request.getParameter("id"));

                GestordeActividadesxSocio g = new GestordeActividadesxSocio();

                ArrayList<Clases.Actividad_x_Socio> lista = g.ObtenerSocioEnParticularConSusActividades(IdSocio);

                int Id = lista.get(0).getId_Socio();

                request.setAttribute("IdSocioActividad", Id);
                request.setAttribute("ActividadesdelSocio", lista);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadodeActividadesdeUnSocio.jsp");
                rd.forward(request, response);
            } catch (Exception e) {

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadodeActividadesdeUnSocio.jsp");
                rd.forward(request, response);

            }
        } else if (modo.equals("pagarfactura") && permitido) {
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
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios?modo=versocios");
                rd.forward(request, response);
            }
        } else if (modo.equals("vercuotas") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorFactura g = new GestorFactura();
            ArrayList<DTOPagosDeUnSocio> lista = g.CuotasPagas(id);

            request.setAttribute("listadeCuotasPagas", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoCuotasPagas.jsp");
            rd.forward(request, response);
        } else if (modo.equals("reactivar") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorSocio g = new GestorSocio();
            g.ReactivarSocio(id);

            response.sendRedirect("ListadoDeSocios?modo=versocios");
        } else if (modo == null || modo.isEmpty()) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String modo = request.getParameter("modo");
        boolean permitido = (boolean) request.getSession().getAttribute("usr");
        if (modo == null || modo.isEmpty()&& permitido) {
            GestorSocio g = new GestorSocio();

            ArrayList<Clases.Socio> lista = g.ObtenerSociosActivos();
            request.setAttribute("listadeSocios", lista);

            GestorFactura gf = new GestorFactura();
            ArrayList<DTOTotalGanado> monto = gf.TotalGanado();
            request.setAttribute("monto", monto);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios.jsp");
            rd.forward(request, response);

        } else if (modo.equals("editar")&& permitido) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("txtNombreSocio");
            String apellido = request.getParameter("txtApellidoSocio");
            int dni = Integer.parseInt(request.getParameter("txtDni"));
            boolean activo = true;
            GestorSocio g = new GestorSocio();

            Clases.Socio a = new Clases.Socio(id, nombre, apellido, dni, activo);

            g.ActualizarSocio(a);

            response.sendRedirect("ListadoDeSocios?modo=versocios");

        } else if (modo.equals("agregaractividad")&& permitido) {

            int idActividad = Integer.parseInt(request.getParameter("cboActividades"));
            int idSocio = Integer.parseInt(request.getParameter("id"));
            boolean activo = true;

            Clases.Socio s = new Clases.Socio();
            s.setId_socio(0);
            Actividad a = new Actividad();
            a.setId_actividad(0);

            Clases.Actividad_x_Socio ac = new Clases.Actividad_x_Socio(idActividad, idSocio, activo, s, a);

            GestordeActividadesxSocio g = new GestordeActividadesxSocio();
            g.AgregarSocio(ac);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios");
            rd.forward(request, response);

        } else if (modo.equals("pagarfactura")&& permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            int idformapado = Integer.parseInt(request.getParameter("cboFormadePago"));
            GestorFactura g = new GestorFactura();
            g.PagarActividades(id, idformapado);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeSocios?modo=versocios");
            rd.forward(request, response);
        } else if (modo.equals("agregarsocio")&& permitido) {
            String nombre = request.getParameter("txtNombreSocio");
            String apellido = request.getParameter("txtApellidoSocio");
            int dni = Integer.parseInt(request.getParameter("txtDni"));
            boolean activo = true;
            GestorSocio g = new GestorSocio();

            Clases.Socio a = new Clases.Socio(0, nombre, apellido, dni, activo);

            g.AgregarSocio(a);

            response.sendRedirect("ListadoDeSocios?modo=versocios");
        } else if (modo.equals("buscarsocio")&& permitido) {
            int dni = Integer.parseInt(request.getParameter("txtDocumentoBuscado"));

            GestorSocio g = new GestorSocio();

            ArrayList<Socio> lista = g.ObtenerSocioPorDni(dni);

            request.setAttribute("SocioBuscadoPorDni", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/SocioBuscado.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
