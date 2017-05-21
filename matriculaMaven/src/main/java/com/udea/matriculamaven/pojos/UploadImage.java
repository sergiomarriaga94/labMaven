 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.matriculamaven.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio.marriaga
 */
@Entity
@Table(name = "upload_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadImage.findAll", query = "SELECT u FROM UploadImage u")
    , @NamedQuery(name = "UploadImage.findByImageid", query = "SELECT u FROM UploadImage u WHERE u.imageid = :imageid")})
public class UploadImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Image_id")
    private Integer imageid;
    @Lob
    @Column(name = "IMAGE")
    private byte[] image;

    public UploadImage() {
    }

    public UploadImage(Integer imageid) {
        this.imageid = imageid;
    }

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageid != null ? imageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UploadImage)) {
            return false;
        }
        UploadImage other = (UploadImage) object;
        if ((this.imageid == null && other.imageid != null) || (this.imageid != null && !this.imageid.equals(other.imageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.matriculamaven.UploadImage[ imageid=" + imageid + " ]";
    }
    
}
