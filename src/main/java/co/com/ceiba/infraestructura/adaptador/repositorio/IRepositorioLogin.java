package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.repositorio.RespositorioLogin;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorLogin;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioLogin extends JpaRepository<LoginEntidad, LoginEntidad>, RespositorioLogin {

    @Override
    default Login crearDetalleCita(LoginEntidad loginEntidad) {
        return TransformadorLogin.mapToLoginModelo(save(loginEntidad));
    }

    @Override
    default Login consultarPorIdLogin(Long idLogin) {
        return null;
    }
}
