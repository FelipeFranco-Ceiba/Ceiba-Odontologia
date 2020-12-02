package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CrearOdontologoServicio {

    private final IRepositorioOdontologo repositorioOdontologo;

    public Odontologo crearOdontologo(Odontologo odontologo) {
        return repositorioOdontologo.crearOdontologo(odontologo);
    }
}
