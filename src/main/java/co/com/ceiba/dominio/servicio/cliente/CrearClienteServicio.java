package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioClienteMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearClienteServicio {

    private final RepositorioClienteMySql repositorioCliente;

    public Cliente crearCliente(Cliente cliente) {
        return repositorioCliente.crearCliente(cliente);
    }
}
