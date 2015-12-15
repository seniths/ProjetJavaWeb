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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "ORDERLINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderline.findAll", query = "SELECT o FROM Orderline o"),
    @NamedQuery(name = "Orderline.findByIdorderline", query = "SELECT o FROM Orderline o WHERE o.idorderline = :idorderline"),
    @NamedQuery(name = "Orderline.findBySize", query = "SELECT o FROM Orderline o WHERE o.size = :size"),
    @NamedQuery(name = "Orderline.findByQuantity", query = "SELECT o FROM Orderline o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderline.findByPrice", query = "SELECT o FROM Orderline o WHERE o.price = :price")})
public class Orderline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDORDERLINE")
    private Integer idorderline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIZE")
    private Character size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Min(value = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @JoinColumn(name = "IDORDER", referencedColumnName = "IDORDER")
    @ManyToOne(optional = false)
    private Clientorder idorder;
    @JoinColumn(name = "IDITEM", referencedColumnName = "IDITEM")
    @ManyToOne(optional = false)
    private Item iditem;

    public Orderline() {
    }

    public Orderline(Integer idorderline) {
        this.idorderline = idorderline;
    }

    public Orderline(Integer idorderline, Character size, int quantity, BigDecimal price) {
        this.idorderline = idorderline;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getIdorderline() {
        return idorderline;
    }

    public void setIdorderline(Integer idorderline) {
        this.idorderline = idorderline;
    }

    public Character getSize() {
        return size;
    }

    public void setSize(Character size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Clientorder getIdorder() {
        return idorder;
    }

    public void setIdorder(Clientorder idorder) {
        this.idorder = idorder;
    }

    public Item getIditem() {
        return iditem;
    }

    public void setIditem(Item iditem) {
        this.iditem = iditem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorderline != null ? idorderline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderline)) {
            return false;
        }
        Orderline other = (Orderline) object;
        if ((this.idorderline == null && other.idorderline != null) || (this.idorderline != null && !this.idorderline.equals(other.idorderline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Orderline[ idorderline=" + idorderline + " ]";
    }
    
}
