package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioCliente;
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
public class ConsultarClienteServicioTest {

    private IRepositorioCliente repositorioCliente;
    private ConsultarClienteServicio spyConsultarClienteServicio;

    @Before
    public void before() {
        repositorioCliente = mock(IRepositorioCliente.class);
        spyConsultarClienteServicio = spy(new ConsultarClienteServicio(repositorioCliente));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void consultarClienteTest() {
        Cliente cliente = new ClienteFactory().buildCliente();

        when(repositorioCliente.consultarCliente()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> clientes = spyConsultarClienteServicio.consultarCliente();

        assertEquals(Collections.singletonList(cliente), clientes);

        verify(repositorioCliente, times(1)).consultarCliente();
    }
}
