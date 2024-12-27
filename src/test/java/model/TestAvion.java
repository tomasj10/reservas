package entity;

import exception.AsientoErroneo;
import main.ReservasApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(classes = ReservasApplication.class)
@TestConfiguration
public class TestAvion {
    @Test
    @DirtiesContext
    public void testAsignacionAsientos(){

        assertThatThrownBy(() -> new Avion("1", 62)).isInstanceOf(AsientoErroneo.class);

        var avion = new Avion("1", 63);

        assertThat(avion.getAsientos().get(0).getTipoAsiento()).isEqualTo("Ventanilla");
        assertThat(avion.getAsientos().get(61).getTipoAsiento()).isEqualTo("Centro");
        assertThat(avion.getAsientos().get(63/3).isVip()).isTrue();
        assertThat(avion.getAsientos().get(63/3 + 1).isVip()).isFalse();
    }
}
