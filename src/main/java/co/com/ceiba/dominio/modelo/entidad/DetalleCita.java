package co.com.ceiba.dominio.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
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
