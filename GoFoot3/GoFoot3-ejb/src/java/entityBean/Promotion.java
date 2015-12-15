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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "PROMOTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByIdpromotion", query = "SELECT p FROM Promotion p WHERE p.idpromotion = :idpromotion"),
    @NamedQuery(name = "Promotion.findByWeeknumber", query = "SELECT p FROM Promotion p WHERE p.weeknumber = :weeknumber")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROMOTION")
    private Integer idpromotion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEEKNUMBER")
    private short weeknumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpromotion")
    private Collection<Promotioncategory> promotioncategoryCollection;

    public Promotion() {
    }

    public Promotion(Integer idpromotion) {
        this.idpromotion = idpromotion;
    }

    public Promotion(Integer idpromotion, short weeknumber) {
        this.idpromotion = idpromotion;
        this.weeknumber = weeknumber;
    }

    public Integer getIdpromotion() {
        return idpromotion;
    }

    public void setIdpromotion(Integer idpromotion) {
        this.idpromotion = idpromotion;
    }

    public short getWeeknumber() {
        return weeknumber;
    }

    public void setWeeknumber(short weeknumber) {
        this.weeknumber = weeknumber;
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
        hash += (idpromotion != null ? idpromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idpromotion == null && other.idpromotion != null) || (this.idpromotion != null && !this.idpromotion.equals(other.idpromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Promotion[ idpromotion=" + idpromotion + " ]";
    }
    
}
