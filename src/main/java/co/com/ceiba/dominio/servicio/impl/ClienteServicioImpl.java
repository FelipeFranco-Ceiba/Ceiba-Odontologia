package co.com.ceiba.dominio.servicio.impl;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import co.com.ceiba.dominio.servicio.IClienteServicio;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioCliente;
import co.com.ceiba.infraestructura.adaptador.transformador.TransformadorCliente;
import co.com.ceiba.infraestructura.modelo.entidad.ClienteEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServicioImpl implements IClienteServicio<Cliente> {

    private final IRepositorioCliente repositorioCliente;

    @Override
    public List<Cliente> consultarCliente() {
        return TransformadorCliente.mapToLstClienteModelo(repositorioCliente.findAll());
    }

    @Transactional
    @Override
    public Cliente crearOActualizarCliente(Cliente cliente) {
        ClienteEntidad clienteEntidad = TransformadorCliente.mapToClienteEntidad(cliente);
        return TransformadorCliente.mapToClienteModelo(repositorioCliente.saveAndFlush(clienteEntidad));
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        existeCliente(cliente.getIdCliente());
        return crearOActualizarCliente(cliente);
    }

    @Transactional
    @Override
    public void eliminarCliente(Long idCliente) {
        existeCliente(idCliente);
        repositorioCliente.deleteByIdCliente(idCliente);
    }

    private void existeCliente(Long idCliente) {
        Boolean existeCliente = repositorioCliente.existsByIdCliente(idCliente);
        if (!existeCliente)
            throw new CitaExcepcion("No existe el cliente");
    }
}
