package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;

import java.util.List;

public interface RepositorioDetalleCita {

    List<DetalleCita> consultarDetalleCita();
}
