package controller.dtos;

import model.Usuario;

public record DTOUsuario(
    String email,
    String password,
    String nombre,
    String apellidos,
    String dni,
    String telefono
) {
}
