package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.aplicacion.comando.ManejadorTransaccionDetalleCita;
import co.com.ceiba.aplicacion.consulta.ManejadorListaDetalleCita;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping(value = "detalleCita")
public class ControladorDetalleCita {

    private final ManejadorListaDetalleCita manejadorListaDetalleCita;
    private final ManejadorTransaccionDetalleCita manejadorTransaccionDetalleCita;

    @GetMapping
    public ResponseEntity<?> consultarDetalleCita() {
        return ResponseEntity.ok(this.manejadorListaDetalleCita.ejecutar());
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ComandoDetalleCita comandoDetalleCita) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorTransaccionDetalleCita.ejecutarCreacion(comandoDetalleCita));
    }

    @DeleteMapping(value = "/{idDetalleCita}")
    public void eliminar(@PathVariable("idDetalleCita") Long idDetalleCita) {
        this.manejadorTransaccionDetalleCita.ejecutarEliminar(idDetalleCita);
    }
}
