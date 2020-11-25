package co.com.ceiba.infraestructura.utilidades;

import co.com.ceiba.dominio.excepcion.CitaExcepcion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RunWith(SpringRunner.class)
public class FormatearFechaTest {

    private static final String ERROR_FORMATEANDO_FECHA = "Ocurrio un error formateando la fecha";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void transformarStringToDateTest() throws ParseException {
        Date fechaEsperada = sdformat.parse("26/09/2020");
        String fechaPrueba = "26/09/2020";

        Date resultado = FormatearFecha.transformarStringToDate(fechaPrueba);
        Assert.assertEquals(resultado, fechaEsperada);
    }

    @Test
    public void transformarStringToDateErrorTest() {
        String fechaPrueba = "2020-05-21T00:00:00.000-05:00";

        try {
            FormatearFecha.transformarStringToDate(fechaPrueba);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof CitaExcepcion);
            Assert.assertEquals(ERROR_FORMATEANDO_FECHA, e.getMessage());

        }
    }

    @Test
    public void transformarDateToLocalDateTest() throws ParseException {
        LocalDate fechaEsperada = LocalDate.parse("27/09/2020", formatter);
        Date fecha = sdformat.parse("27/09/2020");


        LocalDate resultado = FormatearFecha.transformarDateToLocalDate(fecha);

        Assert.assertEquals(fechaEsperada, resultado);

    }

}
