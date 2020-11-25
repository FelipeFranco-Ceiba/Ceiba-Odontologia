package co.com.ceiba.aplicacion.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.dominio.modelo.entidad.Login;

public final class FabricarLogin {

    private FabricarLogin() { }

    public static Login crearLogin(ComandoLogin comandoLogin) {
        return Login.builder()
                .conIdLogin(comandoLogin.getIdLogin())
                .conUsuario(comandoLogin.getUsuario())
                .conClave(comandoLogin.getClave())
                .build();
    }
}
