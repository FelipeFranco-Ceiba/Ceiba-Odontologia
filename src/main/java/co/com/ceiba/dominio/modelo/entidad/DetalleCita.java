package co.com.ceiba.dominio.modelo.entidad;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class DetalleCita {

    private Long idDetalleCita;
    private Date fechaCita;
    private Long horaCita;
    private long valorCita;
    private Odontologo odontologo;
    private Cliente cliente;
    private Login login;
}
