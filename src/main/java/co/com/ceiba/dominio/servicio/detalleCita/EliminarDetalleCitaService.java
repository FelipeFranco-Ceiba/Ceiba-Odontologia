package co.com.ceiba.dominio.servicio.detalleCita;

import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarDetalleCitaService {

    private final RepositorioDetalleCitaMySql repositorioDetalleCita;
    private final ValidarDetalleCita validarDetalleCita;

    public void eliminarDetalleCita(Long idDetalleCita) {
        validarDetalleCita.existeDetalleCita(idDetalleCita);
        repositorioDetalleCita.eliminarDetalleCita(idDetalleCita);
    }
}
