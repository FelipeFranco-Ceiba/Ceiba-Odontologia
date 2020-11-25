package co.com.ceiba.infraestructura.mockfactory;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;
import co.com.ceiba.infraestructura.utilidades.FormatearFecha;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OdontologoFactory {

    private static final String FORMATO = "dd/MM/yyyy";
    private static final String FECHA_INGRESO_ODONTOLOGO = "15/08/2020";

    private static final Long ID_ODONTOLOGO = 2L;
    private static final String NOMBRES = "Felipe";
    private static final String APPELLIDOS = "Franco";
    private static final Boolean ESTADO = true;
    private static final List<DetalleCitaEntidad> DETALLE_CITAS = new ArrayList<>();

    private Long    idOdontologo;
    private String  nombres;
    private String  apellidos;
    private Date fechaIngreso;
    private Boolean  estado;
    private List<DetalleCitaEntidad> detalleCitas;


    public ComandoOdontologo buildComando() {
        return new ComandoOdontologo(ID_ODONTOLOGO, NOMBRES, APPELLIDOS, FECHA_INGRESO_ODONTOLOGO, ESTADO);
    }

    public ComandoOdontologo buildComando(Long idOdontologo, String nombres, String apellidos, String fechaIngreso, Boolean estado) {
        return new ComandoOdontologo(idOdontologo, nombres, apellidos, fechaIngreso, estado);
    }

    public Odontologo buildOdontologo() {
        return Odontologo.builder()
            .conIdOdontologo(ID_ODONTOLOGO)
            .conNombres(NOMBRES)
            .conApellidos(APPELLIDOS)
            .conFechaIngreso(FormatearFecha.transformarStringToDate(FECHA_INGRESO_ODONTOLOGO))
            .conEstado(ESTADO)
            .conDetalleCitas(null)
            .build();
    }
}
