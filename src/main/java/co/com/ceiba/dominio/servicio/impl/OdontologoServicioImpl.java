package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.IOdontologoServicio;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorOdontologo;
import co.com.ceiba.infraestructura.modelo.entidad.OdontologoEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class OdontologoServicioImpl implements IOdontologoServicio {

    private final IRepositorioOdontologo repositorioOdontologo;
    public static final String ERROR_NO_EXISTE_ODONTOLOGO = "No existe el odontologo";

    @Transactional(readOnly = true)
    @Override
    public List<Odontologo> consultarOdontologo() {
        return repositorioOdontologo.consultarOdontologo();
    }

    @Transactional
    @Override
    public Odontologo crearOdontologo(Odontologo odontologo) {
        OdontologoEntidad odontologoEntidad = TransformadorOdontologo.mapToOdontologoEntidad(odontologo);
        return repositorioOdontologo.crearOdontologo(odontologoEntidad);
    }

    @Transactional
    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        existeOdontologo(odontologo.getIdOdontologo());
        return repositorioOdontologo.actualizarOdontologo(TransformadorOdontologo.mapToOdontologoEntidad(odontologo));
    }

    @Transactional
    @Override
    public void eliminarOdontologo(Long idOdontologo) {
        Odontologo odontologo = existeOdontologo(idOdontologo);
        odontologo.setEstado(false);
        repositorioOdontologo.actualizarOdontologo(TransformadorOdontologo.mapToOdontologoEntidad(odontologo));
    }

    @Transactional
    public Odontologo existeOdontologo(Long idOdontologo) {

        Odontologo odontologo = repositorioOdontologo.consultarOdontologoPorId(idOdontologo)
                .map(TransformadorOdontologo::mapToOdontologoModelo)
                .orElse(null);

        if (odontologo == null) {
            throw new CitaExcepcion(ERROR_NO_EXISTE_ODONTOLOGO);
        }
        return odontologo;
    }
}
