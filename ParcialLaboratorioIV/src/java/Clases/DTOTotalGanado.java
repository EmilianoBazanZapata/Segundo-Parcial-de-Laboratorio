package Clases;

public class DTOTotalGanado {

    private float totalganado;

    public float getTotalganado() {
        return totalganado;
    }

    public void setTotalganado(float totalganado) {
        this.totalganado = totalganado;
    }

    public DTOTotalGanado() {
    }

    public DTOTotalGanado(float totalganado) {
        this.totalganado = totalganado;
    }

    @Override
    public String toString() {
        return ""+totalganado;
    }
}
