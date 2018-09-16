
package course_enrolment_system;


public class PostgratDetails extends StudentDetails{
    
    
    private String qualType;
    private String institute;
    private String year_completed;
    
    
    
    public String getQualType() {
        return qualType;
    }

    
    public void setQualType(String qualType) {
        this.qualType = qualType;
    }

    
    public String getInstitute() {
        return institute;
    }

    
    public void setInstitute(String institute) {
        this.institute = institute;
    }

   
    public String getYear_completed() {
        return year_completed;
    }

    
    public void setYear_completed(String year_completed) {
        this.year_completed = year_completed;
    }
}
