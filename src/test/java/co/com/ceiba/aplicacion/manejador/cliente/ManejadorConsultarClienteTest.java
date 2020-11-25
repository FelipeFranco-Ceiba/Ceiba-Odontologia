package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.IClienteServicio;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
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
public class ManejadorConsultarClienteTest {

    private IClienteServicio<Cliente> clienteServicio;
    private ManejadorConsultarCliente spyManejadorConsultarCliente;

    @Before
    public void before() {
        clienteServicio = mock(IClienteServicio.class);
        spyManejadorConsultarCliente = spy(new ManejadorConsultarCliente(clienteServicio));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutarConsultaTest() {
        Cliente cliente = new ClienteFactory().buildCliente();

        when(clienteServicio.consultarCliente()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> listaClientes = spyManejadorConsultarCliente.ejecutar();

        assertEquals(Collections.singletonList(cliente), listaClientes);
        verify(clienteServicio, times(1)).consultarCliente();
    }


}
