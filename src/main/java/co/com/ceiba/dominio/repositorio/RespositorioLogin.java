package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;

public interface RespositorioLogin {

    Login crearDetalleCita(LoginEntidad loginEntidad);
    Login consultarPorIdLogin(Long idLogin);
}
