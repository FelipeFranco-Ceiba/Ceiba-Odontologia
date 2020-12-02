package co.com.ceiba.dominio.servicio.detalleCita;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import co.com.ceiba.infraestructura.mockfactory.DetalleCitaFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ActualizarDetalleCitaServicioTest {

    private RepositorioDetalleCitaMySql repositorioDetalleCita;
    private ConsularHorasTrabajadasOdontologo consularHorasTrabajadasOdontologo;
    private ValidarDetalleCita validarDetalleCita;
    private ActualizarDetalleCitaServicio spyPctualizarDetalleCitaServicio;

    @Before
    public void before() {
        repositorioDetalleCita = mock(RepositorioDetalleCitaMySql.class);
        consularHorasTrabajadasOdontologo = mock(ConsularHorasTrabajadasOdontologo.class);
        validarDetalleCita = mock(ValidarDetalleCita.class);
        spyPctualizarDetalleCitaServicio = spy(new ActualizarDetalleCitaServicio(repositorioDetalleCita, consularHorasTrabajadasOdontologo, validarDetalleCita));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void actualizarDetalleCita() {
        DetalleCita detalleCita = new DetalleCitaFactory().buildDetalleCita();
        Long idDetalleCIta = 2L;
        Long horasTrabajadas = 4L;

        doNothing().when(validarDetalleCita).existeDetalleCita(idDetalleCIta);
        when(consularHorasTrabajadasOdontologo.consultarHorasTrabajadas(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita())).thenReturn(horasTrabajadas);
        when(repositorioDetalleCita.crearDetalleCita(detalleCita)).thenReturn(detalleCita);

        DetalleCita detalleCitaActualizada = spyPctualizarDetalleCitaServicio.actualizarDetalleCita(detalleCita);

        assertEquals(detalleCita, detalleCitaActualizada);

        verify(validarDetalleCita, times(1)).existeDetalleCita(anyLong());
        verify(consularHorasTrabajadasOdontologo, times(1)).consultarHorasTrabajadas(anyLong(), any(), anyLong());
        verify(repositorioDetalleCita, times(1)).crearDetalleCita(any(DetalleCita.class));
    }

    @Test
    public void actualizarDetalleCitaCuandoNoExiste() {
        DetalleCita detalleCita = new DetalleCitaFactory().buildDetalleCita();
        Long idDetalleCIta = 2L;
        Long horasTrabajadas = 4L;

        doThrow(new CitaExcepcion(ValidarDetalleCita.ERROR_NO_EXISTE_INFORMACION_DE_LA_CITA)).when(validarDetalleCita).existeDetalleCita(idDetalleCIta);

        try {
            spyPctualizarDetalleCitaServicio.actualizarDetalleCita(detalleCita);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(ValidarDetalleCita.ERROR_NO_EXISTE_INFORMACION_DE_LA_CITA, error.getMessage());
        }

        verify(validarDetalleCita, times(1)).existeDetalleCita(anyLong());
        verify(consularHorasTrabajadasOdontologo, times(0)).consultarHorasTrabajadas(anyLong(), any(), anyLong());
        verify(repositorioDetalleCita, times(0)).crearDetalleCita(any(DetalleCita.class));
    }

    @Test
    public void actualizarDetalleCitaCuandoSuperaLaHoraMaximaDeTrabajo() {
        DetalleCita detalleCita = new DetalleCitaFactory().buildDetalleCita();
        Long idDetalleCIta = 2L;
        Long horasTrabajadas = 4L;

        doNothing().when(validarDetalleCita).existeDetalleCita(idDetalleCIta);
        when(consularHorasTrabajadasOdontologo.consultarHorasTrabajadas(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita())).thenThrow(new CitaExcepcion(ConsularHorasTrabajadasOdontologo.ERROR_CANTIDAD_HORA_CITA));

        try {
            spyPctualizarDetalleCitaServicio.actualizarDetalleCita(detalleCita);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(ConsularHorasTrabajadasOdontologo.ERROR_CANTIDAD_HORA_CITA, error.getMessage());
        }

        verify(validarDetalleCita, times(1)).existeDetalleCita(anyLong());
        verify(consularHorasTrabajadasOdontologo, times(1)).consultarHorasTrabajadas(anyLong(), any(), anyLong());
        verify(repositorioDetalleCita, times(0)).crearDetalleCita(any(DetalleCita.class));
    }
}
