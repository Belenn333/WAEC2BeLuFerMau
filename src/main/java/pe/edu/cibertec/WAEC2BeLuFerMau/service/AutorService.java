package pe.edu.cibertec.WAEC2BeLuFerMau.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Autor;
import pe.edu.cibertec.WAEC2BeLuFerMau.repository.AutorRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AutorService implements IAutorService{
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarAutor() {
        return autorRepository.findAll();
    }
}
