package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.aplicacion.manejador.login.ManejadorCrearUsuario;
import co.com.ceiba.aplicacion.manejador.login.ManejadorLoginUsuario;
import co.com.ceiba.dominio.modelo.entidad.Login;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping(value = "login")
@AllArgsConstructor
public class ControladorAuth {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorLoginUsuario manejadorLoginUsuario;

    @PostMapping
    public ResponseEntity<Login> crearLogin(@RequestBody ComandoLogin comandoLogin) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorCrearUsuario.ejecutar(comandoLogin));
    }


    @PostMapping(value = "inicio")
    public ResponseEntity<Login> login(@RequestBody ComandoLogin comandoLogin) {
        return ResponseEntity.ok(this.manejadorLoginUsuario.ejecutar(comandoLogin));
    }
}
