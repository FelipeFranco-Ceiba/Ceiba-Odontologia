package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ActualizarOdontologoServicioTest {

    private IRepositorioOdontologo repositorioOdontologo;
    private ActualizarOdontologoServicio spyActualizarOdontologoServicio;

    @Before
    public void before() {
        repositorioOdontologo = mock(IRepositorioOdontologo.class);
        spyActualizarOdontologoServicio = spy(new ActualizarOdontologoServicio(repositorioOdontologo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void actualizarOdontologoExistenteTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        doReturn(odontologo).when(spyActualizarOdontologoServicio).existeOdontologo(anyLong());
        when(repositorioOdontologo.actualizarOdontologo(odontologo)).thenReturn(odontologo);

        Odontologo odontologoActualizado = spyActualizarOdontologoServicio.actualizarOdontologo(odontologo);

        assertEquals(odontologo, odontologoActualizado);

        verify(spyActualizarOdontologoServicio, times(1)).existeOdontologo(anyLong());
        verify(repositorioOdontologo, times(1)).actualizarOdontologo(any(Odontologo.class));
    }

    @Test
    public void actualizarOdontologoNoExistenteTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        doThrow(new CitaExcepcion(ActualizarOdontologoServicio.ERROR_NO_EXISTE_ODONTOLOGO)).when(spyActualizarOdontologoServicio).existeOdontologo(anyLong());

        try {
            spyActualizarOdontologoServicio.actualizarOdontologo(odontologo);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(ActualizarOdontologoServicio.ERROR_NO_EXISTE_ODONTOLOGO, error.getMessage());
        }
    }

    @Test
    public void existeOdontologo() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();
        Long idOdontologo = 1L;

        when(repositorioOdontologo.consultarOdontologoPorId(idOdontologo)).thenReturn(odontologo);

        Odontologo odontologoEncontrado = spyActualizarOdontologoServicio.existeOdontologo(idOdontologo);

        assertEquals(odontologo, odontologoEncontrado);
        verify(repositorioOdontologo, times(1)).consultarOdontologoPorId(anyLong());
    }

    @Test
    public void noExisteOdontologo() {
        Long idOdontologo = 1L;

        when(repositorioOdontologo.consultarOdontologoPorId(idOdontologo)).thenReturn(null);

        try {
            spyActualizarOdontologoServicio.existeOdontologo(idOdontologo);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(ActualizarOdontologoServicio.ERROR_NO_EXISTE_ODONTOLOGO, error.getMessage());
        }

        verify(repositorioOdontologo, times(1)).consultarOdontologoPorId(anyLong());
    }
}
