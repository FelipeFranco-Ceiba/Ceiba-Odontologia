package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.aplicacion.comando.ManejadorTransaccionLogin;
import co.com.ceiba.dominio.modelo.entidad.Login;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "login")
@AllArgsConstructor
public class ControladorAuth {

    private final ManejadorTransaccionLogin manejadorTransaccionLogin;

    @PostMapping
    public ResponseEntity<?> crearLogin(@RequestBody ComandoLogin comandoLogin) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorTransaccionLogin.ejecutarCreacion(comandoLogin));
    }


    @PostMapping(value = "inicio")
    public ResponseEntity<Login> login(@RequestBody ComandoLogin comandoLogin) {
        return ResponseEntity.ok(this.manejadorTransaccionLogin.ejecutarLogin(comandoLogin));
    }
}