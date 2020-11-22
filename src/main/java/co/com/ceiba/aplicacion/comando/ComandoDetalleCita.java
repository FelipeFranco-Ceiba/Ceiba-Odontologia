package co.com.ceiba.aplicacion.comando;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
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
}
