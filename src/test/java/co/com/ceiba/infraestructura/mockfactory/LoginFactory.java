package co.com.ceiba.infraestructura.mockfactory;

import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.dominio.modelo.entidad.Login;

public class LoginFactory {

    private static final Long ID_LOGIN = 2L;
    private static final String USUARIO = "Cliente Prueba";
    private static final String CLAVE = "Prueba";

    public ComandoLogin buildComando(Long idLogin, String usuario, String clave) {
        return new ComandoLogin(idLogin, usuario, clave);
    }

    public ComandoLogin buildComando() {
        return new ComandoLogin(ID_LOGIN, USUARIO, CLAVE);
    }

    public Login buildLogin() {
        return Login.builder()
                .conIdLogin(ID_LOGIN)
                .conUsuario(USUARIO)
                .conClave(CLAVE)
                .build();
    }
}
