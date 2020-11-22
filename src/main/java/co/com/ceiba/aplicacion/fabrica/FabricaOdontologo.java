package co.com.ceiba.aplicacion.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.utilidades.FormatearFecha;

public final class FabricaOdontologo {

    public static Odontologo crearOdontologo(ComandoOdontologo comandoOdontologo) {
        return Odontologo.builder()
                .conIdOdontologo(comandoOdontologo.getIdOdontologo())
                .conNombres(comandoOdontologo.getNombres())
                .conApellidos(comandoOdontologo.getApellidos())
                .conFechaIngreso(FormatearFecha.transformarStringToDate(comandoOdontologo.getFechaIngreso()))
                .conEstado(comandoOdontologo.getEstado())
                .build();
    }
}
