package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.fabrica.FabricaCliente;
import co.com.ceiba.aplicacion.manejador.ManejadorComandoRespuesta;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.cliente.CrearClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<Cliente, ComandoCliente> {

    private final CrearClienteServicio crearClienteServicio;

    @Override
    public Cliente ejecutar(ComandoCliente comando) {
        Cliente cliente = FabricaCliente.crearCliente(comando);
        return this.crearClienteServicio.crearCliente(cliente);
    }
}
