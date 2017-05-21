/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.matriculamaven.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sergio.marriaga
 */
@Named(value="captchaBean")
@RequestScoped
public class captchaBean {

    /**
     * Creates a new instance of captchaBean
     */
    public captchaBean() {
    }
    public void check(){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"su codigo es correcto",null));
    }
}
