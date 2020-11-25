package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.modelo.entidad.OdontologoEntidad;

import java.util.List;
import java.util.Optional;

public interface RepositorioOdontologo {

    List<Odontologo> consultarOdontologo();
    Odontologo crearOdontologo(OdontologoEntidad odontologo);
    Odontologo actualizarOdontologo(OdontologoEntidad odontologo);
    Optional<OdontologoEntidad> consultarOdontologoPorId(Long idOdontologo);
}
