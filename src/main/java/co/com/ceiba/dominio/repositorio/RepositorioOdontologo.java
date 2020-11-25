package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Odontologo;

import java.util.List;

public interface RepositorioOdontologo {

    List<Odontologo> consultarOdontologo();
    Odontologo crearOdontologo(Odontologo odontologo);
    Odontologo actualizarOdontologo(Odontologo odontologo);
    Odontologo consultarOdontologoPorId(Long idOdontologo);
}
