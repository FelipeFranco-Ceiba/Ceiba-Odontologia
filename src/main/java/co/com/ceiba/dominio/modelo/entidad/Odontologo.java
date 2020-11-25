package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @Builder(setterPrefix = "con")
public class Odontologo {


    private Long    idOdontologo;
    private String  nombres;
    private String  apellidos;
    private Date    fechaIngreso;
    private Boolean  estado;
    private List<DetalleCitaEntidad> detalleCitas;
}
