package co.com.ceiba.dominio.excepcion.validacion;

import co.com.ceiba.dominio.excepcion.ValorObligatorioExcepcion;

public class ValidadorArgumentos {

    public static void validarObligatorio(Object argumento, String mensajeError) {
        if (argumento == null || argumento.equals("")) {
            throw new ValorObligatorioExcepcion(mensajeError);
        }
    }
}