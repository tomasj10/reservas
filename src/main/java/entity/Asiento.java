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

    public int numero() {
        return numero;
    }

    public void numero(int numero) {
        this.numero = numero;
    }

    public String tipoAsiento() {
        return tipoAsiento;
    }

    public void tipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public int precio() {
        return precio;
    }

    public void precio(int precio) {
        this.precio = precio;
    }

    public boolean disponible(){
        return disponible;
    }

    public void disponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean vip() {
        return vip;
    }

    public void vip(boolean vip) {
        this.vip = vip;
    }
}
