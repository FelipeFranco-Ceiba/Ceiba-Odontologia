package co.com.ceiba.dominio.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class Login {

    private Long idLogin;
    private String usuario;
    private String clave;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return idLogin.equals(login.idLogin) &&
                Objects.equals(usuario, login.usuario) &&
                Objects.equals(clave, login.clave);
    }
}
