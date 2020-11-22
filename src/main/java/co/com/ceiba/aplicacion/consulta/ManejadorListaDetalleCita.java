package co.com.ceiba.aplicacion.consulta;

import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.aplicacion.fabrica.FabricaDetalleCita;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.servicio.IDetalleCitaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorListaDetalleCita {

    private final IDetalleCitaServicio<DetalleCita> detalleCitaIDetalleCitaServicio;

    public List<DetalleCita> ejecutar() {
        return this.detalleCitaIDetalleCitaServicio.consultarDetalleCita();
    }

    public DetalleCita ejecutarCreacion(ComandoDetalleCita comandoDetalleCita) {
        DetalleCita detalleCita = FabricaDetalleCita.crearDetalleCita(comandoDetalleCita);
        return this.detalleCitaIDetalleCitaServicio.crearOActualizarDetalleCita(detalleCita);
    }
}
