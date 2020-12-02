package co.com.ceiba.aplicacion.manejador.detalleCita;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.servicio.detalleCita.ConsultarDetalleCitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultarDetalleCita {

    private final ConsultarDetalleCitaService consultarDetalleCitaService;

    public List<DetalleCita> ejecutar() {
        return this.consultarDetalleCitaService.consultarDetalleCita();
    }
}
