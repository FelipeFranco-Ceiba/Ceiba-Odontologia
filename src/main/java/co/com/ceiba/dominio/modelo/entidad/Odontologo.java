package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder(setterPrefix = "con")
public class Odontologo {


    private Long    idOdontologo;
    private String  nombres;
    private String  apellidos;
    private Date    fechaIngreso;
    private String  estado;
    private List<DetalleCitaEntidad> detalleCitas;
}
