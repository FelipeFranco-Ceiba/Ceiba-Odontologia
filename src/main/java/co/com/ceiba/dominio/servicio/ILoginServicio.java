package co.com.ceiba.dominio.servicio;

public interface ILoginServicio<T> {

    T crearLogin(T login);

    T login(T login);
}
