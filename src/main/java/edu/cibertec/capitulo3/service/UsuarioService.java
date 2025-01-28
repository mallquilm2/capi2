
package edu.cibertec.capitulo3.service;

import edu.cibertec.capitulo3.dao.UsuarioDAO;
import edu.cibertec.capitulo3.dao.entity.UsuarioEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public UsuarioEntity validarLogin(UsuarioEntity usuario){
        UsuarioEntity rpta = getUsuario(usuario.getUsuario());
        if(rpta == null)
            return rpta;
        if(!rpta.getClave().equalsIgnoreCase(usuario.getClave()))
            return null;
        return rpta;
    }
    
    public void insertarUsuario(UsuarioEntity usuario){
        usuarioDAO.save(usuario);
    }
    
    public List<UsuarioEntity> getListarUsuarios(){
        return usuarioDAO.findAll();
    }
    
    public UsuarioEntity getUsuario(String codigo){
        UsuarioEntity rpta = null;
        Optional<UsuarioEntity> usuarioBusqueda = usuarioDAO.findById(codigo);
        if(usuarioBusqueda.isPresent())
            rpta = usuarioBusqueda.get();
        return rpta;
    }
    
    public void modificarUsuario(UsuarioEntity usuario){
        usuarioDAO.save(usuario);
    }
    
    public void eliminarUsuario(String codigo){
        usuarioDAO.deleteById(codigo);
    }
    
}
