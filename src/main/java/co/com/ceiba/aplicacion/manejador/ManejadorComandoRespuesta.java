package co.com.ceiba.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoRespuesta<R, T> {

    @Transactional
    R ejecutar(T comando);
}
