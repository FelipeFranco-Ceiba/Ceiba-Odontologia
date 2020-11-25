package co.com.ceiba.dominio.excepcion;

public class ValorObligatorioExcepcion extends RuntimeException {

    public ValorObligatorioExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
