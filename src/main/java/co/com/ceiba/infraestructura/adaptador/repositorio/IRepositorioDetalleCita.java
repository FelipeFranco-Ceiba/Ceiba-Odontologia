package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.repositorio.RepositorioDetalleCita;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorDetalleCita;
import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioDetalleCita extends JpaRepository<DetalleCitaEntidad, Long>, RepositorioDetalleCita {

    @Override
    default List<DetalleCita> consultarDetalleCita() {
        return TransformadorDetalleCita.matToLstDetalleCitaModelo(findAll());
    }

    @Override
    default DetalleCita crearDetalleCita(DetalleCitaEntidad detalleCitaEntidad) {
        return TransformadorDetalleCita.mapToDetalleCitaModelo(save(detalleCitaEntidad));
    }
}
