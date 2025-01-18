
package edu.cibertec.capi2.dao;

import edu.cibertec.capi2.model.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {
    
    private List<UsuarioDTO> listaUsuarios;
    
    public UsuarioDAO(){
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new UsuarioDTO("Jose", "12345", "Jose Perez"));
        listaUsuarios.add(new UsuarioDTO("Carmen", "12345", "Carmen Santa Cruz"));
        listaUsuarios.add(new UsuarioDTO("Maria", "12345", "Maria Tenorio"));
        listaUsuarios.add(new UsuarioDTO("Luis", "12345", "Luis Mallqui"));
    }
    
    public List<UsuarioDTO> getListarUsuarios(){
        return listaUsuarios;
    }
    
    public void insertarUsuario(UsuarioDTO usuario){
        listaUsuarios.add(usuario);
    }
    
    public UsuarioDTO validarLogin(UsuarioDTO usuario){
        if(usuario.getUsuario().equalsIgnoreCase("user") &&
                usuario.getClave().equalsIgnoreCase("12345")){
            usuario.setNombreCompleto("Usuario Prueba");
        }else
            usuario = null;
        
        return usuario;
    }
    
    
    
}
