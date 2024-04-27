package pe.edu.cibertec.WAEC2BeLuFerMau.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublicacionResponse {
    private Boolean respuesta;
    private String mensaje;
}
