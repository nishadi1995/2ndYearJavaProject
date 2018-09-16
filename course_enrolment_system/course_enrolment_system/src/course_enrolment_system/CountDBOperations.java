package course_enrolment_system;

import java.sql.ResultSet;

public class CountDBOperations extends DBconnect {

    int undergratsCount() {
        try {
            connection();
            String query13 = "SELECT COUNT(std_id) FROM undergraduate";
            pst = con.prepareStatement(query13);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    int postgratsCount() {
        try {
            connection();
            String query14 = "SELECT COUNT(std_id) FROM postgraduate";
            pst = con.prepareStatement(query14);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    int facultycount(String facname) {
        try {
            connection();

            String query15 = "SELECT COUNT(std_id) FROM undergraduate x  INNER JOIN (SELECT course_id FROM courses WHERE faculty_name=?) y ON x.course_id= y.course_id";
            pst = con.prepareStatement(query15);
            pst.setString(1, facname);
            rs = pst.executeQuery();
            rs.next();

            String query16 = "SELECT COUNT(std_id) FROM postgraduate x  INNER JOIN (SELECT course_id FROM courses WHERE faculty_name=?) y ON x.course_id= y.course_id";
            pst1 = con.prepareStatement(query16);
            pst1.setString(1, facname);
            rs1 = pst1.executeQuery();
            rs1.next();

            return rs.getInt(1) + rs1.getInt(1);

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    int coursecount(String coursename) {
        try {
            connection();
            String query17 = "SELECT course_id,type FROM courses WHERE course_name=?";
            pst = con.prepareStatement(query17);
            pst.setString(1, coursename);
            rs = pst.executeQuery();
            rs.next();

            if ("Master".equals(rs.getString(2))) {
                String query18 = "SELECT COUNT(std_id) FROM postgraduate WHERE course_id=?";
                pst1 = con.prepareStatement(query18);
                pst1.setString(1, rs.getString(1));
                rs1 = pst1.executeQuery();
                rs1.next();
                System.out.println("hhh");
                return rs1.getInt(1);

            } else {
                String query19 = "SELECT COUNT(std_id) FROM undergraduate WHERE course_id=?";
                pst1 = con.prepareStatement(query19);
                pst1.setString(1, rs.getString(1));
                rs1 = pst1.executeQuery();
                rs1.next();
                                System.out.println("oooo");

                return rs1.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    ResultSet getCourses() {
        try {
            connection();
            String query20 = "SELECT course_name FROM courses";
            pst = con.prepareStatement(query20);
            rs=pst.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
}
