package Gestor;

import Clases.Actividad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorAdministrador {

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
    public boolean VerificarUsuario(String usuario, String contraseña) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "   SELECT\n"
                    + "      CASE WHEN EXISTS \n"
                    + "      (\n"
                    + "            SELECT Nombre , Contraseña\n"
                    + "           FROM Administrador\n"
                    + "           WHERE Nombre = ?\n"
                    + "		   AND Contraseña  = ?\n"
                    + "      )\n"
                    + "      THEN 'TRUE'\n"
                    + "      ELSE 'FALSE'\n"
                    + "   END AS 'VERIFICADO'";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setString(1, usuario);
            st.setString(2, contraseña);

            ResultSet rt = st.executeQuery();

            if (rt.next()) {

                 boolean verificado = rt.getBoolean("VERIFICADO");
                if (verificado) {
                    resultado = true;
                } else {
                    resultado = false;
                }
            }
            rt.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }
}
