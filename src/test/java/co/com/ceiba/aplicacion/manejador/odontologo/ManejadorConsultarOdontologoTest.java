package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.odontologo.ConsultarOdontologoServicio;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
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
public class ManejadorConsultarOdontologoTest {

    private ConsultarOdontologoServicio consultarOdontologoServicio;
    private ManejadorConsultarOdontologo spyManejadorConsultaOdontologo;

    @Before
    public void before() {
        consultarOdontologoServicio = mock(ConsultarOdontologoServicio.class);
        spyManejadorConsultaOdontologo = spy(new ManejadorConsultarOdontologo(consultarOdontologoServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarConsultaTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        when(consultarOdontologoServicio.consultarOdontologo()).thenReturn(Collections.singletonList(odontologo));

        List<Odontologo> listaOdontologos = spyManejadorConsultaOdontologo.ejecutar();

        assertEquals(Collections.singletonList(odontologo), listaOdontologos);
        verify(consultarOdontologoServicio, times(1)).consultarOdontologo();
    }

}
