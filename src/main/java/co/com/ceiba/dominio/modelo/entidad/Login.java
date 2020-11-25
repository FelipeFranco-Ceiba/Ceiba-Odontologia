package co.com.ceiba.dominio.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class Login {

    private Long idLogin;
    private String usuario;
    private String clave;
}
