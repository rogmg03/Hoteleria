package hoteleria.controller;

import hoteleria.domain.Usuario;
import hoteleria.services.UsuarioService;
import hoteleria.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService UsuarioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = UsuarioService.getUsuarios();
        model.addAttribute("Usuarios", lista);
        model.addAttribute("totalUsuarios", lista.size());
        return "/usuario/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String UsuarioGuardar(Usuario Usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            UsuarioService.save(Usuario,false);
            Usuario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "Usuario",
                            Usuario.getIdUsuario()));
        }
        UsuarioService.save(Usuario,false);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String UsuarioEliminar(Usuario Usuario) {
        UsuarioService.delete(Usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String UsuarioModificar(Usuario Usuario, Model model) {
        Usuario = UsuarioService.getUsuario(Usuario);
        model.addAttribute("Usuario", Usuario);
        return "/usuario/modifica";
    }
    
    

    
    
}
