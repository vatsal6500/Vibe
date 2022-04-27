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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "activity_feed", catalog = "vibe", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivityFeed.findAll", query = "SELECT a FROM ActivityFeed a"),
    @NamedQuery(name = "ActivityFeed.findByAfId", query = "SELECT a FROM ActivityFeed a WHERE a.afId = :afId"),
    @NamedQuery(name = "ActivityFeed.findBySendermessage", query = "SELECT a FROM ActivityFeed a WHERE a.sendermessage = :sendermessage"),
    @NamedQuery(name = "ActivityFeed.findByReceivermessage", query = "SELECT a FROM ActivityFeed a WHERE a.receivermessage = :receivermessage"),
    @NamedQuery(name = "ActivityFeed.findByTargetUrl", query = "SELECT a FROM ActivityFeed a WHERE a.targetUrl = :targetUrl"),
    @NamedQuery(name = "ActivityFeed.findByActivityDate", query = "SELECT a FROM ActivityFeed a WHERE a.activityDate = :activityDate"),
    @NamedQuery(name = "ActivityFeed.findByIsRead", query = "SELECT a FROM ActivityFeed a WHERE a.isRead = :isRead"),
    @NamedQuery(name = "ActivityFeed.findByIsDeleted", query = "SELECT a FROM ActivityFeed a WHERE a.isDeleted = :isDeleted")})
public class ActivityFeed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "af_id", nullable = false)
    private Integer afId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "sendermessage", nullable = false, length = 1000)
    private String sendermessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "receivermessage", nullable = false, length = 1000)
    private String receivermessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "target_url", nullable = false, length = 1000)
    private String targetUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activity_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_read", nullable = false)
    private boolean isRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    @JoinColumn(name = "groupid", referencedColumnName = "groupid", nullable = false)
    @ManyToOne(optional = false)
    private Groups groupid;
    @JoinColumn(name = "receiverid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private User receiverid;
    @JoinColumn(name = "senderid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private User senderid;

    public ActivityFeed() {
    }

    public ActivityFeed(Integer afId) {
        this.afId = afId;
    }

    public ActivityFeed(Integer afId, String sendermessage, String receivermessage, String targetUrl, Date activityDate, boolean isRead, boolean isDeleted) {
        this.afId = afId;
        this.sendermessage = sendermessage;
        this.receivermessage = receivermessage;
        this.targetUrl = targetUrl;
        this.activityDate = activityDate;
        this.isRead = isRead;
        this.isDeleted = isDeleted;
    }

    public Integer getAfId() {
        return afId;
    }

    public void setAfId(Integer afId) {
        this.afId = afId;
    }

    public String getSendermessage() {
        return sendermessage;
    }

    public void setSendermessage(String sendermessage) {
        this.sendermessage = sendermessage;
    }

    public String getReceivermessage() {
        return receivermessage;
    }

    public void setReceivermessage(String receivermessage) {
        this.receivermessage = receivermessage;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Groups getGroupid() {
        return groupid;
    }

    public void setGroupid(Groups groupid) {
        this.groupid = groupid;
    }

    public User getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(User receiverid) {
        this.receiverid = receiverid;
    }

    public User getSenderid() {
        return senderid;
    }

    public void setSenderid(User senderid) {
        this.senderid = senderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afId != null ? afId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityFeed)) {
            return false;
        }
        ActivityFeed other = (ActivityFeed) object;
        if ((this.afId == null && other.afId != null) || (this.afId != null && !this.afId.equals(other.afId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActivityFeed[ afId=" + afId + " ]";
    }
    
}
