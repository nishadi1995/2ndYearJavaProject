package course_enrolment_system;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ReportTableModel extends AbstractTableModel {

    private static ArrayList<ReportDetails> rprtobjects;
    private static final String[] COLUMN_NAMES = {"Subject Name", "Subject Code", "Grade"};

    ReportTableModel(ArrayList<ReportDetails> list) {
        rprtobjects = list;
    }

    @Override
    public int getRowCount() {
        return rprtobjects.size();
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
                return rprtobjects.get(rowIndex).getSubname();
            case 1:
                return rprtobjects.get(rowIndex).getSubcode();
            case 2:
                return rprtobjects.get(rowIndex).getGrade();
            default:
                return "Error";

        }
    }
}
