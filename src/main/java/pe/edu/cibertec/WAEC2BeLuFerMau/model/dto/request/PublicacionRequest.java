package pe.edu.cibertec.WAEC2BeLuFerMau.model.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Autor;

import java.sql.Date;

@Data
public class PublicacionRequest {
    private Integer idpublicacion;
    private String titulo;
    private String resumen;
    private Date fechpublicacion;
    private Integer autor;
}
