
package edu.cibertec.capi2.controller;

import edu.cibertec.capi2.model.UsuarioDTO;
import edu.cibertec.capi2.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("loginMostrar.do")
    public String loginMostrar(){
        return "login";
    }
    
    @RequestMapping("loginAccion.do")
    public ModelAndView loginAccion(UsuarioDTO usuarioValida){
        ModelAndView mv = null;
        
        UsuarioDTO ue = usuarioService.validarLogin(usuarioValida);
        if(ue == null){
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen.");
        }else{
            //mv = new ModelAndView("saludo", "mensaje", "Bienvenido "+ue.getNombreCompleto());
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListarUsuarios());
        }
        return mv;
    }
    
    @RequestMapping("usuarioCrear.do")
    public ModelAndView crearUsuario(){
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    }
    
    @RequestMapping("grabarUsuario.do")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioDTO usuario, BindingResult result){
        ModelAndView mv = null;
        if(result.hasErrors()){
             mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        }else{
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListarUsuarios());
        }
        return mv; 
    }
    
}
