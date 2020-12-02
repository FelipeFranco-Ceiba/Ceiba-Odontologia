package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioClienteMySql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActualizarClienteService {

    private final RepositorioClienteMySql repositorioCliente;
    public static final String ERROR_NO_EXISTE_CLIENTE = "No existe el cliente";

    public Cliente actualizarCliente(Cliente cliente) {
        existeCliente(cliente.getIdCliente());
        return repositorioCliente.actualizarCliente(cliente);
    }

    public void existeCliente(Long idCliente) {
        Boolean existeCliente = repositorioCliente.existeCliente(idCliente);
        if (!existeCliente)
            throw new ExistenciaPersonaExcepcion(ERROR_NO_EXISTE_CLIENTE);
    }
}
