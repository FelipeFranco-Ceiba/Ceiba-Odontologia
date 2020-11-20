package co.com.ceiba.aplicacion.consulta;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.IClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorListaCliente {

    private final IClienteServicio<Cliente> clienteServicio;

    public List<Cliente> ejecutar() {
        return this.clienteServicio.consultarCliente();
    }
}
