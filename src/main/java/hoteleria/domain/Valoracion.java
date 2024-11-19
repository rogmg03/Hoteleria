package hoteleria.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "valoracion")
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idValoracion;
    private Long idUsuario;
    private Long idHabitacion;
    private int calificacion;
    private String comentarios;
    private Date fecha;
    private boolean activo;

   
    
}
