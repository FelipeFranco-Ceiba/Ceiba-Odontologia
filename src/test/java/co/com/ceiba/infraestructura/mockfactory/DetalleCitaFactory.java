package co.com.ceiba.infraestructura.mockfactory;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.aplicacion.comando.ComandoOdontologo;

public class DetalleCitaFactory {

    private static final Long ID_DETALLE_CITA = 2L;
    private static final String FECHA_CITA = "15/08/2020";
    private static final Long HORA_CITA = 3L;
    private static final Long VALOR_CITA = 35000L;

    public ComandoDetalleCita buildComando() {
        ComandoOdontologo comandoOdontologo = new OdontologoFactory().buildComando();
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        ComandoLogin comandoLogin = new LoginFactory().buildComando();
        return ComandoDetalleCita.builder()
                .conIdDetalleCita(ID_DETALLE_CITA)
                .conFechaCita(FECHA_CITA)
                .conValorCita(VALOR_CITA)
                .conHoraCita(HORA_CITA)
                .conOdontologo(comandoOdontologo)
                .conCliente(comandoCliente)
                .conLogin(comandoLogin)
                .build();
    }

    public ComandoDetalleCita buildComando(Long idDetalleCita, Long idOdontologo, Long idCliente, Long idLogin, Long horaCita) {
        ComandoOdontologo comandoOdontologo = new OdontologoFactory().buildComando();
        comandoOdontologo.setIdOdontologo(idOdontologo);
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        comandoCliente.setIdCliente(idCliente);
        ComandoLogin comandoLogin = new LoginFactory().buildComando();
        comandoLogin.setIdLogin(idLogin);
        return ComandoDetalleCita.builder()
                .conIdDetalleCita(idDetalleCita)
                .conFechaCita(FECHA_CITA)
                .conValorCita(VALOR_CITA)
                .conHoraCita(horaCita)
                .conOdontologo(comandoOdontologo)
                .conCliente(comandoCliente)
                .conLogin(comandoLogin)
                .build();
    }
}
