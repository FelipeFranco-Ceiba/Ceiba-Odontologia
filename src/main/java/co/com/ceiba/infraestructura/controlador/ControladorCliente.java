package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.comando.ManejadorTransaccionCliente;
import co.com.ceiba.aplicacion.consulta.ManejadorListaCliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "cliente")
public class ControladorCliente {

    private final ManejadorListaCliente manejadorListaCliente;
    private final ManejadorTransaccionCliente manejadorTransaccionCliente;

    @GetMapping
    public ResponseEntity<?> consultarCliente() {
        return ResponseEntity.ok(manejadorListaCliente.ejecutar());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ComandoCliente comandoCliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorTransaccionCliente.ejecutarCreacion(comandoCliente));
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody ComandoCliente comandoCliente) {
        return ResponseEntity.ok(this.manejadorTransaccionCliente.ejecutarActualizacion(comandoCliente));
    }

    @DeleteMapping(value = "/{idCliente}")
    public void eliminar(@PathVariable("idCliente") Long idCliente) {
        this.manejadorTransaccionCliente.ejecutarEliminar(idCliente);
    }
}
