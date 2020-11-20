package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.repositorio.RepositorioCliente;
import co.com.ceiba.infraestructura.modelo.entidad.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepositorioCliente extends JpaRepository<ClienteEntidad, Long>, RepositorioCliente {

    @Override
    default Boolean existeCliente(Long idCliente) {
        return null;
    }

    @Override
    default List<Cliente> consultarCliente() {
        return null;
    }

    @Override
    default Cliente crearCliente(ClienteEntidad cliente) {
        return null;
    }

    @Override
    default Cliente actualizarOdontologo(ClienteEntidad cliente) {
        return null;
    }
}
