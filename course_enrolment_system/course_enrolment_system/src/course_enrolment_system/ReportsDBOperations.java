package course_enrolment_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NISHADI
 */
public class ReportsDBOperations extends DBconnect {

    int x;

    int practicalOrtheoritical(String subcode) {                                   //to determine the subject type(theoritical or practical)
        x = 2;
        try {
            connection();
            String query43 = "SELECT prac_or_theo FROM subjects WHERE sub_code=?";
            pst = con.prepareStatement(query43);
            pst.setString(1, subcode);
            rs1 = pst.executeQuery();
            if (rs1.next()) {
                x = rs1.getInt(1);                                                    //x is 0 if the subject is theoretical or else x is 1          
            }

        } catch (Exception e) {
            System.out.println(e);                                                                //if the subject is not in the subject table
        }
        return x;
    }

    ResultSet subjectProgress(int stdid, String subcode) {         //returns the current marks of the subject
        try {

            String query44;
            if (x == 0) {
                query44 = "SELECT inclass_ass1_marks,inclass_ass2_marks,report_marks,exam_marks FROM std_theoretical_subjects WHERE sub_code=? AND std_id=?";
                pst = con.prepareStatement(query44);
                pst.setString(1, subcode);
                pst.setInt(2, stdid);
                rs = pst.executeQuery();

            } else {
                query44 = "SELECT lab_ass_marks,practical_demo_marks,project_marks,exam_marks FROM std_practical_subjects WHERE sub_code=? AND std_id=?";
                pst = con.prepareStatement(query44);
                pst.setString(1, subcode);
                pst.setInt(2, stdid);
                rs = pst.executeQuery();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    void submitMarks(ReportDetails rd, String std_id, String subcode) {
        try {
            connection();
            if (x == 1) {
                String query45 = "UPDATE std_practical_subjects SET lab_ass_marks=?,practical_demo_marks=?,project_marks=?,exam_marks=? WHERE std_id=? AND sub_code=?";
                pst = con.prepareStatement(query45);

            }
            if (x == 0) {
                String query45 = "UPDATE std_theoretical_subjects SET inclass_ass1_marks=?,inclass_ass2_marks=?,report_marks=?,exam_marks=? WHERE std_id=? AND sub_code=?";
                pst = con.prepareStatement(query45);

            }
            pst.setString(1, rd.getAss1());
            pst.setString(2, rd.getAss2());
            pst.setString(3, rd.getAss3());
            pst.setString(4, rd.getExammarks());
            pst.setInt(5, Integer.parseInt(std_id));
            pst.setString(6, subcode);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    char calculateGrade(ReportDetails rd) {
        int assignmentmarks = 0;
        double a, b = 0;
        if (new String(rd.getAss1()) != "AB") {
            assignmentmarks += Integer.parseInt(rd.getAss1());
        }
        if (new String(rd.getAss2()) != "AB") {
            assignmentmarks += Integer.parseInt(rd.getAss2());
        }
        if (new String(rd.getAss3()) != "AB") {
            assignmentmarks += Integer.parseInt(rd.getAss3());
        }
        a = assignmentmarks / 3;
        b = (a / 10) * 3 + ((Integer.parseInt(rd.getExammarks()) / 10) * 7);             //assignments 30% exam 70%

        if (b >= 75) {
            return 'A';
        } else if (b >= 65) {
            return 'B';
        } else if (b >= 50) {
            return 'C';
        } else if (b >= 40) {
            return 'D';
        } else if (b >= 30) {
            return 'E';
        } else {
            return 'F';
        }

    }

    void sendGradetoTable(char c, String stdid, String subcode) {
        try {
            connection();
            if (x == 0) {
                String query46 = "UPDATE std_theoretical_subjects SET grade=? WHERE std_id=? AND sub_code=?";
                pst = con.prepareStatement(query46);
                pst.setString(1, String.valueOf(c));
                pst.setInt(2, Integer.parseInt(stdid));
                pst.setString(3, subcode);
                pst.executeUpdate();

            } else {
                String query46 = "UPDATE std_practical_subjects SET grade=? WHERE std_id=? AND sub_code=?";
                pst = con.prepareStatement(query46);
                pst.setString(1, String.valueOf(c));
                pst.setInt(2, Integer.parseInt(stdid));
                pst.setString(3, subcode);
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    ResultSet getname(int stdid) {
        try {
            connection();
            String query47 = "SELECT first_name,middle_name,last_name FROM student WHERE std_id=?";
            pst = con.prepareStatement(query47);
            pst.setInt(1, stdid);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    ArrayList getResults(String stdid, String sem) {

        ArrayList<ReportDetails> list = new ArrayList();
        try {
            connection();
            String query48 = "SELECT sub_code,grade FROM std_theoretical_subjects WHERE(std_id =? AND semester=?) UNION SELECT sub_code,grade FROM std_practical_subjects WHERE(std_id =? AND semester=?)";

            pst1 = con.prepareStatement(query48);
            pst1.setInt(1, Integer.parseInt(stdid));
            pst1.setString(2, sem);
            pst1.setInt(3, Integer.parseInt(stdid));
            pst1.setString(4, sem);
            rs1 = pst1.executeQuery();

            String query49 = "SELECT sub_name FROM subjects WHERE sub_code=?";
            pst = con.prepareStatement(query49);

            while (rs1.next()) {
                ReportDetails r = new ReportDetails();
                r.setSubcode(rs1.getString(1));
                r.setGrade(rs1.getString(2).charAt(0));

                pst.setString(1, rs1.getString(1));
                rs = pst.executeQuery();
                rs.next();
                r.setSubname(rs.getString(1));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
}
