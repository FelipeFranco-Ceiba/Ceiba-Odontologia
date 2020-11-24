package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioLogin;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorLogin;
import co.com.ceiba.infraestructura.mockfactory.LoginFactory;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginServicioImplTest {

    private IRepositorioLogin repositorioLogin;
    private LoginServicioImpl spyLoginServicio;

    @Before
    public void before() {
        repositorioLogin = mock(IRepositorioLogin.class);
        spyLoginServicio = spy(new LoginServicioImpl(repositorioLogin));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void crearLoginExito() {
        Login loginBuilder = new LoginFactory().buildLogin();
        LoginEntidad loginEntidad = TransformadorLogin.mapToToLoginEntidad(loginBuilder);

        when(repositorioLogin.existeUsuarioRegistrado(loginEntidad.getUsuario())).thenReturn(false);
        when(repositorioLogin.crearDetalleCita(loginEntidad)).thenReturn(loginBuilder);

        Login login = spyLoginServicio.crearLogin(loginBuilder);

        assertEquals(loginBuilder.getIdLogin(), login.getIdLogin());

        verify(repositorioLogin, times(1)).existeUsuarioRegistrado(anyString());
        verify(repositorioLogin, times(1)).crearDetalleCita(any(LoginEntidad.class));
    }

    @Test
    public void crearLoginCuandoExisteElMismoUsuario() {
        Login loginBuilder = new LoginFactory().buildLogin();
        LoginEntidad loginEntidad = TransformadorLogin.mapToToLoginEntidad(loginBuilder);

        when(repositorioLogin.existeUsuarioRegistrado(loginEntidad.getUsuario())).thenReturn(true);

        try {
            spyLoginServicio.crearLogin(loginBuilder);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(LoginServicioImpl.ERROR_EXISTE_USUARIO, error.getMessage());
        }

        verify(repositorioLogin, times(1)).existeUsuarioRegistrado(anyString());
        verify(repositorioLogin, times(0)).crearDetalleCita(any(LoginEntidad.class));
    }

    @Test
    public void iniciarSesion() {
        Login loginBuilder = new LoginFactory().buildLogin();

        when(repositorioLogin.buscarLoginPorUsuarioYClave(loginBuilder.getUsuario(), loginBuilder.getClave())).thenReturn(Optional.of(loginBuilder));

        Login login = spyLoginServicio.login(loginBuilder);

        assertEquals(loginBuilder.getUsuario(), login.getUsuario());
        verify(repositorioLogin, times(1)).buscarLoginPorUsuarioYClave(anyString(), anyString());
    }

    @Test
    public void iniciarSesionCuandoNoExisteElUsuario() {
        Login loginBuilder = new LoginFactory().buildLogin();

        when(repositorioLogin.buscarLoginPorUsuarioYClave(loginBuilder.getUsuario(), loginBuilder.getClave())).thenReturn(Optional.empty());

        try {
            spyLoginServicio.login(loginBuilder);
        } catch (Exception error) {
            assertTrue(error instanceof CitaExcepcion);
            assertEquals(LoginServicioImpl.ERROR_USUARIO_CLAVE_NO_EXISTE, error.getMessage());
        }

        verify(repositorioLogin, times(1)).buscarLoginPorUsuarioYClave(anyString(), anyString());
    }
}
