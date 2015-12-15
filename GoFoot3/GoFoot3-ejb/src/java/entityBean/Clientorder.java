/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "CLIENTORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientorder.findAll", query = "SELECT c FROM Clientorder c"),
    @NamedQuery(name = "Clientorder.findByIdorder", query = "SELECT c FROM Clientorder c WHERE c.idorder = :idorder"),
    @NamedQuery(name = "Clientorder.findByDate", query = "SELECT c FROM Clientorder c WHERE c.date = :date")})
public class Clientorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDORDER")
    private Integer idorder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorder")
    private Collection<Orderline> orderlineCollection;
    @JoinColumn(name = "IDCLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne(optional = false)
    private Client idclient;

    public Clientorder() {
    }

    public Clientorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Clientorder(Integer idorder, Date date) {
        this.idorder = idorder;
        this.date = date;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Orderline> getOrderlineCollection() {
        return orderlineCollection;
    }

    public void setOrderlineCollection(Collection<Orderline> orderlineCollection) {
        this.orderlineCollection = orderlineCollection;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorder != null ? idorder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientorder)) {
            return false;
        }
        Clientorder other = (Clientorder) object;
        if ((this.idorder == null && other.idorder != null) || (this.idorder != null && !this.idorder.equals(other.idorder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Clientorder[ idorder=" + idorder + " ]";
    }
    
}
