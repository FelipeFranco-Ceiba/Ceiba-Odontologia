package co.com.ceiba.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class ComandoLogin {

    private Long idLogin;
    private String usuario;
    private String clave;
}
