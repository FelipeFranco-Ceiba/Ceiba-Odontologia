package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.excepcion.ExistenciaPersonaExcepcion;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EliminarClienteServicio {

    private final IRepositorioCliente repositorioCliente;
    public static final String ERROR_NO_EXISTE_CLIENTE = "No existe el cliente";

    @Transactional
    public void eliminarCliente(Long idCliente) {
        existeCliente(idCliente);
        repositorioCliente.eliminarClientePorId(idCliente);
    }

    public void existeCliente(Long idCliente) {
        Boolean existeCliente = repositorioCliente.existsByIdCliente(idCliente);
        if (!existeCliente)
            throw new ExistenciaPersonaExcepcion(ERROR_NO_EXISTE_CLIENTE);
    }
}
