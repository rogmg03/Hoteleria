package hoteleria.controller;

import hoteleria.domain.Hotel;
import hoteleria.services.HotelService;
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
@RequestMapping("/Hotel")
public class HotelController {

    @Autowired
    private HotelService HotelService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = HotelService.getHoteles(false);
        model.addAttribute("Hoteles", lista);
        model.addAttribute("totalHoteles", lista.size());
        return "/Hotel/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String HotelGuardar(Hotel Hotel,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            HotelService.save(Hotel);
            Hotel.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "Hotel",
                            Hotel.getIdHotel()));
        }
        HotelService.save(Hotel);
        return "redirect:/Hotel/listado";
    }

    @GetMapping("/eliminar/{idHotel}")
    public String HotelEliminar(Hotel Hotel) {
        HotelService.delete(Hotel);
        return "redirect:/Hotel/listado";
    }

    @GetMapping("/modificar/{idHotel}")
    public String HotelModificar(Hotel Hotel, Model model) {
        Hotel = HotelService.getHotel(Hotel);
        model.addAttribute("Hotel", Hotel);
        return "/Hotel/modifica";
    }
}
