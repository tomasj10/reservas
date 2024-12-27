package controller;

import controller.dtos.DTOReserva;
import controller.dtos.DTOUsuario;
import controller.dtos.DTOVuelo;
import controller.dtos.Mapper;
import model.Reserva;
import model.Usuario;
import model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import service.ReservasService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/app-reservas")
public class ReservasController {

    @Autowired
    ReservasService servicio;

    @Autowired
    Mapper mapper;

    /**
     * Encapsula colecciones de recursos de usuarios
     * @return
     */
    @GetMapping("/usuarios")
    public CollectionModel<EntityModel<Usuario>> usuarios() {

        List<EntityModel<Usuario>> listaUsuarios = servicio.usuarios().stream()
                .map(usuario -> EntityModel.of(usuario,
                        linkTo(methodOn(ReservasController.class).buscarUsuario(usuario.getEmail())).withSelfRel(),
                        linkTo(methodOn(ReservasController.class).usuarios()).withRel("usuarios")))
                .collect(Collectors.toList());

        return CollectionModel.of(listaUsuarios,
                linkTo(methodOn(ReservasController.class).usuarios()).withSelfRel());

    }

    @PostMapping("/usuarios")
    public void nuevoUsuario(DTOUsuario dtoUsuario) {
        servicio.newUsuario();
    }

    /**
     * Devuelve un recurso de usuarios que a su vez contiene los links, tanto propio como general, para buscar usuarios.
     * @param id
     * @return
     */
    @GetMapping("/usuarios/{id}")
    public EntityModel<Usuario> buscarUsuario(@PathVariable String id) {
        Usuario usuario = servicio.buscarUsuario(id);

        return EntityModel.of(usuario,
                linkTo(methodOn(ReservasController.class).buscarUsuario(id)).withSelfRel(),
                linkTo(methodOn(ReservasController.class).usuarios()).withRel("usuarios"));
    }

    @GetMapping("/vuelos")
    public List<DTOVuelo> vuelos() {
        return servicio.vuelos().stream()
                .map(v -> new DTOVuelo(v.getId(), v.getCiudadOrigen(), v.getCiudadDestino(),
                     v.getFechaSalida(), v.getFechaLlegada(), v.getAvion().getId()))
                .collect(Collectors.toList());
    }

    @PostMapping("/vuelos")
    public void nuevoVuelo(DTOVuelo dtoVuelo) {
        servicio.newVuelo();
    }

    @GetMapping("/vuelos/{id}/reservas")
    public List<DTOReserva> reservas(@PathVariable String id) {
        Vuelo vuelo = servicio.buscarVuelo(id);
        return servicio.reservas().stream().map(reserva -> mapper.dto(reserva)).collect(Collectors.toList());
    }

    @PostMapping("/vuelos/{id}/reservas")
    public void nuevaReserva(@PathVariable String id, @RequestParam String email,
                             @RequestParam int plazas, @RequestParam List<Integer> numAsientos) {
        servicio.newReserva();
    }

    @GetMapping("/vuelos/{id}/reserva/{idreserva}")
    public void buscarReserva(@PathVariable String id, @PathVariable String idreserva) {
    }
}
