package Clases;

public class Socio {

    private int id_socio;
    private String nombre;
    private String apellido;
    private int dni;

    public int getId_socio() {
        return id_socio;
    }

    public void setId_socio(int id_socio) {
        this.id_socio = id_socio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Socio() {
    }

    public Socio(int id_socio, String nombre, String apellido, int dni) {
        this.id_socio = id_socio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "id_socio :" + id_socio + " nombre : " + nombre + " apellido : " + apellido + " dni : " + dni;
    }
}
