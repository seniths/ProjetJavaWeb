/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIditem", query = "SELECT i FROM Item i WHERE i.iditem = :iditem"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByImagesrc", query = "SELECT i FROM Item i WHERE i.imagesrc = :imagesrc"),
    @NamedQuery(name = "Item.findByCategoryId", query = "SELECT i FROM Item i WHERE i.idcategory = :idcategory")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDITEM")
    private Integer iditem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IMAGESRC")
    private String imagesrc;
    @JoinColumn(name = "IDCATEGORY", referencedColumnName = "IDCATEGORY")
    @ManyToOne(optional = false)
    private Category idcategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditem")
    private Collection<Languageitem> languageitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditem")
    private Collection<Orderline> orderlineCollection;

    public Item() {
    }

    public Item(Integer iditem) {
        this.iditem = iditem;
    }

    public Item(Integer iditem, BigDecimal price, String imagesrc) {
        this.iditem = iditem;
        this.price = price;
        this.imagesrc = imagesrc;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public Category getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Category idcategory) {
        this.idcategory = idcategory;
    }

    @XmlTransient
    public Collection<Languageitem> getLanguageitemCollection() {
        return languageitemCollection;
    }

    public void setLanguageitemCollection(Collection<Languageitem> languageitemCollection) {
        this.languageitemCollection = languageitemCollection;
    }

    @XmlTransient
    public Collection<Orderline> getOrderlineCollection() {
        return orderlineCollection;
    }

    public void setOrderlineCollection(Collection<Orderline> orderlineCollection) {
        this.orderlineCollection = orderlineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Item[ iditem=" + iditem + " ]";
    }
    
}
