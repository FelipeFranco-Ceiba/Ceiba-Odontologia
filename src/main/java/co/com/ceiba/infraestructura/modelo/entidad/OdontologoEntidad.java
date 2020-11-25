package co.com.ceiba.infraestructura.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static co.com.ceiba.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Entity
@Table(name = "ODONTOLOGO", schema = "DB_CEIBA_ODONTOLOGIA")
@Getter
@NoArgsConstructor @Builder
public class OdontologoEntidad implements Serializable {


    private static final long serialVersionUID = 4251732736961477642L;

    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se debe ingresar los nombres del odontologo";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se debe ingresar los apellidos del odontologo";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INGRESO = "Se debe ingresar la fecha de ingteso del odontologo";

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

    public OdontologoEntidad(Long idOdontologo, String nombres, String apellidos, Date fechaIngreso, String estado, List<DetalleCitaEntidad> lstOdontologo) {
        validarObligatorio(nombres, SE_DEBE_INGRESAR_LOS_NOMBRES);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_LOS_APELLIDOS);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LOS_APELLIDOS);

        this.idOdontologo = idOdontologo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.lstOdontologo = lstOdontologo;
    }
}
