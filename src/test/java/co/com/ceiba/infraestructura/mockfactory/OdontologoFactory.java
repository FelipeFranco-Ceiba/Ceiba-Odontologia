package co.com.ceiba.infraestructura.mockfactory;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.dominio.modelo.entidad.Odontologo;
import co.com.ceiba.infraestructura.modelo.entidad.DetalleCitaEntidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public OdontologoFactory() throws ParseException {
        this.idOdontologo = ID_ODONTOLOGO;
        this.nombres = NOMBRES;
        this.apellidos = APPELLIDOS;
        this.fechaIngreso = new SimpleDateFormat(FORMATO).parse(FECHA_INGRESO_ODONTOLOGO);
        this.estado = ESTADO;
        this.detalleCitas = DETALLE_CITAS;
    }

    public OdontologoFactory conEstado(Boolean estado) {
        this.estado = estado;
        return this;
    }

    public Odontologo build() throws ParseException {
        return new Odontologo(ID_ODONTOLOGO, NOMBRES, APPELLIDOS,  new SimpleDateFormat(FORMATO).parse(FECHA_INGRESO_ODONTOLOGO), ESTADO, DETALLE_CITAS);
    }

    public ComandoOdontologo buildComando() {
        return new ComandoOdontologo(ID_ODONTOLOGO, NOMBRES, APPELLIDOS, FECHA_INGRESO_ODONTOLOGO, ESTADO);
    }

    public ComandoOdontologo buildComando(Long idOdontologo, String nombres, String apellidos, String fechaIngreso, Boolean estado) {
        return new ComandoOdontologo(idOdontologo, nombres, apellidos, fechaIngreso, estado);
    }
}
