package co.com.ceiba.infraestructura.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "LOGIN", schema = "DB_CEIBA_ODONTOLOGIA")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginEntidad implements Serializable {

    private static final long serialVersionUID = 638104251721285160L;

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
