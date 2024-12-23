package api;

import api.dtos.DTOReserva;
import api.dtos.DTOUsuario;
import api.dtos.DTOVuelo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservasControllerREST {

    @GetMapping("/usuarios")
    public List<DTOUsuario> usuarios() {
        List<DTOUsuario> listaUsuarios = new ArrayList<>();
        return listaUsuarios;
    }

    @PostMapping("/usuarios")
    public void nuevoUsuario(DTOUsuario dtoUsuario) {
    }

    @GetMapping
    public List<DTOVuelo> vuelos() {
        List<DTOVuelo> listaVuelos = new ArrayList<>();
        return listaVuelos;
    }

    @PostMapping("/vuelos")
    public void nuevoVuelo(DTOVuelo dtoVuelo) {
    }

    @GetMapping("/vuelos/{id}/reservas")
    public List<DTOReserva> reservas(@PathVariable String id) {
        List<DTOReserva> reservas = new ArrayList<>();
        return reservas;
    }

    @PostMapping("/vuelos/{id}/reservas")
    public void nuevaReserva(@PathVariable String id, @RequestParam String email,
                             @RequestParam int plazas, @RequestParam List<Integer> numAsientos) {

    }
}
