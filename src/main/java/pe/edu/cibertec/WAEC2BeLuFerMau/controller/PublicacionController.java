package pe.edu.cibertec.WAEC2BeLuFerMau.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Autor;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Publicacion;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.dto.request.PublicacionRequest;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.dto.response.PublicacionResponse;
import pe.edu.cibertec.WAEC2BeLuFerMau.service.IPublicacionesService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/publicacion")
public class PublicacionController {
    private IPublicacionesService IPublicacionesService;

    @GetMapping("")
    public String listarPublicaciones(Model model){
        model.addAttribute("listarpublicaciones" ,
                IPublicacionesService.listarPublicaciones());
        return "formpublicaciones";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Publicacion> listPublicaciones(){
        return IPublicacionesService.listarPublicaciones();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public PublicacionResponse registrarPublicacion(@RequestBody PublicacionRequest publicacionRequest){
        String mensaje = "Publicacion registrada correctamente";
        boolean respuesta = true;
        try {
            Publicacion publicacion = new Publicacion();
            if(publicacionRequest.getIdpublicacion() > 0){
                publicacion.setIdpublicacion(publicacionRequest.getIdpublicacion());
            }
            publicacion.setTitulo(publicacionRequest.getTitulo());
            publicacion.setResumen(publicacionRequest.getResumen());
            publicacion.setFechpublicacion(publicacionRequest.getFechpublicacion());
            Autor autor = new Autor();
            autor.setIdautor(publicacionRequest.getAutor());
            publicacion.setAutor(autor);
            IPublicacionesService.regitrarPublicaciones(publicacion);
        }catch (Exception ex){
            mensaje = "Libro no registrado, error en la BD.";
            respuesta = false;
        }
        return PublicacionResponse.builder().mensaje(mensaje).respuesta(respuesta).build();

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public PublicacionResponse eliminarPublicacion(@PathVariable("id") Integer id) {
        String mensaje = "Pelicula eliminada correctamente";
        boolean respuesta = true;
        try {
            IPublicacionesService.eliminarPublicaciones(id);
        } catch (Exception ex) {
            mensaje = "Error al eliminar la película";
            respuesta = false;
        }
        return PublicacionResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
