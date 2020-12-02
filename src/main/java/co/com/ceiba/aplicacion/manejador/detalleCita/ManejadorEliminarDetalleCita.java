package co.com.ceiba.aplicacion.manejador.detalleCita;

import co.com.ceiba.aplicacion.manejador.ManejadorComando;
import co.com.ceiba.dominio.servicio.detalleCita.EliminarDetalleCitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarDetalleCita implements ManejadorComando<Long> {

    private final EliminarDetalleCitaService eliminarDetalleCitaService;

    @Override
    public void ejecutar(Long comando) {
        this.eliminarDetalleCitaService.eliminarDetalleCita(comando);
    }
}
