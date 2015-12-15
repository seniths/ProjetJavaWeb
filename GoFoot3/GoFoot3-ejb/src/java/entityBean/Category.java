/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByIdcategory", query = "SELECT c FROM Category c WHERE c.idcategory = :idcategory")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCATEGORY")
    private Integer idcategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategory")
    private Collection<Item> itemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategory")
    private Collection<Languagecategory> languagecategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategory")
    private Collection<Promotioncategory> promotioncategoryCollection;

    public Category() {
    }

    public Category(Integer idcategory) {
        this.idcategory = idcategory;
    }

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<Languagecategory> getLanguagecategoryCollection() {
        return languagecategoryCollection;
    }

    public void setLanguagecategoryCollection(Collection<Languagecategory> languagecategoryCollection) {
        this.languagecategoryCollection = languagecategoryCollection;
    }

    @XmlTransient
    public Collection<Promotioncategory> getPromotioncategoryCollection() {
        return promotioncategoryCollection;
    }

    public void setPromotioncategoryCollection(Collection<Promotioncategory> promotioncategoryCollection) {
        this.promotioncategoryCollection = promotioncategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategory != null ? idcategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.idcategory == null && other.idcategory != null) || (this.idcategory != null && !this.idcategory.equals(other.idcategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Category[ idcategory=" + idcategory + " ]";
    }
    
}
