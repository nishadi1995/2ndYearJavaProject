
package course_enrolment_system;


public class UndergratDetails extends StudentDetails {

    
    private String alresults;
    private int drank; private int irank;
    private double zscore;
    

   
    public int getDrank() {
        return drank;
    }

    
    public void setDrank(int drank) {
        this.drank = drank;
    }

    
    public int getIrank() {
        return irank;
    }

    
    public void setIrank(int irank) {
        this.irank = irank;
    }

    
    public double getZscore() {
        return zscore;
    }

    
    public void setZscore(double zscore) {
        this.zscore = zscore;
    }
    
        
    public String getAlresults() {
        return alresults;
    }

    
    public void setAlresults(String sub1,String sub2,String sub3) {
        this.alresults=sub1+sub2+sub3;
    }
    
}
