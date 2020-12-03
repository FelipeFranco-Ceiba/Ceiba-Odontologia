package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.aplicacion.manejador.detallecita.ManejadorActualizarDetalleCita;
import co.com.ceiba.aplicacion.manejador.detallecita.ManejadorConsultarDetalleCita;
import co.com.ceiba.aplicacion.manejador.detallecita.ManejadorCrearDetalleCita;
import co.com.ceiba.aplicacion.manejador.detallecita.ManejadorEliminarDetalleCita;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4201", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping(value = "detalleCita")
public class ControladorDetalleCita {

    private final ManejadorConsultarDetalleCita manejadorConsultarDetalleCita;
    private final ManejadorCrearDetalleCita manejadorCrearDetalleCita;
    private final ManejadorActualizarDetalleCita manejadorActualizarDetalleCita;
    private final ManejadorEliminarDetalleCita manejadorEliminarDetalleCita;

    @GetMapping
    public ResponseEntity<List<DetalleCita>> consultarDetalleCita() {
        return ResponseEntity.ok(this.manejadorConsultarDetalleCita.ejecutar());
    }
    @PostMapping
    public ResponseEntity<DetalleCita> crear(@RequestBody ComandoDetalleCita comandoDetalleCita) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorCrearDetalleCita.ejecutar(comandoDetalleCita));
    }

    @PutMapping
    public ResponseEntity<DetalleCita> actualizar(@RequestBody ComandoDetalleCita comandoDetalleCita) {
        return ResponseEntity.ok(this.manejadorActualizarDetalleCita.ejecutar(comandoDetalleCita));
    }

    @DeleteMapping(value = "/{idDetalleCita}")
    public void eliminar(@PathVariable("idDetalleCita") Long idDetalleCita) {
        this.manejadorEliminarDetalleCita.ejecutar(idDetalleCita);
    }
}
