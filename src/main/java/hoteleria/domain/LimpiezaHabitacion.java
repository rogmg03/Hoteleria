package hoteleria.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "limpieza_habitacion")
public class LimpiezaHabitacion implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLimpieza;
    private Long idUsuario;
    private Long idHabitacion;
    private Date fecha;
    private String comentario;
    private boolean activo;

}
