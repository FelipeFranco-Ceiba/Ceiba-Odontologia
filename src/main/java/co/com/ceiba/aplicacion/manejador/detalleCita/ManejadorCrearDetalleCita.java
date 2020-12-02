package co.com.ceiba.aplicacion.manejador.detalleCita;

import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.aplicacion.fabrica.FabricaDetalleCita;
import co.com.ceiba.aplicacion.manejador.ManejadorComandoRespuesta;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.servicio.detallecita.CrearDetalleCitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorCrearDetalleCita implements ManejadorComandoRespuesta<DetalleCita, ComandoDetalleCita> {

    private final CrearDetalleCitaService crearDetalleCitaService;

    @Override
    public DetalleCita ejecutar(ComandoDetalleCita comando) {
        DetalleCita detalleCita = FabricaDetalleCita.crearDetalleCita(comando);
        return this.crearDetalleCitaService.crearDetalleCita(detalleCita);
    }
}
