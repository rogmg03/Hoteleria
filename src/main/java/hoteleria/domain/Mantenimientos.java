package hoteleria.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "mantenimientos")
public class Mantenimientos implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMantenimiento;
    private Long idUsuario;
    
    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "idHabitacion")
    private Habitacion habitacion;
    
    private String descripcion;
    private Date fecha;
    private double costo;
    private boolean activo;

}
