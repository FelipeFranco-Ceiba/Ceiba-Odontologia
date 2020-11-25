package co.com.ceiba.dominio.servicio.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CrearClienteServicio {

    private final IRepositorioCliente repositorioCliente;

    @Transactional
    public Cliente crearCliente(Cliente cliente) {
        return repositorioCliente.crearCliente(cliente);
    }
}
