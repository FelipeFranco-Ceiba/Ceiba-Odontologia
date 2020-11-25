package co.com.ceiba.aplicacion.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.dominio.modelo.entidad.DetalleCita;
import co.com.ceiba.infraestructura.utilidades.FormatearFecha;

public final class FabricaDetalleCita {

    private FabricaDetalleCita() { }

    public static DetalleCita crearDetalleCita(ComandoDetalleCita comandoDetalleCita) {
        return DetalleCita.builder()
                .conIdDetalleCita(comandoDetalleCita.getIdDetalleCita())
                .conFechaCita(FormatearFecha.transformarStringToDate(comandoDetalleCita.getFechaCita()))
                .conHoraCita(comandoDetalleCita.getHoraCita())
                .conValorCita(comandoDetalleCita.getValorCita())
                .conOdontologo(FabricaOdontologo.crearOdontologo(comandoDetalleCita.getOdontologo()))
                .conCliente(FabricaCliente.crearCliente(comandoDetalleCita.getCliente()))
                .conLogin(FabricarLogin.crearLogin(comandoDetalleCita.getLogin()))
                .build();
    }
}
