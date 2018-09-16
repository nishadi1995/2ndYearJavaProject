package course_enrolment_system;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FindIDTableModel extends AbstractTableModel {

    private static ArrayList<LecturerInstructorDetails> lcinobjects;
    private static final String[] COLUMN_NAMES = {"Lecturer Name", "Staff_ID"};

    FindIDTableModel(ArrayList<LecturerInstructorDetails> list) {
        lcinobjects = list;
    }

    @Override
    public int getRowCount() {
        return lcinobjects.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
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
                return lcinobjects.get(rowIndex).getName();
            case 1:
                return lcinobjects.get(rowIndex).getStaff_id();
            default:
                return "Error";

        }
    }

}
