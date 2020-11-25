package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.aplicacion.manejador.ManejadorComando;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.IClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final IClienteServicio<Cliente> clienteServicio;

    @Override
    public void ejecutar(Long idCliente) {
        this.clienteServicio.eliminarCliente(idCliente);
    }
}
