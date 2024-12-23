package entity;

import java.util.List;

public class Usuario {
    private String email;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private List<Reserva> reservas;

    public Usuario(){};

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(String email, String password, String nombre, String apellidos, String dni, String telefono){
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String email(){
        return email;
    }

    public void email(String email){
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void password(String password) {
        this.password = password;
    }

    public String nombre() {
        return nombre;
    }

    public void nombre(String nombre) {
        this.nombre = nombre;
    }

    public String apellidos() {
        return apellidos;
    }

    public void apellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String dni() {
        return dni;
    }

    public void dni(String dni) {
        this.dni = dni;
    }

    public String telefono() {
        return telefono;
    }

    public void telefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Reserva> reservas() {
        return reservas;
    }

    public void reservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
