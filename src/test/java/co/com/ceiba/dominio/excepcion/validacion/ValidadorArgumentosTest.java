package co.com.ceiba.dominio.excepcion.validacion;

import co.com.ceiba.dominio.excepcion.ValorObligatorioExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class ValidadorArgumentosTest {

    @Test
    public void validarObligatorioNombreVacio() {
        String nombresPrueba = "";
        try {
            ValidadorArgumentos.validarObligatorio(nombresPrueba, Cliente.SE_DEBE_INGRESAR_LOS_NOMBRES);
        } catch (Exception error) {
            Assert.assertTrue(error instanceof ValorObligatorioExcepcion);
            Assert.assertEquals(Cliente.SE_DEBE_INGRESAR_LOS_NOMBRES, error.getMessage());
        }
    }

    @Test
    public void validarObligatorioNombreNoExiste() {
        try {
            ValidadorArgumentos.validarObligatorio(null, Cliente.SE_DEBE_INGRESAR_LOS_NOMBRES);
        } catch (Exception error) {
            Assert.assertTrue(error instanceof ValorObligatorioExcepcion);
            Assert.assertEquals(Cliente.SE_DEBE_INGRESAR_LOS_NOMBRES, error.getMessage());
        }
    }
}
