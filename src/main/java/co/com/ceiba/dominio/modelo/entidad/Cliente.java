package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder(setterPrefix = "con")
public class Cliente {

    private Long idCliente;
    private String nombres;
    private String apellidos;
    private List<DetalleCitaEntidad> detalleCitas;
}
