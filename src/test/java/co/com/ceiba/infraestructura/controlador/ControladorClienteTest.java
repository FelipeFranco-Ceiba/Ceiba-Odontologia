package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoCliente;
import co.com.ceiba.aplicacion.comando.ComandoOdontologo;
import co.com.ceiba.infraestructura.mockfactory.ClienteFactory;
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
public class ControladorClienteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Long ID_CLIENTE = 3L;
    private static final String APPELLIDOS = "Franco";

    @Test
    public void consultaClientes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/cliente")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].nombres").value("LA MOSA"));
    }

    @Test
    public void crearCliente() throws Exception {
        ComandoCliente comandoCliente = new ClienteFactory().buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/cliente")
                .content(objectMapper.writeValueAsString(comandoCliente))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/cliente")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2].apellidos").value("Prueba"));
    }

    @Test
    public void actualizarCliente() throws Exception {
        String nombres = "Prueba cambio nombre";
        ComandoCliente comandoCliente = new ClienteFactory().buildComando(ID_CLIENTE, nombres, APPELLIDOS);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/cliente")
                .content(objectMapper.writeValueAsString(comandoCliente))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/cliente")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].nombres").value(nombres));
    }

    @Test
    public void eliminarOdontolos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/cliente/{idCliente}", 1))
                .andExpect(status().isOk());
    }
}
