package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.consulta.ManejadorListaDetalleCita;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "detalleCita")
public class ControladorDetalleCita {

    private final ManejadorListaDetalleCita manejadorListaDetalleCita;

    @GetMapping
    public ResponseEntity<?> consultarDetalleCita() {
        return ResponseEntity.ok(this.manejadorListaDetalleCita.ejecutar());
    }
}
