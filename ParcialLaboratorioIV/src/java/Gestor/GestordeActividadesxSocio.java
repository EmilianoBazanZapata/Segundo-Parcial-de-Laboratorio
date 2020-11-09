package Gestor;

import Clases.Actividad;
import Clases.Actividad_x_Socio;
import Clases.Socio;
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

public class GestordeActividadesxSocio {

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

    public ArrayList<Actividad_x_Socio> ObtenerSocioEnParticularConSusActividades(int Id) {
        ArrayList<Actividad_x_Socio> lista = new ArrayList<Actividad_x_Socio>();
        try {
            AbrirConexion();

            String Consulta = " EXEC UP_SELECCIONAR_ACTIVIDAD_DE_UNA_PERSONA ? ";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, Id);

            ResultSet rt = st.executeQuery();

            while (rt.next()) {

                int idActividad = rt.getInt("Id_Actividad");
                int idSocio = rt.getInt("Id_Socio");
                String actividad = rt.getString("Actividad");
                String nombre = rt.getString("Nombre");
                String apellido = rt.getString("Apellido");
                int dni = rt.getInt("DNI");
                boolean activo = rt.getBoolean("Activo");

                Actividad a = new Actividad();
                a.setActividad(actividad);

                Socio s = new Socio();
                s.setNombre(nombre);
                s.setApellido(apellido);
                s.setDni(dni);

                Actividad_x_Socio ac = new Actividad_x_Socio(idActividad, idSocio, activo, s, a);

                lista.add(ac);
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

    public boolean DardeBajaActividaddeUnSocio(int id, int idActividad) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_DESCATICVAR_ACTIVIDAD_X_SOCIO ? , ?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, id);
            st.setInt(2, idActividad);

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public boolean ReactivarActividaddeUnSocio(int id, int idActividad) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_REATICVAR_ACTIVIDAD_X_SOCIO ? , ?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, id);
            st.setInt(2, idActividad);

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public boolean AgregarSocio(Actividad_x_Socio ac) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_ACTIVIDAD_X_SOCIO ?,?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, ac.getId_Actividad());
            st.setInt(2, ac.getId_Socio());

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
