package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;

import java.util.List;

public interface RepositorioDetalleCita {

    List<DetalleCita> consultarDetalleCita();

    DetalleCita crearDetalleCita(DetalleCitaEntidad detalleCitaEntidad);
}
