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

    /**
     * Realiza la asignación de asientos en un avion
     * La variable asientoPorFila permite asignar correctamente los tipos de asientos.
     */
    private void asignarAsientos() {
        int asientoPorFila = 0;
        for (int numAsiento = 0; numAsiento < totalAsientos; numAsiento++) {
            nuevoAsiento(numAsiento, asientoPorFila);
            asientoPorFila++;
        }
    }

    /**
     * Añade un nuevo asiento al mapa de asientos
     * @param numAsiento identificador único del asiento en el avión
     * @param asientoPorFila número de asiento en la fila (0-8)
     */
    private void nuevoAsiento(int numAsiento, int asientoPorFila) {
        asientos.put(numAsiento, new Asiento(
                                numAsiento,
                                tipoAsiento(comprobarNuevaFila(asientoPorFila)),
                                esVip(numAsiento))
        );
    }

    /**
     * Comprueba si hay que pasar a la siguiente fila de asientos
     * @param asientoPorFila número de asiento en la fila (0-8)
     * @return número de asiento en la fila o 0 si hay que pasar a la siguiente fila
     */
    private int comprobarNuevaFila(int asientoPorFila) {
        return asientoPorFila == columnas ? asientoPorFila : 0;
    }

    /**
     * Asigna el tipo de un asiento según su posición en la fila.
     * 0 y 8 -> Ventanilla
     * 1, 4 y 7 -> Centro
     * Resto -> Pasillo
     * @param asientoPorFila número de asiento en la fila (0-8)
     * @return tipo del asiento pasado por parámetro
     */
    private String tipoAsiento(int asientoPorFila) {
        return switch (asientoPorFila) {
            case 0, 8 -> tiposAsientos.get(0);
            case 1, 4, 7 -> tiposAsientos.get(1);
            default -> tiposAsientos.get(2);
        };
    }

    /**
     * Comprueba si un asiento es vip.
     * Considerando que 2/3 de los asientos de un avión no lo son y que los primeros asientos son los vips.
     * @param numAsiento identificador del asiento por número
     * @return true si el asiento pertenece al primer tercio del total de asientos, false si es lo contrario.
     */
    boolean esVip(int numAsiento){
        return numAsiento > totalAsientos/3;
    }

    public void mostrarAsientos() {
        for (int asiento = 0; asiento < totalAsientos; asiento++) {
            System.out.println(asientos.get(asiento).getNumero() + " " + asientos.get(asiento).getTipoAsiento());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public Map<Integer, Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(Map<Integer, Asiento> asientos) {
        this.asientos = asientos;
    }
}
