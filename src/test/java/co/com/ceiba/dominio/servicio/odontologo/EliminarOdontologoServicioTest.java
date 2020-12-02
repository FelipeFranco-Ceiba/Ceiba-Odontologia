package co.com.ceiba.dominio.servicio.odontologo;


import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioOdontologoMySql;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EliminarOdontologoServicioTest {

    private RepositorioOdontologoMySql repositorioOdontologo;
    private EliminarOdontologoServicio spyEliminarOdontologoServicio;

    @Before
    public void before() {
        repositorioOdontologo = mock(RepositorioOdontologoMySql.class);
        spyEliminarOdontologoServicio = spy(new EliminarOdontologoServicio(repositorioOdontologo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noExisteOdontologo() {
        Long idOdontologo = 1L;

        when(repositorioOdontologo.consultarOdontologoPorId(idOdontologo)).thenReturn(null);

        try {
            spyEliminarOdontologoServicio.existeOdontologo(idOdontologo);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(EliminarOdontologoServicio.ERROR_NO_EXISTE_ODONTOLOGO, error.getMessage());
        }
    }
}
