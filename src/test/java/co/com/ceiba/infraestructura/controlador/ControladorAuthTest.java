package co.com.ceiba.infraestructura.controlador;

import co.com.ceiba.aplicacion.comando.ComandoLogin;
import co.com.ceiba.infraestructura.mockfactory.LoginFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration
@TestPropertySource("/test-application.properties")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorAuthTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Long ID_LOGIN = 2L;
    private static final String USUARIO = "Cliente";
    private static final String CLAVE = "Prueba";

    @Test
    public void crearUsuario() throws Exception {
        ComandoLogin comandoLogin = new LoginFactory().buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/login")
                .content(objectMapper.writeValueAsString(comandoLogin))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void crearUsuarioYaExistente() throws Exception {
        ComandoLogin comandoLogin = new LoginFactory().buildComando(ID_LOGIN, USUARIO, CLAVE);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/login")
                .content(objectMapper.writeValueAsString(comandoLogin))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> Assert.assertEquals("Ya existe un usuario con este mismo usuario, por favor ingresa uno diferente", result.getResolvedException().getMessage()));
    }

    @Test
    public void iniciarSesion() throws Exception {
        ComandoLogin comandoLogin = new LoginFactory().buildComando(ID_LOGIN, USUARIO, CLAVE);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/login/inicio")
                .content(objectMapper.writeValueAsString(comandoLogin))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void iniciarSesionUsuarioIncorrecto() throws Exception {
        String usuarioIncorrecto = "usuario incorrecto";
        ComandoLogin comandoLogin = new LoginFactory().buildComando(ID_LOGIN, usuarioIncorrecto, CLAVE);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/login/inicio")
                .content(objectMapper.writeValueAsString(comandoLogin))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> Assert.assertEquals("Usuario o Clave incorrecta", result.getResolvedException().getMessage()));
    }
}
