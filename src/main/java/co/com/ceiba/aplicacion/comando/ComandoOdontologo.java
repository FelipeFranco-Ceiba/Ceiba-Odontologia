package co.com.ceiba.aplicacion.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class ComandoOdontologo {

    private Long idOdontologo;
    private String nombres;
    private String apellidos;
    private String fechaIngreso;
    private Boolean estado;
}
