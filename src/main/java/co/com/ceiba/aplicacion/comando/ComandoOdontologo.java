package co.com.ceiba.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class ComandoOdontologo {

    private Long idOdontologo;
    private String nombres;
    private String apellidos;
    private String fechaIngreso;
    private String estado;
}
