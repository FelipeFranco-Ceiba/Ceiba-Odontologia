package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoDetalleCita;
import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.infraestructura.mockfactory.DetalleCitaFactory;
import co.com.ceiba.infraestructura.mockfactory.OdontologoFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration
@TestPropertySource("/test-application.properties")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorDetalleCitaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Long ID_DETALLE_CITA = 2L;
    private static final Long HORA_CITA = 3L;

    @Test
    public void consultaDetalleCita() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/detalleCita")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].valorCita").value(35000L));
    }

    @Test
    public void crearDetalleCita() throws Exception {
        Long idOdontologo = 1L;
        Long idCliente = 1L;
        Long idLogin = 1L;
        ComandoDetalleCita comandoDetalleCita = new DetalleCitaFactory().buildComando(ID_DETALLE_CITA, idOdontologo, idCliente, idLogin, HORA_CITA);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/detalleCita")
                .content(objectMapper.writeValueAsString(comandoDetalleCita))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/detalleCita")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].horaCita").value(3L));
    }

//    @Test
//    public void actualizarDetalleCita() throws Exception {
//        Long idDetalleCita = 3L;
//        Long idOdontologo = 1L;
//        Long idCliente = 1L;
//        Long idLogin = 1L;
//        Long horaCita = 4L;
//        ComandoDetalleCita comandoDetalleCita = new DetalleCitaFactory().buildComando(idDetalleCita, idOdontologo, idCliente, idLogin, horaCita);
//        mockMvc.perform(MockMvcRequestBuilders
//                .put("/detalleCita")
//                .content(objectMapper.writeValueAsString(comandoDetalleCita))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/detalleCita")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].horaCita").value(horaCita));
//    }
}