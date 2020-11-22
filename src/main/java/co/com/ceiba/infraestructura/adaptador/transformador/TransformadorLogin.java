package co.com.ceiba.infraestructura.adaptador.transformador;

import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;

import java.util.ArrayList;

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
}
