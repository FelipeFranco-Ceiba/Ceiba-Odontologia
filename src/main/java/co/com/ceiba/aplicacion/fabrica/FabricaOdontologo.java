package co.com.ceiba.aplicacion.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FabricaOdontologo {

    private static final String FORMATO = "dd/MM/yyyy";

    public static Odontologo crearOdontologo(ComandoOdontologo comandoOdontologo) {
        Date fechaFormateada;
        try {
            fechaFormateada = new SimpleDateFormat(FORMATO).parse(comandoOdontologo.getFechaIngreso());
        } catch (ParseException e) {
            throw new CitaExcepcion("Ocurrio un error formateando la fecha de ingreso del Odontologo");
        }
        return Odontologo.builder()
                .conIdOdontologo(comandoOdontologo.getIdOdontologo())
                .conNombres(comandoOdontologo.getNombres())
                .conApellidos(comandoOdontologo.getApellidos())
                .conFechaIngreso(fechaFormateada)
                .conEstado(comandoOdontologo.getEstado())
                .build();
    }
}
