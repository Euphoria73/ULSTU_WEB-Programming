package email.model;

import java.util.Date;

public class EmailForm {
    private Date dateIn;
    private Date dateOut;
    private String room;
    private Integer guestCount;

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
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

    @Override
    public String toString() {
        return "EmailForm{" +
                "dateIn='" + dateIn + '\'' +
                "dateOut='" + dateOut + '\'' +
                ", room='" + room + '\'' +
                ", guestCount='" + guestCount + '\'' +
                '}';
    }
}
