package co.com.ceiba.aplicacion.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ComandoLogin {

    private Long idLogin;
    private String usuario;
    private String clave;
}
