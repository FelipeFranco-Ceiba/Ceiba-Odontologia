package co.com.ceiba.infraestructura.adaptador.transformador;

import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;

import java.util.ArrayList;
import java.util.Optional;

public final class TransformadorLogin {

    public static Login mapToLoginModelo(LoginEntidad loginEntidad) {
        return Login.builder()
                .conIdLogin(loginEntidad.getIdLogin())
                .conUsuario(loginEntidad.getUsuario())
                .conClave(loginEntidad.getClave())
                .build();
    }

    public static LoginEntidad mapToToLoginEntidad(Login login) {
        return LoginEntidad.builder()
                .idLogin(login.getIdLogin())
                .usuario(login.getUsuario())
                .clave(login.getClave())
                .lstDetalleCita(new ArrayList<>())
                .build();
    }

    public static Optional<Login> matToOptionalLoginModelo(Optional<LoginEntidad> loginEntidad) {
        return loginEntidad.map(login -> Login.builder()
                .conIdLogin(login.getIdLogin())
                .conUsuario(login.getUsuario())
                .conClave(login.getClave())
                .build());
    }
}
