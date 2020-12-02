package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;

import java.util.Date;
import java.util.List;

public interface RepositorioDetalleCita {

    List<DetalleCita> consultarDetalleCita();

    DetalleCita crearDetalleCita(DetalleCita detalleCita);

    boolean existeDetalleCita(Long idDetalleCita);

    void eliminarDetalleCita(Long idDetalleCita);

    int horasTrabajasOdontologo(Long idOdontologo, Date fechaCita);
}
