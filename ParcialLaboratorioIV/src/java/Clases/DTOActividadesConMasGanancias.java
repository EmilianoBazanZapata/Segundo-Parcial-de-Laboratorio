package Clases;

public class DTOActividadesConMasGanancias {

    private float monto;
    private String Actividad;

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public DTOActividadesConMasGanancias() {
    }

    public DTOActividadesConMasGanancias(float monto, String Actividad) {
        this.monto = monto;
        this.Actividad = Actividad;
    }

    @Override
    public String toString() {
        return "DTOActividadesConMasGanancias{" + "monto=" + monto + ", Actividad=" + Actividad + '}';
    }

}
