package hoteleria.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private Long idUsuario;
    private Long idHabitacion;
    private Date fechaInicio;
    private Date fechaFin;
    private double total;
    private boolean activo;

}
