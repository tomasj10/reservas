package entity;

import exception.ReservaInvalida;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Component
@Validated
public class Reserva {
    private String id;
    @NotNull
    @PastOrPresent
    private LocalDateTime fechaReserva;
    @NotNull
    @Positive
    @Max(MAX_PLAZAS)
    private int numPlazas;
    @NotEmpty(message = "Debe seleccionar un asiento como mínimo")
    @Size(max = MAX_PLAZAS)
    private List<Integer> numerosAsientos;
    private boolean vip;
    private Usuario usuario;
    private Vuelo vuelo;
    private static final int MAX_PLAZAS = 3;

    public Reserva() {}

    public Reserva(String id, LocalDateTime fechaReserva, int numPlazas, List<Integer> numerosAsientos,
                   Usuario usuario, Vuelo vuelo, boolean vip) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.numPlazas = numPlazas;
        comprobarAsientos(numerosAsientos);
        this.numerosAsientos = numerosAsientos;
        this.usuario = usuario;
        this.vuelo = vuelo;
        this.vip = vip;
    }

    public void reservarAsientos(List<Integer> asientos) {
        numerosAsientos.addAll(asientos.stream()
                                       .sorted()
                                       .collect(Collectors.toList()));
    }

    private void comprobarAsientos(List<Integer> asientos) {
        if (asientos.stream()
                    .anyMatch(
                            a -> a > vuelo.getAvion().getTotalAsientos() || a < 0
                    ))
            throw new ReservaInvalida();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public List<Integer> getNumerosAsientos() {
        return numerosAsientos;
    }

    public void setNumerosAsientos(List<Integer> numerosAsientos) {
        this.numerosAsientos = numerosAsientos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
