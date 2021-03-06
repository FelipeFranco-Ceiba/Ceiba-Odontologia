package co.com.ceiba.dominio.servicio.detallecita;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarDetalleCitaService {

    private final RepositorioDetalleCitaMySql repositorioDetalleCita;

    public List<DetalleCita> consultarDetalleCita() {
        return repositorioDetalleCita.consultarDetalleCita();
    }
}
