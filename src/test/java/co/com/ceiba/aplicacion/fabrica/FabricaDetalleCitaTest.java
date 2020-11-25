package co.com.ceiba.aplicacion.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
import co.com.ceiba.infraestructura.mockfactory.DetalleCitaFactory;
import org.junit.Assert;
import org.junit.Test;

public class FabricaDetalleCitaTest {

    @Test
    public void crearCliente() {
        DetalleCita detalleCitaEsperado = new DetalleCitaFactory().buildDetalleCita();
        ComandoDetalleCita comandoDetalleCita = new DetalleCitaFactory().buildComando();

        DetalleCita detalleCita = FabricaDetalleCita.crearDetalleCita(comandoDetalleCita);

        Assert.assertEquals(detalleCitaEsperado.getHoraCita(), detalleCita.getHoraCita());
    }
}
