/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.matriculamaven.facades;

import com.udea.matriculamaven.pojos.UploadImage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sergio.marriaga
 */
@Local
public interface UploadImageFacadeLocal {

    void create(UploadImage uploadImage);

    void edit(UploadImage uploadImage);

    void remove(UploadImage uploadImage);

    UploadImage find(Object id);

    List<UploadImage> findAll();

    List<UploadImage> findRange(int[] range);

    int count();
    
}
