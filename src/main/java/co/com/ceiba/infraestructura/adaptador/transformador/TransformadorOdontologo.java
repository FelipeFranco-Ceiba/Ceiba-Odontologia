package co.com.ceiba.infraestructura.adaptador.transformador;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.modelo.entidad.OdontologoEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorOdontologo {

    public static Odontologo mapToOdontologoModelo(OdontologoEntidad odontologo) {
        return Odontologo.builder()
                .conIdOdontologo(odontologo.getIdOdontologo())
                .conNombres(odontologo.getNombres())
                .conApellidos(odontologo.getApellidos())
                .conFechaIngreso(odontologo.getFechaIngreso())
                .conEstado(odontologo.getEstado())
                .conDetalleCitas(odontologo.getLstOdontologo())
                .build();
    }

    public static Odontologo mapToOdontologoModeloSinListaDetalle(OdontologoEntidad odontologo) {
        return Odontologo.builder()
                .conIdOdontologo(odontologo.getIdOdontologo())
                .conNombres(odontologo.getNombres())
                .conApellidos(odontologo.getApellidos())
                .conFechaIngreso(odontologo.getFechaIngreso())
                .conEstado(odontologo.getEstado())
                .build();
    }

    public static List<Odontologo> mapToLstOdontologoModelo(List<OdontologoEntidad> lstOdontologo) {
        return lstOdontologo.stream().map(TransformadorOdontologo::mapToOdontologoModelo).collect(Collectors.toList());
    }

    public static OdontologoEntidad mapToOdontologoEntidad(Odontologo odontologo) {
        return OdontologoEntidad.builder()
                .idOdontologo(odontologo.getIdOdontologo())
                .nombres(odontologo.getNombres())
                .apellidos(odontologo.getApellidos())
                .fechaIngreso(odontologo.getFechaIngreso())
                .estado(odontologo.getEstado())
                .lstOdontologo(new ArrayList<>())
                .build();
    }
}
