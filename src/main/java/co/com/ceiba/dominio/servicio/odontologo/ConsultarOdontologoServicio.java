package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ConsultarOdontologoServicio {

    private final IRepositorioOdontologo repositorioOdontologo;

    public List<Odontologo> consultarOdontologo() {
        return repositorioOdontologo.consultarOdontologo();
    }
}
