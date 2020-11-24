package co.com.ceiba.aplicacion.comando;

import co.com.ceiba.aplicacion.fabrica.FabricaCliente;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.IClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorTransaccionCliente {

    private final IClienteServicio<Cliente> clienteServicio;

    public Cliente ejecutarCreacion(ComandoCliente comandoCliente) {
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);
        return this.clienteServicio.crearOActualizarCliente(cliente);
    }

    public Cliente ejecutarActualizacion(ComandoCliente comandoCliente) {
        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);
        return this.clienteServicio.actualizarCliente(cliente);
    }

    public void ejecutarEliminar(Long idCliente) {
        this.clienteServicio.eliminarCliente(idCliente);
    }
}
