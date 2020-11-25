package co.com.ceiba.infraestructura.adaptador.transformador;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.modelo.entidad.OdontologoEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorOdontologo {

    private TransformadorOdontologo() { }

    public static Odontologo mapToOdontologoModelo(OdontologoEntidad odontologo) {
        return Odontologo.builder()
                .conIdOdontologo(odontologo.getIdOdontologo())
                .conNombres(odontologo.getNombres())
                .conApellidos(odontologo.getApellidos())
                .conFechaIngreso(odontologo.getFechaIngreso())
                .conEstado(TransformadorOdontologo.transformarStringToBoolean(odontologo.getEstado()))
                .conDetalleCitas(odontologo.getLstOdontologo())
                .build();
    }

    public static Boolean transformarStringToBoolean(String estado) {
        return "S".equals(estado);
    }

    public static String transformarBooleanToString(Boolean estado) {
        return estado ? "S" : "N";
    }

    public static Odontologo mapToOdontologoModeloSinListaDetalle(OdontologoEntidad odontologo) {
        return Odontologo.builder()
                .conIdOdontologo(odontologo.getIdOdontologo())
                .conNombres(odontologo.getNombres())
                .conApellidos(odontologo.getApellidos())
                .conFechaIngreso(odontologo.getFechaIngreso())
                .conEstado(TransformadorOdontologo.transformarStringToBoolean(odontologo.getEstado()))
                .build();
    }

    public static List<Odontologo> mapToLstOdontologoModelo(List<OdontologoEntidad> lstOdontologo) {
        return lstOdontologo.stream().map(TransformadorOdontologo::mapToOdontologoModelo).collect(Collectors.toList());
    }

    public static OdontologoEntidad mapToOdontologoEntidad(Odontologo odontologo) {
        return new OdontologoEntidad(
                odontologo.getIdOdontologo(),
                odontologo.getNombres(),
                odontologo.getApellidos(),
                odontologo.getFechaIngreso(),
                TransformadorOdontologo.transformarBooleanToString(odontologo.getEstado()),
                new ArrayList<>());
    }
}
