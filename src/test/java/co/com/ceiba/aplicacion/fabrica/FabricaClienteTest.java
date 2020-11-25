package co.com.ceiba.aplicacion.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
import org.junit.Assert;
import org.junit.Test;

public class FabricaClienteTest {

    @Test
    public void crearCliente() {
        Cliente clienteEsperado = new ClienteFactory().buildCliente();
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();

        Cliente cliente = FabricaCliente.crearCliente(comandoCliente);

        Assert.assertEquals(clienteEsperado, cliente);
    }
}
