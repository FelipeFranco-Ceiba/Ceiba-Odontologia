package co.com.ceiba.aplicacion.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.dominio.modelo.entidad.Cliente;

public final class FabricaCliente {

    private FabricaCliente() { }

    public static Cliente crearCliente(ComandoCliente comandoCliente) {
        return Cliente.builder()
                .conIdCliente(comandoCliente.getIdCliente())
                .conNombres(comandoCliente.getNombres())
                .conApellidos(comandoCliente.getApellidos())
                .build();
    }
}
