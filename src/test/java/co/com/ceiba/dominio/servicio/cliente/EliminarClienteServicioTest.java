package co.com.ceiba.dominio.servicio.cliente;


import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioCliente;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class EliminarClienteServicioTest {

    private IRepositorioCliente repositorioCliente;
    private EliminarClienteServicio spyEliminarClienteServicio;

    @Before
    public void before() {
        repositorioCliente = mock(IRepositorioCliente.class);
        spyEliminarClienteServicio = spy(new EliminarClienteServicio(repositorioCliente));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noExisteCliente() {
        Long idCliente = 1L;

        when(repositorioCliente.existsByIdCliente(idCliente)).thenReturn(false);

        try {
            spyEliminarClienteServicio.existeCliente(idCliente);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(EliminarClienteServicio.ERROR_NO_EXISTE_CLIENTE, error.getMessage());
        }
        verify(repositorioCliente, times(1)).existsByIdCliente(anyLong());
    }

}
