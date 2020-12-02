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
public class ValidarDetalleCitaTest {

    private RepositorioDetalleCitaMySql repositorioDetalleCita;
    private ValidarDetalleCita spyValidarDetalleCita;

    @Before
    public void before() {
        repositorioDetalleCita = mock(RepositorioDetalleCitaMySql.class);
        spyValidarDetalleCita = spy(new ValidarDetalleCita(repositorioDetalleCita));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noExisteDetalleCitaTest() {
        Long idDetalleCita = 1L;

        when(repositorioDetalleCita.existeDetalleCita(idDetalleCita)).thenReturn(false);

        try {
            spyValidarDetalleCita.existeDetalleCita(idDetalleCita);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(ValidarDetalleCita.ERROR_NO_EXISTE_INFORMACION_DE_LA_CITA, error.getMessage());
        }

        verify(repositorioDetalleCita, times(1)).existeDetalleCita(anyLong());
    }
}
