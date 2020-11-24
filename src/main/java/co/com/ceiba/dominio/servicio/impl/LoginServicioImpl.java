package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.servicio.ILoginServicio;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioLogin;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorLogin;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServicioImpl implements ILoginServicio<Login> {

    private final IRepositorioLogin repositorioLogin;
    public static final String ERROR_EXISTE_USUARIO = "Ya existe un usuario con este mismo usuario, por favor ingresa uno diferente";
    public static final String ERROR_USUARIO_CLAVE_NO_EXISTE = "Usuario o Clave incorrecta";

    @Override
    public Login crearLogin(Login login) {
        LoginEntidad loginEntidad = TransformadorLogin.mapToToLoginEntidad(login);
        Boolean existeUsuarioRegistrado = repositorioLogin.existeUsuarioRegistrado(loginEntidad.getUsuario());
        if (existeUsuarioRegistrado) {
            throw new CitaExcepcion(ERROR_EXISTE_USUARIO);
        }
        return repositorioLogin.crearDetalleCita(loginEntidad);
    }

    @Override
    public Login login(Login login) {
        return repositorioLogin.buscarLoginPorUsuarioYClave(login.getUsuario(), login.getClave())
                .orElseThrow(() -> new CitaExcepcion(ERROR_USUARIO_CLAVE_NO_EXISTE));
    }
}
