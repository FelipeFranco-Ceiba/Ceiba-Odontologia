package co.com.ceiba.infraestructura.mockfactory;

import co.com.ceiba.aplicacion.comando.ComandoCliente;

public class ClienteFactory {

    private static final Long ID_CLIENTE = 2L;
    private static final String NOMBRES = "Cliente";
    private static final String APPELLIDOS = "Prueba";

    public ComandoCliente buildComando() {
        return new ComandoCliente(ID_CLIENTE, NOMBRES, APPELLIDOS);
    }

    public ComandoCliente buildComando(Long idCliente, String nombres, String apellidos) {
        return new ComandoCliente(idCliente, nombres, apellidos);
    }

}
