package Clases;



public class DTOPagosDeUnSocio {

    private String fecha;
    private float total;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public DTOPagosDeUnSocio() {
    }

    public DTOPagosDeUnSocio(String fecha, float total) {
        this.fecha = fecha;
        this.total = total;
    }

    @Override
    public String toString() {
        return "DTOPagosDeUnSocio{" + "fecha=" + fecha + ", total=" + total + '}';
    }

}
