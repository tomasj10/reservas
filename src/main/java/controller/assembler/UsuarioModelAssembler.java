package controller.assembler;

import controller.ReservasController;
import model.Usuario;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {
    @Override
    public EntityModel<Usuario> toModel(Usuario usuario) {

        return EntityModel.of(usuario,
                linkTo(methodOn(ReservasController.class).buscarUsuario(usuario.getEmail())).withSelfRel(),
                linkTo(methodOn(ReservasController.class).usuarios()).withRel("usuarios")
        );
    }
}
