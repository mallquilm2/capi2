
package edu.cibertec.capi2.service;

import edu.cibertec.capi2.dao.UsuarioDAO;
import edu.cibertec.capi2.model.UsuarioDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public UsuarioDTO validarLogin(UsuarioDTO usuario){
        return usuarioDAO.validarLogin(usuario);
    }
    
    public void insertarUsuario(UsuarioDTO usuario){
        usuarioDAO.insertarUsuario(usuario);
    }
    
    public List<UsuarioDTO> getListarUsuarios(){
        return usuarioDAO.getListarUsuarios();
    }
    
}
