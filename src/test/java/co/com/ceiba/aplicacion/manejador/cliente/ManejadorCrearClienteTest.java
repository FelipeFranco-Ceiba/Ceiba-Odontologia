package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.fabrica.FabricaCliente;
import co.com.ceiba.dominio.excepcion.ValorObligatorioExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.cliente.CrearClienteServicio;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
import co.com.ceiba.infraestructura.modelo.entidad.ClienteEntidad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ManejadorCrearClienteTest {

    private CrearClienteServicio crearClienteServicio;
    private ManejadorCrearCliente spyManejadorCrearCliente;

    @Before
    public void before() {
        crearClienteServicio = mock(CrearClienteServicio.class);
        spyManejadorCrearCliente = spy(new ManejadorCrearCliente(crearClienteServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarCrearCliente() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(crearClienteServicio.crearCliente(cliente)).thenReturn(cliente);

        Cliente clienteCreado = spyManejadorCrearCliente.ejecutar(comandoCliente);

        assertEquals(cliente, clienteCreado);

        verify(crearClienteServicio, times(1)).crearCliente(any(Cliente.class));
    }

    @Test
    public void ejecutarCrearOdontologoError() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(crearClienteServicio.crearCliente(cliente)).thenThrow(new ValorObligatorioExcepcion(ClienteEntidad.SE_DEBE_INGRESAR_LOS_APELLIDOS));

        try {
            spyManejadorCrearCliente.ejecutar(comandoCliente);
        } catch (Exception error) {
            assertTrue(error instanceof ValorObligatorioExcepcion);
            assertEquals(ClienteEntidad.SE_DEBE_INGRESAR_LOS_APELLIDOS, error.getMessage());
        }

        verify(crearClienteServicio, times(1)).crearCliente(any(Cliente.class));
    }
}
