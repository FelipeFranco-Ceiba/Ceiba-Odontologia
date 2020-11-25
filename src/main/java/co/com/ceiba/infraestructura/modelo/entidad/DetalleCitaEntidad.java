package co.com.ceiba.infraestructura.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DETALLE_CITA", schema = "DB_CEIBA_ODONTOLOGIA")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleCitaEntidad implements Serializable {

    private static final long serialVersionUID = 7617811362219595918L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleCita;

    private Date fechaCita;
    private Long horaCita;
    private long valorCita;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ODONTOLOGO")
    private OdontologoEntidad odontologoEntidad;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntidad clienteEntidad;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LOGIN")
    private LoginEntidad loginEntidad;
}
