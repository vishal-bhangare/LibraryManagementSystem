/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.vishal.librarymanagementsystem;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author vishal
 */
public class Login extends javax.swing.JFrame {
    LibraryManagementSystem lms = new LibraryManagementSystem();
    Connection connection = LibraryManagementSystem.connection;
    Statement statement = LibraryManagementSystem.statement;
    PreparedStatement pstmt = LibraryManagementSystem.pstmt;
    ResultSet rs = LibraryManagementSystem.rs;
    /**
     * Creates new form login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        background = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        head2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        head1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        LoginPanels = new javax.swing.JTabbedPane();
        adminPanel = new javax.swing.JPanel();
        adminUserlbl = new javax.swing.JLabel();
        adminPasslbl = new javax.swing.JLabel();
        adminUser = new javax.swing.JTextField();
        adminPass = new javax.swing.JPasswordField();
        adminLoginBtn = new javax.swing.JPanel();
        adminloginlbl = new javax.swing.JLabel();
        LibPanel = new javax.swing.JPanel();
        libUserlbl = new javax.swing.JLabel();
        libPasslbl = new javax.swing.JLabel();
        libUser = new javax.swing.JTextField();
        libPass = new javax.swing.JPasswordField();
        libLoginBtn = new javax.swing.JPanel();
        libLoginlbl = new javax.swing.JLabel();
        exitBtn = new javax.swing.JLabel();
        author = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(100, 100));
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(0, 102, 102));
        background.setPreferredSize(new java.awt.Dimension(1000, 650));

        container.setMinimumSize(new java.awt.Dimension(370, 400));
        container.setPreferredSize(new java.awt.Dimension(370, 400));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setBackground(new java.awt.Color(153, 153, 153));
        head.setOpaque(false);
        head.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head2.setBackground(new java.awt.Color(204, 102, 255));
        head2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                head2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Librarian");

        javax.swing.GroupLayout head2Layout = new javax.swing.GroupLayout(head2);
        head2.setLayout(head2Layout);
        head2Layout.setHorizontalGroup(
            head2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        head2Layout.setVerticalGroup(
            head2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        head.add(head2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 190, 60));

        head1.setBackground(new java.awt.Color(255, 153, 153));
        head1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                head1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin");

        javax.swing.GroupLayout head1Layout = new javax.swing.GroupLayout(head1);
        head1.setLayout(head1Layout);
        head1Layout.setHorizontalGroup(
            head1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, head1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(43, 43, 43))
        );
        head1Layout.setVerticalGroup(
            head1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        head.add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        container.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 60));

        LoginPanels.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        LoginPanels.setMinimumSize(new java.awt.Dimension(100, 100));
        LoginPanels.setPreferredSize(new java.awt.Dimension(200, 200));

        adminPanel.setBackground(new java.awt.Color(255, 153, 153));

        adminUserlbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        adminUserlbl.setForeground(new java.awt.Color(255, 255, 255));
        adminUserlbl.setLabelFor(adminUser);
        adminUserlbl.setText("Password :");

        adminPasslbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        adminPasslbl.setForeground(new java.awt.Color(255, 255, 255));
        adminPasslbl.setLabelFor(adminPass);
        adminPasslbl.setText("Username :");

        adminUser.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        adminPass.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        adminLoginBtn.setBackground(new java.awt.Color(255, 51, 102));
        adminLoginBtn.setPreferredSize(new java.awt.Dimension(125, 50));
        adminLoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLoginBtnMouseClicked(evt);
            }
        });

        adminloginlbl.setBackground(new java.awt.Color(102, 51, 255));
        adminloginlbl.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        adminloginlbl.setForeground(new java.awt.Color(255, 255, 255));
        adminloginlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminloginlbl.setText("Login");

        javax.swing.GroupLayout adminLoginBtnLayout = new javax.swing.GroupLayout(adminLoginBtn);
        adminLoginBtn.setLayout(adminLoginBtnLayout);
        adminLoginBtnLayout.setHorizontalGroup(
            adminLoginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminLoginBtnLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(adminloginlbl)
                .addGap(33, 33, 33))
        );
        adminLoginBtnLayout.setVerticalGroup(
            adminLoginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLoginBtnLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(adminloginlbl)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(adminPanelLayout.createSequentialGroup()
                            .addComponent(adminPasslbl)
                            .addGap(18, 18, 18)
                            .addComponent(adminUser, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, adminPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(adminUserlbl)
                            .addGap(18, 18, 18)
                            .addComponent(adminPass, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(adminLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminPasslbl))
                .addGap(18, 18, 18)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminUserlbl))
                .addGap(34, 34, 34)
                .addComponent(adminLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        LoginPanels.addTab("tab1", adminPanel);

        LibPanel.setBackground(new java.awt.Color(204, 102, 255));

        libUserlbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        libUserlbl.setForeground(new java.awt.Color(255, 255, 255));
        libUserlbl.setLabelFor(adminUser);
        libUserlbl.setText("Password :");

        libPasslbl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        libPasslbl.setForeground(new java.awt.Color(255, 255, 255));
        libPasslbl.setLabelFor(adminPass);
        libPasslbl.setText("Username :");

        libUser.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libPass.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libLoginBtn.setBackground(new java.awt.Color(204, 0, 204));
        libLoginBtn.setPreferredSize(new java.awt.Dimension(125, 50));
        libLoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libLoginBtnMouseClicked(evt);
            }
        });

        libLoginlbl.setBackground(new java.awt.Color(102, 51, 255));
        libLoginlbl.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        libLoginlbl.setForeground(new java.awt.Color(255, 255, 255));
        libLoginlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libLoginlbl.setText("Login");

        javax.swing.GroupLayout libLoginBtnLayout = new javax.swing.GroupLayout(libLoginBtn);
        libLoginBtn.setLayout(libLoginBtnLayout);
        libLoginBtnLayout.setHorizontalGroup(
            libLoginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, libLoginBtnLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(libLoginlbl)
                .addGap(33, 33, 33))
        );
        libLoginBtnLayout.setVerticalGroup(
            libLoginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(libLoginBtnLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(libLoginlbl)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LibPanelLayout = new javax.swing.GroupLayout(LibPanel);
        LibPanel.setLayout(LibPanelLayout);
        LibPanelLayout.setHorizontalGroup(
            LibPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(LibPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LibPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(LibPanelLayout.createSequentialGroup()
                            .addComponent(libPasslbl)
                            .addGap(18, 18, 18)
                            .addComponent(libUser, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LibPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(libUserlbl)
                            .addGap(18, 18, 18)
                            .addComponent(libPass, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(LibPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(libLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        LibPanelLayout.setVerticalGroup(
            LibPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibPanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(LibPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libPasslbl))
                .addGap(18, 18, 18)
                .addGroup(LibPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libUserlbl))
                .addGap(34, 34, 34)
                .addComponent(libLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        LoginPanels.addTab("tab2", LibPanel);

        LoginPanels.setSelectedIndex(1);

        container.add(LoginPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 50, 430, 360));

        exitBtn.setBackground(new java.awt.Color(0, 0, 102));
        exitBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(204, 102, 255));
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn.setText("Exit");
        exitBtn.setOpaque(true);
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

        author.setBackground(new java.awt.Color(204, 102, 255));
        author.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        author.setForeground(new java.awt.Color(255, 255, 255));
        author.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        author.setText("@created_by_vishal_bhangare :)");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(author)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void head1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head1MouseClicked
        LoginPanels.setSelectedIndex(0);

    }//GEN-LAST:event_head1MouseClicked

    private void head2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head2MouseClicked
        LoginPanels.setSelectedIndex(1);
    }//GEN-LAST:event_head2MouseClicked

    private void libLoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libLoginBtnMouseClicked
        String user = libUser.getText();
        String pass = new String(libPass.getPassword());
        try{
            lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, dob from librarians where email_id = ?");
            lms.pstmt.setString(1,user);
            
            lms.rs = lms.pstmt.executeQuery();
            if(!lms.rs.next()){
                JOptionPane.showMessageDialog (null, "Invalid Username");
            }
            else{
                do{
                    String fname = lms.rs.getString(1);
                    String lname = lms.rs.getString(2);
                    String dob = lms.rs.getString(3);
                    String dbpass = fname.substring(0,2) + lname.substring(lname.length()- 2,lname.length()) + dob.substring(0,4);
//                    System.out.println(user + " -- " + dbpass);
                    if(pass.equals(dbpass)){
                        dispose();
                        new Librarian().setVisible(true);
                    }
                    else{
                      JOptionPane.showMessageDialog (null, "Invalid Password");
                    }
                }while(lms.rs.next()); 
                
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_libLoginBtnMouseClicked

    private void adminLoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLoginBtnMouseClicked
        String user = adminUser.getText();
        String pass = new String(adminPass.getPassword());
        String dbuser = null;
        String dbpass = null;
        try {
            lms.pstmt = lms.connection.prepareStatement("select username, password from admins where username = ? and password = ? ");
            lms.pstmt.setString(1,user);
            lms.pstmt.setString(2, pass);
            
            lms.rs = lms.pstmt.executeQuery();
            
            while(lms.rs.next()){
                dbuser = lms.rs.getString(1);
                dbpass = lms.rs.getString(2);
//                System.out.println(lms.rs.getString(1) + " -- " + lms.rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dbuser.equals(user) && dbpass.equals(pass)){
            dispose();
            new Admin().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog (null, "Invalid Username Or Password");
        }
        
        
    }//GEN-LAST:event_adminLoginBtnMouseClicked

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        
        try {
            
            LibraryManagementSystem.rs.close();
            LibraryManagementSystem.statement.close();
            LibraryManagementSystem.pstmt.close();
            LibraryManagementSystem.connection.close();
            System.out.println("Connection Closed");

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            System.exit(0);
        }
        
    }//GEN-LAST:event_exitBtnMouseClicked
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        new Login().setVisible(true);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LibPanel;
    private javax.swing.JTabbedPane LoginPanels;
    public javax.swing.JPanel adminLoginBtn;
    private javax.swing.JPanel adminPanel;
    public javax.swing.JPasswordField adminPass;
    private javax.swing.JLabel adminPasslbl;
    public javax.swing.JTextField adminUser;
    private javax.swing.JLabel adminUserlbl;
    private javax.swing.JLabel adminloginlbl;
    private javax.swing.JLabel author;
    private javax.swing.JPanel background;
    private javax.swing.JPanel container;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JPanel head;
    private javax.swing.JPanel head1;
    private javax.swing.JPanel head2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel libLoginBtn;
    private javax.swing.JLabel libLoginlbl;
    public javax.swing.JPasswordField libPass;
    private javax.swing.JLabel libPasslbl;
    public javax.swing.JTextField libUser;
    private javax.swing.JLabel libUserlbl;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
