package Clases;

public class Actividad {

    private int id_actividad;
    private String actividad;
    private float precio;

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Actividad() {
    }

    public Actividad(int id_actividad, String actividad, float precio) {
        this.id_actividad = id_actividad;
        this.actividad = actividad;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Id Actividad :" + id_actividad + " Actividad : " + actividad + " Precio :" + precio + '}';
    }
}
