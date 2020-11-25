package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioCliente;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CrearClienteServicioTest {

    private IRepositorioCliente repositorioCliente;
    private CrearClienteServicio spyCrearClienteServicio;

    @Before
    public void before() {
        repositorioCliente = mock(IRepositorioCliente.class);
        spyCrearClienteServicio = spy(new CrearClienteServicio(repositorioCliente));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearOdontologoTest() {
        Cliente cliente = new ClienteFactory().buildCliente();

        when(repositorioCliente.crearCliente(cliente)).thenReturn(cliente);

        Cliente clienteCreado = spyCrearClienteServicio.crearCliente(cliente);

        assertEquals(cliente, clienteCreado);

        verify(repositorioCliente, times(1)).crearCliente(any(Cliente.class));
    }
}
