
package edu.cibertec.capi2.controller;

import edu.cibertec.capi2.model.UsuarioDTO;
import edu.cibertec.capi2.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView loginAccion(HttpServletRequest request){
        ModelAndView mv = null;
        UsuarioDTO usuarioValida = new UsuarioDTO();
        usuarioValida.setUsuario(request.getParameter("txtUsuario"));
        usuarioValida.setClave(request.getParameter("txtClave"));
        
        UsuarioDTO ue = usuarioService.validarLogin(usuarioValida);
        if(ue == null){
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen.");
        }else{
            mv = new ModelAndView("saludo", "mensaje", "Bienvenido "+ue.getNombreCompleto());
        }
        return mv;
    }
    
}