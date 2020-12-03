package co.com.ceiba.dominio.servicio.login;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioLogin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUsuarioServicio {

    private final IRepositorioLogin repositorioLogin;
    public static final String ERROR_USUARIO_CLAVE_NO_EXISTE = "Usuario o Clave incorrecta";

    public Login login(Login login) {
        return repositorioLogin.buscarLoginPorUsuarioYClave(login.getUsuario(), login.getClave())
                .orElseThrow(() -> new CitaExcepcion(ERROR_USUARIO_CLAVE_NO_EXISTE));
    }
}
