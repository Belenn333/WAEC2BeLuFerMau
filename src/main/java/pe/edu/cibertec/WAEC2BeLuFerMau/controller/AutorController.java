package pe.edu.cibertec.WAEC2BeLuFerMau.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.WAEC2BeLuFerMau.model.bd.Autor;
import pe.edu.cibertec.WAEC2BeLuFerMau.service.IAutorService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/autor")
public class AutorController {
    private IAutorService IAutorService;

    @GetMapping("/list")
    public String listarAutor(Model model){
        model.addAttribute("generos",
                IAutorService.listarAutor());
        return "formautores";
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Autor> listAutor(){
        return IAutorService.listarAutor();
    }
}
