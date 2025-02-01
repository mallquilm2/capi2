package edu.cibertec.capitulo3.dao.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmatricula;
    private Date fechaMat;
    @OneToOne
    @JoinColumn(name="usuario")
    private UsuarioEntity usuario;
    @OneToOne
    @JoinColumn(name = "idcurso")
    private CursoEntity curso;
    
    private int estado;

    public MatriculaEntity() {
    }

    public MatriculaEntity(int idmatricula, Date fechaMat, UsuarioEntity usuario, CursoEntity curso, int estado) {
        this.idmatricula = idmatricula;
        this.fechaMat = fechaMat;
        this.usuario = usuario;
        this.curso = curso;
        this.estado = estado;
    }
    

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Date getFechaMat() {
        return fechaMat;
    }

    public void setFechaMat(Date fechaMat) {
        this.fechaMat = fechaMat;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
   

}
