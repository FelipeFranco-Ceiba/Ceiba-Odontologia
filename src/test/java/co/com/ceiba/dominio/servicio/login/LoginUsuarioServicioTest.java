package co.com.ceiba.dominio.servicio.login;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioLogin;
import co.com.ceiba.infraestructura.mockfactory.LoginFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class LoginUsuarioServicioTest {

    private IRepositorioLogin repositorioLogin;
    private LoginUsuarioServicio spyLoginUsuarioServicio;

    @Before
    public void before() {
        repositorioLogin = mock(IRepositorioLogin.class);
        spyLoginUsuarioServicio = spy(new LoginUsuarioServicio(repositorioLogin));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void iniciarSesion() {
        Login loginBuilder = new LoginFactory().buildLogin();

        when(repositorioLogin.buscarLoginPorUsuarioYClave(loginBuilder.getUsuario(), loginBuilder.getClave())).thenReturn(Optional.of(loginBuilder));

        Login login = spyLoginUsuarioServicio.login(loginBuilder);

        assertEquals(loginBuilder.getUsuario(), login.getUsuario());
        verify(repositorioLogin, times(1)).buscarLoginPorUsuarioYClave(anyString(), anyString());
    }

    @Test
    public void iniciarSesionCuandoNoExisteElUsuario() {
        Login loginBuilder = new LoginFactory().buildLogin();

        when(repositorioLogin.buscarLoginPorUsuarioYClave(loginBuilder.getUsuario(), loginBuilder.getClave())).thenReturn(Optional.empty());

        try {
            spyLoginUsuarioServicio.login(loginBuilder);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(LoginUsuarioServicio.ERROR_USUARIO_CLAVE_NO_EXISTE, error.getMessage());
        }

        verify(repositorioLogin, times(1)).buscarLoginPorUsuarioYClave(anyString(), anyString());
    }
}
