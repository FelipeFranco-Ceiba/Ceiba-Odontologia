package co.com.ceiba.aplicacion.manejador.login;

import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.aplicacion.fabrica.FabricarLogin;
import co.com.ceiba.aplicacion.manejador.ManejadorComandoRespuesta;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.servicio.login.CrearUsaurioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<Login, ComandoLogin> {

    private final CrearUsaurioServicio crearUsaurioServicio;

    @Override
    public Login ejecutar(ComandoLogin comando) {
        Login login = FabricarLogin.crearLogin(comando);
        return this.crearUsaurioServicio.crearLogin(login);
    }
}
