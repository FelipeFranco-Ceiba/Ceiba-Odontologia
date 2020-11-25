package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.dominio.servicio.odontologo.EliminarOdontologoServicio;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@RunWith(SpringRunner.class)
public class ManejadorEliminarOdontologoTest {

    private EliminarOdontologoServicio eliminarOdontologoServicio;
    private ManejadorEliminarOdontologo spyManejadorEliminarOdontologo;

    @Before
    public void before() {
        eliminarOdontologoServicio = mock(EliminarOdontologoServicio.class);
        spyManejadorEliminarOdontologo = spy(new ManejadorEliminarOdontologo(eliminarOdontologoServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarEliminacionOdontologo() {
        Long idOdontologo = 1L;

        spyManejadorEliminarOdontologo.ejecutar(idOdontologo);

    }
}
