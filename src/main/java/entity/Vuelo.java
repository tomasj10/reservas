package entity;

import java.time.LocalDate;
import java.util.List;

public class Vuelo {
    private String id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int horaSalida;
    private int horaLlegada;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private Avion avion;
    private List<Reserva> reservas;

    public Vuelo() {}

    public Vuelo(String id, String ciudadOrigen, String ciudadDestino, int horaSalida,
                 int horaLlegada, LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public String ciudadOrigen() {
        return ciudadOrigen;
    }

    public void ciudadOrigen(String ciudad) {
        this.ciudadOrigen = ciudad;
    }

    public String ciudadDestino() {
        return ciudadDestino;
    }

    public void ciudadDestino(String ciudad) {
        this.ciudadDestino = ciudad;
    }

    public int horaSalida() {
        return horaSalida;
    }

    public void horaSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int horaLlegada() {
        return horaLlegada;
    }

    public void horaLlegada(int horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDate fechaSalida() {
        return fechaSalida;
    }

    public void fechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate fechaLlegada() {
        return fechaLlegada;
    }

    public void fechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Avion avion() {
        return avion;
    }

    public void avion(Avion avion) {
        this.avion = avion;
    }

    public List<Reserva> reservas() {
        return reservas;
    }

    public void reservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
