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

    public static Cliente mapToClienteModeloSinListaDetalle(ClienteEntidad clienteEntidad) {
        return Cliente.builder()
                .conIdCliente(clienteEntidad.getIdCliente())
                .conNombres(clienteEntidad.getNombres())
                .conApellidos(clienteEntidad.getApellidos())
                .build();
    }

    public static List<Cliente> mapToLstClienteModelo(List<ClienteEntidad> clientes) {
        return clientes.stream().map(TransformadorCliente::mapToClienteModelo).collect(Collectors.toList());
    }

    public static ClienteEntidad mapToClienteEntidad(Cliente cliente) {
        return new ClienteEntidad(
                cliente.getIdCliente(),
                cliente.getNombres(),
                cliente.getApellidos(),
                new ArrayList<>());
    }
}
