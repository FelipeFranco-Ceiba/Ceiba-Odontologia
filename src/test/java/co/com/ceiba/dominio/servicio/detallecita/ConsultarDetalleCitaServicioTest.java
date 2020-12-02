package co.com.ceiba.dominio.servicio.detallecita;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import co.com.ceiba.infraestructura.mockfactory.DetalleCitaFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ConsultarDetalleCitaServicioTest {

    private RepositorioDetalleCitaMySql repositorioDetalleCita;
    private ConsultarDetalleCitaService spyConsultarDetalleCitaService;

    @Before
    public void before() {
        repositorioDetalleCita = mock(RepositorioDetalleCitaMySql.class);
        spyConsultarDetalleCitaService = spy(new ConsultarDetalleCitaService(repositorioDetalleCita));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void consultarDetalleCitaTest() {
        DetalleCita detalleCita = new DetalleCitaFactory().buildDetalleCita();

        when(repositorioDetalleCita.consultarDetalleCita()).thenReturn(Collections.singletonList(detalleCita));

        List<DetalleCita> detalleCitas = spyConsultarDetalleCitaService.consultarDetalleCita();

        assertEquals(Collections.singletonList(detalleCita), detalleCitas);

        verify(repositorioDetalleCita, times(1)).consultarDetalleCita();
    }
}
