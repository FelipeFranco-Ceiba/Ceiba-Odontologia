package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CrearOdontologoServicioTest {

    private IRepositorioOdontologo repositorioOdontologo;
    private CrearOdontologoServicio spyCrearOdontologoServicio;

    @Before
    public void before() {
        repositorioOdontologo = mock(IRepositorioOdontologo.class);
        spyCrearOdontologoServicio = spy(new CrearOdontologoServicio(repositorioOdontologo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearOdontologoTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        when(repositorioOdontologo.crearOdontologo(odontologo)).thenReturn(odontologo);

        Odontologo odontologoCreado = spyCrearOdontologoServicio.crearOdontologo(odontologo);

        assertEquals(odontologo, odontologoCreado);

        verify(repositorioOdontologo, times(1)).crearOdontologo(any(Odontologo.class));
    }
}
