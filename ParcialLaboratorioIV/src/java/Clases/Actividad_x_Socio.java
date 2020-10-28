package Clases;

public class Actividad_x_Socio {

    private int Id_Actividad;
    private int Id_Socio;
    private Socio socio;
    private Actividad actividad;

    public int getId_Actividad() {
        return Id_Actividad;
    }

    public void setId_Actividad(int Id_Actividad) {
        this.Id_Actividad = Id_Actividad;
    }

    public int getId_Socio() {
        return Id_Socio;
    }

    public void setId_Socio(int Id_Socio) {
        this.Id_Socio = Id_Socio;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Actividad_x_Socio() {
    }

    public Actividad_x_Socio(int Id_Actividad, int Id_Socio, Socio socio, Actividad actividad) {
        this.Id_Actividad = Id_Actividad;
        this.Id_Socio = Id_Socio;
        this.socio = socio;
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "Actividad_x_Socio{" + "Id_Actividad=" + Id_Actividad + ", Id_Socio=" + Id_Socio + ", socio=" + socio + ", actividad=" + actividad + '}';
    }

}