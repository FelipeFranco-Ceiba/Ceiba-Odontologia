package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.aplicacion.comando.ManejadorTransaccionDetalleCita;
import co.com.ceiba.aplicacion.consulta.ManejadorListaDetalleCita;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping(value = "detalleCita")
public class ControladorDetalleCita {

    private final ManejadorListaDetalleCita manejadorListaDetalleCita;
    private final ManejadorTransaccionDetalleCita manejadorTransaccionDetalleCita;

    @GetMapping
    public ResponseEntity<List<DetalleCita>> consultarDetalleCita() {
        return ResponseEntity.ok(this.manejadorListaDetalleCita.ejecutar());
    }
    @PostMapping
    public ResponseEntity<DetalleCita> crear(@RequestBody ComandoDetalleCita comandoDetalleCita) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorTransaccionDetalleCita.ejecutarCreacion(comandoDetalleCita));
    }

    @PutMapping
    public ResponseEntity<DetalleCita> actualizar(@RequestBody ComandoDetalleCita comandoDetalleCita) {
        return ResponseEntity.ok(this.manejadorTransaccionDetalleCita.ejecutarActualizacion(comandoDetalleCita));
    }

    @DeleteMapping(value = "/{idDetalleCita}")
    public void eliminar(@PathVariable("idDetalleCita") Long idDetalleCita) {
        this.manejadorTransaccionDetalleCita.ejecutarEliminar(idDetalleCita);
    }
}
