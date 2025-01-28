
package edu.cibertec.capitulo3.controller;

import edu.cibertec.capitulo3.dao.entity.UsuarioEntity;
import edu.cibertec.capitulo3.service.UsuarioService;
import java.util.Base64;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
    public ModelAndView loginAccion(UsuarioEntity usuarioValida){
        ModelAndView mv = null;
        
        UsuarioEntity ue = usuarioService.validarLogin(usuarioValida);
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
        ModelAndView mv = new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioEntity());
        mv.addObject("accion","Insertar");
        return mv;
    }
    
    @RequestMapping("usuarioMod.do")
    public ModelAndView usuarioModificar(@RequestParam("codigoUsuario") String codigo){
        ModelAndView mv = new ModelAndView("usuarioDatos", "usuarioBean", usuarioService.getUsuario(codigo));
        mv.addObject("accion","Modificar");
        return mv;
    }
    
    @RequestMapping("grabarUsuario.do")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult result,
            @RequestParam("archivo") CommonsMultipartFile archivo, @RequestParam("accion") String accion){
        ModelAndView mv = null;
        if(result.hasErrors()){
             mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        }else{
            usuario.setFoto(archivo.getBytes());
            if(accion.equalsIgnoreCase("Insertar"))
                usuarioService.insertarUsuario(usuario);
            else
                usuarioService.modificarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListarUsuarios());
        }
        return mv; 
    }
    
    @RequestMapping("fotoMostrar.do")
    public String fotoMostrar(@RequestParam("codigoUsuario") String codigoUsuario, Model modelo){
        UsuarioEntity user = usuarioService.getUsuario(codigoUsuario);
        modelo.addAttribute("usuario", user);
        modelo.addAttribute("foto64", user.getFotoBase64());
        return "fotoUsuario";
    }
    
    @RequestMapping("usuarioListar.do")
    public ModelAndView usuarioListar(){
        return new ModelAndView("usuarioLista", "lista", usuarioService.getListarUsuarios());
    }
    
    @RequestMapping("usuarioEli.do")
    public ModelAndView usuarioEliminar(@RequestParam("codigoUsuario") String codigo){
        usuarioService.eliminarUsuario(codigo);
        return new ModelAndView("redirect:usuarioListar.do");
    }
    
}
