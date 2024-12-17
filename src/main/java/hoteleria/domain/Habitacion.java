package hoteleria.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;
    //private Long idHotel;
    private int numero;
    private int piso;
    private String tipo;
    private double precio;
    private boolean disponible;
    private String rutaImagen;
    private boolean activo;
    
   @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "idHotel", nullable = false)
    private Hotel hotel;
}
