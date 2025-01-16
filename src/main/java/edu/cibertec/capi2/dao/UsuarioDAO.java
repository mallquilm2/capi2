
package edu.cibertec.capi2.dao;

import edu.cibertec.capi2.model.UsuarioDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {
    
    public UsuarioDTO validarLogin(UsuarioDTO usuario){
        if(usuario.getUsuario().equalsIgnoreCase("user") &&
                usuario.getClave().equalsIgnoreCase("12345")){
            usuario.setNombreCompleto("Usuario Prueba");
        }else
            usuario = null;
        
        return usuario;
    }
    
}
