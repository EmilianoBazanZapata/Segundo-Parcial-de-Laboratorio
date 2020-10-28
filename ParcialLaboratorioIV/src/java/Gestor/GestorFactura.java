package Gestor;

import Clases.Actividad;
import Clases.DTOPagosDeUnSocio;
import Clases.DTOTotalGanado;
import Clases.Factura;
import Clases.Forma_de_Pago;
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

public class GestorFactura {

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

    public ArrayList<Forma_de_Pago> ObtenerFormasdePago() {
        ArrayList<Forma_de_Pago> lista = new ArrayList<Forma_de_Pago>();
        try {
            AbrirConexion();

            String Consulta = " EXEC CONSULTAR_FORMAS_DE_PAGO ";

            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery(Consulta);

            while (rt.next()) {
                int id = rt.getInt("Id_Pago");
                String nombre = rt.getString("Pago");

                Forma_de_Pago f = new Forma_de_Pago(id, nombre);

                lista.add(f);
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

    public ArrayList<Factura> TotalApagarPorSocio(int Id) {
        ArrayList<Factura> lista = new ArrayList<Factura>();
        try {
            AbrirConexion();

            String Consulta = " EXEC UP_TOTAL_A_PAGAR_POR_USUARIO ? ";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, Id);

            ResultSet rt = st.executeQuery();

            if (rt.next()) {

                float preciototal = rt.getInt("PRECIO TOTAL A PAGAR");
                int idSocio = rt.getInt("Id_Socio");
                String nombre = rt.getString("Nombre");
                String apellido = rt.getString("Apellido");
                int Dni = rt.getInt("DNI");

                Socio s = new Socio();
                s.setId_socio(idSocio);
                s.setNombre(nombre);
                s.setApellido(apellido);
                s.setDni(Dni);

                Forma_de_Pago f = new Forma_de_Pago();

                Factura ac = new Factura(0, s, f, preciototal);

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

    public boolean PagarActividades(int idsocio,int idformadepago) {
        boolean resultado = false;
        try {
            AbrirConexion();

            String Consulta = "EXEC UP_AGREGAR_FACTURA ?,?";

            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1,idsocio);
            st.setInt(2,idformadepago);

            st.execute();

            resultado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CerrarConexion();
        }
        return resultado;
    }
    public ArrayList<DTOPagosDeUnSocio> CuotasPagas(int Id) {
        ArrayList<DTOPagosDeUnSocio> lista = new ArrayList<DTOPagosDeUnSocio>();
        try {
            AbrirConexion();

            String Consulta = " EXEC UP_CUOTAS_PAGADAS_DE_UN_SOCIO ? ";
            PreparedStatement st = con.prepareStatement(Consulta);

            st.setInt(1, Id);

            ResultSet rt = st.executeQuery();

           while (rt.next()) {

                String fecha = rt.getString("FECHA");
                float pagado = rt.getFloat("COSTO_TOTAL");

                DTOPagosDeUnSocio ac = new DTOPagosDeUnSocio(fecha,pagado);

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
    public ArrayList<DTOTotalGanado> TotalGanado() {
        ArrayList<DTOTotalGanado> lista = new ArrayList<DTOTotalGanado>();
        try {
            AbrirConexion();

            String Consulta = " select SUM(Costo_Total) as'MONTO GANADO HASTA AHORA'\n" +
                              "from factura ";

            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery(Consulta);

            if (rt.next()) {
                float monto = rt.getFloat("MONTO GANADO HASTA AHORA");

                DTOTotalGanado f = new DTOTotalGanado(monto);

                lista.add(f);
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
