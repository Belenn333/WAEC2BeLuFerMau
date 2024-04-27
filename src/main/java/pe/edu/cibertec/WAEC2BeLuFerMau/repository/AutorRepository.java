package pe.edu.cibertec.WAEC2BeLuFerMau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Autor;
@Repository
public interface AutorRepository  extends JpaRepository<Autor, Integer> {
}
