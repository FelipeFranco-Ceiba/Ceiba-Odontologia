package co.com.ceiba.dominio.servicio.odontologo;

import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioOdontologo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EliminarOdontologoServicio {

    private final IRepositorioOdontologo repositorioOdontologo;
    public static final String ERROR_NO_EXISTE_ODONTOLOGO = "No existe el odontologo";

    public void eliminarOdontologo(Long idOdontologo) {
        Odontologo odontologo = existeOdontologo(idOdontologo);
        odontologo.setEstado(false);
        repositorioOdontologo.actualizarOdontologo(odontologo);
    }

    public Odontologo existeOdontologo(Long idOdontologo) {

        Odontologo odontologo = repositorioOdontologo.consultarOdontologoPorId(idOdontologo);

        if (odontologo == null) {
            throw new ExistenciaPersonaExcepcion(ERROR_NO_EXISTE_ODONTOLOGO);
        }
        return odontologo;
    }
}
