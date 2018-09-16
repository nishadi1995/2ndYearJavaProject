package course_enrolment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//this class is next to the database layer(backend) to connect database and the project
public class DBconnect {

    String url = "jdbc:mysql://localhost:3306/course_enrolment_system";   //Since the DB is installed in the same computer IP adress is localhost
    String username = "root";                                             //mysql service is running in port 3306.This url is to find the location of the DB 
    String password = "";
    Connection con = null;
    PreparedStatement pst, pst1 = null;
    ResultSet rs, rs1, rs2 = null;

    public void connection() {
        try {
            con = DriverManager.getConnection(url, username, password);   //get the connection.This throws a SQLException
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Oops..Connection Error!!");
        }

    }
}
