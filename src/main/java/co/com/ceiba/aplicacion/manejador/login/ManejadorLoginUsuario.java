package co.com.ceiba.aplicacion.manejador.login;

import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.aplicacion.fabrica.FabricarLogin;
import co.com.ceiba.aplicacion.manejador.ManejadorComandoRespuesta;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.servicio.login.LoginUsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorLoginUsuario implements ManejadorComandoRespuesta<Login, ComandoLogin> {

    private final LoginUsuarioServicio loginUsuarioServicio;

    @Override
    public Login ejecutar(ComandoLogin comando) {
        Login login = FabricarLogin.crearLogin(comando);
        return this.loginUsuarioServicio.login(login);
    }
}
