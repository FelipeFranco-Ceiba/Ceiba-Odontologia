package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static co.com.ceiba.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Getter
@Builder(setterPrefix = "con")
public class Odontologo {

    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se debe ingresar los nombres del odontologo";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se debe ingresar los apellidos del odontologo";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INGRESO = "Se debe ingresar la fecha de ingteso del odontologo";

    private Long    idOdontologo;
    private String  nombres;
    private String  apellidos;
    private Date    fechaIngreso;
    private Boolean  estado;
    private List<DetalleCitaEntidad> detalleCitas;

    public Odontologo(Long idOdontologo, String nombres, String apellidos, Date fechaIngreso, Boolean estado, List<DetalleCitaEntidad> lstOdontologo) {
        validarObligatorio(nombres, SE_DEBE_INGRESAR_LOS_NOMBRES);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_LOS_APELLIDOS);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LOS_APELLIDOS);

        this.idOdontologo = idOdontologo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.detalleCitas = lstOdontologo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Odontologo that = (Odontologo) o;
        return idOdontologo.equals(that.idOdontologo) &&
                Objects.equals(nombres, that.nombres) &&
                Objects.equals(apellidos, that.apellidos) &&
                Objects.equals(fechaIngreso, that.fechaIngreso) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(detalleCitas, that.detalleCitas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOdontologo, nombres, apellidos, fechaIngreso, estado, detalleCitas);
    }
}
