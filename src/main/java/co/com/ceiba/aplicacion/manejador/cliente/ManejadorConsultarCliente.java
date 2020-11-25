package co.com.ceiba.aplicacion.manejador.cliente;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.cliente.ConsultarClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultarCliente  {

    private final ConsultarClienteServicio consultarClienteServicio;

    public List<Cliente> ejecutar() {
        return this.consultarClienteServicio.consultarCliente();
    }
}
