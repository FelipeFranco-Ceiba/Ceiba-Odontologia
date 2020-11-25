package co.com.ceiba.dominio.excepcion.validacion;

import co.com.ceiba.dominio.excepcion.ValorObligatorioExcepcion;

public final class ValidadorArgumentos {

    private ValidadorArgumentos() { }

    public static void validarObligatorio(Object argumento, String mensajeError) {
        if (argumento == null || "".equals(argumento)) {
            throw new ValorObligatorioExcepcion(mensajeError);
        }
    }
}
