package co.com.ceiba.infraestructura.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static co.com.ceiba.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Entity
@Table(name = "CLIENTE", schema = "DB_CEIBA_ODONTOLOGIA")
@Getter
@NoArgsConstructor @Builder
public class ClienteEntidad implements Serializable {

    private static final long serialVersionUID = 8434850033473170469L;

    public static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se debe ingresar los nombres del cliente";
    public static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se debe ingresar los apellidos del cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombres;
    private String apellidos;

    @JsonManagedReference
    @OneToMany(mappedBy = "clienteEntidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCitaEntidad> lstDetalleCita;

    public ClienteEntidad(Long idCliente, String nombres, String apellidos, List<DetalleCitaEntidad> lstDetalleCita) {
        validarObligatorio(nombres, SE_DEBE_INGRESAR_LOS_NOMBRES);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_LOS_APELLIDOS);

        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.lstDetalleCita = lstDetalleCita;
    }
}
