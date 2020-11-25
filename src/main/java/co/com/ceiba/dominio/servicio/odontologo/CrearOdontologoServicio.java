package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CrearOdontologoServicio {

    private final IRepositorioOdontologo repositorioOdontologo;

    @Transactional
    public Odontologo crearOdontologo(Odontologo odontologo) {
        return repositorioOdontologo.crearOdontologo(odontologo);
    }
}
