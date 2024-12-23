package entity;

import main.ReservasApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ReservasApplication.class)
@TestConfiguration
public class TestAvion {
    @Test
    @DirtiesContext
    public void testAsignacionAsientos(){
        var avion = new Avion("1", 63);
        avion.mostrarAsientos();
        assertThat(avion.totalAsientos()).isEqualTo(63);
    }
}
