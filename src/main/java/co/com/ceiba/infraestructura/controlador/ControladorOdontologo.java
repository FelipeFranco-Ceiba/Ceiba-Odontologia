package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.aplicacion.consulta.ManejadorListaOdontologo;
import co.com.ceiba.aplicacion.comando.ManejadorTransaccionOdontologo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping(value = "/odontologo")
public class ControladorOdontologo {

    private final ManejadorListaOdontologo manejadorListaOdontologo;
    private final ManejadorTransaccionOdontologo manejadorTransaccionOdontologo;

    @GetMapping
    public ResponseEntity<?> consultaOdontolos() {
        return ResponseEntity.ok(manejadorListaOdontologo.ejecutar());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ComandoOdontologo comandoOdontologo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorTransaccionOdontologo.ejecutarCreacion(comandoOdontologo));
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody ComandoOdontologo comandoOdontologo) {
        return ResponseEntity.ok(this.manejadorTransaccionOdontologo.ejecutarActualizacion(comandoOdontologo));
    }

    @DeleteMapping(value = "/{idOdontologo}")
    public void eliminar(@PathVariable("idOdontologo") Long idOdontologo) {
        this.manejadorTransaccionOdontologo.ejecutarEliminar(idOdontologo);
    }
}
