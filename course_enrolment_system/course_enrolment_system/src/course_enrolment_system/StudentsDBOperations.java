package course_enrolment_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class StudentsDBOperations extends DBconnect {

    void checkvalidation(String logusername, String logpassword) {
        try {
            connection();
            String query1 = "SELECT * FROM login WHERE username= ?";        //sql query to run

            pst = con.prepareStatement(query1);                             //A SQL statement with or without IN parameters can be pre-compiled and stored in a PreparedStatement object.This object can then be used to efficiently execute this statement multiple times.
            pst.setString(1, logusername);                                 //sets the parameter to a string.Driver then converts it to a SQL VARCHAR when it sends to the DB 
            rs = pst.executeQuery();                                        // execute the sql query and returns the object containing the data produced by the query
            boolean b = rs.next();                                          //moves the cursor one row forword from the current position.return true if the current row is valid

            if (b == false) {
                JOptionPane.showMessageDialog(null, "Error! Entered username doesn't exsist");
            } else {
                if (logpassword.equals(rs.getString(2))) {                      //retrives the value in 2nd colomn in resultset object
                    SecondWindow sw = new SecondWindow();
                    sw.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Password is incorrect");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();              //return current date as sql.date
        return new java.sql.Date(today.getTime());
    }

    void addUndergraduate(UndergratDetails ud) {
        try {
            connection();
            String query2 = "SELECT course_id FROM courses WHERE course_name=?";
            pst1 = con.prepareStatement(query2);
            pst1.setString(1, ud.getCoursename());

            rs1 = pst1.executeQuery();
            rs1.next();

            String query3 = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query3);

            pst.setInt(1, ud.getStd_id());                            //add values to sql query
            pst.setString(2, ud.getFirstname());                      //add values to sql query
            pst.setString(3, ud.getMidname());                        //add values to sql query
            pst.setString(4, ud.getLastname());                       //add values to sql query
            pst.setString(5, ud.getNic());                             //add values to sql query
            pst.setDate(6, ud.getDob());
            pst.setInt(7, ud.getConnum());
            pst.setString(8, ud.getAddress());
            pst.setString(9, Character.toString(ud.getGender()));
            pst.setString(10, ud.getIntake());
            pst.setDate(11, getCurrentDate());
            pst.setString(12, rs1.getString(1));

            pst.executeUpdate();                                     //execute the sql query and add values to db table

            String query4 = "SELECT std_id FROM student ORDER BY std_id DESC LIMIT 1";
            pst1 = con.prepareStatement(query4);
            rs = pst1.executeQuery();
            rs.next();

            String query5 = "INSERT INTO undergraduate VALUES(?,?,?,?,?,?)";
            pst = con.prepareStatement(query5);

            pst.setInt(1, Integer.parseInt(rs.getString(1)));
            pst.setString(2, ud.getAlresults());
            pst.setInt(3, ud.getDrank());
            pst.setInt(4, ud.getIrank());
            pst.setDouble(5, ud.getZscore());
            pst.setString(6, rs1.getString(1));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserted successfully! Student ID is " + rs.getString(1));

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error,while inserting..");
        }finally{
            try{
             if(pst != null){
              pst.close();
             }
             if(con != null){
             con.close();
             }
            }catch(Exception e){}
        }
    }

    void addPostgraduate(PostgratDetails pd) {

        try {
            connection();

            String query6 = "SELECT course_id FROM courses WHERE course_name=?";
            pst1 = con.prepareStatement(query6);
            pst1.setString(1, pd.getCoursename());
            rs1 = pst1.executeQuery();
            rs1.next();

            String query7 = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query7);

            pst.setInt(1, pd.getStd_id());
            pst.setString(2, pd.getFirstname());
            pst.setString(3, pd.getMidname());
            pst.setString(4, pd.getLastname());
            pst.setString(5, pd.getNic());
            pst.setDate(6, pd.getDob());
            pst.setInt(7, pd.getConnum());
            pst.setString(8, pd.getAddress());
            pst.setString(9, Character.toString(pd.getGender()));
            pst.setString(10, pd.getIntake());
            pst.setDate(11, getCurrentDate());
            pst.setString(12, rs1.getString(1));                             //retrieves the value of the designated column in the current row of this ResultSet object

            pst.executeUpdate();

            String query8 = "SELECT std_id FROM student ORDER BY std_id DESC LIMIT 1";
            pst1 = con.prepareStatement(query8);
            rs = pst1.executeQuery();
            rs.next();

            String query9 = "INSERT INTO postgraduate VALUES(?,?,?,?,?)";
            pst = con.prepareStatement(query9);

            pst.setInt(1, Integer.parseInt(rs.getString(1)));
            pst.setString(2, pd.getQualType());
            pst.setString(3, pd.getInstitute());
            pst.setString(4, pd.getYear_completed());
            pst.setString(5, rs1.getString(1));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserted successfully! Student ID is " + rs.getString(1));

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error,when inserting..");
        }finally{                                           //releasing the resources
            try{
             if(pst != null){
              pst.close();
             }
             if(con != null){
             con.close();
             }
            }catch(Exception e){}
        }
    }

    int deletestudent(String stdid) {
        try {
            connection();
            String query10 = "DELETE FROM student WHERE std_id=?";
            pst = con.prepareStatement(query10);
            pst.setInt(1, Integer.parseInt(stdid));
            int x = pst.executeUpdate();                       //returns either the row count for SQL Data Manipulation Language (DML) statements or 0 for SQL statements that return nothing
            return x;                                          //returns one if successfully deleted.

        } catch (Exception e) {
            System.out.println(e);
            return 2;
        }finally{                                             //releasing the resources
            try{
             if(pst != null){
              pst.close();
             }
             if(con != null){
             con.close();
             }
            }catch(Exception e){}
        }
    }

    StudentDetails viewStudent(String stdid) {
        StudentDetails sd = new StudentDetails();
        Calendar cal = Calendar.getInstance();

        try {
            connection();
            String query11 = "SELECT * FROM student WHERE std_id = ?";
            pst = con.prepareStatement(query11);
            pst.setInt(1, Integer.parseInt(stdid));
            rs = pst.executeQuery();
            
            if(rs.next()){
            
            sd.setFirstname(rs.getString(2));
            sd.setMidname(rs.getString(3));
            sd.setLastname(rs.getString(4));
            sd.setNic(rs.getString(5));
            cal.setTime(rs.getDate(6));                      //convert date to calendar
            sd.setDob(cal);
            sd.setConnum(rs.getInt(7));
            sd.setAddress(rs.getString(8));
            sd.setGender(rs.getString(9).charAt(0));
            sd.setIntake(rs.getString(10));
            sd.setEndate(rs.getDate(11));

            String query12 = "SELECT course_name FROM courses WHERE course_id = ?";
            pst = con.prepareStatement(query12);
            pst.setString(1, rs.getString(12));
            rs1 = pst.executeQuery();rs1.next();
            sd.setCoursename(rs1.getString(1));
            
            return sd;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
        
    }

    ResultSet getundergraduateCourses() {
        try {
            connection();
            String query12 = "SELECT course_name FROM courses WHERE type=?";
            pst = con.prepareStatement(query12);
            pst.setString(1, "Bachelor");
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    ResultSet getpostgraduateCourses() {
        try {
            connection();
            String query12 = "SELECT course_name FROM courses WHERE type=?";
            pst = con.prepareStatement(query12);
            pst.setString(1, "Master");
            rs1 = pst.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs1;
    }

}
