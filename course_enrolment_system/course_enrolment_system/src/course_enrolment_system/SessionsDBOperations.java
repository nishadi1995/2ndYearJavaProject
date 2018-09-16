package course_enrolment_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class SessionsDBOperations extends DBconnect {

    void addLecture(SessionsDetails sd) {
        try {
            connection();
            String query39 = "INSERT INTO sessions VALUES(?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query39);

            pst.setDate(1, sd.getDate());
            pst.setTime(2, sd.getTime());
            pst.setString(3, sd.getLocation());
            pst.setInt(4, sd.getDuration());
            pst.setInt(5, sd.getStaff_id1());
            pst.setString(6, sd.getSubcode());
            pst.setInt(7, 0);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully inserted!!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    void addLab(SessionsDetails sd) {
        try {
            connection();
            String query40 = "INSERT INTO sessions VALUES(?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query40);

            for (int i = 0; i < 2; i++) {                     //insert 2 rows for one lab,with same details but changing the instructor id
                pst.setDate(1, sd.getDate());
                pst.setTime(2, sd.getTime());
                pst.setString(3, sd.getLocation());
                pst.setInt(4, sd.getDuration());
                if (i == 0) {
                    pst.setInt(5, sd.getStaff_id1());
                } else {
                    pst.setInt(5, sd.getStaff_id2());
                }

                pst.setString(6, sd.getSubcode());
                pst.setInt(7, 1);

                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Successfully inserted!!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    ResultSet getLecIDs() {
        try {
            connection();
            String query41 = "SELECT name,staff_id FROM academic_staff WHERE lec_or_inst=?";
            pst1 = con.prepareStatement(query41);
            pst1.setInt(1, 1);

            rs1 = pst1.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs1;
    }

    ResultSet getInstructorIDs() {
        try {
            connection();
            String query42 = "SELECT name,staff_id FROM academic_staff WHERE lec_or_inst=?";
            pst = con.prepareStatement(query42);
            pst.setInt(1, 0);

            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    ArrayList getSessions(String staffid) {
        ArrayList<SessionsDetails> list = new ArrayList();
        Calendar cal = Calendar.getInstance();

        try {
            int stfid = Integer.parseInt(staffid);
            connection();
            String query37 = "SELECT * FROM sessions WHERE staff_id=?";
            pst1 = con.prepareStatement(query37);
            pst1.setInt(1, stfid);
            rs1 = pst1.executeQuery();

            String query38 = "SELECT sub_name FROM subjects WHERE sub_code=?";
            pst = con.prepareStatement(query38);

            if (!rs1.first()) {
                JOptionPane.showMessageDialog(null, "Staff ID not found!!");
            } else {

                do {
                    SessionsDetails sd = new SessionsDetails();
                    cal.setTime(rs1.getDate(1));
                    sd.setDate(cal);
                    sd.setTime(rs1.getTime(2).toLocalTime());
                    sd.setLocation(rs1.getString(3));
                    sd.setDuration(rs1.getInt(4));

                    pst.setString(1, rs1.getString(6));
                    rs = pst.executeQuery();
                    rs.next();
                    sd.setSubname(rs.getString(1));
                    list.add(sd);
                } while (rs1.next());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }

}
