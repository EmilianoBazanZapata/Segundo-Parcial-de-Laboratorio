package Servlets.Noticias;

import Clases.Actividad;
import Gestor.GestorActividad;
import Gestor.GestorNoticia;
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

@WebServlet(name = "ABMNoticia", urlPatterns = {"/ABMNoticia"})
public class ABMNoticia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
        boolean permitido = (boolean) request.getSession().getAttribute("usr");
        if (modo.equals("agregar") && permitido) {
            GestorActividad g = new GestorActividad();
            ArrayList<Actividad> lista = g.ObtenerActividades();

            request.setAttribute("Actividades", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AgregarNoticia.jsp");
            rd.forward(request, response);
        } else if (modo.equals("buscar") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorNoticia g = new GestorNoticia();
            ArrayList<Clases.Noticia> lista = g.ObtenerNoticiaPorId(id);
            request.setAttribute("listadeNoticiasBuscadas", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoDeNoticiasBuscadas.jsp");
            rd.forward(request, response);
        } else if (modo.equals("buscarinvitado") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorNoticia g = new GestorNoticia();
            ArrayList<Clases.Noticia> lista = g.ObtenerNoticiaPorId(id);
            request.setAttribute("listadeNoticiasBuscadas", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/NoticiasBuscadasParaInvitados.jsp");
            rd.forward(request, response);
        } else if (modo.equals("eliminar") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorNoticia g = new GestorNoticia();
            g.DardeBajaNoticia(id);

            response.sendRedirect("ListadoNoticia?modo=noticias");
        } else if (modo.equals("habilitar") && permitido) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestorNoticia g = new GestorNoticia();
            g.ReactivarNoticia(id);

            response.sendRedirect("ListadoNoticia?modo=noticias");
        }else if (modo == null || modo.isEmpty()) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modo = request.getParameter("modo");
        if (modo.equals("agregar")) {
            String titulo = request.getParameter("txtTitulo");
            String noticia = request.getParameter("txtNoticia");

            int idActividad = Integer.parseInt(request.getParameter("cboActividades"));

            Actividad a = new Actividad();
            a.setId_actividad(idActividad);
            boolean actividad = true;

            Clases.Noticia n = new Clases.Noticia(0, titulo, noticia, a, actividad);

            GestorNoticia g = new GestorNoticia();

            g.AgregarNoticia(n);

            response.sendRedirect("ListadoNoticia?modo=noticias");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
