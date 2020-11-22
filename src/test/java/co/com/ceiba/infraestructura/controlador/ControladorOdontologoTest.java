package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
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
public class ControladorOdontologoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Long ID_ODONTOLOGO = 2L;
    private static final String NOMBRES = "Felipe";
    private static final String APPELLIDOS = "Franco";
    private static final String FECHA_INGRESO = "15/06/2020";
    private static final Boolean ESTADO = true;

    @Test
    public void consultaOdontolos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        .get("/odontologo")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].nombres").value("FELIPE"));
    }

    @Test
    public void crearOdontolos() throws Exception {
        ComandoOdontologo comandoOdontologo = new OdontologoFactory().buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/odontologo")
                .content(objectMapper.writeValueAsString(comandoOdontologo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/odontologo")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].apellidos").value("Franco"));
    }

    @Test
    public void actualizarOdontologo() throws Exception {
        Boolean estadoActualizado = false;
        ComandoOdontologo coandoOdontologo = new OdontologoFactory().buildComando(ID_ODONTOLOGO, NOMBRES, APPELLIDOS, FECHA_INGRESO, estadoActualizado);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/odontologo")
                .content(objectMapper.writeValueAsString(coandoOdontologo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/odontologo")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].estado").value(false));
    }

    @Test
    public void actualizarOdontologoErrorFormatoFecha() throws Exception {
        String FECHA_INGRESO = "2020-11-19T05:00:00.000+00:00";
        ComandoOdontologo coandoOdontologo = new OdontologoFactory().buildComando(ID_ODONTOLOGO, NOMBRES, APPELLIDOS, FECHA_INGRESO, ESTADO);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/odontologo")
                .content(objectMapper.writeValueAsString(coandoOdontologo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void eliminarOdontolos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/odontologo/{idOdontologo}", 1))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/odontologo")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].estado").value(false));
    }

}
