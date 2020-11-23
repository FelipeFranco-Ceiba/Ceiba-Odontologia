package co.com.ceiba.aplicacion.comando;

import co.com.ceiba.aplicacion.fabrica.FabricaDetalleCita;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.servicio.IDetalleCitaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorTransaccionDetalleCita {

    private final IDetalleCitaServicio<DetalleCita> detalleCitaIDetalleCitaServicio;

    public DetalleCita ejecutarCreacion(ComandoDetalleCita comandoDetalleCita) {
        DetalleCita detalleCita = FabricaDetalleCita.crearDetalleCita(comandoDetalleCita);
        return this.detalleCitaIDetalleCitaServicio.crearOActualizarDetalleCita(detalleCita);
    }

    public void ejecutarEliminar(Long idDetalleCita) {
        this.detalleCitaIDetalleCitaServicio.eliminarDetalleCita(idDetalleCita);
    }

    public DetalleCita ejecutarActualizacion(ComandoDetalleCita comandoDetalleCita) {
        DetalleCita detalleCita = FabricaDetalleCita.crearDetalleCita(comandoDetalleCita);
        return this.detalleCitaIDetalleCitaServicio.actualizarDetalleCita(detalleCita);
    }
}
