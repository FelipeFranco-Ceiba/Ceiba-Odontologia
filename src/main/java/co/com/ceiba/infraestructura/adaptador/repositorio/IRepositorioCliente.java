package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.repositorio.RepositorioCliente;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorCliente;
import co.com.ceiba.infraestructura.modelo.entidad.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRepositorioCliente extends JpaRepository<ClienteEntidad, Long>, RepositorioCliente {

    @Override
    default Boolean existeCliente(Long idCliente) {
        return existsByIdCliente(idCliente);
    }

    @Override
    default List<Cliente> consultarCliente() {
        return TransformadorCliente.mapToLstClienteModelo(findAll());
    }

    @Override
    default Cliente crearCliente(Cliente cliente) {
        ClienteEntidad clienteEntidad = TransformadorCliente.mapToClienteEntidad(cliente);
        return TransformadorCliente.mapToClienteModelo(saveAndFlush(clienteEntidad));
    }

    @Override
    default Cliente actualizarCliente(Cliente cliente) {
        ClienteEntidad clienteEntidad = TransformadorCliente.mapToClienteEntidad(cliente);
        return TransformadorCliente.mapToClienteModelo(saveAndFlush(clienteEntidad));
    }

    @Override
    default void eliminarClientePorId(Long idCliente) {
        deleteByIdCliente(idCliente);
    }

    void deleteByIdCliente(Long idCliente);
    Boolean existsByIdCliente(Long idCliente);
}
