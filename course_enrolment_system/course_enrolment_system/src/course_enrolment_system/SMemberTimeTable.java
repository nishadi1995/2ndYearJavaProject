package course_enrolment_system;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SMemberTimeTable extends AbstractTableModel {

    private static ArrayList<SessionsDetails> sessionsobjects;
    private static final String[] COLUMN_NAMES = {"Date", "Time", "Subject", "Lab num/Hall num", "Duration"};

    SMemberTimeTable(ArrayList<SessionsDetails> l) {
           sessionsobjects=l;
    }

    @Override
    public int getRowCount() {
        return sessionsobjects.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return sessionsobjects.get(rowIndex).getDate();
            case 1:
                return sessionsobjects.get(rowIndex).getTime();
            case 2:
                return sessionsobjects.get(rowIndex).getSubname();
            case 3:
                return sessionsobjects.get(rowIndex).getLocation();
            case 4:
                return sessionsobjects.get(rowIndex).getDuration();
            default:
                return "Error";
        }

    }

}
