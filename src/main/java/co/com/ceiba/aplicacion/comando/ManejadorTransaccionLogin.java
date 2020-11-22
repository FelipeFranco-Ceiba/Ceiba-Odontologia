package co.com.ceiba.aplicacion.comando;

import co.com.ceiba.aplicacion.fabrica.FabricarLogin;
import co.com.ceiba.dominio.modelo.entidad.Login;
import co.com.ceiba.dominio.servicio.ILoginServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorTransaccionLogin {

    private final ILoginServicio<Login> loginServicio;

    public Login ejecutarCreacion(ComandoLogin comandoLogin) {
        Login login = FabricarLogin.crearLogin(comandoLogin);
        return this.loginServicio.crearLogin(login);
    }

    public Login ejecutarLogin(ComandoLogin comandoLogin) {
        Login login = FabricarLogin.crearLogin(comandoLogin);
        return this.loginServicio.login(login);
    }
}
