package Clases;

public class Detalle_Factura {

    private int num_factura;
    private int id_actividad;
    private float precio_unitario;

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Detalle_Factura() {
    }

    public Detalle_Factura(int num_factura, int id_actividad, float precio_unitario) {
        this.num_factura = num_factura;
        this.id_actividad = id_actividad;
        this.precio_unitario = precio_unitario;
    }

    @Override
    public String toString() {
        return "num_factura : " + num_factura + " id_actividad : " + id_actividad + " precio_unitario : " + precio_unitario;
    }
}
