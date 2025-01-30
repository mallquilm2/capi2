
package edu.cibertec.capitulo3.controller;

import edu.cibertec.capitulo3.service.CursoService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursoController {
    
    @Autowired
    private CursoService cursoService;
    
    @RequestMapping("cursoMostrar.do")
    public String cursoMostrar(){
        return "cursoBusqueda";
    }
    
    @RequestMapping("cursoBusqueda")
    public ModelAndView menuConsultas(@RequestParam("tipo") String tipo){
        ModelAndView mv = new ModelAndView("cursoBusqueda");
        
        switch (tipo) {
            case "estado":
                int estado = Integer.parseInt(tipo);
                mv.addObject("lista", cursoService.consultarPorEstado(estado));
                break;
            case "incompleto":
                mv.addObject("lista", cursoService.abiertoIncompleto());
                break;
            case "porfecha":
                
            default:
                throw new AssertionError();
        }
        
        return null;
    }
    
}
