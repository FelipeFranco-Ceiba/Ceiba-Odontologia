package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.repositorio.RepositorioDetalleCita;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorDetalleCita;
import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IRepositorioDetalleCita extends JpaRepository<DetalleCitaEntidad, Long>, RepositorioDetalleCita {

    @Override
    default List<DetalleCita> consultarDetalleCita() {
        return TransformadorDetalleCita.matToLstDetalleCitaModelo(findAll());
    }

    @Override
    default DetalleCita crearDetalleCita(DetalleCita detalleCita) {
        DetalleCitaEntidad detalleCitaEntidad = TransformadorDetalleCita.mapToDetalleCitaEntidad(detalleCita);
        return TransformadorDetalleCita.mapToDetalleCitaModelo(saveAndFlush(detalleCitaEntidad));
    }

    @Override
    default Boolean existeDetalleCita(Long idDetalleCita) {
        return existsById(idDetalleCita);
    }

    @Override
    default void eliminarDetalleCita(Long idDetalleCita) {
        deleteById(idDetalleCita);
    }

    @Override
    default int horasTrabajasOdontologo(Long idOdontologo, Date fechaCita) {
        return sumarHoras(idOdontologo, fechaCita);
    }

    @Query("SELECT COALESCE(SUM(dc.horaCita), 0) FROM DetalleCitaEntidad dc where dc.odontologoEntidad.idOdontologo = ?1 AND dc.fechaCita = ?2")
    int sumarHoras(Long idOdontologo, Date fechaCita);
}
