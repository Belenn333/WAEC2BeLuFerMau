package pe.edu.cibertec.WAEC2BeLuFerMau.service;

import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Publicacion;

import java.util.List;

public interface IPublicacionesService {
    List<Publicacion> listarPublicaciones();

    void regitrarPublicaciones(Publicacion publicaciones);
    void eliminarPublicaciones(Integer id);
}
