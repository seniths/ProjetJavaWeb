/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "LANGUAGECATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languagecategory.findAll", query = "SELECT l FROM Languagecategory l"),
    @NamedQuery(name = "Languagecategory.findByIdlangcat", query = "SELECT l FROM Languagecategory l WHERE l.idlangcat = :idlangcat"),
    @NamedQuery(name = "Languagecategory.findByLabel", query = "SELECT l FROM Languagecategory l WHERE l.label = :label"),
    @NamedQuery(name = "Languagecategory.findByLangId", query = "SELECT l FROM Languagecategory l WHERE l.idlanguage = :idlang")})
public class Languagecategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLANGCAT")
    private Integer idlangcat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LABEL")
    private String label;
    @JoinColumn(name = "IDCATEGORY", referencedColumnName = "IDCATEGORY")
    @ManyToOne(optional = false)
    private Category idcategory;
    @JoinColumn(name = "IDLANGUAGE", referencedColumnName = "IDLANGUAGE")
    @ManyToOne(optional = false)
    private Language idlanguage;

    public Languagecategory() {
    }

    public Languagecategory(Integer idlangcat) {
        this.idlangcat = idlangcat;
    }

    public Languagecategory(Integer idlangcat, String label) {
        this.idlangcat = idlangcat;
        this.label = label;
    }

    public Integer getIdlangcat() {
        return idlangcat;
    }

    public void setIdlangcat(Integer idlangcat) {
        this.idlangcat = idlangcat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Category getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Category idcategory) {
        this.idcategory = idcategory;
    }

    public Language getIdlanguage() {
        return idlanguage;
    }

    public void setIdlanguage(Language idlanguage) {
        this.idlanguage = idlanguage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlangcat != null ? idlangcat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languagecategory)) {
            return false;
        }
        Languagecategory other = (Languagecategory) object;
        if ((this.idlangcat == null && other.idlangcat != null) || (this.idlangcat != null && !this.idlangcat.equals(other.idlangcat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Languagecategory[ idlangcat=" + idlangcat + " ]";
    }
    
}
