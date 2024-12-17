package hoteleria.controller;

import hoteleria.domain.Habitacion;
import hoteleria.domain.Hotel;
import hoteleria.services.HabitacionService;
import hoteleria.services.HotelService;
import hoteleria.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionControlller {

@Autowired
    private HabitacionService HabitacionService;
@Autowired
    private HotelService HotelService;

//@Autowired
//    private Habitacion Habitacion;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = HabitacionService.getHabitaciones(false);
        var lista2 = HotelService.getHoteles(false);
        model.addAttribute("Habitaciones", lista);
        model.addAttribute("totalHabitaciones", lista.size());
        model.addAttribute("Hoteles", lista2);
        return "/habitaciones/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String HabitacionGuardar(Habitacion Habitacion,
            @RequestParam("imagenFile") MultipartFile imagenFile,  @RequestParam("idHotel") Long idHotel) {
        Hotel hotel = HotelService.findById(idHotel);
        if (!imagenFile.isEmpty()) {
            Habitacion.setHotel(hotel);
            HabitacionService.save(Habitacion);
            Habitacion.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "Habitacion",
                            Habitacion.getIdHabitacion()));
        }
        HabitacionService.save(Habitacion);
        return "redirect:/habitaciones/listado";
    }

    @GetMapping("/eliminar/{idHabitacion}")
    public String HabitacionEliminar(Habitacion Habitacion) {
        HabitacionService.delete(Habitacion);
        return "redirect:/habitaciones/listado";
    }

    @GetMapping("/modificar/{idHabitacion}")
    public String HabitacionModificar(Habitacion Habitacion, Model model) {
        Habitacion = HabitacionService.getHabitacion(Habitacion);
        model.addAttribute("Habitacion", Habitacion);
        return "/habitaciones/modifica";
    }
    
    @GetMapping("/listado2/{idHotel}")
        public String HotelHabitacion(@PathVariable Long idHotel, Model model) {
        var habitacionUnica = HabitacionService.findByIdHotel(idHotel);
        //model.addAttribute("Habitaciones", Habitacion);
        model.addAttribute("Habitaciones", habitacionUnica);
        model.addAttribute("IdHotel", idHotel);
        return "habitaciones/listado2";
    }
}
