package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.aplicacion.fabrica.FabricaOdontologo;
import co.com.ceiba.dominio.excepcion.ValorObligatorioExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.odontologo.CrearOdontologoServicio;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ManejadorCrearOdontologoTest {

    private CrearOdontologoServicio crearOdontologoServicio;
    private ManejadorCrearOdontologo spyManejadorCrearOdontologo;

    @Before
    public void before() {
        crearOdontologoServicio = mock(CrearOdontologoServicio.class);
        spyManejadorCrearOdontologo = spy(new ManejadorCrearOdontologo(crearOdontologoServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarCrearOdontologo() {
        ComandoOdontologo comandoOdontologo = new OdontologoFactory().buildComando();
        Odontologo odontologo = FabricaOdontologo.crearOdontologo(comandoOdontologo);

        when(crearOdontologoServicio.crearOdontologo(odontologo)).thenReturn(odontologo);

        Odontologo odontologoCreado = spyManejadorCrearOdontologo.ejecutar(comandoOdontologo);

        assertEquals(odontologo, odontologoCreado);

        verify(crearOdontologoServicio, times(1)).crearOdontologo(any(Odontologo.class));
    }

    @Test
    public void ejecutarCrearOdontologoError() {
        ComandoOdontologo comandoOdontologo = new OdontologoFactory().buildComando();
        Odontologo odontologo = FabricaOdontologo.crearOdontologo(comandoOdontologo);

        when(crearOdontologoServicio.crearOdontologo(odontologo)).thenThrow(new ValorObligatorioExcepcion("Facke error"));

        try {
            spyManejadorCrearOdontologo.ejecutar(comandoOdontologo);
        } catch (Exception error) {
            assertTrue(error instanceof ValorObligatorioExcepcion);
            assertEquals("Facke error", error.getMessage());
        }

        verify(crearOdontologoServicio, times(1)).crearOdontologo(any(Odontologo.class));
    }
}
