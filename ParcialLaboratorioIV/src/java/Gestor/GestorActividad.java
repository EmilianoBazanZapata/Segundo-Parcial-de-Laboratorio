package Gestor;

import Clases.Actividad;
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

public class GestorActividad {

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

    public ArrayList<Actividad> ObtenerActividades() {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();
        try {
            AbrirConexion();

            String Consulta = " EXEC UP_TRAER_ACTIVIDADES ";

            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery(Consulta);

            while (rt.next()) {
                int id = rt.getInt("Id_Actividad");
                String nombre = rt.getString("Actividad");
                float precio = rt.getInt("Precio");

                Actividad d = new Actividad(id, nombre, precio);

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

    public boolean AgregarActividad(Actividad A) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_AGREGAR_ACTIVIDAD ?, ?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setString(1, A.getActividad());
            st.setFloat(2, A.getPrecio());

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public boolean ActualizarActividad(Actividad a) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_ACTUALIZAR_ACTIVIDAD ? ,? ,?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setString(1, a.getActividad());
            st.setFloat(2, a.getPrecio());
            st.setInt(3, a.getId_actividad());

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }

    public ArrayList<Actividad> ObtenerActividadEnParticular(int Id) {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_TRAER_ACTIVIDAD_EN_PARTICULAR ?";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, Id);

            ResultSet rt = st.executeQuery();

            if (rt.next()) {

                int id = rt.getInt("Id_Actividad");
                String nombre = rt.getString("Actividad");
                float precio = rt.getFloat("Precio");

                Actividad s = new Actividad(id, nombre, precio);

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

    public boolean EliminarActividad(int id) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_ELIMINAR_ACTIVIDAD ?";

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

    public ArrayList<Actividad> ObtenerActividadEnParticularPorNombre(String nombreActividad) {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_TRAER_ACTIVIDAD_EN_PARTICULAR_POR_NOMBRE ?";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setString(1, nombreActividad);

            ResultSet rt = st.executeQuery();

            if (rt.next()) {

                int id = rt.getInt("Id_Actividad");
                String nombre = rt.getString("Actividad");
                float precio = rt.getFloat("Precio");

                Actividad s = new Actividad(id, nombre, precio);

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
