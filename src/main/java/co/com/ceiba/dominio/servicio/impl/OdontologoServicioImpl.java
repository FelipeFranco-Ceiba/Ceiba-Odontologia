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
import java.util.function.Function;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class OdontologoServicioImpl implements IOdontologoServicio {

    private final IRepositorioOdontologo repositorioOdontologo;

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
        existe(odontologo.getIdOdontologo());
        return this.repositorioOdontologo.actualizarOdontologo(TransformadorOdontologo.mapToOdontologoEntidad(odontologo));
    }

    @Transactional
    @Override
    public void eliminarOdontologo(Long idOdontologo) {
        Odontologo odontologo = existeOdontologo(idOdontologo);
        odontologo.setEstado("N");
        repositorioOdontologo.actualizarOdontologo(TransformadorOdontologo.mapToOdontologoEntidad(odontologo));
    }

    private void existe(Long idOdontologo) {
        Boolean existeOdontologo = repositorioOdontologo.existeOdontologo(idOdontologo);
        if (!existeOdontologo)
            throw new CitaExcepcion("No existe el odontologo");
    }

//    private Odontologo existe(Long idOdontologo) {
//        return repositorioOdontologo.consultarOdontologoPorId(idOdontologo)
//                .map(odontologoEntidad -> {
//                    Odontologo odontologo = TransformadorOdontologo.mapToOdontologoModelo(odontologoEntidad);
//                    odontologo.setEstado("N");
//                    return odontologo;
//                })
//                .orElseThrow(() -> {
//                    throw new CitaExcepcion("No existe el odontogolo");
//                });
//    }

    @Transactional
    private Odontologo existeOdontologo(Long idOdontologo) {
        return repositorioOdontologo.consultarOdontologoPorId(idOdontologo)
                .map(TransformadorOdontologo::mapToOdontologoModelo)
                .orElseThrow(() -> {
                    throw new CitaExcepcion("No existe el odontologo");
                });
    }
}
