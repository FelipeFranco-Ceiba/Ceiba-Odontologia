package co.com.ceiba.aplicacion.comando;

import lombok.*;

@AllArgsConstructor
@Getter
public class ComandoDetalleCita {

    private Long idDetalleCita;
    private String fechaCita;
    private Long horaCita;
    private long valorCita;
    private ComandoOdontologo odontologo;
    private ComandoCliente cliente;
    private ComandoLogin login;
}
