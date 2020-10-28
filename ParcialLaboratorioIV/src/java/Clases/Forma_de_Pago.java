package Clases;

public class Forma_de_Pago {

    private int id_Pago;
    private String forma_de_pago;

    public int getId_Pago() {
        return id_Pago;
    }

    public void setId_Pago(int id_Pago) {
        this.id_Pago = id_Pago;
    }

    public String getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(String forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }

    public Forma_de_Pago() {
    }

    public Forma_de_Pago(int id_Pago, String forma_de_pago) {
        this.id_Pago = id_Pago;
        this.forma_de_pago = forma_de_pago;
    }

    @Override
    public String toString() {
        return "Id_Pago : " + id_Pago + " Forma de Pago : " + forma_de_pago;
    }
}
