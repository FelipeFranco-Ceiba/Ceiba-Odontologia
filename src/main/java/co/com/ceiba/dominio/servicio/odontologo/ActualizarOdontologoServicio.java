package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioOdontologoMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ActualizarOdontologoServicio {

    private final RepositorioOdontologoMySql repositorioOdontologo;
    public static final String ERROR_NO_EXISTE_ODONTOLOGO = "No existe el odontologo";

    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        existeOdontologo(odontologo.getIdOdontologo());
        return repositorioOdontologo.actualizarOdontologo(odontologo);
    }

    public Odontologo existeOdontologo(Long idOdontologo) {

        Odontologo odontologo = repositorioOdontologo.consultarOdontologoPorId(idOdontologo);
        if (odontologo == null) {
            throw new ExistenciaPersonaExcepcion(ERROR_NO_EXISTE_ODONTOLOGO);
        }
        return odontologo;
    }
}
