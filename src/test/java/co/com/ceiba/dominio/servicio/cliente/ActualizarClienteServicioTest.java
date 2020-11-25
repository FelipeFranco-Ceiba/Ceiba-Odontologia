package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioCliente;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ActualizarClienteServicioTest {

    private IRepositorioCliente repositorioCliente;
    private ActualizarClienteService spyActualizarClienteService;

    @Before
    public void before() {
        repositorioCliente = mock(IRepositorioCliente.class);
        spyActualizarClienteService = spy(new ActualizarClienteService(repositorioCliente));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void actualizarClienteExistenteTest() {
        Cliente cliente = new ClienteFactory().buildCliente();

        doNothing().when(spyActualizarClienteService).existeCliente(anyLong());
        when(repositorioCliente.actualizarCliente(cliente)).thenReturn(cliente);

        Cliente clienteActualizado = spyActualizarClienteService.actualizarCliente(cliente);

        assertEquals(cliente, clienteActualizado);

        verify(spyActualizarClienteService, times(1)).existeCliente(anyLong());
        verify(repositorioCliente, times(1)).actualizarCliente(any(Cliente.class));
    }

    @Test
    public void actualizarClienteNoExistenteTest() {
        Cliente cliente = new ClienteFactory().buildCliente();

        doThrow(new ExistenciaPersonaExcepcion(ActualizarClienteService.ERROR_NO_EXISTE_CLIENTE)).when(spyActualizarClienteService).existeCliente(anyLong());

        try {
            spyActualizarClienteService.actualizarCliente(cliente);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(ActualizarClienteService.ERROR_NO_EXISTE_CLIENTE, error.getMessage());
        }
    }

    @Test
    public void noExisteCliente() {
        Odontologo odontologo = new OdontologoFactory().buildOdontologo();
        Long idOdontologo = 1L;

        when(repositorioCliente.existeCliente(idOdontologo)).thenReturn(false);

        try {
            spyActualizarClienteService.existeCliente(idOdontologo);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(EliminarClienteServicio.ERROR_NO_EXISTE_CLIENTE, error.getMessage());
        }

        verify(repositorioCliente, times(1)).existeCliente(anyLong());
    }

}

