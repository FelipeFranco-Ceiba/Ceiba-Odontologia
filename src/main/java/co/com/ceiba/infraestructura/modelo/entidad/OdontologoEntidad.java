package co.com.ceiba.infraestructura.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ODONTOLOGO", schema = "DB_CEIBA_ODONTOLOGIA")
@Getter
@AllArgsConstructor
@NoArgsConstructor @Builder
public class OdontologoEntidad implements Serializable {


    private static final long serialVersionUID = 4251732736961477642L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOdontologo;

    private String nombres;
    private String apellidos;
    private Date   fechaIngreso;
    private String estado;

    @JsonManagedReference
    @OneToMany(mappedBy = "odontologoEntidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCitaEntidad> lstOdontologo;
}
