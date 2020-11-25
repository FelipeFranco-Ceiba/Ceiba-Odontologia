package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class Cliente {

    private Long idCliente;
    private String nombres;
    private String apellidos;
    private List<DetalleCitaEntidad> detalleCitas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente.equals(cliente.idCliente) &&
                Objects.equals(nombres, cliente.nombres) &&
                Objects.equals(apellidos, cliente.apellidos) &&
                Objects.equals(detalleCitas, cliente.detalleCitas);
    }
}
