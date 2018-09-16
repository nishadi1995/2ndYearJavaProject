package course_enrolment_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class LecInsDBOperations extends DBconnect {

    int staff_id;

    ResultSet fillSubjects() {
        try {
            connection();
            String query36 = "SELECT sub_name FROM subjects";
            pst = con.prepareStatement(query36);
            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;

    }

    void addLecInst(LecturerInstructorDetails lid) {
        try {
            connection();
            String query32 = "INSERT INTO academic_staff VALUES(?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query32);

            pst.setInt(1, lid.getStaff_id());
            pst.setString(2, lid.getName());
            pst.setString(3, lid.getAddress());
            pst.setInt(4, lid.getConnum());
            pst.setString(5, lid.getEmail());
            pst.setString(6, lid.getRoom());
            pst.setInt(7, lid.getI());

            pst.executeUpdate();

            String query34 = "SELECT staff_id FROM academic_staff ORDER BY staff_id DESC LIMIT 1";
            pst1 = con.prepareStatement(query34);
            rs = pst1.executeQuery();
            rs.next();
            JOptionPane.showMessageDialog(null, "Inserted successfully! Staff ID is " + rs.getInt(1));
            staff_id = rs.getInt(1);

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error,while inserting..");
        }
    }

    void addSubjects(DefaultListModel dm) {

        for (int i = 0; i < dm.getSize(); i++) {
            try {
                String query36 = "SELECT sub_code FROM subjects WHERE sub_name = ?";
                pst1 = con.prepareStatement(query36);
                pst1.setString(1, (String) dm.getElementAt(i));
                rs = pst1.executeQuery();
                rs.next();

                String query35 = "INSERT INTO staff_subjects (staff_id,sub_code) VALUES (?,?)";
                pst = con.prepareStatement(query35);
                pst.setInt(1, staff_id);
                pst.setString(2, rs.getString(1));
                pst.executeUpdate();


            } catch (SQLException ex) {
                System.out.println(ex);

            }

        }
    }

    ResultSet viewStaff(int id) {
        try {
            connection();
            String query33 = "SELECT * FROM academic_staff WHERE staff_id = ?";
            pst = con.prepareStatement(query33);
            pst.setInt(1, id);
            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    void updateLecInst(LecturerInstructorDetails lid) {
        try {
            connection();
            String query35 = "UPDATE academic_staff SET name=?, address=?, con_num=?, email=?, room=? WHERE (staff_id=?)";
            pst = con.prepareStatement(query35);

            pst.setString(1, lid.getName());
            pst.setString(2, lid.getAddress());
            pst.setInt(3, lid.getConnum());
            pst.setString(4, lid.getEmail());
            pst.setString(5, lid.getRoom());
            pst.setInt(6, lid.getStaff_id());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated successfully!!");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error,while updating..");
        }

    }
}
