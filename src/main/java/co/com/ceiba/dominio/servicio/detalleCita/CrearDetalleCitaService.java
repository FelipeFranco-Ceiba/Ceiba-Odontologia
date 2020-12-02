package co.com.ceiba.dominio.servicio.detalleCita;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearDetalleCitaService {

    private final RepositorioDetalleCitaMySql repositorioDetalleCita;
    private final ConsularHorasTrabajadasOdontologo consularHorasTrabajadasOdontologo;

    public DetalleCita crearDetalleCita(DetalleCita detalleCita) {
        Long valorCita = consularHorasTrabajadasOdontologo.consultarHorasTrabajadas(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita());
        detalleCita.setValorCita(valorCita);

        return repositorioDetalleCita.crearDetalleCita(detalleCita);
    }
}
