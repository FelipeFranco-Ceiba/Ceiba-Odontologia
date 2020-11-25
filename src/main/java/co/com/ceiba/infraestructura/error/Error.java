package co.com.ceiba.infraestructura.error;

import lombok.*;

@Getter
@AllArgsConstructor
public class Error {

    private final String nombreExcepcion;
    private final String mensaje;

}
