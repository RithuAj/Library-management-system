/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;



/**
 *
 * @author RITHU JALGAR
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
     
    
    //to fetch the book details from the database and display it to book details panel
    public void getBookDetails()
    {
        int bookId=Integer.parseInt(txt_bookId.getText());
        
        try{
            Connection con =DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from book_deatils where book_id=?");
            pst.setInt(1,bookId);
            ResultSet rs = pst.executeQuery();
            
            
            if(rs.next())
            {
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
                
            
            
            
             }
            else
            {
                 lbl_bookError.setText("Invalid book Id");
            }
        }
        catch(Exception e)
                {
            e.printStackTrace();
        }
    }
    
    
    //to fetch the book details from the database and display it to book details panel
    public void getstudentDetails()
    {
        String studentUsn=txt_studentUsn.getText();
        
        try{
            Connection con =DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from student_details where student_usn=?");
            pst.setString(1,studentUsn);
            ResultSet rs = pst.executeQuery();
            
            
            if(rs.next())
            {
                lbl_studentUsn.setText(rs.getString("student_usn"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_semester.setText(rs.getString("semester"));
                lbl_branch.setText(rs.getString("branch"));
            }
            else
            {
                 lbl_studentError.setText("Invalid Student Id");
            }
        }
        catch(Exception e)
                {
            e.printStackTrace();
        }
    }
    
    //INSERT ISSUE BOOK DETAILS TO DATABASE
    public boolean issueBook()
    {   boolean isIssued=false;
        int bookId= Integer.parseInt(txt_bookId.getText());
        String studentUsn=txt_studentUsn.getText();
        String bookName= lbl_bookName.getText();
        String studentName= lbl_studentName.getText();
        
        Date uIssueDate=date_issueDate.getDatoFecha();
        Date uDueDate=date_dueDate.getDatoFecha();
        
        Long l1=uIssueDate.getTime();
        Long l2=uDueDate.getTime();
        
        
        java.sql.Date sIssueDate= new java.sql.Date(l1);
        java.sql.Date sDueDate= new java.sql.Date(l2);
        
        
        try{
            Connection con=DBConnection .getConnection();
            String sql="insert into issue_book_details(book_id,book_name,student_usn,student_name,issue_date,due_date,status) values (?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookName);
            pst.setString(3,studentUsn);
            pst.setString(4,studentName);
            pst.setDate(5,sIssueDate);
            pst.setDate(6,sDueDate);
            pst.setString(7,"PENDING");
            
            
            int rowCount=pst.executeUpdate();
            if(rowCount>0)
            {
               isIssued=true; 
            }
            else
            {
                isIssued=false;
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return isIssued;
    
}
    
     //UPDATING BOOK COUNT
    public void updateBookCount()
    {
        int bookId= Integer.parseInt(txt_bookId.getText());
       try{
           Connection con=DBConnection .getConnection();
            String sql="update book_deatils set quantity=quantity-1 where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            
            
            int rowCount=pst.executeUpdate();
            if(rowCount>0)
            {
               JOptionPane.showMessageDialog(this,"Book count updated");
               int initialCount=Integer.parseInt(lbl_quantity.getText());
               lbl_quantity.setText(Integer.toString(initialCount-1));
               
            }
            else
            {
               JOptionPane.showMessageDialog(this,"Book count not updated");
            }
           
       } 
       catch(Exception e){
           e.printStackTrace();
           
       }
    }
    
    //CHECKING BOOK  IS ALREADLY ALLOCATED OR NOT 
   public boolean isAlreadyIssued(){
       boolean isAlreadyIssued=false;
       int bookId= Integer.parseInt(txt_bookId.getText());
       String studentUsn=txt_studentUsn.getText();
       
       
       try
       {
           Connection con=DBConnection .getConnection();
           String sql="select * from issue_book_details where book_id=? and student_usn=? and status=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1,bookId);
           pst.setString(2,studentUsn);
           pst.setString(3,"PENDING");
           
           ResultSet rs=pst.executeQuery();
           if(rs.next())
           {
               isAlreadyIssued=true;
               
           }
           else
           {
              isAlreadyIssued=false; 
           }
           
           
           
           
       }
       catch (Exception e)
       {
        e.printStackTrace();
       }
       return isAlreadyIssued;
       
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_studentUsn = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_semester = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_studentUsn = new app.bolivia.swing.JCTextField();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(51, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDENT DETAILS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 220, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 135, 220, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Branch :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 160, 30));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 200, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 160, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Semester :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 160, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student USN :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, 30));

        lbl_studentUsn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentUsn.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentUsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 200, 30));

        lbl_studentName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 200, 30));

        lbl_semester.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_semester.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 200, 30));

        lbl_studentError.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        lbl_studentError.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_studentErrorFocusLost(evt);
            }
        });
        jPanel1.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 310, 30));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 420, 810));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setForeground(new java.awt.Color(51, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("BACK");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("BOOK DETAILS");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 135, 220, 5));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantity :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 160, 30));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 200, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Name :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 160, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author :");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 160, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book Id :");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, 30));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 200, 30));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 200, 30));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 200, 30));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel4.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 320, 30));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("ISSUE BOOK");
        panel_main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 90, 140, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panel_main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 0, 30, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 0));
        jLabel10.setText("Book Id");
        panel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, -1, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setForeground(new java.awt.Color(255, 51, 0));
        txt_bookId.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter the Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 160, 320, 30));

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, 250, 5));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 0));
        jLabel14.setText("Issue Date :");
        panel_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 310, 150, -1));

        txt_studentUsn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentUsn.setForeground(new java.awt.Color(255, 51, 0));
        txt_studentUsn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txt_studentUsn.setPlaceholder("Enter the Student Id");
        txt_studentUsn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentUsnFocusLost(evt);
            }
        });
        txt_studentUsn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentUsnActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentUsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 230, 300, 30));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issueDate.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        date_issueDate.setPlaceholder("Select issue date");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 330, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 0));
        jLabel18.setText("Student Id");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 190, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 0));
        jLabel19.setText("Due Date :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 380, 150, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_dueDate.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        date_dueDate.setPlaceholder("Select due date");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 380, 330, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle2.setText(" ISSUE BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 470, 360, 60));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals(""))
        {
             getBookDetails();
        }
       
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentUsnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentUsnFocusLost
        if(!txt_studentUsn.getText().equals(""))
        {
             getstudentDetails();
        }
    }//GEN-LAST:event_txt_studentUsnFocusLost

    private void txt_studentUsnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentUsnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentUsnActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(lbl_quantity.getText().equals("0"))
            
        {
            JOptionPane.showMessageDialog(this,"book is not available");
            
        }
        else
        {
           if(isAlreadyIssued()==false)
        {
            
        
        if(issueBook()==true)
        {
            JOptionPane.showMessageDialog(this,"book issued successfully");
            updateBookCount();
            
        }
        else{
            JOptionPane.showMessageDialog(this,"book issueing failed");
        }
        } 
        else{
            JOptionPane.showMessageDialog(this,"This student already has this book");
        } 
        }
        
        
                
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void lbl_studentErrorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentErrorFocusLost
       
    }//GEN-LAST:event_lbl_studentErrorFocusLost

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        HomePage home= new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_semester;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JLabel lbl_studentUsn;
    private javax.swing.JPanel panel_main;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentUsn;
    // End of variables declaration//GEN-END:variables
}
