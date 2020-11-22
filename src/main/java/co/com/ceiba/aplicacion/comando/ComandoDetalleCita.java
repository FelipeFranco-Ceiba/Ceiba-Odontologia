package co.com.ceiba.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class ComandoDetalleCita {

    private Long idDetalleCita;
    private String fechaCita;
    private Long horaCita;
    private long valorCita;
    private ComandoOdontologo odontologo;
    private ComandoCliente cliente;
    private ComandoLogin login;
}
