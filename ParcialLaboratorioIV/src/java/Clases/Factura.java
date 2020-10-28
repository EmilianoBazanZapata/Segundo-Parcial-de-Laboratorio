package Clases;

public class Factura {

    private int numero_de_factura;
    private Socio socio;
    private Forma_de_Pago forma_de_pago;
    private float monto_total;

    public int getNumero_de_factura() {
        return numero_de_factura;
    }

    public void setNumero_de_factura(int numero_de_factura) {
        this.numero_de_factura = numero_de_factura;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Forma_de_Pago getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(Forma_de_Pago forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }

    public float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(float monto_total) {
        this.monto_total = monto_total;
    }

    public Factura() {
    }

    public Factura(int numero_de_factura, Socio socio, Forma_de_Pago forma_de_pago, float monto_total) {
        this.numero_de_factura = numero_de_factura;
        this.socio = socio;
        this.forma_de_pago = forma_de_pago;
        this.monto_total = monto_total;
    }

    @Override
    public String toString() {
        return "Factura{" + "numero_de_factura=" + numero_de_factura + ", socio=" + socio + ", forma_de_pago=" + forma_de_pago + ", monto_total=" + monto_total + '}';
    }
}
