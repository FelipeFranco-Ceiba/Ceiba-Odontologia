package co.com.ceiba.infraestructura.adaptador.transformador;

import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.infraestructura.modelo.entidad.ClienteEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorCliente {

    public static Cliente mapToClienteModelo(ClienteEntidad clienteEntidad) {
        return Cliente.builder()
                .conIdCliente(clienteEntidad.getIdCliente())
                .conNombres(clienteEntidad.getNombres())
                .conApellidos(clienteEntidad.getApellidos())
                .conDetalleCitas(clienteEntidad.getLstDetalleCita())
                .build();
    }

    public static List<Cliente> mapToLStClienteModelo(List<ClienteEntidad> clientes) {
        return clientes.stream().map(TransformadorCliente::mapToClienteModelo).collect(Collectors.toList());
    }

    public static ClienteEntidad mapToClienteEntidad(Cliente cliente) {
        return ClienteEntidad.builder()
                .idCliente(cliente.getIdCliente())
                .nombres(cliente.getNombres())
                .apellidos(cliente.getApellidos())
                .lstDetalleCita(new ArrayList<>())
                .build();
    }
}
