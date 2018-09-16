package course_enrolment_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindID extends javax.swing.JPanel {

    ResultSet lecin1, lecin2;
    SessionsDBOperations sdbops = new SessionsDBOperations();

    public FindID() {
        initComponents();
        lecin1 = sdbops.getLecIDs();
        lecin2 = sdbops.getInstructorIDs();
    }

    void loadLecturerIDs(ResultSet x) {

        ArrayList<LecturerInstructorDetails> list1 = new ArrayList();

        try {

            while (x.next()) {
                LecturerInstructorDetails lcinobjects1 = new LecturerInstructorDetails();
                lcinobjects1.setName(x.getString(1));
                lcinobjects1.setStaff_id(x.getInt(2));
                list1.add(lcinobjects1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        FindIDTableModel tblm1 = new FindIDTableModel(list1);
        tblLecID.setModel(tblm1);
    }

    void loadInstructorIDs(ResultSet y) {
        ArrayList<LecturerInstructorDetails> list2 = new ArrayList();

        try {

            while (y.next()) {

                LecturerInstructorDetails lcinobjects2 = new LecturerInstructorDetails();
                lcinobjects2.setName(y.getString(1));
                lcinobjects2.setStaff_id(y.getInt(2));
                list2.add(lcinobjects2);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        FindIDTableModel tblm2 = new FindIDTableModel(list2);
        tblLecID.setModel(tblm2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSeparator1 = new javax.swing.JSeparator();
        btnLecturerIDs = new javax.swing.JButton();
        btnInstIDs = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Find ID"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText(" Staff IDs :");

        tblLecID.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLecID);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnLecturerIDs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLecturerIDs.setText("Lecturers IDs");
        btnLecturerIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLecturerIDsActionPerformed(evt);
            }
        });

        btnInstIDs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInstIDs.setText("Instructors IDs");
        btnInstIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstIDsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnLecturerIDs, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnInstIDs, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLecturerIDs, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInstIDs, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLecturerIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecturerIDsActionPerformed
        loadLecturerIDs(lecin1);
    }//GEN-LAST:event_btnLecturerIDsActionPerformed

    private void btnInstIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstIDsActionPerformed
        loadInstructorIDs(lecin2);
    }//GEN-LAST:event_btnInstIDsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInstIDs;
    private javax.swing.JButton btnLecturerIDs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private final javax.swing.JTable tblLecID = new javax.swing.JTable();
    // End of variables declaration//GEN-END:variables
}
