package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;

import java.util.Optional;

public interface RespositorioLogin {

    Login crearDetalleCita(LoginEntidad loginEntidad);

    Optional<Login> buscarLoginPorUsuarioYClave(String usuario, String clave);
}
