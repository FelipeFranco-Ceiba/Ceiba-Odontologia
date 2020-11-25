package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.fabrica.FabricaCliente;
import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.cliente.ActualizarClienteService;
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

    private ActualizarClienteService actualizarClienteService;
    private ManejadorActualizarCliente spyManejadorActualizarCliente;

    @Before
    public void before() {
        actualizarClienteService = mock(ActualizarClienteService.class);
        spyManejadorActualizarCliente = spy(new ManejadorActualizarCliente((actualizarClienteService)));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarActualizarcliente() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(actualizarClienteService.actualizarCliente(cliente)).thenReturn(cliente);

        Cliente clienteActualizado = spyManejadorActualizarCliente.ejecutar(comandoCliente);

        assertEquals(cliente, clienteActualizado);

        verify(actualizarClienteService, times(1)).actualizarCliente(any(Cliente.class));
    }

    @Test
    public void ejecutarActualizarClienteNoExiste() {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        when(actualizarClienteService.actualizarCliente(cliente)).thenThrow(new ExistenciaPersonaExcepcion(ActualizarClienteService.ERROR_NO_EXISTE_CLIENTE));

        try {
            spyManejadorActualizarCliente.ejecutar(comandoCliente);
        } catch (Exception error) {

            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(ActualizarClienteService.ERROR_NO_EXISTE_CLIENTE, error.getMessage());
        }

        verify(actualizarClienteService, times(1)).actualizarCliente(any(Cliente.class));
    }
}
