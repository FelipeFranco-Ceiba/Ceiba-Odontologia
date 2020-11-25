package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.IOdontologoServicio;
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

    private IOdontologoServicio odontologoServicio;
    private ManejadorConsultarOdontologo spyManejadorConsultaOdontologo;

    @Before
    public void before() {
        odontologoServicio = mock(IOdontologoServicio.class);
        spyManejadorConsultaOdontologo = spy(new ManejadorConsultarOdontologo(odontologoServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarConsultaTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        when(odontologoServicio.consultarOdontologo()).thenReturn(Collections.singletonList(odontologo));

        List<Odontologo> listaOdontologos = spyManejadorConsultaOdontologo.ejecutar();

        assertEquals(Collections.singletonList(odontologo), listaOdontologos);
        verify(odontologoServicio, times(1)).consultarOdontologo();
    }

}
