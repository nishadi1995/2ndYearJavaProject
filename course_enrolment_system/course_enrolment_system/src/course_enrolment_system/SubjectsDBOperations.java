package course_enrolment_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class SubjectsDBOperations extends DBconnect {

    ResultSet fillCourseCombo() {                       //returns the available courses in the university
        try {
            connection();
            String query20 = "SELECT course_name FROM courses";
            pst = con.prepareStatement(query20);
            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    void addSubject(SubjectDetails subd) {                                       //add new subjects
        try {
            connection();

            String query21 = "SELECT course_id FROM courses WHERE course_name=?";
            pst = con.prepareStatement(query21);
            pst.setString(1, subd.getCourse());

            rs = pst.executeQuery();
            rs.next();

            String query22 = "INSERT INTO subjects VALUES (?,?,?,?,?,?,?)";
            pst1 = con.prepareStatement(query22);

            pst1.setString(1, subd.getSubcode());
            pst1.setString(2, subd.getSubname());
            pst1.setInt(3, subd.getFees());
            pst1.setInt(4, subd.getCredits());
            pst1.setString(5, subd.getYrsem());
            pst1.setString(6, rs.getString(1));
            pst1.setInt(7, subd.getI());

            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserted successfully!");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error while inserting..");
        }
    }

    ResultSet getRelavantSubjects(String stdid, String yr_sem) {                        //returns the subjects related to the course and semester
        try {
            connection();
            String query23 = "SELECT sub_name FROM subjects WHERE sub_code IN (SELECT sub_code FROM subjects WHERE course_id =(SELECT course_id FROM student WHERE std_id = ?) AND yr_sem = ?)";

            pst = con.prepareStatement(query23);
            pst.setInt(1, Integer.parseInt(stdid));
            pst.setString(2, yr_sem);

            rs = pst.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    ResultSet getSelectedSubjects(String stdid, String yr_sem) {                //returns the subjects which are selected already
        try {
            connection();
            String query24 = "SELECT sub_name,sub_code,credits,fees FROM subjects WHERE sub_code IN(SELECT sub_code FROM std_practical_subjects WHERE (std_id =? AND semester=?) UNION SELECT sub_code FROM std_theoretical_subjects WHERE (std_id =? AND semester=?))";
            pst = con.prepareStatement(query24);
            pst.setInt(1, Integer.parseInt(stdid));
            pst.setString(2, yr_sem);
            pst.setInt(3, Integer.parseInt(stdid));
            pst.setString(4, yr_sem);

            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    void addSelectedSubjects(DefaultListModel dm, String stdid) {                //add the selected subjects to the database
        try {
            connection();
            for (int i = 0; i < dm.getSize(); i++) {
                String query25 = "SELECT sub_code,prac_or_theo,yr_sem FROM subjects WHERE sub_name=?";
                pst = con.prepareStatement(query25);
                pst.setString(1, (String) dm.getElementAt(i));
                rs = pst.executeQuery();
                rs.next();

                if (false == rs.getBoolean(2)) {                                               //if subject is theoretical
                    String query26 = "INSERT INTO std_theoretical_subjects (std_id,sub_code,semester) VALUES (?,?,?)ON DUPLICATE KEY UPDATE std_id=?";
                    pst1 = con.prepareStatement(query26);

                } else {                                                                    //if the subject is practical
                    String query26 = "INSERT INTO std_practical_subjects (std_id,sub_code,semester) VALUES (?,?,?)ON DUPLICATE KEY UPDATE std_id=?";
                    pst1 = con.prepareStatement(query26);
                }

                pst1.setInt(1, Integer.parseInt(stdid));
                pst1.setString(2, rs.getString(1));
                pst1.setString(3, rs.getString(3));
                pst1.setInt(4, Integer.parseInt(stdid));
                pst1.executeUpdate();

            }
            JOptionPane.showMessageDialog(null, "Inserted successfully!");

        } catch (Exception e) {
            System.out.println("11" + e);
        }
    }

    void removesubject(String sub, String stdid) {                              //remove the relevent subject from db
        try {
            connection();
            String query29 = "SELECT sub_code,prac_or_theo FROM subjects WHERE sub_name=?";
            pst = con.prepareStatement(query29);
            pst.setString(1, sub);
            rs = pst.executeQuery();
            rs.next();
            if (rs.getBoolean(2)) {
                String query30 = "DELETE FROM std_practical_subjects WHERE (sub_code=? AND std_id=?)";
                pst1 = con.prepareStatement(query30);
                pst1.setString(1, rs.getString(1));
                pst1.setInt(2, Integer.parseInt(stdid));
                pst1.executeUpdate();

            } else {
                String query31 = "DELETE FROM std_theoretical_subjects WHERE (sub_code=? AND std_id=?)";
                pst1 = con.prepareStatement(query31);
                pst1.setString(1, rs.getString(1));
                pst1.setInt(2, Integer.parseInt(stdid));
                pst1.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    int checkstudent(String stdid, String yr_sem) {
        try {
            connection();
            String query27 = "SELECT std_id FROM student WHERE std_id=?";
            String query28 = "SELECT 1 FROM std_theoretical_subjects WHERE(std_id =? AND semester=?) UNION SELECT 1 FROM std_practical_subjects WHERE(std_id =? AND semester=?) ";
            pst = con.prepareStatement(query27);
            pst.setInt(1, Integer.parseInt(stdid));
            rs = pst.executeQuery();

            pst1 = con.prepareStatement(query28);
            pst1.setInt(1, Integer.parseInt(stdid));
            pst1.setString(2, yr_sem);
            pst1.setInt(3, Integer.parseInt(stdid));
            pst1.setString(4, yr_sem);
            rs1 = pst1.executeQuery();
            if (!rs.first()) {
                return 1;
            } else if (!rs1.first()) {
                return 2;
            }

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        return 0;
    }
}
