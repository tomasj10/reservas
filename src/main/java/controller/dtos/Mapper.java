package controller.dtos;

import model.Reserva;

public class Mapper {
    public DTOReserva dto(Reserva r) {
        return new DTOReserva(r.getId(), r.getFechaReserva(),
                r.getNumPlazas(), r.getUsuario().getEmail(),
                r.getVuelo().getId(), r.getNumerosAsientos(),
                r.isVip());
    }
}
