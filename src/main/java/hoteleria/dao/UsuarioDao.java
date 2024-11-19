package hoteleria.dao;

import hoteleria.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao
        extends JpaRepository<Usuario, Long> {

    public Usuario findByCorreo(String correo);

    Usuario findByCorreoAndContrasena(String correo, String Contrasena);

    Usuario findByCorreoOrContrasena(String correo, String Contrasena);

    boolean existsByCorreoOrContrasena(String correo, String Contrasena);
}
