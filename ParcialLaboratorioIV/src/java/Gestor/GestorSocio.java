package Gestor;

import Clases.Actividad;
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

public class GestorSocio {

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

    public ArrayList<Socio> ObtenerSociosActivos() {
        ArrayList<Socio> lista = new ArrayList<Socio>();
        try {
            AbrirConexion();

            String Consulta = " EXEC UP_CONSULTAR_SOCIOS_ACTIVOS ";

            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery(Consulta);

            while (rt.next()) {
                int id = rt.getInt("Id_Socio");
                String nombre = rt.getString("Nombre");
                String apellido = rt.getString("Apellido");
                int dni = rt.getInt("DNI");
                boolean activo = rt.getBoolean("Activo");

                Socio s = new Socio(id, nombre, apellido, dni, activo);

                lista.add(s);
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

    public boolean AgregarSocio(Socio s) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_AGREGAR_SOCIO ?,?,?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setString(1, s.getNombre());
            st.setString(2, s.getApellido());
            st.setInt(3, s.getDni());

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public ArrayList<Socio> ObtenerSocioEnParticular(int Id) {
        ArrayList<Socio> lista = new ArrayList<Socio>();
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_CONSULTAR_SOCIO_EN_PARTICULAR ?";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, Id);

            ResultSet rt = st.executeQuery();

            if (rt.next()) {

                int id = rt.getInt("Id_Socio");
                String nombre = rt.getString("Nombre");
                String apellido = rt.getString("Apellido");
                int dni = rt.getInt("DNI");
                boolean activo = true;

                Socio s = new Socio(id, nombre, apellido, dni, activo);

                lista.add(s);
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

    public boolean ActualizarSocio(Socio s) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_ACTUALIZAR_SOCIO ?,?,?,?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, s.getId_socio());
            st.setString(2, s.getNombre());
            st.setString(3, s.getApellido());
            st.setInt(4, s.getDni());

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public boolean DardeBajaSocio(int id) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_BAJA_DE_SOCIO ?";

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

    public boolean ReactivarSocio(int id) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_REACTIVAR_DE_SOCIO ?";

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

    public ArrayList<Socio> ObtenerSocioPorDni(int documento) {
        ArrayList<Socio> lista = new ArrayList<Socio>();
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_CONSULTAR_SOCIO_EN_PARTICULAR_POR_DNI ?";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, documento);

            ResultSet rt = st.executeQuery();

            if (rt.next()) {

                int id = rt.getInt("Id_Socio");
                String nombre = rt.getString("Nombre");
                String apellido = rt.getString("Apellido");
                int dni = rt.getInt("DNI");
                boolean activo = true;

                Socio s = new Socio(id, nombre, apellido, dni, activo);

                lista.add(s);
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
}
