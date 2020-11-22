package co.com.ceiba.infraestructura.adaptador.transformador;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;

import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorDetalleCita {

    public static DetalleCita mapToDetalleCitaModelo(DetalleCitaEntidad detalleCitaEntidad) {
        return DetalleCita.builder()
                .conIdDetalleCita(detalleCitaEntidad.getIdDetalleCita())
                .conFechaCita(detalleCitaEntidad.getFechaCita())
                .conHoraCita(detalleCitaEntidad.getHoraCita())
                .conValorCita(detalleCitaEntidad.getValorCita())
                .conCliente(TransformadorCliente.mapToClienteModeloSinListaDetalle(detalleCitaEntidad.getClienteEntidad()))
                .conOdontologo(TransformadorOdontologo.mapToOdontologoModeloSinListaDetalle(detalleCitaEntidad.getOdontologoEntidad()))
                .build();
    }

    public static List<DetalleCita> matToLstDetalleCitaModelo(List<DetalleCitaEntidad> detalleCitas) {
        return detalleCitas.stream().map(TransformadorDetalleCita::mapToDetalleCitaModelo).collect(Collectors.toList());
    }

    public static DetalleCitaEntidad mapToDetalleCitaEntidad(DetalleCita detalleCita) {
        return DetalleCitaEntidad.builder()
                .idDetalleCita(detalleCita.getIdDetalleCita())
                .fechaCita(detalleCita.getFechaCita())
                .horaCita(detalleCita.getHoraCita())
                .valorCita(detalleCita.getValorCita())
                .clienteEntidad(TransformadorCliente.mapToClienteEntidad(detalleCita.getCliente()))
                .odontologoEntidad(TransformadorOdontologo.mapToOdontologoEntidad(detalleCita.getOdontologo()))
                .build();
    }
}
