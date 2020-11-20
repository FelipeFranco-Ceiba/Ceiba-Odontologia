package co.com.ceiba.aplicacion.consulta;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.IOdontologoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorListaOdontologo {

    private final IOdontologoServicio odontologoServicio;

    public List<Odontologo> ejecutar() {
        return this.odontologoServicio.consultarOdontologo();
    }
}
