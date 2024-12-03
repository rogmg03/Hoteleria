package hoteleria.controller;

import hoteleria.domain.Mantenimientos;
import hoteleria.services.LimpiezaHabitacionService;
import hoteleria.services.MantenimientosService;
import hoteleria.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mantenimientos")
public class MantenimientosController {

    @Autowired
    private MantenimientosService MantenimientosService;
    
    @Autowired
    private LimpiezaHabitacionService LimpiezaHabitacionService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = MantenimientosService.getMantenimientoss(false);
        model.addAttribute("Mantenimientos", lista);
        model.addAttribute("totalMantenimientos", lista.size());
        var lista2 = LimpiezaHabitacionService.getLimpiezaHabitaciones(false);
        model.addAttribute("Limpiezas", lista2);
        model.addAttribute("totalLimpiezas", lista2.size());
        return "/mantenimientos/listado";
    }
/*
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = LimpiezaHabitacionService.getLimpiezaHabitaciones(false);
        model.addAttribute("LimpiezaLimpiezaHabitaciones", lista);
        model.addAttribute("totalLimpiezaLimpiezaHabitaciones", lista.size());
        return "/limpieza/listado";
    }
  */  
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    
    @PostMapping("/guardar")
    public String MantenimientosGuardar(Mantenimientos Mantenimientos) {
        MantenimientosService.save(Mantenimientos);
        return "redirect:/mantenimientos/listado";
    }

    @GetMapping("/eliminar/{idMantenimientos}")
    public String MantenimientosEliminar(Mantenimientos Mantenimientos) {
        MantenimientosService.delete(Mantenimientos);
        return "redirect:/mantenimientos/listado";
    }

    @GetMapping("/modificar/{idMantenimientos}")
    public String MantenimientosModificar(Mantenimientos Mantenimientos, Model model) {
        Mantenimientos = MantenimientosService.getMantenimientos(Mantenimientos);
        model.addAttribute("Mantenimientos", Mantenimientos);
        return "/mantenimientos/modifica";
    }
}
