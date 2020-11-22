package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.repositorio.RespositorioLogin;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorLogin;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositorioLogin extends JpaRepository<LoginEntidad, Long>, RespositorioLogin {

    @Override
    default Login crearDetalleCita(LoginEntidad loginEntidad) {
        return TransformadorLogin.mapToLoginModelo(save(loginEntidad));
    }

    @Override
    default Optional<Login> buscarLoginPorUsuarioYClave(String usuario, String clave) {
        return TransformadorLogin.matToOptionalLoginModelo(findByUsuarioAndClave(usuario, clave));
    }

    Optional<LoginEntidad> findByUsuarioAndClave(String usuario, String clave);

}
