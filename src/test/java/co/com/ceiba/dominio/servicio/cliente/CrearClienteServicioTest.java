package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioClienteMySql;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CrearClienteServicioTest {

    private RepositorioClienteMySql repositorioCliente;
    private CrearClienteServicio spyCrearClienteServicio;

    @Before
    public void before() {
        repositorioCliente = mock(RepositorioClienteMySql.class);
        spyCrearClienteServicio = spy(new CrearClienteServicio(repositorioCliente));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearOdontologoTest() {
        Cliente cliente = new ClienteFactory().buildCliente();

        when(repositorioCliente.crearCliente(cliente)).thenReturn(cliente);

        Cliente clienteCreado = spyCrearClienteServicio.crearCliente(cliente);

        assertEquals(cliente, clienteCreado);
        assertEquals(cliente.hashCode(), clienteCreado.hashCode());
        verify(repositorioCliente, times(1)).crearCliente(any(Cliente.class));
    }
}
