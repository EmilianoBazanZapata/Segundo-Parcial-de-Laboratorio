package Clases;

public class Administrador {

    private int id_administrador;
    private String nombre;
    private String apellido;
    private int dni;
    private String contraseña;

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Administrador() {
    }

    public Administrador(int id_administrador, String nombre, String apellido, int dni, String contraseña) {
        this.id_administrador = id_administrador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "id_administrador : " + id_administrador + " nombre : " + nombre + " apellido : " + apellido + " dni : " + dni + " contraseña : " + contraseña;
    }

}
