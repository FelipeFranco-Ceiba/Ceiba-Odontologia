package co.com.ceiba.infraestructura.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DETALLE_CITA", schema = "DB_CEIBA_ODONTOLOGIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleCitaEntidad implements Serializable {

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
}
