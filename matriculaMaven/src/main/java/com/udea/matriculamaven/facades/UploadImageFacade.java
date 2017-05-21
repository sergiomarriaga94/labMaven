/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.matriculamaven.facades;

import com.udea.matriculamaven.pojos.UploadImage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio.marriaga
 */
@Stateless
public class UploadImageFacade extends AbstractFacade<UploadImage> implements UploadImageFacadeLocal {

    @PersistenceContext(unitName = "com.udea_matriculaMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UploadImageFacade() {
        super(UploadImage.class);
    }
    
}
