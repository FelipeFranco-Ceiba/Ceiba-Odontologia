package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

import static co.com.ceiba.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Getter
@Builder(setterPrefix = "con")
public class Cliente {

    public static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se debe ingresar los nombres del cliente";
    public static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se debe ingresar los apellidos del cliente";

    private Long idCliente;
    private String nombres;
    private String apellidos;
    private List<DetalleCitaEntidad> detalleCitas;

    public Cliente(Long idCliente, String nombres, String apellidos, List<DetalleCitaEntidad> lstDetalleCita) {
        validarObligatorio(nombres, SE_DEBE_INGRESAR_LOS_NOMBRES);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_LOS_APELLIDOS);

        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.detalleCitas = lstDetalleCita;
    }

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
