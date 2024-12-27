package controller.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record DTOVuelo(
    String id,
    String ciudadOrigen,
    String ciudadDestino,
    LocalDateTime fechaSalida,
    LocalDateTime fechaLlegada,
    String idAvion )
{}
