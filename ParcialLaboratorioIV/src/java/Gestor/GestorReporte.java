package Gestor;

import Clases.Actividad;
import Clases.Actividad_x_Socio;
import Clases.DTOActividadesConMasGanancias;
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

public class GestorReporte {

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
    public ArrayList<DTOActividadesConMasGanancias> ObtenerActividadesConMasGanancias() {
        ArrayList<DTOActividadesConMasGanancias> lista = new ArrayList<DTOActividadesConMasGanancias>();
        try {
            AbrirConexion();

            String Consulta = " EXEC UP_ACTIVIDADES_CON_MAS_GANANCIAS ";

            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery(Consulta);

            while (rt.next()) {
                String nombre = rt.getString("Actividad");
                float total = rt.getInt("MONTO");

                DTOActividadesConMasGanancias d = new DTOActividadesConMasGanancias(total,nombre);

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
    public ArrayList<Actividad_x_Socio> ObtenerSociosDeUnaActividad(int Id) {
        ArrayList<Actividad_x_Socio> lista = new ArrayList<Actividad_x_Socio>();
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_SOCIOS_DE_UNA_ACTIVIDAD ?";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, Id);

            ResultSet rt = st.executeQuery();

            while (rt.next()) {

                String actividad = rt.getString("Actividad");
                String nombre = rt.getString("Nombre");
                String apellido = rt.getString("Apellido");
                int  DNI = rt.getInt("DNI");
                
                Socio s = new Socio();
                s.setNombre(nombre);
                s.setApellido(apellido);
                s.setDni(DNI);
                
                Actividad ac = new Actividad();
                ac.setActividad(actividad);
                
                boolean activo = true;

                Actividad_x_Socio a = new Actividad_x_Socio(0,0,activo,s,ac);

                lista.add(a);
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
