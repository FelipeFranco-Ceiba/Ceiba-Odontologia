package co.com.ceiba.dominio.servicio.detallecita;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActualizarDetalleCitaServicio {

    private final RepositorioDetalleCitaMySql repositorioDetalleCita;
    private final ConsularHorasTrabajadasOdontologo consularHorasTrabajadasOdontologo;
    private final ValidarDetalleCita validarDetalleCita;

    public DetalleCita actualizarDetalleCita(DetalleCita detalleCita) {
        validarDetalleCita.existeDetalleCita(detalleCita.getIdDetalleCita());
        Long valorCita = consularHorasTrabajadasOdontologo.consultarHorasTrabajadas(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita());
        detalleCita.setValorCita(valorCita);

        return repositorioDetalleCita.crearDetalleCita(detalleCita);
    }
}
