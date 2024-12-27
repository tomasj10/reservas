package model;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Component
@Validated
public class Usuario {
    @Email
    private String email;
    @NotBlank(message = "La contraseña no debe ser nula")
    private String password;
    @NotBlank(message = "El nombre no debe ser nulo")
    @Size(min = 2, max = 32, message = "El nombre debe tener entre 2 y 32 caracteres")
    private String nombre;
    @NotBlank(message = "Los apellidos no deben ser nulos")
    private String apellidos;
    @NotBlank(message = "Introduzca un dni válido")
    @Digits(integer = 9, fraction = 0)
    @Pattern(regexp = "[0-9]{8}[A-Za-z]", message = "Debe introducir 8 números y 1 letra")
    private String dni;
    @Pattern(regexp = "\\d{9}[1-9]")
    private String telefono;
    private List<Reserva> reservas;

    public Usuario(){}

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
        this.reservas = new ArrayList<>();
    }

    public Usuario(String email, String password, String nombre, String apellidos, String dni, String telefono){
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.reservas = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
