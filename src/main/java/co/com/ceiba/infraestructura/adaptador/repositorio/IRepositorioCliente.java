package co.com.ceiba.infraestructura.adaptador.repositorio;

import co.com.ceiba.infraestructura.modelo.entidad.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositorioCliente extends JpaRepository<ClienteEntidad, Long> {

    Optional<ClienteEntidad> findByIdCliente(Long idCliente);
}
