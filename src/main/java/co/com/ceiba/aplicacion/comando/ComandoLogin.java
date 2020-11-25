package co.com.ceiba.aplicacion.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class ComandoLogin {

    private Long idLogin;
    private String usuario;
    private String clave;
}
