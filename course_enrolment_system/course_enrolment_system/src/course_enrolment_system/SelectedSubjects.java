package course_enrolment_system;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NISHADI
 */
public class SelectedSubjects extends AbstractTableModel {

    private static ArrayList<SubjectDetails> subjectobjects;
    private static final String[] COLUMN_NAMES = {"Subject Name", "Subject Code", "Credits", "Fees"};
    private double feestopay=0;
    
    SelectedSubjects(ArrayList<SubjectDetails> list) {
        subjectobjects = list;
    }

    @Override
    public int getRowCount() {
        return subjectobjects.size();
    }

    @Override
    public String getColumnName(int columnIndex){
       return COLUMN_NAMES[columnIndex];
    }
    
    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return subjectobjects.get(rowIndex).getSubname();
            case 1:
                return subjectobjects.get(rowIndex).getSubcode();
            case 2:
                return subjectobjects.get(rowIndex).getCredits();
            case 3:
                return subjectobjects.get(rowIndex).getFees();
            default:
                return "Error";

        }
    }
    
    public double total(){
        for (SubjectDetails subjectobject : subjectobjects) {
           feestopay+=subjectobject.getFees();
        }
        return feestopay;
    }

}
