package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.entidad.Cliente;

import java.util.List;

public interface IClienteServicio<T> {

    List<T> consultarCliente();

    T crearOActualizarCliente(T cliente);

    Cliente actualizarCliente(T cliente);


    void eliminarCliente(Long idCliente);
}
