package co.com.ceiba.infraestructura.modelo.entidad;

import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "LOGIN", schema = "DB_CEIBA_ODONTOLOGIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogin;

    @Column(name = "USUARIO")
    private String usuario;
    private String clave;

    @JsonManagedReference
    @OneToMany(mappedBy = "loginEntidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCitaEntidad> lstDetalleCita;
}
