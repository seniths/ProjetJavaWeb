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
@Table(name = "LANGUAGEITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languageitem.findAll", query = "SELECT l FROM Languageitem l"),
    @NamedQuery(name = "Languageitem.findByIdlangitem", query = "SELECT l FROM Languageitem l WHERE l.idlangitem = :idlangitem"),
    @NamedQuery(name = "Languageitem.findByLabel", query = "SELECT l FROM Languageitem l WHERE l.label = :label"),
    @NamedQuery(name = "Languageitem.findByCatAndLang", query = "SELECT l FROM Languageitem l, Item i WHERE i.iditem = l.iditem.iditem AND i.idcategory = :idcategory AND l.idlanguage = :idlanguage"),
    @NamedQuery(name = "Languageitem.findByItemId", query = "SELECT l FROM Languageitem l WHERE l.iditem = :iditem AND l.idlanguage = :idlang")})
public class Languageitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLANGITEM")
    private Integer idlangitem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LABEL")
    private String label;
    @JoinColumn(name = "IDITEM", referencedColumnName = "IDITEM")
    @ManyToOne(optional = false)
    private Item iditem;
    @JoinColumn(name = "IDLANGUAGE", referencedColumnName = "IDLANGUAGE")
    @ManyToOne(optional = false)
    private Language idlanguage;

    public Languageitem() {
    }

    public Languageitem(Integer idlangitem) {
        this.idlangitem = idlangitem;
    }

    public Languageitem(Integer idlangitem, String label) {
        this.idlangitem = idlangitem;
        this.label = label;
    }

    public Integer getIdlangitem() {
        return idlangitem;
    }

    public void setIdlangitem(Integer idlangitem) {
        this.idlangitem = idlangitem;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Item getIditem() {
        return iditem;
    }

    public void setIditem(Item iditem) {
        this.iditem = iditem;
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
        hash += (idlangitem != null ? idlangitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languageitem)) {
            return false;
        }
        Languageitem other = (Languageitem) object;
        if ((this.idlangitem == null && other.idlangitem != null) || (this.idlangitem != null && !this.idlangitem.equals(other.idlangitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Languageitem[ idlangitem=" + idlangitem + " ]";
    }
    
}
