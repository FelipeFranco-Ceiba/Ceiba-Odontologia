package co.com.ceiba.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class ComandoCliente {

    private Long idCliente;
    private String nombres;
    private String apellidos;
}
