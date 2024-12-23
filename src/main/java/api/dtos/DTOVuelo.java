package api.dtos;

import entity.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;

public record DTOVuelo(
    String id,
    String ciudadOrigen,
    String ciudadDestino,
    int horaSalida,
    int horaLlegada,
    LocalDate fechaSalida,
    LocalDate fechaLlegada,
    int totalAsientos,
    ArrayList<Integer> asientos
    )
{}
