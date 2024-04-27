package pe.edu.cibertec.WAEC2BeLuFerMau.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpublicacion")
    private int idpublicacion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "fechpublicacion")
    private Date fechpublicacion;
    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;
}
