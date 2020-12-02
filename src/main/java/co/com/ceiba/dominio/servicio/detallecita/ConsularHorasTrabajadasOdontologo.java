package co.com.ceiba.dominio.servicio.detallecita;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioDetalleCitaMySql;
import co.com.ceiba.infraestructura.utilidades.FormatearFecha;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

@Service
@AllArgsConstructor
public class ConsularHorasTrabajadasOdontologo {

    private final RepositorioDetalleCitaMySql repositorioDetalleCita;
    private static final Long VALOR_HORA = 35000L;
    public static final String ERROR_CANTIDAD_HORA_CITA = "La cita sobrepasa la cantidad de horas maximas de trabajo del odontologo";

    public Long consultarHorasTrabajadas(Long idOdontologo, Date fechaCita, Long horaCita) {
        int horasTrabajadas = repositorioDetalleCita.horasTrabajasOdontologo(idOdontologo, fechaCita);
        LocalDate fechaCitaFormat = FormatearFecha.transformarDateToLocalDate(fechaCita);

        if (fechaCitaFormat.getDayOfWeek().equals(DayOfWeek.SATURDAY) || fechaCitaFormat.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return validYCalcularValorHorasFinDeSemana(horasTrabajadas, horaCita);
        } else {
            return validYCalcularValorHorasEnSemana(horasTrabajadas, horaCita);
        }
    }

    private Long validYCalcularValorHorasFinDeSemana(int horasTrabajadas, Long horaCita) {
        long totalHoras = horasTrabajadas + horaCita;
        if (totalHoras > 5) {
            throw new CitaExcepcion(ERROR_CANTIDAD_HORA_CITA);
        }
        return ((horaCita * VALOR_HORA) * 2);
    }

    private Long validYCalcularValorHorasEnSemana(int horasTrabajadas, Long horaCita) {
        long totalHoras = horasTrabajadas + horaCita;
        if (totalHoras > 8) {
            throw new CitaExcepcion(ERROR_CANTIDAD_HORA_CITA);
        }
        return (horaCita * VALOR_HORA);
    }
}
