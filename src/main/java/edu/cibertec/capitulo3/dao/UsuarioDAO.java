
package edu.cibertec.capitulo3.dao;

import edu.cibertec.capitulo3.dao.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<UsuarioEntity, String>{
    
    public UsuarioEntity findByUsuarioAndClave(String usuario, String clave);
    
}
