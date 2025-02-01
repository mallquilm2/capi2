package edu.cibertec.capitulo3.dao;

import edu.cibertec.capitulo3.dao.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaDAO extends JpaRepository<MatriculaEntity, Integer>{
    
}
