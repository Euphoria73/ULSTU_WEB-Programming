package email.model;

import email.core.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Email extends BaseEntity {
    private Date dateIn;
    private Date dateOut;
    private String room;
    private Integer guestCount;

    public Email() {

    }

    public Email(Date dateIn, Date dateOut,String room, Integer guestCount) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.room = room;
        this.guestCount = guestCount;
    }

    public Date getDataIn() {
        return dateIn;
    }

    public void setDataIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDataOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }
}
