package co.com.ceiba.dominio.servicio.login;

import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioLogin;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorLogin;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearUsaurioServicio {

    private final IRepositorioLogin repositorioLogin;
    public static final String ERROR_EXISTE_USUARIO = "Ya existe un usuario con este mismo usuario, por favor ingresa uno diferente";

    public Login crearLogin(Login login) {
        LoginEntidad loginEntidad = TransformadorLogin.mapToToLoginEntidad(login);
        existeUsuarioRegistrado(login.getUsuario());
        return repositorioLogin.crearUsuario(loginEntidad);
    }

    public void existeUsuarioRegistrado(String usuario) {
        boolean existeUsuarioRegistrado = repositorioLogin.existeUsuarioRegistrado(usuario);
        if (existeUsuarioRegistrado) {
            throw new ExistenciaPersonaExcepcion(ERROR_EXISTE_USUARIO);
        }
    }
}
