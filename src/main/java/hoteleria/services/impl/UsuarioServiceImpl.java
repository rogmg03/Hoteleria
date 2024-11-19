package hoteleria.services.impl;


import hoteleria.dao.RolDao;
import hoteleria.dao.UsuarioDao;
import hoteleria.domain.Usuario;
import hoteleria.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorCorreoYContrasena(String correo, String contrasena) {
        return usuarioDao.findByCorreoAndContrasena(correo, contrasena);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorCorreoOContrasena(String correo, String contrasena) {
        return usuarioDao.findByCorreoOrContrasena(correo, contrasena);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorCorreoOContrasena(String correo, String contrasena) {
        return usuarioDao.existsByCorreoOrContrasena(correo, contrasena);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public void save(Usuario usuario, boolean crearRolUser) {
        usuarioDao.save(usuario);
    }
}
