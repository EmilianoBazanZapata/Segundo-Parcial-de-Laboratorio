package Gestor;

import Clases.Actividad;
import Clases.Noticia;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class GestorNoticia {

    private static final String CON
            = "jdbc:sqlserver://DESKTOP-B01DD70\\SQLEXPRESS:1433;databaseName=Club";
    private String USER = "sa";
    private String PASS = "111624";
    private Connection con;

    public void Gestor() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorActividad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void AbrirConexion() {
        try {
            Gestor();
            con = DriverManager.getConnection(CON, USER, PASS);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void CerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Noticia> ObtenerNoticias() {
        ArrayList<Noticia> lista = new ArrayList<Noticia>();
        try {
            AbrirConexion();

            String Consulta = " UP_TODAS_LAS_NOTICIAS ";

            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery(Consulta);

            while (rt.next()) {
                boolean activo = rt.getBoolean("Activo");
                int id = rt.getInt("Id_Noticia");
                String noticia = rt.getString("Noticia");
                String titulo = rt.getString("Titulo");
                String Actividad = rt.getString("Actividad");
                int IdActividad = rt.getInt("Id_Actividad");
                Actividad a = new Actividad();

                a.setActividad(Actividad);
                a.setId_actividad(IdActividad);
                Noticia d = new Noticia(id, titulo, noticia, a, activo);

                lista.add(d);
            }
            rt.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return lista;
    }

    public ArrayList<Noticia> ObtenerNoticiasParaInvitados() {
        ArrayList<Noticia> lista = new ArrayList<Noticia>();
        try {
            AbrirConexion();

            String Consulta = " EXEC UP_NOTICIAS ";

            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery(Consulta);

            while (rt.next()) {
                boolean activo = rt.getBoolean("Activo");
                int id = rt.getInt("Id_Noticia");
                String noticia = rt.getString("Noticia");
                String titulo = rt.getString("Titulo");
                String Actividad = rt.getString("Actividad");
                int IdActividad = rt.getInt("Id_Actividad");
                Actividad a = new Actividad();

                a.setActividad(Actividad);
                a.setId_actividad(IdActividad);
                Noticia d = new Noticia(id, titulo, noticia, a, activo);

                lista.add(d);
            }
            rt.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return lista;
    }

    public ArrayList<Noticia> ObtenerNoticiaPorId(int idnoticia) {
        ArrayList<Noticia> lista = new ArrayList<Noticia>();
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_NOTICIAS_EN_PARTIULAR ?";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, idnoticia);

            ResultSet rt = st.executeQuery();

            while (rt.next()) {

                int id = rt.getInt("Id_Noticia");
                String noticia = rt.getString("Noticia");
                String titulo = rt.getString("Titulo");
                String Actividad = rt.getString("Actividad");
                int IdActividad = rt.getInt("Id_Actividad");
                Actividad a = new Actividad();
                boolean actividad = rt.getBoolean("Activo");

                a.setActividad(Actividad);
                a.setId_actividad(IdActividad);
                Noticia d = new Noticia(id, titulo, noticia, a, actividad);

                lista.add(d);
            }
            rt.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return lista;
    }

    public boolean DardeBajaNoticia(int id) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_DESACTIVAR_PUBLICACION ?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, id);

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public boolean ReactivarNoticia(int id) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_ACTIVAR_PUBLICACION ?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, id);

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public boolean AgregarNoticia(Noticia n) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_AGREGAR_PUBLICACION ? , ?,?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setString(1, n.getNoticia());
            st.setInt(2, n.getActividad().getId_actividad());
            st.setString(3, n.getTitulo());

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }
}
