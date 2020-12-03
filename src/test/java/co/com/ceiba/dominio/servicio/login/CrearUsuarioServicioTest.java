package co.com.ceiba.dominio.servicio.login;

import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioLogin;
import co.com.ceiba.infraestructura.mockfactory.LoginFactory;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CrearUsuarioServicioTest {

    private IRepositorioLogin repositorioLogin;
    private CrearUsaurioServicio spyLoginServicio;

    @Before
    public void before() {
        repositorioLogin = mock(IRepositorioLogin.class);
        spyLoginServicio = spy(new CrearUsaurioServicio(repositorioLogin));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearLoginCuandoExisteElMismoUsuario() {
        Login loginBuilder = new LoginFactory().buildLogin();

        doThrow(new ExistenciaPersonaExcepcion(CrearUsaurioServicio.ERROR_EXISTE_USUARIO)).when(spyLoginServicio).existeUsuarioRegistrado(loginBuilder.getUsuario());

        try {
            spyLoginServicio.crearLogin(loginBuilder);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(CrearUsaurioServicio.ERROR_EXISTE_USUARIO, error.getMessage());
        }

        verify(spyLoginServicio, times(1)).existeUsuarioRegistrado(anyString());
        verify(repositorioLogin, times(0)).crearUsuario(any(LoginEntidad.class));
    }

    @Test
    public void exiteUsuarioRegistrado() {
        String usuario = "Felipe";

        when(repositorioLogin.existeUsuarioRegistrado(usuario)).thenReturn(true);

        try {
            spyLoginServicio.existeUsuarioRegistrado(usuario);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(CrearUsaurioServicio.ERROR_EXISTE_USUARIO, error.getMessage());
        }
    }
}
