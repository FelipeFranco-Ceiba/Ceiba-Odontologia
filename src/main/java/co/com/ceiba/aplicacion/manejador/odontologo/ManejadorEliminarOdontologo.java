package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.aplicacion.manejador.ManejadorComando;
import co.com.ceiba.dominio.servicio.IOdontologoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarOdontologo implements ManejadorComando<Long> {

    private final IOdontologoServicio odontologoServicio;

    @Override
    public void ejecutar(Long idOdontologo) {
        this.odontologoServicio.eliminarOdontologo(idOdontologo);
    }
}
