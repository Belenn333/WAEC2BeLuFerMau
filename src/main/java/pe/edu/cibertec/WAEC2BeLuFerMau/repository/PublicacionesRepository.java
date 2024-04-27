package pe.edu.cibertec.WAEC2BeLuFerMau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Publicacion;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicacion, Integer> {
}
