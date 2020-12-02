package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.servicio.ILoginServicio;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioLogin;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorLogin;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LoginServicioImpl implements ILoginServicio<Login> {

    private final IRepositorioLogin repositorioLogin;
    public static final String ERROR_EXISTE_USUARIO = "Ya existe un usuario con este mismo usuario, por favor ingresa uno diferente";
    public static final String ERROR_USUARIO_CLAVE_NO_EXISTE = "Usuario o Clave incorrecta";

    @Transactional
    @Override
    public Login crearLogin(Login login) {
        LoginEntidad loginEntidad = TransformadorLogin.mapToToLoginEntidad(login);
        existeUsuarioRegistrado(login.getUsuario());
        return repositorioLogin.crearUsuario(loginEntidad);
    }

    @Override
    public Login login(Login login) {
        return repositorioLogin.buscarLoginPorUsuarioYClave(login.getUsuario(), login.getClave())
                .orElseThrow(() -> new CitaExcepcion(ERROR_USUARIO_CLAVE_NO_EXISTE));
    }

    public void existeUsuarioRegistrado(String usuario) {
        boolean existeUsuarioRegistrado = repositorioLogin.existeUsuarioRegistrado(usuario);
        if (existeUsuarioRegistrado) {
            throw new ExistenciaPersonaExcepcion(ERROR_EXISTE_USUARIO);
        }
    }
}
