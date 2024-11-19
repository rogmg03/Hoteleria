package hoteleria.controller;

import hoteleria.domain.Reservas;
import hoteleria.services.ReservasService;
import hoteleria.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Reservas")
public class ReservasController {

    @Autowired
    private ReservasService ReservasService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = ReservasService.getReservaciones(false);
        model.addAttribute("Reservass", lista);
        model.addAttribute("totalReservass", lista.size());
        return "/Reservas/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String ReservasGuardar(Reservas Reservas) {
        ReservasService.save(Reservas);
        return "redirect:/Reservas/listado";
    }

    @GetMapping("/eliminar/{idReservas}")
    public String ReservasEliminar(Reservas Reservas) {
        ReservasService.delete(Reservas);
        return "redirect:/Reservas/listado";
    }

    @GetMapping("/modificar/{idReservas}")
    public String ReservasModificar(Reservas Reservas, Model model) {
        Reservas = ReservasService.getReservas(Reservas);
        model.addAttribute("Reservas", Reservas);
        return "/Reservas/modifica";
    }
}
