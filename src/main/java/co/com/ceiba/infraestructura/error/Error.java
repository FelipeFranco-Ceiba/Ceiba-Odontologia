package co.com.ceiba.infraestructura.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class Error {

    private final String nombreExcepcion;
    private final String mensaje;

}
