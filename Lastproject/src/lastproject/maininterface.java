/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastproject;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author SHIRAF
 */
public class maininterface extends javax.swing.JFrame {
    Connection con = null;
   PreparedStatement pst = null;
   ResultSet rs = null;

    /**
     * Creates new form Login
     */
    public maininterface() {
        initComponents();
        panel_home home = new panel_home();
panel_under.add(home);
panel_under.repaint();
panel_under.revalidate();
lbl_showuser.setText(saveuser.cuser);
seticon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        aaa = new javax.swing.JPanel();
        bbb = new javax.swing.JPanel();
        jp_train = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jp_staff = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jp_user = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jp_home = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_showuser = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jp_search = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panel_under = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Contacts_15px_1.png"))); // NOI18N

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Record Management System Of ASD");
        setBackground(new java.awt.Color(102, 102, 102));

        aaa.setBackground(new java.awt.Color(204, 0, 204));
        aaa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bbb.setBackground(new java.awt.Color(0, 153, 153));
        bbb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_train.setBackground(new java.awt.Color(0, 102, 102));
        jp_train.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jp_train.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_train.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jp_trainMouseMoved(evt);
            }
        });
        jp_train.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_trainMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Training_70px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Training Program");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_trainLayout = new javax.swing.GroupLayout(jp_train);
        jp_train.setLayout(jp_trainLayout);
        jp_trainLayout.setHorizontalGroup(
            jp_trainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_trainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_trainLayout.setVerticalGroup(
            jp_trainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_trainLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jp_trainLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bbb.add(jp_train, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 400, 110));

        jp_staff.setBackground(new java.awt.Color(0, 102, 102));
        jp_staff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jp_staff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_staff.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jp_staffMouseMoved(evt);
            }
        });
        jp_staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_staffMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Staff_70px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Staff Member");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_staffLayout = new javax.swing.GroupLayout(jp_staff);
        jp_staff.setLayout(jp_staffLayout);
        jp_staffLayout.setHorizontalGroup(
            jp_staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_staffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jp_staffLayout.setVerticalGroup(
            jp_staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_staffLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jp_staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_staffLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        bbb.add(jp_staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 400, 110));

        jp_user.setBackground(new java.awt.Color(0, 102, 102));
        jp_user.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jp_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_user.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jp_userMouseMoved(evt);
            }
        });
        jp_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_userMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("User Accounts");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Add_User_Male_70px.png"))); // NOI18N

        javax.swing.GroupLayout jp_userLayout = new javax.swing.GroupLayout(jp_user);
        jp_user.setLayout(jp_userLayout);
        jp_userLayout.setHorizontalGroup(
            jp_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jp_userLayout.setVerticalGroup(
            jp_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_userLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_userLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bbb.add(jp_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 400, 110));

        btn_logout.setBackground(new java.awt.Color(153, 0, 0));
        btn_logout.setFont(new java.awt.Font("Perpetua Titling MT", 0, 17)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Redo_25px.png"))); // NOI18N
        btn_logout.setText("Log out");
        btn_logout.setToolTipText("You can exit and login to a another user ccount");
        btn_logout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        bbb.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 790, 140, 40));

        jp_home.setBackground(new java.awt.Color(0, 102, 102));
        jp_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jp_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_home.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jp_homeMouseMoved(evt);
            }
        });
        jp_home.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jp_homeMouseWheelMoved(evt);
            }
        });
        jp_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_homeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp_homeMouseReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Home");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_3D_House_70px_1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp_homeLayout = new javax.swing.GroupLayout(jp_home);
        jp_home.setLayout(jp_homeLayout);
        jp_homeLayout.setHorizontalGroup(
            jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jp_homeLayout.setVerticalGroup(
            jp_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_homeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(31, 31, 31))
        );

        bbb.add(jp_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 400, 110));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Current User :");
        bbb.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 130, 30));

        lbl_showuser.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        lbl_showuser.setForeground(new java.awt.Color(255, 255, 255));
        bbb.add(lbl_showuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 730, 140, 30));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("SriLankan", 0, 20)); // NOI18N
        jLabel16.setText("Development");
        jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bbb.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, 30));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("SriLankan", 0, 20)); // NOI18N
        jLabel17.setText("Academy for Staff");
        jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bbb.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 210, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/asd_1.png"))); // NOI18N
        bbb.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 90));

        jp_search.setBackground(new java.awt.Color(0, 102, 102));
        jp_search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jp_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jp_searchMouseMoved(evt);
            }
        });
        jp_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_searchMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp_searchMouseReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Search");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Find_and_Replace_70px_2.png"))); // NOI18N

        javax.swing.GroupLayout jp_searchLayout = new javax.swing.GroupLayout(jp_search);
        jp_search.setLayout(jp_searchLayout);
        jp_searchLayout.setHorizontalGroup(
            jp_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_searchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jp_searchLayout.setVerticalGroup(
            jp_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_searchLayout.createSequentialGroup()
                .addGroup(jp_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_searchLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel13))
                    .addGroup(jp_searchLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel12)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bbb.add(jp_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 400, 110));

        aaa.add(bbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 880));

        panel_under.setBackground(new java.awt.Color(153, 153, 0));
        panel_under.setLayout(new java.awt.CardLayout());
        aaa.add(panel_under, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 1100, 760));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/Cot_New1.jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        aaa.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 1170, 120));

        jScrollPane1.setViewportView(aaa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
jp_staffMouseClicked(evt);
    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        jp_trainMouseClicked(evt);       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
jp_userMouseClicked(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jp_trainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_trainMouseClicked
      panel_train train = new panel_train();
        panel_under.removeAll();
       panel_under.repaint();
       panel_under.revalidate();
       panel_under.add(train);
        panel_under.repaint();
       panel_under.revalidate();
       
        setcolur(jp_train);
        resetcolor(jp_home);
        resetcolor(jp_search);
        resetcolor(jp_staff);
        resetcolor(jp_user);
    }//GEN-LAST:event_jp_trainMouseClicked

    private void jp_staffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_staffMouseClicked
//removing panels
panel_staff staff = new panel_staff();
        panel_under.removeAll();
       panel_under.repaint();
       panel_under.revalidate();
       //adding panels
       panel_under.add(staff);
        panel_under.repaint();
       panel_under.revalidate();        
// TODO add your handling code here:

        setcolur(jp_staff);
        resetcolor(jp_home);
        resetcolor(jp_search);
        resetcolor(jp_train);
        resetcolor(jp_user);
        
    }//GEN-LAST:event_jp_staffMouseClicked

    private void jp_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_userMouseClicked
