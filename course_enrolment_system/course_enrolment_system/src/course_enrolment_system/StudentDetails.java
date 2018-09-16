package course_enrolment_system;

import java.util.Date;

public class StudentDetails {


    private int std_id;
    private String firstname;
    private String midname;
    private String lastname;
    private String nic;
    private java.util.Calendar dob;
    private int connum;
    private String address;
    private char gender;
    private String intake;
    private String coursename;
    private Date endate;

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getConnum() {
        return connum;
    }

    public void setConnum(int connum) {
        this.connum = connum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getIntake() {
        return intake;
    }

    public void setIntake(String intake) {
        this.intake = intake;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public java.sql.Date getDob() {
        return new java.sql.Date(dob.getTime().getTime());
    }

    public void setDob(java.util.Calendar dob) {
        this.dob = dob;
    }
    
    public Date getEndate() {
        return endate;
    }

    
    public void setEndate(Date endate) {
        this.endate = endate;
    }

}
