package entity;

import exception.VueloInvalido;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Validated
public class Vuelo {
    private String id;
    @NotBlank(message = "Ciudad incorrecta")
    private String ciudadOrigen;
    @NotBlank(message = "Ciudad incorrecta")
    private String ciudadDestino;
    @NotNull
    @Future
    private LocalDateTime fechaSalida;
    @NotNull
    @Future
    private LocalDateTime fechaLlegada;
    private Avion avion;
    private List<Reserva> reservas;

    public Vuelo() {}

    public Vuelo(String id, String ciudadOrigen, String ciudadDestino,
                 LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Avion avion) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        comprobarFechas(fechaSalida, fechaLlegada);
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.avion = avion;
        this.reservas = new ArrayList<>();
    }

    private void comprobarFechas(LocalDateTime fecha1, LocalDateTime fecha2) {
        if (!fecha1.isBefore(fecha2))
            throw new VueloInvalido();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
