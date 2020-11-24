package co.com.ceiba.infraestructura.utilidades;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FormatearFecha {

    private static final String FORMATO = "dd/MM/yyyy";

    public static Date transformarStringToDate(String fecha) {
        try {
            return new SimpleDateFormat(FORMATO).parse(fecha);
        } catch (ParseException e) {
            throw new CitaExcepcion("Ocurrio un error formateando la fecha");
        }
    }

    public static LocalDate transformarDateToLocalDate(Date fecha) {
        return fecha.toInstant().atZone(ZoneId.of("America/Bogota")).toLocalDate();
    }
}
