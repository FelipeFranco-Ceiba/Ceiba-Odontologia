package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.repositorio.RepositorioOdontologo;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorOdontologo;
import co.com.ceiba.infraestructura.modelo.entidad.OdontologoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRepositorioOdontologo extends JpaRepository<OdontologoEntidad, Long>, RepositorioOdontologo {

    @Override
    default List<Odontologo> consultarOdontologo() {
        return TransformadorOdontologo.mapToLstOdontologoModelo(findAll());
    }

    @Override
    default Odontologo crearOdontologo(OdontologoEntidad odontologo) {
        return TransformadorOdontologo.mapToOdontologoModelo(saveAndFlush(odontologo));
    }

    @Override
    default Odontologo actualizarOdontologo(OdontologoEntidad odontologo) {
        return TransformadorOdontologo.mapToOdontologoModelo(saveAndFlush(odontologo));
    }

    @Override
    default Boolean existeOdontologo(Long idOdontologo) {
        return existsById(idOdontologo);
    }

    @Override
    default Optional<OdontologoEntidad> consultarOdontologoPorId(Long idOdontologo) {
        return findById(idOdontologo);
    }

}
