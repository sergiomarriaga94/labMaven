/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.matriculamaven.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio.marriaga
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByCelular", query = "SELECT u FROM Usuario u WHERE u.celular = :celular")
    , @NamedQuery(name = "Usuario.findByCiudad", query = "SELECT u FROM Usuario u WHERE u.ciudad = :ciudad")
    , @NamedQuery(name = "Usuario.findByDepartamento", query = "SELECT u FROM Usuario u WHERE u.departamento = :departamento")
    , @NamedQuery(name = "Usuario.findByNombreMadre", query = "SELECT u FROM Usuario u WHERE u.nombreMadre = :nombreMadre")
    , @NamedQuery(name = "Usuario.findByNombrePadre", query = "SELECT u FROM Usuario u WHERE u.nombrePadre = :nombrePadre")
    , @NamedQuery(name = "Usuario.findByFechaMatricula", query = "SELECT u FROM Usuario u WHERE u.fechaMatricula = :fechaMatricula")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CELULAR")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Size(max = 10)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_MADRE")
    private String nombreMadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_PADRE")
    private String nombrePadre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MATRICULA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMatricula;

    public Usuario() {
    }

    public Usuario(Integer cedula) {
        this.cedula = cedula;
    }

    public Usuario(Integer cedula, String nombre, String apellidos, String telefono, String celular, String ciudad, String nombreMadre, String nombrePadre, Date fechaMatricula) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.celular = celular;
        this.ciudad = ciudad;
        this.nombreMadre = nombreMadre;
        this.nombrePadre = nombrePadre;
        this.fechaMatricula = fechaMatricula;
    }

    public Usuario(Integer cedula, String nombre, String apellidos, String telefono, String celular, String ciudad, String departamento, String nombreMadre, String nombrePadre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.celular = celular;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.nombreMadre = nombreMadre;
        this.nombrePadre = nombrePadre;
    }
    

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.matriculamaven.pojos.Usuario[ cedula=" + cedula + " ]";
    }
    
}
