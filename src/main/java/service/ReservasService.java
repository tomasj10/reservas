package service;

import model.Reserva;
import model.Usuario;
import model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservasService {

    public List<Usuario> usuarios() {
        return new ArrayList<>();
    }

    public Usuario newUsuario() {
        throw new UnsupportedOperationException();
    }

    public Usuario buscarUsuario(String id) {
        return new Usuario();
    }

    public void deleteUsuario(String id) {}

    public List<Vuelo> vuelos() {
        return new ArrayList<>();
    }

    public void newVuelo() {
        throw new UnsupportedOperationException();
    }

    public Vuelo buscarVuelo(String id) {
        return new Vuelo();
    }

    public List<Reserva> reservas() {
        return new ArrayList<>();
    }

    public void newReserva(){
        throw new UnsupportedOperationException();
    }

    public Reserva buscarReserva(String id) {
        return new Reserva();
    }

}
