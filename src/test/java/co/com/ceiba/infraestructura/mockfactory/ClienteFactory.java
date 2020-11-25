package co.com.ceiba.infraestructura.mockfactory;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.dominio.modelo.entidad.Cliente;

import java.util.ArrayList;

public class ClienteFactory {

    private static final Long ID_CLIENTE = 2L;
    private static final String NOMBRES = "Cliente";
    private static final String APPELLIDOS = "Prueba";

    public Cliente buildCliente() {
        return Cliente.builder()
                .conIdCliente(ID_CLIENTE)
                .conNombres(NOMBRES)
                .conApellidos(APPELLIDOS)
                .conDetalleCitas(null)
                .build();
    }

    public ComandoCliente buildComando() {
        return new ComandoCliente(ID_CLIENTE, NOMBRES, APPELLIDOS);
    }

    public ComandoCliente buildComando(Long idCliente, String nombres, String apellidos) {
        return new ComandoCliente(idCliente, nombres, apellidos);
    }

}
