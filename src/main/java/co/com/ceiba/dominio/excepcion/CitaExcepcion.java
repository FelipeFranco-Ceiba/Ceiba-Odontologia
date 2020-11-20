package co.com.ceiba.dominio.excepcion;

public class CitaExcepcion extends RuntimeException {

    public CitaExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
