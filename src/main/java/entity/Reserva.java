package entity;

import java.time.LocalDateTime;
import java.util.List;

public class Reserva {
    private String id;
    private LocalDateTime fechaReserva;
    private int numPlazas;
    private List<Integer> numAsientos;
    private Usuario usuario;
    private Vuelo vuelo;
    private boolean vip;



}
