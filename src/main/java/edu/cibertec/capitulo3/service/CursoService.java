
package edu.cibertec.capitulo3.service;

import edu.cibertec.capitulo3.dao.CursoDAO;
import edu.cibertec.capitulo3.dao.entity.CursoEntity;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    
    @Autowired
    private CursoDAO cursoDao;
    
    public List<CursoEntity> consultarPorEstado(int estado){
        return cursoDao.consultarPorEstado(estado);
    }
    
    public List<CursoEntity> abiertoIncompleto(){
        return cursoDao.abiertoIncompleto();
    }
    
    public List<CursoEntity> consultarPorFecha(Date fecha){
        return cursoDao.consultarPorFecha(fecha);
    }
    
    public List<CursoEntity> consultarFaltantes(Integer cantidad){
        return cursoDao.consultarFaltantes(cantidad);
    }
    
    public List<CursoEntity> consultarPorNombre(String cadena){
        return cursoDao.consultarPorNombre(cadena);
    }
    
}
