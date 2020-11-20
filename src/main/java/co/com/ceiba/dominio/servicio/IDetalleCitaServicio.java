package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.entidad.Cliente;

import java.util.List;

public interface IDetalleCitaServicio<T> {

    List<T> consultarDetalleCita();

    T crearOActualizarDetalleCita(T detalleCita);

    Cliente actualizarDetalleCita(T detalleCita);


    void eliminarDetalleCita(Long idDetalleCita);
}
