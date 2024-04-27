package pe.edu.cibertec.WAEC2BeLuFerMau.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idautor")
    private int idautor;
    @Column(name = "nomautor")
    private String nomautor;
    @Column(name = "apeautor")
    private String apeautor;
    @Column(name = "fechnacautor")
    private Date fechnacautor;
}
