
package hoteleria.services;

import hoteleria.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    // Se obtiene un listado de usuarios en un List
    public List<Usuario> getUsuarios();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuario getUsuario(Usuario usuario);
    
    // Se obtiene un Usuario, a partir del correo de un usuario
    public Usuario getUsuarioPorCorreo(String correo);

    // Se obtiene un Usuario, a partir del correo y el contrasena de un usuario
    public Usuario getUsuarioPorCorreoYContrasena(String correo, String contrasena);
    
    // Se obtiene un Usuario, a partir del correo y el contrasena de un usuario
    public Usuario getUsuarioPorCorreoOContrasena(String correo, String contrasena);
    
    // Se valida si existe un Usuario considerando el correo
    public boolean existeUsuarioPorCorreoOContrasena(String correo, String contrasena);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Usuario usuario,boolean crearRolUser);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuario usuario);
}
