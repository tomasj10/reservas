package controller;

import controller.assembler.UsuarioModelAssembler;
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
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ReservasService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/app-reservas")
public class ReservasController {

    @Autowired
    ReservasService servicio;

    @Autowired
    UsuarioModelAssembler usuarioModelAssembler;

    /**
     * Encapsula colecciones de recursos de usuarios
     * @return
     */
    @GetMapping("/usuarios")
    public CollectionModel<EntityModel<Usuario>> usuarios() {

        List<EntityModel<Usuario>> listaUsuarios = servicio.usuarios().stream()
                .map(usuarioModelAssembler::toModel) // Equivale a map(usuario -> usuarioModelAssembler.toModel(usuario))
                .collect(Collectors.toList());

        return CollectionModel.of(listaUsuarios,
                linkTo(methodOn(ReservasController.class).usuarios()).withSelfRel());

    }

    /**
     * HTTP 201 si el usuario se ha creado bien
     * @param dtoUsuario
     * @return
     */
    @PostMapping("/usuarios")
    public ResponseEntity<EntityModel<Usuario>> nuevoUsuario() {
        EntityModel<Usuario> userModel = usuarioModelAssembler.toModel(servicio.newUsuario());
        return ResponseEntity
                .created(userModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(userModel);
    }

    /**
     * HTTP 204 : No content, al borrar el usuario 
     * @param id
     * @return
     */
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String id) {
        servicio.deleteUsuario(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Devuelve un recurso de usuarios que a su vez contiene los links, tanto propio como general, para buscar usuarios.
     * @param id
     * @return
     */
    @GetMapping("/usuarios/{id}")
    public EntityModel<Usuario> buscarUsuario(@PathVariable String id) {
        return usuarioModelAssembler.toModel(servicio.buscarUsuario(id));
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
        return new ArrayList<>();
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
