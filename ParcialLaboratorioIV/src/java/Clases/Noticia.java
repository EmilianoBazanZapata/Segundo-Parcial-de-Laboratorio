package Clases;

public class Noticia {

    private int id_noticia;
    private String titulo;
    private String noticia;
    private Actividad actividad;
    private boolean activo;

    public Noticia(int id_noticia, String titulo, String noticia, Actividad actividad, boolean activo) {
        this.id_noticia = id_noticia;
        this.titulo = titulo;
        this.noticia = noticia;
        this.actividad = actividad;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(int id_noticia) {
        this.id_noticia = id_noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Noticia() {
    }

    @Override
    public String toString() {
        return "Noticia{" + "id_noticia=" + id_noticia + ", titulo=" + titulo + ", noticia=" + noticia + ", actividad=" + actividad + ", activo=" + activo + '}';
    }

}
