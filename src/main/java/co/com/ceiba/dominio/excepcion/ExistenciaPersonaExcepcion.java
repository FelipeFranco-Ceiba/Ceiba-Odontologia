package co.com.ceiba.dominio.excepcion;

public class ExistenciaPersonaExcepcion extends RuntimeException {

    public ExistenciaPersonaExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
