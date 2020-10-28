package Clases;

public class DTOSociosDeUnaActividad {

    private Actividad actividad;
    private Socio socio;

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public DTOSociosDeUnaActividad() {
    }

    public DTOSociosDeUnaActividad(Actividad actividad, Socio socio) {
        this.actividad = actividad;
        this.socio = socio;
    }

    @Override
    public String toString() {
        return "actividad=" + actividad + ", socio=" + socio + '}';
    }

}
