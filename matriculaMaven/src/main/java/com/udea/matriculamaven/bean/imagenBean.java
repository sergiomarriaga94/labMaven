package com.udea.matriculamaven.bean;


import com.udea.matriculamaven.facades.UploadImageFacadeLocal;
import com.udea.matriculamaven.facades.UsuarioFacadeLocal;
import com.udea.matriculamaven.pojos.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.model.UploadedFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergio.marriaga
 */

@ManagedBean
//@SessionScoped
public class imagenBean implements Serializable{

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
    
    private UploadedFile File;
    private int codigo=0;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public UploadedFile getFile() {
        return File;
    }

    public void setFile(UploadedFile File) {
        this.File = File;
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
    
    /**
     * Creates a new instance of imagenBean
     */
      
    public imagenBean() {
    }
    
    public void upload(){
        try{
            if(File!=null){
                Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?user=root&password=root");
            
                PreparedStatement st=cn.prepareStatement("INSERT INTO upload_image (IMAGE) VALUES (?)");
                st.setBinaryStream(1, File.getInputstream());
                st.executeUpdate();
                cn.close();
                
                System.out.println(nombre);
                System.out.println(apellidos);
                System.out.println(ciudad);
                System.out.println(departamento);
                
                codigo++;
                FacesMessage facesMessage= new FacesMessage("Exito..",File.getFileName() + "fue subido");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                
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
            
        }catch(Exception e){
            FacesMessage fm=new FacesMessage("Error al subir el archivo");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public void ver(){
        ResultSet st;
        
        
        try{
            byte[] bs=null;
            
            Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab2?user=root&password=root");
            PreparedStatement preparedStatement=cn.prepareStatement("SELECT image FROM upload_image WHERE Image_id=(?)");
            
            preparedStatement.setInt(1, codigo);
            st = preparedStatement.executeQuery();
            while(st.next()){
                bs=st.getBytes("IMAGE");
            }        
            cn.close();
            
            FacesMessage message=new FacesMessage("Exito");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            HttpServletResponse hsr=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            hsr.getOutputStream().write(bs);
            hsr.getOutputStream().close();
            
            FacesContext.getCurrentInstance().responseComplete();
        }catch(IOException | ClassNotFoundException | SQLException e){
            FacesMessage fm=new FacesMessage("Error de conexion ");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
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
}
