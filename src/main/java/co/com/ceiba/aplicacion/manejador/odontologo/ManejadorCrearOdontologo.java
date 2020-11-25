package co.com.ceiba.aplicacion.manejador.odontologo;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.aplicacion.fabrica.FabricaOdontologo;
import co.com.ceiba.aplicacion.manejador.ManejadorComandoRespuesta;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.dominio.servicio.IOdontologoServicio;
import co.com.ceiba.dominio.servicio.odontologo.CrearOdontologoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorCrearOdontologo implements ManejadorComandoRespuesta<Odontologo, ComandoOdontologo> {

    private final CrearOdontologoServicio crearOdontologoServicio;

    @Override
    public Odontologo ejecutar(ComandoOdontologo comando) {
        Odontologo odontologo = FabricaOdontologo.crearOdontologo(comando);
        return this.crearOdontologoServicio.crearOdontologo(odontologo);
    }
}
