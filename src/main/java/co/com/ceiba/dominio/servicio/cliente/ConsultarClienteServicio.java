package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioClienteMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarClienteServicio {

    private final RepositorioClienteMySql repositorioCliente;

    public List<Cliente> consultarCliente() {
        return repositorioCliente.consultarCliente();
    }
}
