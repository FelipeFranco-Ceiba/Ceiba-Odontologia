package co.com.ceiba.dominio.servicio.detallecita;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EliminarDetalleCitaServiceTest {

    private RepositorioDetalleCitaMySql repositorioDetalleCita;
    private ValidarDetalleCita validarDetalleCita;
    private EliminarDetalleCitaService spyEliminarDetalleCitaService;

    @Before
    public void before() {
        repositorioDetalleCita = mock(RepositorioDetalleCitaMySql.class);
        validarDetalleCita = mock(ValidarDetalleCita.class);
        spyEliminarDetalleCitaService = spy(new EliminarDetalleCitaService(repositorioDetalleCita, validarDetalleCita));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noExisteDetalleCita() {
        Long idDetalleCita = 2L;

        doThrow(new CitaExcepcion(ValidarDetalleCita.ERROR_NO_EXISTE_INFORMACION_DE_LA_CITA)).when(validarDetalleCita).existeDetalleCita(idDetalleCita);

        try {
            spyEliminarDetalleCitaService.eliminarDetalleCita(idDetalleCita);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(ValidarDetalleCita.ERROR_NO_EXISTE_INFORMACION_DE_LA_CITA, error.getMessage());
        }

        verify(validarDetalleCita, times(1)).existeDetalleCita(anyLong());
        verify(repositorioDetalleCita, times(0)).eliminarDetalleCita(anyLong());
    }
}
