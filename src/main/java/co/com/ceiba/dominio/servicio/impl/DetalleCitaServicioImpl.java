package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.IDetalleCitaServicio;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioDetalleCita;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorDetalleCita;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorOdontologo;
import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCitaServicioImpl implements IDetalleCitaServicio<DetalleCita> {

    private final IRepositorioDetalleCita repositorioDetalleCita;
    private final IRepositorioOdontologo repositorioOdontologo;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleCita> consultarDetalleCita() {
        return repositorioDetalleCita.consultarDetalleCita();
    }

    @Transactional
    @Override
    public DetalleCita crearOActualizarDetalleCita(DetalleCita detalleCita) {
        // TODO: Logica antes de guardar

        consultarHorasTrabajadasOdontologo(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita());



        DetalleCitaEntidad detalleCitaEntidad = TransformadorDetalleCita.mapToDetalleCitaEntidad(detalleCita);
        return repositorioDetalleCita.crearDetalleCita(detalleCitaEntidad);
    }

    private void consultarHorasTrabajadasOdontologo(Long idOdontologo, Date fechaCita) {
        repositorioDetalleCita.horasTrabajasOdontologo(idOdontologo, fechaCita);
    }

    @Override
    public Cliente actualizarDetalleCita(DetalleCita detalleCita) {
        return null;
    }

    @Transactional
    @Override
    public void eliminarDetalleCita(Long idDetalleCita) {
        existeDetalleCita(idDetalleCita);
        repositorioDetalleCita.eliminarDetalleCita(idDetalleCita);
    }

    @Transactional
    private void existeDetalleCita(Long idDetalleCita) {
        Boolean existeDetalleCita = repositorioDetalleCita.existeDetalleCita(idDetalleCita);
        if (!existeDetalleCita)
            throw new CitaExcepcion("No existe informacion del detalle de la cita");
    }
}
