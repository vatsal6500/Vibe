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
import javax.persistence.Lob;
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
@Table(name = "chat", catalog = "vibe", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c"),
    @NamedQuery(name = "Chat.findByChatid", query = "SELECT c FROM Chat c WHERE c.chatid = :chatid"),
    @NamedQuery(name = "Chat.findByTime", query = "SELECT c FROM Chat c WHERE c.time = :time"),
    @NamedQuery(name = "Chat.findByDate", query = "SELECT c FROM Chat c WHERE c.date = :date"),
    @NamedQuery(name = "Chat.findByIsDelevered", query = "SELECT c FROM Chat c WHERE c.isDelevered = :isDelevered"),
    @NamedQuery(name = "Chat.findByIsRead", query = "SELECT c FROM Chat c WHERE c.isRead = :isRead"),
    @NamedQuery(name = "Chat.findByIsDeleted", query = "SELECT c FROM Chat c WHERE c.isDeleted = :isDeleted")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chatid", nullable = false)
    private Integer chatid;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "message", nullable = false, length = 16777215)
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_delevered", nullable = false)
    private boolean isDelevered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_read", nullable = false)
    private boolean isRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    @JoinColumn(name = "receiverid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private User receiverid;
    @JoinColumn(name = "senderid", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private User senderid;

    public Chat() {
    }

    public Chat(Integer chatid) {
        this.chatid = chatid;
    }

    public Chat(Integer chatid, String message, Date time, Date date, boolean isDelevered, boolean isRead, boolean isDeleted) {
        this.chatid = chatid;
        this.message = message;
        this.time = time;
        this.date = date;
        this.isDelevered = isDelevered;
        this.isRead = isRead;
        this.isDeleted = isDeleted;
    }

    public Integer getChatid() {
        return chatid;
    }

    public void setChatid(Integer chatid) {
        this.chatid = chatid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getIsDelevered() {
        return isDelevered;
    }

    public void setIsDelevered(boolean isDelevered) {
        this.isDelevered = isDelevered;
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
        hash += (chatid != null ? chatid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.chatid == null && other.chatid != null) || (this.chatid != null && !this.chatid.equals(other.chatid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Chat[ chatid=" + chatid + " ]";
    }
    
}
