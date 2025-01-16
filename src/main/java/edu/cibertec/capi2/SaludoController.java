
package edu.cibertec.capi2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaludoController {
    /* 
    //Usando Model
    @RequestMapping("saludo.do")
    public String saludar(Model modelo){
        modelo.addAttribute("mensaje", "Bienvenido desde el controlador.");
        return "saludo";
    }
*/
    /*
    //Usando ModelAndView
    @RequestMapping("saludo.do")
    public ModelAndView saludar2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("mensaje", "Bienvenido desde el Controlador MV");
        mv.setViewName("saludo");
        return mv;
    }
    */
    
    
    //Usando el ModelAndView en una linea.
    @RequestMapping("saludo.do")
    public ModelAndView saludar3(){
        return new ModelAndView("saludo", "mensaje", "Bienvenido desde el controlador MV 3");
    }
}
