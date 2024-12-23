package entity;

import exception.AsientoErroneo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avion {
    private String id;
    private int totalAsientos;
    private Map<Integer, Asiento> asientos;
    private static final int columnas = 9;
    private static final List<String> tiposAsientos = List.of("Ventanilla", "Centro", "Pasillo");

    public Avion() {}

    public Avion(String id, int totalAsientos) {
        this.id = id;
        this.totalAsientos = comprobarTotalAsientos(totalAsientos);
        asientos = new HashMap<>();
        asignarAsientos();
    }

    private int comprobarTotalAsientos(int totalAsientos) {
        if (totalAsientos % columnas != 0)
            throw new AsientoErroneo();
        return totalAsientos;
    }

    private void asignarAsientos() {
        int asientoPorFila = 0;
        for (int numAsiento = 0; numAsiento < totalAsientos; numAsiento++) {
            if (asientoPorFila == columnas)
                asientoPorFila = 0;
            asientos.put(numAsiento, new Asiento(numAsiento, tipoAsiento(asientoPorFila), numAsiento > 2*totalAsientos/3));
            asientoPorFila++;
        }
    }

    private String tipoAsiento(int asientoPorFila) {
        return switch (asientoPorFila) {
            case 0, 8 -> tiposAsientos.get(0);
            case 1, 4, 7 -> tiposAsientos.get(1);
            default -> tiposAsientos.get(2);
        };
    }

    public void mostrarAsientos() {
        for (int asiento = 0; asiento < totalAsientos; asiento++) {
            System.out.println(asientos.get(asiento).numero() + " " + asientos.get(asiento).tipoAsiento());
        }
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public int totalAsientos() {
        return totalAsientos;
    }

    public void totalAsientos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public Map<Integer, Asiento> asientos() {
        return asientos;
    }

    public void asientos(Map<Integer, Asiento> asientos) {
        this.asientos = asientos;
    }
}
