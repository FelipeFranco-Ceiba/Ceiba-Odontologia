package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Cliente;

import java.util.List;

public interface RepositorioCliente {

    Boolean existeCliente(Long idCliente);
    List<Cliente> consultarCliente();
    Cliente crearCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    void eliminarClientePorId(Long idCliente);
}
