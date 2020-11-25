package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.fabrica.FabricaCliente;
import co.com.ceiba.dominio.excepcion.ValorObligatorioExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.IClienteServicio;
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

    private IClienteServicio<Cliente> clienteServicio;
    private ManejadorCrearCliente spyManejadorCrearCliente;

    @Before
    public void before() {
        clienteServicio = mock(IClienteServicio.class);
        spyManejadorCrearCliente = spy(new ManejadorCrearCliente(clienteServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarCrearCliente() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(clienteServicio.crearOActualizarCliente(cliente)).thenReturn(cliente);

        Cliente clienteCreado = spyManejadorCrearCliente.ejecutar(comandoCliente);

        assertEquals(cliente, clienteCreado);

        verify(clienteServicio, times(1)).crearOActualizarCliente(any(Cliente.class));
    }

    @Test
    public void ejecutarCrearOdontologoError() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(clienteServicio.crearOActualizarCliente(cliente)).thenThrow(new ValorObligatorioExcepcion(ClienteEntidad.SE_DEBE_INGRESAR_LOS_APELLIDOS));

        try {
            spyManejadorCrearCliente.ejecutar(comandoCliente);
        } catch (Exception error) {
            assertTrue(error instanceof ValorObligatorioExcepcion);
            assertEquals(ClienteEntidad.SE_DEBE_INGRESAR_LOS_APELLIDOS, error.getMessage());
        }

        verify(clienteServicio, times(1)).crearOActualizarCliente(any(Cliente.class));
    }
}
