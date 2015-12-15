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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "LANGUAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
    @NamedQuery(name = "Language.findByIdlanguage", query = "SELECT l FROM Language l WHERE l.idlanguage = :idlanguage"),
    @NamedQuery(name = "Language.findByLabel", query = "SELECT l FROM Language l WHERE l.label = :label")})
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLANGUAGE")
    private Integer idlanguage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LABEL")
    private String label;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlanguage")
    private Collection<Languagecategory> languagecategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlanguage")
    private Collection<Languageitem> languageitemCollection;

    public Language() {
    }

    public Language(Integer idlanguage) {
        this.idlanguage = idlanguage;
    }

    public Language(Integer idlanguage, String label) {
        this.idlanguage = idlanguage;
        this.label = label;
    }

    public Integer getIdlanguage() {
        return idlanguage;
    }

    public void setIdlanguage(Integer idlanguage) {
        this.idlanguage = idlanguage;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlTransient
    public Collection<Languagecategory> getLanguagecategoryCollection() {
        return languagecategoryCollection;
    }

    public void setLanguagecategoryCollection(Collection<Languagecategory> languagecategoryCollection) {
        this.languagecategoryCollection = languagecategoryCollection;
    }

    @XmlTransient
    public Collection<Languageitem> getLanguageitemCollection() {
        return languageitemCollection;
    }

    public void setLanguageitemCollection(Collection<Languageitem> languageitemCollection) {
        this.languageitemCollection = languageitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlanguage != null ? idlanguage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.idlanguage == null && other.idlanguage != null) || (this.idlanguage != null && !this.idlanguage.equals(other.idlanguage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Language[ idlanguage=" + idlanguage + " ]";
    }
    
}
