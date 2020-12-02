package co.com.ceiba.dominio.servicio.detalleCita;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidarDetalleCita {

    private final RepositorioDetalleCitaMySql repositorioDetalleCita;
    public static final String ERROR_NO_EXISTE_INFORMACION_DE_LA_CITA = "No existe informacion del detalle de la cita";

    public void existeDetalleCita(Long idDetalleCita) {
        boolean existeDetalleCita = repositorioDetalleCita.existeDetalleCita(idDetalleCita);
        if (!existeDetalleCita)
            throw new CitaExcepcion(ERROR_NO_EXISTE_INFORMACION_DE_LA_CITA);
    }
}
