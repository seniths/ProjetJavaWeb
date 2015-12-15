/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "PROMOTIONCATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotioncategory.findAll", query = "SELECT p FROM Promotioncategory p"),
    @NamedQuery(name = "Promotioncategory.findByIdpromcat", query = "SELECT p FROM Promotioncategory p WHERE p.idpromcat = :idpromcat"),
    @NamedQuery(name = "Promotioncategory.findByPercentage", query = "SELECT p FROM Promotioncategory p WHERE p.percentage = :percentage"),
    @NamedQuery(name = "Promotioncategory.findByWeekNumber", query = "SELECT p FROM Promotioncategory p, Promotion pr WHERE pr.weeknumber = :weeknumber AND p.idpromotion.idpromotion = pr.idpromotion"),
    @NamedQuery(name = "Promotioncategory.findByWeekNumberAndCatId", query = "SELECT p FROM Promotioncategory p, Promotion pr, Category c WHERE pr.weeknumber = :weeknumber AND p.idpromotion.idpromotion = pr.idpromotion AND c.idcategory = :idcategory AND p.idcategory.idcategory = c.idcategory")})
public class Promotioncategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROMCAT")
    private Integer idpromcat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERCENTAGE")
    private BigDecimal percentage;
    @JoinColumn(name = "IDCATEGORY", referencedColumnName = "IDCATEGORY")
    @ManyToOne(optional = false)
    private Category idcategory;
    @JoinColumn(name = "IDPROMOTION", referencedColumnName = "IDPROMOTION")
    @ManyToOne(optional = false)
    private Promotion idpromotion;

    public Promotioncategory() {
    }

    public Promotioncategory(Integer idpromcat) {
        this.idpromcat = idpromcat;
    }

    public Promotioncategory(Integer idpromcat, BigDecimal percentage) {
        this.idpromcat = idpromcat;
        this.percentage = percentage;
    }

    public Integer getIdpromcat() {
        return idpromcat;
    }

    public void setIdpromcat(Integer idpromcat) {
        this.idpromcat = idpromcat;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public Category getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Category idcategory) {
        this.idcategory = idcategory;
    }

    public Promotion getIdpromotion() {
        return idpromotion;
    }

    public void setIdpromotion(Promotion idpromotion) {
        this.idpromotion = idpromotion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromcat != null ? idpromcat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotioncategory)) {
            return false;
        }
        Promotioncategory other = (Promotioncategory) object;
        if ((this.idpromcat == null && other.idpromcat != null) || (this.idpromcat != null && !this.idpromcat.equals(other.idpromcat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Promotioncategory[ idpromcat=" + idpromcat + " ]";
    }
    
}
