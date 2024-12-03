package hoteleria.controller;

import hoteleria.domain.LimpiezaHabitacion;
import hoteleria.services.LimpiezaHabitacionService;
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
@RequestMapping("/limpiezas")
public class LimpiezaHabitacionController {

    @Autowired
    private LimpiezaHabitacionService LimpiezaHabitacionService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = LimpiezaHabitacionService.getLimpiezaHabitaciones(false);
        model.addAttribute("LimpiezaLimpiezaHabitaciones", lista);
        model.addAttribute("totalLimpiezaLimpiezaHabitaciones", lista.size());
        return "/limpiezas/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String LimpiezaHabitacionGuardar(LimpiezaHabitacion LimpiezaHabitacion) {
        LimpiezaHabitacionService.save(LimpiezaHabitacion);
        return "redirect:/limpiezas/listado";
    }

    @GetMapping("/eliminar/{idLimpiezaHabitacion}")
    public String LimpiezaHabitacionEliminar(LimpiezaHabitacion LimpiezaHabitacion) {
        LimpiezaHabitacionService.delete(LimpiezaHabitacion);
        return "redirect:/limpiezas/listado";
    }

    @GetMapping("/modificar/{idLimpiezaHabitacion}")
    public String LimpiezaHabitacionModificar(LimpiezaHabitacion LimpiezaHabitacion, Model model) {
        LimpiezaHabitacion = LimpiezaHabitacionService.getLimpiezaHabitacion(LimpiezaHabitacion);
        model.addAttribute("LimpiezaHabitacion", LimpiezaHabitacion);
        return "/limpiezas/modifica";
    }
}
