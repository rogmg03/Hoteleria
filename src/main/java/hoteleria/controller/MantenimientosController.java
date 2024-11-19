package hoteleria.controller;

import hoteleria.domain.Mantenimientos;
import hoteleria.services.MantenimientosService;
import hoteleria.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Mantenimientos")
public class MantenimientosController {

    @Autowired
    private MantenimientosService MantenimientosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = MantenimientosService.getMantenimientoss(false);
        model.addAttribute("Mantenimientoss", lista);
        model.addAttribute("totalMantenimientoss", lista.size());
        return "/Mantenimientos/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String MantenimientosGuardar(Mantenimientos Mantenimientos) {
        MantenimientosService.save(Mantenimientos);
        return "redirect:/Mantenimientos/listado";
    }

    @GetMapping("/eliminar/{idMantenimientos}")
    public String MantenimientosEliminar(Mantenimientos Mantenimientos) {
        MantenimientosService.delete(Mantenimientos);
        return "redirect:/Mantenimientos/listado";
    }

    @GetMapping("/modificar/{idMantenimientos}")
    public String MantenimientosModificar(Mantenimientos Mantenimientos, Model model) {
        Mantenimientos = MantenimientosService.getMantenimientos(Mantenimientos);
        model.addAttribute("Mantenimientos", Mantenimientos);
        return "/Mantenimientos/modifica";
    }
}
