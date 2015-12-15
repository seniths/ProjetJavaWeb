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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maxime
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient"),
    @NamedQuery(name = "Client.findByLogin", query = "SELECT c FROM Client c WHERE c.login = :login"),
    @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password"),
    @NamedQuery(name = "Client.findByFirstname", query = "SELECT c FROM Client c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Client.findByLastname", query = "SELECT c FROM Client c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.mail = :mail"),
    @NamedQuery(name = "Client.findByAddStreet", query = "SELECT c FROM Client c WHERE c.addStreet = :addStreet"),
    @NamedQuery(name = "Client.findByAddNumber", query = "SELECT c FROM Client c WHERE c.addNumber = :addNumber"),
    @NamedQuery(name = "Client.findByAddLocality", query = "SELECT c FROM Client c WHERE c.addLocality = :addLocality"),
    @NamedQuery(name = "Client.findByAddPosatlcode", query = "SELECT c FROM Client c WHERE c.addPosatlcode = :addPosatlcode"),
    @NamedQuery(name = "Client.findByGender", query = "SELECT c FROM Client c WHERE c.gender = :gender"),
    @NamedQuery(name = "Client.findByTelnumber", query = "SELECT c FROM Client c WHERE c.telnumber = :telnumber"),
    @NamedQuery(name = "Client.findByBirthdate", query = "SELECT c FROM Client c WHERE c.birthdate = :birthdate")})
public class Client implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(max = 10)
    @Column(name = "ADD_NUMBER")
    private String addNumber;
    @Column(name = "GENDER")
    private Boolean gender;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCLIENT")
    private Integer idclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADD_STREET")
    private String addStreet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADD_LOCALITY")
    private String addLocality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADD_POSATLCODE")
    private short addPosatlcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TELNUMBER")
    private String telnumber;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private Collection<Clientorder> clientorderCollection;

    public Client() {
    }

    public Client(Integer idclient) {
        this.idclient = idclient;
    }

    public Client(Integer idclient, String login, String password, String firstname, String lastname, String mail, String addStreet, String addNumber, String addLocality, short addPosatlcode, Boolean gender, String telnumber, Date birthdate) {
        this.idclient = idclient;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.addStreet = addStreet;
        this.addNumber = addNumber;
        this.addLocality = addLocality;
        this.addPosatlcode = addPosatlcode;
        this.gender = gender;
        this.telnumber = telnumber;
        this.birthdate = birthdate;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public String getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(String addNumber) {
        this.addNumber = addNumber;
    }

    public String getAddLocality() {
        return addLocality;
    }

    public void setAddLocality(String addLocality) {
        this.addLocality = addLocality;
    }

    public short getAddPosatlcode() {
        return addPosatlcode;
    }

    public void setAddPosatlcode(short addPosatlcode) {
        this.addPosatlcode = addPosatlcode;
    }


    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @XmlTransient
    public Collection<Clientorder> getClientorderCollection() {
        return clientorderCollection;
    }

    public void setClientorderCollection(Collection<Clientorder> clientorderCollection) {
        this.clientorderCollection = clientorderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBean.Client[ idclient=" + idclient + " ]";
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    
}
