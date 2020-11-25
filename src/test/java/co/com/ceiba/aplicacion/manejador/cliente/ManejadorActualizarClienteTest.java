package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.fabrica.FabricaCliente;
import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.IClienteServicio;
import co.com.ceiba.dominio.servicio.impl.ClienteServicioImpl;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ManejadorActualizarClienteTest {

    private IClienteServicio<Cliente> clienteServicio;
    private ManejadorActualizarCliente spyManejadorActualizarCliente;

    @Before
    public void before() {
        clienteServicio = mock(IClienteServicio.class);
        spyManejadorActualizarCliente = spy(new ManejadorActualizarCliente((clienteServicio)));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarActualizarcliente() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(clienteServicio.actualizarCliente(cliente)).thenReturn(cliente);

        Cliente clienteActualizado = spyManejadorActualizarCliente.ejecutar(comandoCliente);

        assertEquals(cliente, clienteActualizado);

        verify(clienteServicio, times(1)).actualizarCliente(any(Cliente.class));
    }

    @Test
    public void ejecutarActualizarClienteNoExiste() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(clienteServicio.actualizarCliente(cliente)).thenThrow(new ExistenciaPersonaExcepcion(ClienteServicioImpl.ERROR_NO_EXISTE_CLIENTE));

        try {
            spyManejadorActualizarCliente.ejecutar(comandoCliente);
        } catch (Exception error) {

            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(ClienteServicioImpl.ERROR_NO_EXISTE_CLIENTE, error.getMessage());
        }

        verify(clienteServicio, times(1)).actualizarCliente(any(Cliente.class));
    }
}
