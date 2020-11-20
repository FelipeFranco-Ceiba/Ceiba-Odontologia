package co.com.ceiba.aplicacion.comando;

import co.com.ceiba.aplicacion.fabrica.FabricaOdontologo;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.IOdontologoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorTransaccionOdontologo {

    private final IOdontologoServicio odontologoServicio;

    public Odontologo ejecutarCreacion(ComandoOdontologo comandoOdontologo) {
        Odontologo odontologo = FabricaOdontologo.crearOdontologo(comandoOdontologo);
        return this.odontologoServicio.crearOdontologo(odontologo);
    }

    public Odontologo ejecutarActualizacion(ComandoOdontologo comandoOdontologo) {
        Odontologo odontologo = FabricaOdontologo.crearOdontologo(comandoOdontologo);
        return this.odontologoServicio.actualizarOdontologo(odontologo);
    }

    public void ejecutarEliminar(Long idOdontologo) {
        this.odontologoServicio.eliminarOdontologo(idOdontologo);
    }
}
