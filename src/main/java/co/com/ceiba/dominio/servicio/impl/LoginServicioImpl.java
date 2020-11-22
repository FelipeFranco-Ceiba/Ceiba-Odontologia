package co.com.ceiba.dominio.servicio.impl;

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

    @Override
    public Login crearLogin(Login login) {
        LoginEntidad loginEntidad = TransformadorLogin.mapToToLoginEntidad(login);
        return repositorioLogin.crearDetalleCita(loginEntidad);
    }
}
