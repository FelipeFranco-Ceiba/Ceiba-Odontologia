package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.aplicacion.fabrica.FabricaOdontologo;
import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.odontologo.ActualizarOdontologoServicio;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ManejadorActualizarOdontologoTest {

    private ActualizarOdontologoServicio actualizarOdontologoServicio;
    private ManejadorActualizarOdontologo spyManejadorActualizarOdontologo;

    @Before
    public void before() {
        actualizarOdontologoServicio = mock(ActualizarOdontologoServicio.class);
        spyManejadorActualizarOdontologo = spy(new ManejadorActualizarOdontologo((actualizarOdontologoServicio)));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarActualizarOdontologo() {
        ComandoOdontologo comandoOdontologo = new OdontologoFactory().buildComando();
        Odontologo odontologo = FabricaOdontologo.crearOdontologo(comandoOdontologo);

        when(actualizarOdontologoServicio.actualizarOdontologo(odontologo)).thenReturn(odontologo);

        Odontologo odontologoActualizado = spyManejadorActualizarOdontologo.ejecutar(comandoOdontologo);

        assertEquals(odontologo, odontologoActualizado);

        verify(actualizarOdontologoServicio, times(1)).actualizarOdontologo(any(Odontologo.class));
    }

    @Test
    public void ejecutarActualizarOdontologoNoExiste() {
        ComandoOdontologo comandoOdontologo = new OdontologoFactory().buildComando();
        Odontologo odontologo = FabricaOdontologo.crearOdontologo(comandoOdontologo);

        when(actualizarOdontologoServicio.actualizarOdontologo(odontologo)).thenThrow(new ExistenciaPersonaExcepcion(ActualizarOdontologoServicio.ERROR_NO_EXISTE_ODONTOLOGO));

        try {
            spyManejadorActualizarOdontologo.ejecutar(comandoOdontologo);
        } catch (Exception error) {

            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(ActualizarOdontologoServicio.ERROR_NO_EXISTE_ODONTOLOGO, error.getMessage());
        }

        verify(actualizarOdontologoServicio, times(1)).actualizarOdontologo(any(Odontologo.class));
    }

}
