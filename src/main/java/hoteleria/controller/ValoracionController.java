package hoteleria.controller;

import hoteleria.domain.Valoracion;
import hoteleria.services.ValoracionService;
import hoteleria.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/valoraciones")
public class ValoracionController {

    @Autowired
    private ValoracionService ValoracionService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = ValoracionService.getValoraciones(false);
        model.addAttribute("Valoraciones", lista);
        model.addAttribute("totalValoraciones", lista.size());
        return "/valoraciones/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String ValoracionGuardar(Valoracion Valoracion) {
        ValoracionService.save(Valoracion);
        return "redirect:/valoraciones/listado";
    }

    @GetMapping("/eliminar/{idValoracion}")
    public String ValoracionEliminar(Valoracion Valoracion) {
        ValoracionService.delete(Valoracion);
        return "redirect:/valoraciones/listado";
    }

    @GetMapping("/modificar/{idValoracion}")
    public String ValoracionModificar(Valoracion Valoracion, Model model) {
        Valoracion = ValoracionService.getValoracion(Valoracion);
        model.addAttribute("Valoracion", Valoracion);
        return "/valoraciones/modifica";
    }
}
