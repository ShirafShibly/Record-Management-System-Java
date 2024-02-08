/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastproject;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author SHIRAF
 */
public class panel_search extends javax.swing.JPanel {
   ResultSet search_rs = null;
   PreparedStatement search_pst = null;
   Connection search_con = null;
   
   Connection con = null;
   PreparedStatement pst = null;
   ResultSet rs = null;
String filter_factor = "";
    /**
     * Creates new form panel_search
     */
    public panel_search() {
        initComponents();
        add_training_programme_to_search();
        tbl_search_by_programme_name.setVisible(false);
        adddistrict();
            cmb_filter_district.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                   
                    
                         cmb_filter_center.removeAllItems();
                         cmb_filter_center.addItem("Not Selected");
                    showcent();
            }
            }
        });
    }
     public void adddistrict(){
                con = mysqlconnect.connectDB();
        try{
            String sql = "select * from district_list";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                String dis = rs.getString("district_name");
                cmb_filter_district.addItem(dis);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                    
                    }
        finally{
        closeall();
        }
        
    }
      public void showcent(){
        
                con=mysqlconnect.connectDB();
        try{
            String sql = "select * from centre_list where district = ?";
            pst=con.prepareStatement(sql);
            pst.setString(1,cmb_filter_district.getSelectedItem().toString());
            rs = pst.executeQuery();
            while(rs.next()){
            String cent = rs.getString("centre");
            cmb_filter_center.addItem(cent);}

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            
           closeall();
        }
        
    }
    public void fill_incompleted_programmes(){
                      con=mysqlconnect.connectDB();
     try{
         
String sql = "SELECT training_programme.p_id as Programme_ID, training_programme.p_name as Programme_Name FROM training_programme WHERE training_programme.p_id NOT IN ( SELECT participation.p_id FROM participation WHERE participation.s_nic = ? )";


         pst=con.prepareStatement(sql);
         pst.setString(1,txt_search_panel_searchbar.getText());
        
         rs= pst.executeQuery();
         tbl_search_not_completed_programmes.setModel(DbUtils.resultSetToTableModel(rs));
         
         
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
     finally{
     closeall();
     }
        
        
    }
    public void fill_completed_programmes(){
                           con=mysqlconnect.connectDB();
     try{
         String sql = "select participation.p_id as Programmme_ID,training_programme.p_name as Programme_Name,Cast(participation.start_date as char(10) )as Started_Date ,Cast(participation.end_date as char(10)) as Ended_Date  from training_programme,participation where participation.s_nic=? and participation.p_id = training_programme.p_id ";
         pst=con.prepareStatement(sql);
         pst.setString(1,txt_search_panel_searchbar.getText());
         rs= pst.executeQuery();
         tbl_search_completed_programmes.setModel(DbUtils.resultSetToTableModel(rs));
         
         
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
     finally{
     closeall();
     }
        
        
    }
    public void add_training_programme_to_search(){
                con = mysqlconnect.connectDB();
        try{
            String sql = "select p_name from training_programme";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                String pat = rs.getString("p_name");
               cmb_search_panel_p_name.addItem(pat);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
                    
                    }
        finally{
            try{
                
                rs.close();
                pst.close();
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_search_panel_searchbar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_search_nic = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_search_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_search_district = new javax.swing.JTextField();
        txt_search_epf = new javax.swing.JTextField();
        txt_search_center = new javax.swing.JTextField();
        txt_search_course = new javax.swing.JTextField();
        txt_search_academic_status = new javax.swing.JTextField();
        txt_search_email = new javax.swing.JTextField();
        txt_search_stype = new javax.swing.JTextField();
        txt_search_tp = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_search_not_completed_programmes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_search_completed_programmes = new javax.swing.JTable();
        lbl_incompleted_count = new javax.swing.JLabel();
        lbl_completed_count = new javax.swing.JLabel();
        btn_search_clear = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_completed_count_number = new javax.swing.JLabel();
        lbl_incompleted_count_number = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img_search = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cmb_search_panel_p_name = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        cmb_search_panel_show_who_complete = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_search_by_programme_name = new javax.swing.JTable();
        btn_search_panel_search_by_pro = new javax.swing.JButton();
        lbl_search_panel_pro_name = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_search_panel_no_of_staff = new javax.swing.JLabel();
        btn_search_panel_print = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmb_filter_district = new javax.swing.JComboBox();
        cmb_filter_center = new javax.swing.JComboBox();
        cmb_filter_ac_status = new javax.swing.JComboBox();
        cmb_filter_s_type = new javax.swing.JComboBox();
        cmb_filter_gender = new javax.swing.JComboBox();
        lbl_search_panel_filter_status = new javax.swing.JLabel();

        jLabel4.setText("EPF No");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 153));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabbedPane1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTabbedPane1.setInheritsPopupMenu(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1153, 1092));
        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Search");

        txt_search_panel_searchbar.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        txt_search_panel_searchbar.setText(".....NIC.....");
        txt_search_panel_searchbar.setToolTipText("Enter the NIC");
        txt_search_panel_searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_panel_searchbarActionPerformed(evt);
            }
        });
        txt_search_panel_searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_panel_searchbarKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel2.setText("NIC");

        txt_search_nic.setEditable(false);
        txt_search_nic.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel3.setText("Name");

        txt_search_name.setEditable(false);
        txt_search_name.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel5.setText("EPF No");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel6.setText("District");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel7.setText("Center");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel10.setText("Academic Status");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel8.setText("Course");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel11.setText("Service Type");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel9.setText("Telephone No");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel12.setText("E-mail ");

        txt_search_district.setEditable(false);
        txt_search_district.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        txt_search_epf.setEditable(false);
        txt_search_epf.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        txt_search_center.setEditable(false);
        txt_search_center.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        txt_search_course.setEditable(false);
        txt_search_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        txt_search_academic_status.setEditable(false);
        txt_search_academic_status.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txt_search_academic_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_academic_statusActionPerformed(evt);
            }
        });

        txt_search_email.setEditable(false);
        txt_search_email.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txt_search_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_emailActionPerformed(evt);
            }
        });

        txt_search_stype.setEditable(false);
        txt_search_stype.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txt_search_stype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_stypeActionPerformed(evt);
            }
        });

        txt_search_tp.setEditable(false);
        txt_search_tp.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txt_search_tp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_tpActionPerformed(evt);
            }
        });

        tbl_search_not_completed_programmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Programme_ID", "Programme_Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_search_not_completed_programmes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl_search_not_completed_programmes.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(tbl_search_not_completed_programmes);

        tbl_search_completed_programmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Programme_ID", "Programme_Name", "Started_Date", "Ended_Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_search_completed_programmes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(tbl_search_completed_programmes);

        lbl_incompleted_count.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl_incompleted_count.setText("No of  Incompleted Programmes");

        lbl_completed_count.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl_completed_count.setText(" No of Completed Programmes");

        btn_search_clear.setBackground(new java.awt.Color(153, 153, 255));
        btn_search_clear.setFont(new java.awt.Font("Perpetua Titling MT", 0, 15)); // NOI18N
        btn_search_clear.setText("Clear");
        btn_search_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_clearActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Incompleted Programmes");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText(" Completed Programmes");

        lbl_completed_count_number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbl_incompleted_count_number.setBackground(new java.awt.Color(255, 255, 255));
        lbl_incompleted_count_number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jDesktopPane1.setLayer(img_search, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(img_search, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img_search, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "\t\tSri Lanka College of Technology - Maradana", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jSeparator1.setName(""); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Cancel_25px_1.png"))); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lastproject/images/icons8_Ok_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_search_epf, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_search_district, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_search_name, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_search_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_search_tp))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_search_stype, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_search_email, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_completed_count, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(113, 113, 113)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lbl_completed_count_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel25)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_search_academic_status, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search_center, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search_course, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_incompleted_count, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(lbl_incompleted_count_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel24))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_search_panel_searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btn_search_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_search_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search_panel_searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search_name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search_epf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search_district, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search_center, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search_stype, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search_academic_status, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search_tp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_search_course, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_search_email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_incompleted_count)
                            .addComponent(lbl_completed_count)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_incompleted_count_number, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_completed_count_number, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jSeparator1.getAccessibleContext().setAccessibleName(" \tSri Lanka College of Technology");

        jTabbedPane1.addTab("Search by NIC", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setAutoscrolls(true);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel13.setText("Programme Name ");

        cmb_search_panel_p_name.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cmb_search_panel_p_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select A Programme" }));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel14.setText("Show ");

        cmb_search_panel_show_who_complete.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cmb_search_panel_show_who_complete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Completed ", "Not Completed " }));

        tbl_search_by_programme_name.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_search_by_programme_name);

        btn_search_panel_search_by_pro.setBackground(new java.awt.Color(153, 153, 255));
        btn_search_panel_search_by_pro.setFont(new java.awt.Font("Perpetua Titling MT", 0, 15)); // NOI18N
        btn_search_panel_search_by_pro.setText("Search");
        btn_search_panel_search_by_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_panel_search_by_proActionPerformed(evt);
            }
        });

        lbl_search_panel_pro_name.setFont(new java.awt.Font("Yu Gothic UI", 0, 15)); // NOI18N
        lbl_search_panel_pro_name.setText("   ");
        lbl_search_panel_pro_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel17.setText("No of Staff Members");

        lbl_search_panel_no_of_staff.setFont(new java.awt.Font("Yu Gothic UI", 0, 15)); // NOI18N
        lbl_search_panel_no_of_staff.setText("          ");
        lbl_search_panel_no_of_staff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_search_panel_print.setBackground(new java.awt.Color(153, 153, 255));
        btn_search_panel_print.setFont(new java.awt.Font("Perpetua Titling MT", 0, 15)); // NOI18N
        btn_search_panel_print.setText("Print");
        btn_search_panel_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_panel_printActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jLabel18.setText("Filter By ");

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel19.setText("District ");

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel20.setText("Center");

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel21.setText("Academic Status");

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel22.setText("Service Type");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel23.setText("Gender");

        cmb_filter_district.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cmb_filter_district.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Selected" }));

        cmb_filter_center.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cmb_filter_center.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Selected" }));

        cmb_filter_ac_status.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cmb_filter_ac_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Selected", "Academic", "Non - Academic" }));

        cmb_filter_s_type.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cmb_filter_s_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Selected", "Permanet", "Contract basis" }));
        cmb_filter_s_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filter_s_typeActionPerformed(evt);
            }
        });

        cmb_filter_gender.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cmb_filter_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Selected", "Male", "Female" }));

        lbl_search_panel_filter_status.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        lbl_search_panel_filter_status.setText("   Filter by :  ");
        lbl_search_panel_filter_status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_search_panel_pro_name, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(lbl_search_panel_no_of_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_search_panel_filter_status, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_filter_ac_status, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_filter_s_type, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_filter_center, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_filter_district, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_search_panel_p_name, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_search_panel_show_who_complete, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cmb_filter_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(btn_search_panel_search_by_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(btn_search_panel_print, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(89, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_search_panel_p_name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_search_panel_show_who_complete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmb_filter_center, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cmb_filter_ac_status, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cmb_filter_s_type, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_filter_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search_panel_search_by_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search_panel_print, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmb_filter_district, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addComponent(lbl_search_panel_pro_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_search_panel_filter_status, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_search_panel_no_of_staff, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Search By Programme", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_search_academic_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_academic_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_academic_statusActionPerformed

    private void txt_search_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_emailActionPerformed

    private void txt_search_stypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_stypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_stypeActionPerformed

    private void txt_search_tpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_tpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_tpActionPerformed

    private void txt_search_panel_searchbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_panel_searchbarKeyReleased
               search_con = mysqlconnect.connectDB(); 
     
      try{
          String sql = "SELECT * FROM staff_member LEFT OUTER JOIN academic ON staff_member.s_nic = academic.s_nic LEFT OUTER JOIN non_academic ON staff_member.s_nic = non_academic.s_nic WHERE staff_member.s_nic = ?";
          
          search_pst = search_con.prepareStatement(sql);
          search_pst.setString(1,txt_search_panel_searchbar.getText());
          search_rs = search_pst.executeQuery();
         
          if(search_rs.next()){
              tbl_search_not_completed_programmes.setVisible(true);
          String s_nic = search_rs.getString("s_nic");
          txt_search_nic.setText(s_nic);
          String s_name = search_rs.getString("s_name");
          txt_search_name.setText(s_name);
          String s_epf = search_rs.getString("s_epf");
          txt_search_epf.setText(s_epf);
          
          
          
          
            String s_ac_status = search_rs.getString("s_ac_status");
          txt_search_academic_status.setText(s_ac_status);
          String s_type = search_rs.getString("s_type");
          txt_search_stype.setText(s_type);
          String s_tel = search_rs.getString("s_tel");
          txt_search_tp.setText(s_tel);
          String s_email = search_rs.getString("s_email");
         txt_search_email.setText(s_email);
         
          
          String s_district = search_rs.getString("s_district");
          txt_search_district.setText(s_district);
          
            String s_center = search_rs.getString("s_center");
         txt_search_center.setText(s_center);
         
         String ins_course = search_rs.getString("ins_course");
         txt_search_course.setText(ins_course);
        
         
         byte[] image = search_rs.getBytes("image");
         if(image == null){
             
         }else{
         ImageIcon imageicon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(img_search.getHeight(), img_search.getWidth(), Image.SCALE_DEFAULT));
         img_search.setIcon(imageicon);}
          
          
          
            
          
          
          
         
//        
        
          
          }else{
              clear_no_records();
              
//              JOptionPane.showMessageDialog(null,"No records found");
          }
        
          
      }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
      } 
      finally{
         
          try{
    
    search_rs.close();
    search_pst.close();
    search_con.close();
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}
      }
      fill_incompleted_programmes();
      fill_completed_programmes();
     String complete_no = String.valueOf(tbl_search_completed_programmes.getRowCount());
     lbl_completed_count_number.setText(complete_no);
     String incomplete_no = String.valueOf(tbl_search_not_completed_programmes.getRowCount());
     lbl_incompleted_count_number.setText(incomplete_no);
      
      
    }//GEN-LAST:event_txt_search_panel_searchbarKeyReleased
public void clear_no_records(){
     
       txt_search_nic.setText("");
       txt_search_name.setText("");
       txt_search_academic_status.setText("");
       txt_search_center.setText("");
       txt_search_course.setText("");
       txt_search_district.setText("");
       txt_search_email.setText("");
       txt_search_epf.setText("");
       txt_search_stype.setText("");
       txt_search_tp.setText("");
       lbl_completed_count_number.setText("");
      
     
       fill_incompleted_programmes();
       fill_completed_programmes();
        lbl_incompleted_count_number.setText("");
       tbl_search_not_completed_programmes.setVisible(false);
       img_search.setIcon(null);
       
    
}
    private void btn_search_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_clearActionPerformed
       txt_search_panel_searchbar.setText("");
       txt_search_nic.setText("");
       txt_search_name.setText("");
       txt_search_academic_status.setText("");
       txt_search_center.setText("");
       txt_search_course.setText("");
       txt_search_district.setText("");
       txt_search_email.setText("");
       txt_search_epf.setText("");
       txt_search_stype.setText("");
       txt_search_tp.setText("");
       txt_search_panel_searchbar.requestFocusInWindow();
       fill_incompleted_programmes();
       fill_completed_programmes();
       tbl_search_not_completed_programmes.setVisible(false);
       lbl_completed_count_number.setText("");
       lbl_incompleted_count_number.setText("");
       img_search.setIcon(null);
       
    }//GEN-LAST:event_btn_search_clearActionPerformed

    private void btn_search_panel_search_by_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_panel_search_by_proActionPerformed
tbl_search_by_programme_name.setVisible(true);
filter_factor = "";
lbl_search_panel_filter_status.setText("Filter by: ");
if(cmb_filter_district.getSelectedItem().equals("Not Selected")==false){
    filter_factor = filter_factor+ " and staff_member.s_district = '"+cmb_filter_district.getSelectedItem().toString()+"'";
    lbl_search_panel_filter_status.setText(lbl_search_panel_filter_status.getText()+" "+ cmb_filter_district.getSelectedItem().toString());
}
    
 if(cmb_filter_center.getSelectedItem().equals("Not Selected")==false){
    filter_factor = filter_factor+ " and staff_member.s_center = '"+cmb_filter_center.getSelectedItem().toString()+"'";
    lbl_search_panel_filter_status.setText(lbl_search_panel_filter_status.getText()+" "+  cmb_filter_center.getSelectedItem().toString());
    
}
 if(cmb_filter_ac_status.getSelectedItem().equals("Not Selected")==false){
    filter_factor = filter_factor+ " and staff_member.s_ac_status = '"+cmb_filter_ac_status.getSelectedItem().toString()+"'";
    lbl_search_panel_filter_status.setText(lbl_search_panel_filter_status.getText()+ " "+ cmb_filter_ac_status.getSelectedItem().toString());
    
}
 if(cmb_filter_s_type.getSelectedItem().equals("Not Selected")==false){
    filter_factor = filter_factor+ " and staff_member.s_type = '"+cmb_filter_s_type.getSelectedItem().toString()+"'";
    lbl_search_panel_filter_status.setText(lbl_search_panel_filter_status.getText()+ " "+ cmb_filter_s_type.getSelectedItem().toString());
    
}
 if(cmb_filter_gender.getSelectedItem().equals("Not Selected")==false){
    filter_factor = filter_factor+ " and staff_member.gender = '"+cmb_filter_gender.getSelectedItem().toString()+"'";
    lbl_search_panel_filter_status.setText(lbl_search_panel_filter_status.getText()+ " "+ cmb_filter_gender.getSelectedItem().toString());
    
}



        if(cmb_search_panel_show_who_complete.getSelectedIndex()==0){
        show_completed_staff_members();
        }
        else{
        show_not_completed_staff_members();
        }
        
        lbl_search_panel_pro_name.setText(cmb_search_panel_p_name.getSelectedItem().toString() + "  "+ cmb_search_panel_show_who_complete.getSelectedItem().toString());
        lbl_search_panel_no_of_staff.setText(String.valueOf(tbl_search_by_programme_name.getRowCount()));
                
                
            
    }//GEN-LAST:event_btn_search_panel_search_by_proActionPerformed

    private void btn_search_panel_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_panel_printActionPerformed
  MessageFormat header = new MessageFormat(lbl_search_panel_pro_name.getText()+"\n"+lbl_search_panel_filter_status.getText());
        MessageFormat footer  = new  MessageFormat("Page No : ");
        try{
            tbl_search_by_programme_name.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            
            
        }catch(java.awt.print.PrinterException e){
           System.err.format("can not print %s%n" , e.getMessage());
            
        }
    }//GEN-LAST:event_btn_search_panel_printActionPerformed

    private void cmb_filter_s_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filter_s_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_filter_s_typeActionPerformed

    private void txt_search_panel_searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_panel_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_panel_searchbarActionPerformed
  public void closeall(){
      try{
         rs.close();
    pst.close();
    con.close();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);

            }
  }
  public void show_completed_staff_members(){
             con=mysqlconnect.connectDB();
     try{
         String sql = "select participation.s_nic as NIC,s_name as Name,s_epf as EPF,s_district as District,s_center as Center_Name,s_tel as Tel_No,s_email as Email,s_type as Service_Type,s_ac_status as Academic_Status,gender as Gender" 
                 +" from staff_member,participation,training_programme" 
                 +" where participation.p_id = (select training_programme.p_id from training_programme where training_programme.p_name = ?)  and"
                  +" participation.p_id = training_programme.p_id and participation.s_nic = staff_member.s_nic"  +filter_factor+"";
         pst=con.prepareStatement(sql);
         pst.setString(1, cmb_search_panel_p_name.getSelectedItem().toString());
         rs= pst.executeQuery();
         tbl_search_by_programme_name.setModel(DbUtils.resultSetToTableModel(rs));
         
         
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    
    }finally{
     closeall();
     }
      
  }
  
  public void  show_not_completed_staff_members(){
                  con=mysqlconnect.connectDB();
     try{
         String sql = "select staff_member.s_nic as NIC,s_name as Name,s_epf as EPF,s_district as District,s_center as Center_Name,s_tel as Tel_No,s_email as Email,s_type as Service_Type,s_ac_status as Academic_Status,gender as Gender "
                 + "from staff_member where staff_member.s_nic not in (select participation.s_nic  "
                 +"from staff_member,participation,training_programme "
                  +"where participation.p_id = (select training_programme.p_id from training_programme where training_programme.p_name = ?)  and "
                 + " participation.p_id = training_programme.p_id and participation.s_nic = staff_member.s_nic)"+filter_factor+"";
         pst=con.prepareStatement(sql);
         pst.setString(1, cmb_search_panel_p_name.getSelectedItem().toString());
         rs= pst.executeQuery();
         tbl_search_by_programme_name.setModel(DbUtils.resultSetToTableModel(rs));
         
         
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    
    }finally{
     closeall();
     }
   
      
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_search_clear;
    private javax.swing.JButton btn_search_panel_print;
    private javax.swing.JButton btn_search_panel_search_by_pro;
    private javax.swing.JComboBox cmb_filter_ac_status;
    private javax.swing.JComboBox cmb_filter_center;
    private javax.swing.JComboBox cmb_filter_district;
    private javax.swing.JComboBox cmb_filter_gender;
    private javax.swing.JComboBox cmb_filter_s_type;
    private javax.swing.JComboBox cmb_search_panel_p_name;
    private javax.swing.JComboBox cmb_search_panel_show_who_complete;
    private javax.swing.JLabel img_search;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_completed_count;
    private javax.swing.JLabel lbl_completed_count_number;
    private javax.swing.JLabel lbl_incompleted_count;
    private javax.swing.JLabel lbl_incompleted_count_number;
    private javax.swing.JLabel lbl_search_panel_filter_status;
    private javax.swing.JLabel lbl_search_panel_no_of_staff;
    private javax.swing.JLabel lbl_search_panel_pro_name;
    private javax.swing.JTable tbl_search_by_programme_name;
    private javax.swing.JTable tbl_search_completed_programmes;
    private javax.swing.JTable tbl_search_not_completed_programmes;
    private javax.swing.JTextField txt_search_academic_status;
    private javax.swing.JTextField txt_search_center;
    private javax.swing.JTextField txt_search_course;
    private javax.swing.JTextField txt_search_district;
    private javax.swing.JTextField txt_search_email;
    private javax.swing.JTextField txt_search_epf;
    private javax.swing.JTextField txt_search_name;
    private javax.swing.JTextField txt_search_nic;
    private javax.swing.JTextField txt_search_panel_searchbar;
    private javax.swing.JTextField txt_search_stype;
    private javax.swing.JTextField txt_search_tp;
    // End of variables declaration//GEN-END:variables

private ImageIcon format = null;
String filename = null;
byte[] person_image = null;




}
