package co.com.ceiba.dominio.servicio.detalleCita;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioDetalleCita;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearDetalleCitaService {

    private final IRepositorioDetalleCita repositorioDetalleCita;
    private final ConsularHorasTrabajadasOdontologo consularHorasTrabajadasOdontologo;
    private final ValidarDetalleCita validarDetalleCita;

    public DetalleCita crearDetalleCita(DetalleCita detalleCita) {
        Long valorCita = consularHorasTrabajadasOdontologo.consultarHorasTrabajadas(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita());
        detalleCita.setValorCita(valorCita);

        return repositorioDetalleCita.crearDetalleCita(detalleCita);
    }
}
