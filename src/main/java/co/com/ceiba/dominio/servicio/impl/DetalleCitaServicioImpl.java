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
import co.com.ceiba.infraestructura.utilidades.FormatearFecha;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCitaServicioImpl implements IDetalleCitaServicio<DetalleCita> {

    private final IRepositorioDetalleCita repositorioDetalleCita;
    private static final Long VALOR_HORA = 35000L;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleCita> consultarDetalleCita() {
        return repositorioDetalleCita.consultarDetalleCita();
    }

    @Transactional
    @Override
    public DetalleCita crearOActualizarDetalleCita(DetalleCita detalleCita) {

        Long valorTotalCita = consultarHorasTrabajadasOdontologo(detalleCita.getOdontologo().getIdOdontologo(), detalleCita.getFechaCita(), detalleCita.getHoraCita());
        detalleCita.setValorCita(valorTotalCita);

        DetalleCitaEntidad detalleCitaEntidad = TransformadorDetalleCita.mapToDetalleCitaEntidad(detalleCita);
        return repositorioDetalleCita.crearDetalleCita(detalleCitaEntidad);
    }



    private Long consultarHorasTrabajadasOdontologo(Long idOdontologo, Date fechaCita, Long horaCita) {
        int horasTrabajadas = repositorioDetalleCita.horasTrabajasOdontologo(idOdontologo, fechaCita);
        LocalDate fechaCitaFormat = FormatearFecha.transformarDateToLocalDate(fechaCita);

        if (fechaCitaFormat.plusDays(1).getDayOfWeek().equals(DayOfWeek.SATURDAY) || fechaCitaFormat.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return validYCalcularValorHorasFinDeSemana(horasTrabajadas, horaCita);
        } else {
            return validYCalcularValorHorasEnSemana(horasTrabajadas, horaCita);
        }

    }

    private Long validYCalcularValorHorasFinDeSemana(int horasTrabajadas, Long horaCita) {
        long totalHoras = horasTrabajadas + horaCita;
        if (totalHoras > 5) {
            throw new CitaExcepcion("La cita sobrepasa la cantidad de horas maximas de trabajo del odontologo");
        }
        return ((horaCita * VALOR_HORA) * 2);
    }

    private Long validYCalcularValorHorasEnSemana(int horasTrabajadas, Long horaCita) {
        long totalHoras = horasTrabajadas + horaCita;
        if (totalHoras > 8) {
            throw new CitaExcepcion("La cita sobrepasa la cantidad de horas maximas de trabajo del odontologo");
        }
        return (horaCita * VALOR_HORA);
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
