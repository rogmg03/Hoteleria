package hoteleria.controller;

import hoteleria.domain.Servicios;
import hoteleria.services.ServiciosService;
import hoteleria.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Servicios")
public class ServiciosController {

    @Autowired
    private ServiciosService ServiciosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = ServiciosService.getServicioss(false);
        model.addAttribute("Servicios", lista);
        model.addAttribute("totalServicios", lista.size());
        return "/Servicios/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String ServiciosGuardar(Servicios Servicios) {
        ServiciosService.save(Servicios);
        return "redirect:/Servicios/listado";
    }

    @GetMapping("/eliminar/{idServicios}")
    public String ServiciosEliminar(Servicios Servicios) {
        ServiciosService.delete(Servicios);
        return "redirect:/Servicios/listado";
    }

    @GetMapping("/modificar/{idServicios}")
    public String ServiciosModificar(Servicios Servicios, Model model) {
        Servicios = ServiciosService.getServicios(Servicios);
        model.addAttribute("Servicios", Servicios);
        return "/Servicios/modifica";
    }
}
