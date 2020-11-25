package co.com.ceiba.aplicacion.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class ComandoCliente {

    private Long idCliente;
    private String nombres;
    private String apellidos;
}
