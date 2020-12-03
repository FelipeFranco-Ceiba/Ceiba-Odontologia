package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.aplicacion.manejador.odontologo.ManejadorConsultarOdontologo;
import co.com.ceiba.aplicacion.manejador.odontologo.ManejadorActualizarOdontologo;
import co.com.ceiba.aplicacion.manejador.odontologo.ManejadorCrearOdontologo;
import co.com.ceiba.aplicacion.manejador.odontologo.ManejadorEliminarOdontologo;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@AllArgsConstructor
@RequestMapping(value = "/odontologo")
public class ControladorOdontologo {

    private final ManejadorConsultarOdontologo manejadorConsultarOdontologo;
    private final ManejadorCrearOdontologo manejadorCrearOdontologo;
    private final ManejadorActualizarOdontologo manejadorActualizarOdontologo;
    private final ManejadorEliminarOdontologo manejadorEliminarOdontologo;

    @GetMapping
    public ResponseEntity<List<Odontologo>> consultaOdontolos() {
        return ResponseEntity.ok(this.manejadorConsultarOdontologo.ejecutar());
    }

    @PostMapping
    public ResponseEntity<Odontologo> crear(@RequestBody ComandoOdontologo comandoOdontologo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorCrearOdontologo.ejecutar(comandoOdontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody ComandoOdontologo comandoOdontologo) {
        return ResponseEntity.ok(this.manejadorActualizarOdontologo.ejecutar(comandoOdontologo));
    }

    @DeleteMapping(value = "/{idOdontologo}")
    public void eliminar(@PathVariable("idOdontologo") Long idOdontologo) {
        this.manejadorEliminarOdontologo.ejecutar(idOdontologo);
    }
}
