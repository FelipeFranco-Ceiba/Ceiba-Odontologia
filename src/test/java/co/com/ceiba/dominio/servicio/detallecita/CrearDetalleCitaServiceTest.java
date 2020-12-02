package co.com.ceiba.dominio.servicio.detallecita;

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
public class CrearDetalleCitaServiceTest {

    private RepositorioDetalleCitaMySql repositorioDetalleCita;
    private ConsularHorasTrabajadasOdontologo consularHorasTrabajadasOdontologo;
    private CrearDetalleCitaService spyCrearDetalleCitaService;

    @Before
    public void before() {
        repositorioDetalleCita = mock(RepositorioDetalleCitaMySql.class);
        consularHorasTrabajadasOdontologo = mock(ConsularHorasTrabajadasOdontologo.class);
        spyCrearDetalleCitaService = spy(new CrearDetalleCitaService(repositorioDetalleCita, consularHorasTrabajadasOdontologo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void actualizarDetalleCita() {
        DetalleCita detalleCita = new DetalleCitaFactory().buildDetalleCita();
        Long horasTrabajadas = 4L;

        when(consularHorasTrabajadasOdontologo.consultarHorasTrabajadas(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita())).thenReturn(horasTrabajadas);
        when(repositorioDetalleCita.crearDetalleCita(detalleCita)).thenReturn(detalleCita);

        DetalleCita detalleCitaCreada = spyCrearDetalleCitaService.crearDetalleCita(detalleCita);

        assertEquals(detalleCita, detalleCitaCreada);

        verify(consularHorasTrabajadasOdontologo, times(1)).consultarHorasTrabajadas(anyLong(), any(), anyLong());
        verify(repositorioDetalleCita, times(1)).crearDetalleCita(any(DetalleCita.class));
    }

    @Test
    public void crearDetalleCitaCuandoSuperaLaHoraMaximaDeTrabajo() {
        DetalleCita detalleCita = new DetalleCitaFactory().buildDetalleCita();
        Long horasTrabajadas = 4L;

        when(consularHorasTrabajadasOdontologo.consultarHorasTrabajadas(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita())).thenThrow(new CitaExcepcion(ConsularHorasTrabajadasOdontologo.ERROR_CANTIDAD_HORA_CITA));

        try {
            spyCrearDetalleCitaService.crearDetalleCita(detalleCita);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(ConsularHorasTrabajadasOdontologo.ERROR_CANTIDAD_HORA_CITA, error.getMessage());
        }

        verify(consularHorasTrabajadasOdontologo, times(1)).consultarHorasTrabajadas(anyLong(), any(), anyLong());
        verify(repositorioDetalleCita, times(0)).crearDetalleCita(any(DetalleCita.class));
    }
}

