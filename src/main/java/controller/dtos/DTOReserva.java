package controller.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record  DTOReserva (
        String id,
        LocalDateTime fechaReserva,
        int numPlazas,
        String emailUsuario,
        String idVuelo,
        List<Integer> numerosAsientos,
        boolean vip
){}
