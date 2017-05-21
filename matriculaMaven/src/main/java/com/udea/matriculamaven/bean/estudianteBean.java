/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.matriculamaven.bean;

import com.udea.matriculamaven.facades.UsuarioFacadeLocal;
import com.udea.matriculamaven.pojos.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sergio.marriaga
 */
@Named(value="estudianteBean")
@SessionScoped
public class estudianteBean implements Serializable{

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
   private int cedula;
   private String nombre;
   private String apellidos;
   private String telefono;
   private String celular;
   private String ciudad;
   private String departamento;
   private String madre;
   private String padre;
   private Date fecha=new Date();

    /**
     * Creates a new instance of estudianteBean
     */
    public estudianteBean() {
        
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }
    public void guardarMatricula(){
       Usuario u=new Usuario();
       u.setCedula(cedula);
       u.setNombre(nombre);
       u.setApellidos(apellidos);
       u.setTelefono(telefono);
       u.setCelular(celular);
       u.setCiudad(ciudad);
       u.setDepartamento(departamento);
       u.setNombreMadre(madre);
       u.setNombrePadre(padre);
       this.usuarioFacade.create(u);
       
   }
    private Locale locale=FacesContext.getCurrentInstance().getViewRoot().getLocale();
   public Locale getLocale(){
       return locale;
   }
   public String getLenguaje(){
       return locale.getLanguage();
   }
   public void cambiolenguaje(String lenguaje){
       locale=new Locale(lenguaje);
       FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(lenguaje));
   }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
