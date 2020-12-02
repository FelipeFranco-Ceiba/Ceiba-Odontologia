package co.com.ceiba.dominio.modelo.entidad;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

import static co.com.ceiba.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Getter
@Builder(setterPrefix = "con")
public class Login {

    public static final String SE_DEBE_INGRESAR_EL_USUARIO = "Se debe ingresar el usuario";
    public static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";

    private Long idLogin;
    private String usuario;
    private String clave;

    public Login(Long idLogin, String usuario, String clave) {
        validarObligatorio(usuario, SE_DEBE_INGRESAR_EL_USUARIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);

        this.idLogin = idLogin;
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Login login = (Login) o;
        return idLogin.equals(login.idLogin) &&
                Objects.equals(usuario, login.usuario) &&
                Objects.equals(clave, login.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLogin, usuario, clave);
    }
}
