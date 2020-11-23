package co.com.ceiba.dominio.servicio;

import java.util.List;

public interface IDetalleCitaServicio<T> {

    List<T> consultarDetalleCita();

    T crearOActualizarDetalleCita(T detalleCita);

    T actualizarDetalleCita(T detalleCita);


    void eliminarDetalleCita(Long idDetalleCita);
}
