package edu.cibertec.capitulo3.service;

import edu.cibertec.capitulo3.dao.MatriculaDAO;
import edu.cibertec.capitulo3.dao.entity.MatriculaEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    
    @Autowired
    private MatriculaDAO matriculaDao;
    
    public List<MatriculaEntity> listarMatriculas(){
        return matriculaDao.findAll();
    }
    
    public void grabarMatricula(MatriculaEntity matricula){
        matriculaDao.save(matricula);
    }
    
}
