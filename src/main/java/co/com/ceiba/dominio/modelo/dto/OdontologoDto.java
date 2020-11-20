package co.com.ceiba.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "con")
public class OdontologoDto {

    private Long idOdontologo;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
}
