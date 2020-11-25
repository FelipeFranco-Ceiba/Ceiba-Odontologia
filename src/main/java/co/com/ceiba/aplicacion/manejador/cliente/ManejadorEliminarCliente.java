package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.aplicacion.manejador.ManejadorComando;
import co.com.ceiba.dominio.servicio.cliente.EliminarClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final EliminarClienteServicio clienteServicio;

    @Override
    public void ejecutar(Long idCliente) {
        this.clienteServicio.eliminarCliente(idCliente);
    }
}
