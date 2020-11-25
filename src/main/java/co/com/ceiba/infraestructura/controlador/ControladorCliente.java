package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.manejador.cliente.ManejadorActualizarCliente;
import co.com.ceiba.aplicacion.manejador.cliente.ManejadorConsultarCliente;
import co.com.ceiba.aplicacion.manejador.cliente.ManejadorCrearCliente;
import co.com.ceiba.aplicacion.manejador.cliente.ManejadorEliminarCliente;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping(value = "cliente")
public class ControladorCliente {

    private final ManejadorConsultarCliente manejadorConsultarCliente;
    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;

    @GetMapping
    public ResponseEntity<List<Cliente>> consultarCliente() {
        return ResponseEntity.ok(this.manejadorConsultarCliente.ejecutar());
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody ComandoCliente comandoCliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorCrearCliente.ejecutar(comandoCliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizar(@RequestBody ComandoCliente comandoCliente) {
        return ResponseEntity.ok(this.manejadorActualizarCliente.ejecutar(comandoCliente));
    }

    @DeleteMapping(value = "/{idCliente}")
    public void eliminar(@PathVariable("idCliente") Long idCliente) {
        this.manejadorEliminarCliente.ejecutar(idCliente);
    }
}
