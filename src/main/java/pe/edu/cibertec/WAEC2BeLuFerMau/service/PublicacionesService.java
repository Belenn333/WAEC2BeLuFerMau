package pe.edu.cibertec.WAEC2BeLuFerMau.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Publicacion;
import pe.edu.cibertec.WAEC2BeLuFerMau.repository.PublicacionesRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PublicacionesService implements IPublicacionesService{
    private PublicacionesRepository PublicacionesRepository;
    @Override
    public List<Publicacion> listarPublicaciones() {
        return PublicacionesRepository.findAll();
    }

    @Override
    public void regitrarPublicaciones(Publicacion publicaciones) {
        PublicacionesRepository.save(publicaciones);
    }
    @Override
    public void eliminarPublicaciones(Integer id) {
        PublicacionesRepository.deleteById(id);
    }
}
