package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.odontologo.ConsultarOdontologoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultarOdontologo {

    private final ConsultarOdontologoServicio consultarOdontologoServicio;

    public List<Odontologo> ejecutar() {
        return this.consultarOdontologoServicio.consultarOdontologo();
    }
}
