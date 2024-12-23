package entity;

public class Asiento {
    private int numero;
    private String tipoAsiento;
    private int precio;
    private boolean disponible;
    private boolean vip;

    public Asiento(int numero, String tipoAsiento, boolean vip) {
        this.numero = numero;
        this.tipoAsiento = tipoAsiento;
        this.precio = precioPorAsiento();
        this.disponible = true;
        this.vip = vip;
    }

    private int precioPorAsiento() {
        return switch (tipoAsiento) {
            case "Ventanilla" -> 45;
            case "Pasillo" -> 40;
            default -> 30;
        };
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
