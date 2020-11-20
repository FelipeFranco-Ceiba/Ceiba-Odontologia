package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.dominio.servicio.IDetalleCitaServicio;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioDetalleCita;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCitaServicioImpl implements IDetalleCitaServicio<DetalleCita> {

    private final IRepositorioDetalleCita repositorioDetalleCita;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleCita> consultarDetalleCita() {
        return repositorioDetalleCita.consultarDetalleCita();
    }

    @Override
    public DetalleCita crearOActualizarDetalleCita(DetalleCita detalleCita) {
        return null;
    }

    @Override
    public Cliente actualizarDetalleCita(DetalleCita detalleCita) {
        return null;
    }

    @Override
    public void eliminarDetalleCita(Long idDetalleCita) {

    }
}
