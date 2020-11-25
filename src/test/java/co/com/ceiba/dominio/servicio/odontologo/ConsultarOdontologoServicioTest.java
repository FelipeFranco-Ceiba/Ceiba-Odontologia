package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
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
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class ConsultarOdontologoServicioTest {

    private IRepositorioOdontologo repositorioOdontologo;
    private ConsultarOdontologoServicio spyConsultarOdontologoServicio;

    @Before
    public void before() {
        repositorioOdontologo = mock(IRepositorioOdontologo.class);
        spyConsultarOdontologoServicio = spy(new ConsultarOdontologoServicio(repositorioOdontologo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void consultarOdontologoTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        when(repositorioOdontologo.consultarOdontologo()).thenReturn(Collections.singletonList(odontologo));

        List<Odontologo> odontologos = spyConsultarOdontologoServicio.consultarOdontologo();

        assertEquals(Collections.singletonList(odontologo), odontologos);

        verify(repositorioOdontologo, times(1)).consultarOdontologo();
    }
}
