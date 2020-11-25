package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class Odontologo {


    private Long    idOdontologo;
    private String  nombres;
    private String  apellidos;
    private Date    fechaIngreso;
    private Boolean  estado;
    private List<DetalleCitaEntidad> detalleCitas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Odontologo that = (Odontologo) o;
        return idOdontologo.equals(that.idOdontologo) &&
                Objects.equals(nombres, that.nombres) &&
                Objects.equals(apellidos, that.apellidos) &&
                Objects.equals(fechaIngreso, that.fechaIngreso) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(detalleCitas, that.detalleCitas);
    }
}
