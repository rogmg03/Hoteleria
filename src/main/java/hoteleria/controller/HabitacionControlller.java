package hoteleria.controller;

import hoteleria.domain.Habitacion;
import hoteleria.services.HabitacionService;
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
@RequestMapping("/Habitacion")
public class HabitacionControlller {

@Autowired
    private HabitacionService HabitacionService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = HabitacionService.getHabitaciones(false);
        model.addAttribute("Habitaciones", lista);
        model.addAttribute("totalHabitaciones", lista.size());
        return "/Habitacion/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String HabitacionGuardar(Habitacion Habitacion,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            HabitacionService.save(Habitacion);
            Habitacion.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "Habitacion",
                            Habitacion.getIdHabitacion()));
        }
        HabitacionService.save(Habitacion);
        return "redirect:/Habitacion/listado";
    }

    @GetMapping("/eliminar/{idHabitacion}")
    public String HabitacionEliminar(Habitacion Habitacion) {
        HabitacionService.delete(Habitacion);
        return "redirect:/Habitacion/listado";
    }

    @GetMapping("/modificar/{idHabitacion}")
    public String HabitacionModificar(Habitacion Habitacion, Model model) {
        Habitacion = HabitacionService.getHabitacion(Habitacion);
        model.addAttribute("Habitacion", Habitacion);
        return "/Habitacion/modifica";
    }
}
