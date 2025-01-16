
package edu.cibertec.capi2.service;

import edu.cibertec.capi2.dao.UsuarioDAO;
import edu.cibertec.capi2.model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public UsuarioDTO validarLogin(UsuarioDTO usuario){
        return usuarioDAO.validarLogin(usuario);
    }
    
}
