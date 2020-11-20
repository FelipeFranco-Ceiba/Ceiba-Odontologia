package co.com.ceiba.dominio.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.modelo.entidad.ClienteEntidad;

import java.util.List;

public interface RepositorioCliente {

    Boolean existeCliente(Long idCliente);
    List<Cliente> consultarCliente();
    Cliente crearCliente(ClienteEntidad cliente);
    Cliente actualizarOdontologo(ClienteEntidad cliente);
}
