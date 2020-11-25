package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.repositorio.RepositorioOdontologo;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorOdontologo;
import co.com.ceiba.infraestructura.modelo.entidad.OdontologoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioOdontologo extends JpaRepository<OdontologoEntidad, Long>, RepositorioOdontologo {

    @Override
    default List<Odontologo> consultarOdontologo() {
        return TransformadorOdontologo.mapToLstOdontologoModelo(findAll());
    }

    @Override
    default Odontologo crearOdontologo(Odontologo odontologo) {
        OdontologoEntidad odontologoEntidad = TransformadorOdontologo.mapToOdontologoEntidad(odontologo);
        return TransformadorOdontologo.mapToOdontologoModelo(saveAndFlush(odontologoEntidad));
    }

    @Override
    default Odontologo actualizarOdontologo(Odontologo odontologo) {
        OdontologoEntidad odontologoEntidad = TransformadorOdontologo.mapToOdontologoEntidad(odontologo);
        return TransformadorOdontologo.mapToOdontologoModelo(saveAndFlush(odontologoEntidad));
    }

    @Override
    default Odontologo consultarOdontologoPorId(Long idOdontologo) {
        return findById(idOdontologo)
                .map(TransformadorOdontologo::mapToOdontologoModelo)
                .orElse(null);
    }

}
