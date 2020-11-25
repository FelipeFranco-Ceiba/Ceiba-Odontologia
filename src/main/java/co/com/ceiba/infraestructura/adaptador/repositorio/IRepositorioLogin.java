package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.repositorio.RespositorioLogin;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorLogin;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositorioLogin extends JpaRepository<LoginEntidad, Long>, RespositorioLogin {

    @Override
    default Login crearUsuario(LoginEntidad loginEntidad) {
        Login login = TransformadorLogin.mapToLoginModelo(saveAndFlush(loginEntidad));
        return login;
    }

    @Override
    default Optional<Login> buscarLoginPorUsuarioYClave(String usuario, String clave) {
        return TransformadorLogin.matToOptionalLoginModelo(findByUsuarioAndClave(usuario, clave));
    }

    @Override
    default Boolean existeUsuarioRegistrado(String usuario) {
        return existsByUsuario(usuario);
    }

    Boolean existsByUsuario (String usuario);

    Optional<LoginEntidad> findByUsuarioAndClave(String usuario, String clave);

}
