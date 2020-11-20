package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.dto.OdontologoDto;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;

import java.util.List;

public interface IOdontologoServicio {

    List<Odontologo> consultarOdontologo();

    Odontologo crearOdontologo(Odontologo odontologo);

    Odontologo actualizarOdontologo(Odontologo odontologo);


    void eliminarOdontologo(Long idOdontologo);
}
