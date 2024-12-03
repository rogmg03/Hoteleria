package hoteleria.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String email;
    private String rutaImagen;
    private boolean activo;

    
}

