package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorOdontologo;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
import co.com.ceiba.infraestructura.modelo.entidad.OdontologoEntidad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class OdontologoServiceImplTest {

    private IRepositorioOdontologo repositorioOdontologo;
    private OdontologoServicioImpl spyOdontologoServicio;

    @Before
    public void before() {
        repositorioOdontologo = mock(IRepositorioOdontologo.class);
        spyOdontologoServicio = spy(new OdontologoServicioImpl(repositorioOdontologo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void consultarOdontologoTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        when(repositorioOdontologo.consultarOdontologo()).thenReturn(Collections.singletonList(odontologo));

        List<Odontologo> odontologos = spyOdontologoServicio.consultarOdontologo();

        assertEquals(Collections.singletonList(odontologo), odontologos);

        verify(repositorioOdontologo, times(1)).consultarOdontologo();
    }

    @Test
    public void crearOdontologoTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        when(repositorioOdontologo.consultarOdontologo()).thenReturn(Collections.singletonList(odontologo));

        List<Odontologo> odontologos = spyOdontologoServicio.consultarOdontologo();

        assertEquals(Collections.singletonList(odontologo), odontologos);

        verify(repositorioOdontologo, times(1)).consultarOdontologo();
    }

    @Test
    public void actualizarOdontologoExistenteTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();
        OdontologoEntidad odontologoEntidad = TransformadorOdontologo.mapToOdontologoEntidad(odontologo);

        doReturn(odontologo).when(spyOdontologoServicio).existeOdontologo(anyLong());
        when(repositorioOdontologo.actualizarOdontologo(odontologoEntidad)).thenReturn(odontologo);

        Odontologo odontologoActualizado = spyOdontologoServicio.actualizarOdontologo(odontologo);

        assertEquals(odontologo, odontologoActualizado);

        verify(spyOdontologoServicio, times(1)).existeOdontologo(anyLong());
        verify(repositorioOdontologo, times(1)).actualizarOdontologo(any(OdontologoEntidad.class));
    }

    @Test
    public void actualizarOdontologoNoExistenteTest() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();

        doThrow(new CitaExcepcion(OdontologoServicioImpl.ERROR_NO_EXISTE_ODONTOLOGO)).when(spyOdontologoServicio).existeOdontologo(anyLong());

        try {
            spyOdontologoServicio.actualizarOdontologo(odontologo);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(OdontologoServicioImpl.ERROR_NO_EXISTE_ODONTOLOGO, error.getMessage());
        }
        verify(spyOdontologoServicio, times(1)).existeOdontologo(anyLong());
    }
}
