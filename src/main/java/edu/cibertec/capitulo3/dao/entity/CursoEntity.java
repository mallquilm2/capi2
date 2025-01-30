
package edu.cibertec.capitulo3.dao.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
@NamedQuery(name = "CursoEntity.abiertoIncompleto",
        query = "SELECT c FROM CursoEntity c WHERE c.alumnosMin > c.alumnosAct c.estado = 1")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcurso")
    private Integer idCurso;
    @Column(name = "nomcurso")
    private String nomCurso;
    private Date fechaInicio;
    private Integer alumnosMin;
    private Integer alumnosAct;
    private Integer estado;

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getAlumnosMin() {
        return alumnosMin;
    }

    public void setAlumnosMin(Integer alumnosMin) {
        this.alumnosMin = alumnosMin;
    }

    public Integer getAlumnosAct() {
        return alumnosAct;
    }

    public void setAlumnosAct(Integer alumnosAct) {
        this.alumnosAct = alumnosAct;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
    
}
