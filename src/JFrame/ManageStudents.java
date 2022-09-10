/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author RITHU JALGAR
 */
public class ManageStudents extends javax.swing.JFrame
{

    /**
     * Creates new form ManageBooks
     */
    String studentName,branch,studentUsn;
    int semester;
    DefaultTableModel model;
    
    public ManageStudents() 
    {
        initComponents();
        setStudentDetailsToTable();
    }

    
    
    //to set the book deatils into the table
    public void setStudentDetailsToTable()
     {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from student_details");
             
             while(rs.next())
            {
            String StudentUsn=rs.getString("student_usn");
            String StudentName=rs.getString("name");
            int Semester=rs.getInt("semester");
            String Branch=rs.getString("branch");
            Object[] obj={StudentUsn,StudentName,Semester,Branch};
            model=(DefaultTableModel)tbl_studentDetails.getModel();
            model.addRow(obj);
            
            
            
            
            }
            
            }
        catch(Exception e)
        {
           e.printStackTrace();
        }
       }
    
    //TO ADD STUDENTS
    
    public boolean addStudent()
    {   
       boolean isAdded=false;
       studentUsn=txt_studentusn.getText();
       studentName=txt_studentName.getText();
       semester=Integer.parseInt(combo_semester.getSelectedItem().toString());
       branch=combo_branch.getSelectedItem().toString();
       
       
       
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            String sql="insert into student_details(student_usn,name,semester,branch) values (?,?,?,?)";
            PreparedStatement st= con. prepareStatement(sql);
            st.setString(1,studentUsn);
            st.setString(2,studentName);
            st.setInt(3,semester);
            st.setString(4,branch);
             
            int rowCount=st.executeUpdate();
            if(rowCount>0)
             {
               isAdded=true;  
             }
            else
             {
                 isAdded=false;
             }
                     
                     
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
           
       }
       return isAdded;
    }
    
    
    //to update student deatils
    public boolean updateStudent()
    {
        boolean isUpdated=false;
       
       studentUsn=txt_studentusn.getText();
       studentName=txt_studentName.getText();
       semester=Integer.parseInt(combo_semester.getSelectedItem().toString());
       branch=combo_branch.getSelectedItem().toString();
       
       
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            String sql="update student_details set name=?,semester=?,branch=? where student_usn=?";
            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setString(1,studentName);
            pst.setInt(2,semester);
            pst.setString(3,branch);
            pst.setString(4,studentUsn);
            int rowCount=pst.executeUpdate();
            
            if(rowCount>0)
                {
                    isUpdated=true;
                        
                }
            else
            {
                isUpdated=false;
            }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return isUpdated;
        
    }
    
    
    //to delete student detail
    public boolean deleteStudent()
    {
       studentUsn=txt_studentusn.getText();
        boolean isdeleted=false;
         try
       {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            String sql="delete from student_details  where student_usn=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,studentUsn);
            int rowCount=pst.executeUpdate();
            
            if(rowCount>0)
                {
                    isdeleted=true;
                        
                }
            else
            {
                isdeleted=false;
            }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return isdeleted;
        
    }
            
        
  
        
        
        
    
    
    //clear table 
    public void  clearTable()
    {
        DefaultTableModel model= (DefaultTableModel)tbl_studentDetails.getModel();
        model.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_studentusn = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        combo_semester = new javax.swing.JComboBox<>();
        combo_branch = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("BACK");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jLabel10.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Student  USN");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        txt_studentusn.setBackground(new java.awt.Color(153, 153, 255));
        txt_studentusn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentusn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_studentusn.setPlaceholder("Enter the Student USN");
        txt_studentusn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentusnFocusLost(evt);
            }
        });
        txt_studentusn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentusnActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentusn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 390, 30));

        jLabel11.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Student Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, 40));

        txt_studentName.setBackground(new java.awt.Color(153, 153, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_studentName.setPlaceholder("Enter the Student Name");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 390, 40));

        jLabel12.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter the Semester");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 220, 40));

        jLabel13.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter the Branch");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle1.setText("UPDATE");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 190, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 190, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle3.setText("DELETE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 190, 60));

        combo_semester.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        jPanel1.add(combo_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 400, -1));

        combo_branch.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "ISE", "ECE", "EEE", "CIVIL", "MECHANICAL", "ARTIFICIAL INTELLIGENCE AND DATA SCIENCE", "AERONAUTICAL " }));
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 400, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 30, 30));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_USN", "Name", "Semester", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(153, 153, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(153, 153, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 790, 260));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Manage Students");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 240, -1));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 230, 3));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 920, 820));

        setSize(new java.awt.Dimension(1500, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
       HomePage home=new HomePage();
       home.setVisible(true);
       dispose();
       
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txt_studentusnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentusnFocusLost
       

    }//GEN-LAST:event_txt_studentusnFocusLost

    private void txt_studentusnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentusnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentusnActionPerformed

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if( updateStudent()==true)
       {
           JOptionPane.showMessageDialog(this,"Student details updated");
           clearTable();
           setStudentDetailsToTable();
           
       }
       
       else{
             JOptionPane.showMessageDialog(this,"Student details updation failed ");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if( addStudent()==true)
       {
           JOptionPane.showMessageDialog(this,"Student added sucessfully");
           clearTable();
           setStudentDetailsToTable();
           
       }
       
       else{
             JOptionPane.showMessageDialog(this,"Student addition failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if( deleteStudent()==true)
       {
           JOptionPane.showMessageDialog(this,"Student deleted sucessfully");
           clearTable();
           setStudentDetailsToTable();
           
       }
       
       else{
             JOptionPane.showMessageDialog(this,"Student deletion failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo= tbl_studentDetails.getSelectedRow();
        TableModel model=tbl_studentDetails.getModel();
        
        
        txt_studentusn.setText(model.getValueAt(rowNo,0).toString());
        txt_studentName.setText(model.getValueAt(rowNo,1).toString());
        combo_semester.setSelectedItem(model.getValueAt(rowNo, 2));
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
        
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_semester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentName;
    private app.bolivia.swing.JCTextField txt_studentusn;
    // End of variables declaration//GEN-END:variables
}
