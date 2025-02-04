
package edu.cibertec.capitulo3.controller;

import edu.cibertec.capitulo3.dao.entity.CursoEntity;
import edu.cibertec.capitulo3.dao.entity.MatriculaEntity;
import edu.cibertec.capitulo3.dao.entity.UsuarioEntity;
import edu.cibertec.capitulo3.service.CursoService;
import edu.cibertec.capitulo3.service.MatriculaService;
import edu.cibertec.capitulo3.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CursoService cursoService;
    
    @RequestMapping("matriculaMostrar.do")
    public ModelAndView matriculaMostrar(){
        ModelAndView mv = new ModelAndView("matricula", "listaMatricula", matriculaService.listarMatriculas());
        mv.addObject("listaUsuarios", usuarioService.listarTodosLosUsuarios());
        mv.addObject("listaCursos", cursoService.listarTodosLosCursos());
        return mv;
    }
    
    @RequestMapping("matriculaGrabar.do")
    public ModelAndView matriculaGrabar(MatriculaEntity entity, HttpServletRequest request){
        
        CursoEntity ce = new CursoEntity();
        ce.setIdCurso(Integer.parseInt(request.getParameter("cmbCurso")));
        
        UsuarioEntity ue = new UsuarioEntity();
        ue.setUsuario(request.getParameter("cmbUsuario"));
        
        entity.setCurso(ce);
        entity.setUsuario(ue);
        
        matriculaService.grabarMatricula(entity);
        
        return new ModelAndView("redirect:matriculaMostrar.do");
    }
    
    
}
