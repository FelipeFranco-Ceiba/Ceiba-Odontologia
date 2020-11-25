package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.dominio.servicio.IOdontologoServicio;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ManejadorEliminarOdontologoTest {

    private IOdontologoServicio odontologoServicio;
    private ManejadorEliminarOdontologo spyManejadorEliminarOdontologo;

    @Before
    public void before() {
        odontologoServicio = mock(IOdontologoServicio.class);
        spyManejadorEliminarOdontologo = spy(new ManejadorEliminarOdontologo(odontologoServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarEliminacionOdontologo() {
        Long idOdontologo = 1L;

        spyManejadorEliminarOdontologo.ejecutar(idOdontologo);

    }
}