panel_user user = new panel_user();
        panel_under.removeAll();
       panel_under.repaint();
       panel_under.revalidate();
       panel_under.add(user);
        panel_under.repaint();
       panel_under.revalidate();
       // TODO add your handling code here:
       
        setcolur(jp_user);
        resetcolor(jp_home);
        resetcolor(jp_search);
        resetcolor(jp_staff);
        resetcolor(jp_train);
    }//GEN-LAST:event_jp_userMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
jp_homeMouseClicked(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jp_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_homeMouseClicked
panel_home home = new panel_home();
panel_under.removeAll();
panel_under.repaint();
panel_under.revalidate();
panel_under.add(home);
panel_under.repaint();
panel_under.revalidate();// TODO add your handling code here:

        setcolur(jp_home);
        resetcolor(jp_search);
        resetcolor(jp_staff);
        resetcolor(jp_train);
        resetcolor(jp_user);

    }//GEN-LAST:event_jp_homeMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        jp_searchMouseClicked(evt);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jp_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_searchMouseClicked
panel_search search = new panel_search();
panel_under.removeAll();
panel_under.repaint();
panel_under.revalidate();
panel_under.add(search);
panel_under.repaint();
panel_under.revalidate();   
// TODO add your handling code here:

        setcolur(jp_search);
        resetcolor(jp_home);
        resetcolor(jp_staff);
        resetcolor(jp_train);
        resetcolor(jp_user);
        
    }//GEN-LAST:event_jp_searchMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
jp_homeMouseClicked(evt);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        login log = new login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void jp_homeMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jp_homeMouseWheelMoved

        // TODO add your handling code here:
    }//GEN-LAST:event_jp_homeMouseWheelMoved

    private void jp_homeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_homeMouseReleased


        // TODO add your handling code here:
    }//GEN-LAST:event_jp_homeMouseReleased

    private void jp_searchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_searchMouseReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_jp_searchMouseReleased

    private void jp_homeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_homeMouseMoved
setcolor2(jp_home);
        resetcolor2(jp_search);
        resetcolor2(jp_staff);
        resetcolor2(jp_train);
        resetcolor2(jp_user);
        // TODO add your handling code here:
    }//GEN-LAST:event_jp_homeMouseMoved

    private void jp_searchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_searchMouseMoved
setcolur(jp_search);
        resetcolor2(jp_home);
        resetcolor2(jp_staff);
        resetcolor2(jp_train);
        resetcolor2(jp_user);
        // TODO add your handling code here:
    }//GEN-LAST:event_jp_searchMouseMoved

    private void jp_userMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_userMouseMoved
        setcolor2(jp_user);
        resetcolor2(jp_home);
        resetcolor2(jp_search);
        resetcolor2(jp_staff);
        resetcolor2(jp_train);
        // TODO add your handling code here:
    }//GEN-LAST:event_jp_userMouseMoved

    private void jp_staffMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_staffMouseMoved
       setcolor2(jp_staff);
        resetcolor2(jp_home);
        resetcolor2(jp_search);
        resetcolor2(jp_train);
        resetcolor2(jp_user);
        // TODO add your handling code here:
    }//GEN-LAST:event_jp_staffMouseMoved

    private void jp_trainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_trainMouseMoved
        setcolor2(jp_train);
        resetcolor2(jp_home);
        resetcolor2(jp_search);
        resetcolor2(jp_staff);
        resetcolor2(jp_user);
        // TODO add your handling code here:
    }//GEN-LAST:event_jp_trainMouseMoved

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
            java.util.logging.Logger.getLogger(maininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maininterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aaa;
    private javax.swing.JPanel bbb;
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_home;
    private javax.swing.JPanel jp_search;
    private javax.swing.JPanel jp_staff;
    private javax.swing.JPanel jp_train;
    private javax.swing.JPanel jp_user;
    private javax.swing.JLabel lbl_showuser;
    private javax.swing.JPanel panel_under;
    // End of variables declaration//GEN-END:variables

 private void setcolur(JPanel aset){
     aset.setBackground(new Color(0, 198, 255));
 }   
 private void resetcolor(JPanel areset){
     areset.setBackground(new Color (0,102,102));
 }
 private void setcolor2(JPanel bset){
     bset.setBackground(new Color (0, 198, 255));
 }
 private void resetcolor2(JPanel breset){
     breset.setBackground(new Color(0,102,102));
 }
 public void seticon(){
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons8_Course_48px_1.png")));
 }
}