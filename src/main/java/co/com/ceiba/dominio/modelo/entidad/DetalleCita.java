package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.LoginEntidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
