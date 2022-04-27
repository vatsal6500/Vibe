/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "friend_list", catalog = "vibe", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FriendList.findAll", query = "SELECT f FROM FriendList f"),
    @NamedQuery(name = "FriendList.findByFlId", query = "SELECT f FROM FriendList f WHERE f.flId = :flId"),
    @NamedQuery(name = "FriendList.findByAcceptedDate", query = "SELECT f FROM FriendList f WHERE f.acceptedDate = :acceptedDate"),
    @NamedQuery(name = "FriendList.findByFriendStatus", query = "SELECT f FROM FriendList f WHERE f.friendStatus = :friendStatus")})
public class FriendList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fl_id", nullable = false)
    private Integer flId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accepted_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "friend_status", nullable = false)
    private boolean friendStatus;
    @JoinColumn(name = "friendid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private User friendid;
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private User userid;

    public FriendList() {
    }

    public FriendList(Integer flId) {
        this.flId = flId;
    }

    public FriendList(Integer flId, Date acceptedDate, boolean friendStatus) {
        this.flId = flId;
        this.acceptedDate = acceptedDate;
        this.friendStatus = friendStatus;
    }

    public Integer getFlId() {
        return flId;
    }

    public void setFlId(Integer flId) {
        this.flId = flId;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public boolean getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(boolean friendStatus) {
        this.friendStatus = friendStatus;
    }

    public User getFriendid() {
        return friendid;
    }

    public void setFriendid(User friendid) {
        this.friendid = friendid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flId != null ? flId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendList)) {
            return false;
        }
        FriendList other = (FriendList) object;
        if ((this.flId == null && other.flId != null) || (this.flId != null && !this.flId.equals(other.flId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FriendList[ flId=" + flId + " ]";
    }
    
}
