package course_enrolment_system;

import java.sql.Time;

public class SessionsDetails {

    private int staff_id1;
    private int staff_id2;
    private String subcode;
    private java.util.Calendar date;
    private java.time.LocalTime time;
    private String location;
    private int duration;
    private String subname;
    
    
    public int getStaff_id1() {
        return staff_id1;
    }

    public void setStaff_id1(int staff_id1) {
        this.staff_id1 = staff_id1;
    }
    
    public int getStaff_id2() {
        return staff_id2;
    }

    public void setStaff_id2(int staff_id2) {
        this.staff_id2 = staff_id2;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public java.sql.Date getDate() {
        return new java.sql.Date(date.getTime().getTime());
    }

    public void setDate(java.util.Calendar date) {
        this.date = date;
    }

    public java.sql.Time getTime() {
        Time sqltime = Time.valueOf(time);
        return sqltime;
    }

    public void setTime(java.time.LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String getSubname() {
        return subname;
    }

    
    public void setSubname(String subname) {
        this.subname = subname;
    }

}
