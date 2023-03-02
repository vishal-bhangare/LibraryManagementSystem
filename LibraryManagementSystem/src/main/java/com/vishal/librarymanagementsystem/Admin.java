/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.vishal.librarymanagementsystem;

import com.vishal.chart.ModelChart;
import static com.vishal.librarymanagementsystem.LibraryManagementSystem.rs;
import static com.vishal.librarymanagementsystem.LibraryManagementSystem.statement;
import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vishal
 */
public class Admin extends javax.swing.JFrame {
    LibraryManagementSystem lms = new LibraryManagementSystem();
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        
        String thoughts[] = {
            "Teachers can open the door, but you must enter it yourself.",
            "Education is the most powerful weapon you can use to change the world." ,
            "The mind is not a vessel to be filled but a fire to be ignited.",
            "Don’t let what you cannot do interfere with what you can do.",
            "A person who never made a mistake never tried anything new.",
            "Never let the fear of striking out stop you from playing the game.",
            "Procrastination makes easy things hard and hard things harder."
        };
        todaysThought.setText(thoughts[((int)(Math.random()*(6-0+1)+0))]);
        DateTimeFormatter datef =  DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);//("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        date.setText(datef.format(localDate));
        DateTimeFormatter timef = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        LocalTime localTime = LocalTime.now();
        time.setText(timef.format(localTime));
        
        try {
            rs = statement.executeQuery("select count(cnt) from (select count(*) as cnt from records where return_date IS NOT NULL group by feedback) as total");
            double total = 0;
            while(rs.next()){
                total += rs.getDouble(1);
            }
            rs = statement.executeQuery("select `feedback`, count(*) from records where return_date IS NOT NULL group by `feedback`");
            chart.addLegend("", Color.yellow);
            while(rs.next()){
               chart.addData(new ModelChart(rs.getString(1), new double[]{(rs.getDouble(2)/total)*100.0}));
            }
            
            //            total no of students
            rs = statement.executeQuery("select count(student_id) from students");
            while(rs.next()){
                 totalStudents.setText(rs.getString(1));
            }
            //            total no of books
            rs = statement.executeQuery("select count(book_id) from books");
            while(rs.next()){
                totalBooks.setText(rs.getString(1));
            }
            //            total no of librarians
            
            rs = statement.executeQuery("select count(firstname) from librarians");
            while(rs.next()){
                totalLib.setText(rs.getString(1));
            }
            
            
//            count of books issued to students
            rs = statement.executeQuery("select count(book_name) from records where issue_date is not null");
            
            while(rs.next()){
               booksIssued.setText(rs.getString(1));
            }
            
//            count of books returned
            rs = statement.executeQuery("select count(sr_no) from records where issue_date is not null and return_date is not null");
            
            while(rs.next()){
                booksReturned.setText(rs.getString(1));
            }  
            //            books reissued
            rs = statement.executeQuery("select count(sr_no) from records where reissue > 0"); //books reissue 
            
            while(rs.next()){
               booksReissued.setText(rs.getString(1));
            }
            //count of books not returned
            booksNotReturned.setText(String.valueOf(Integer.parseInt(booksIssued.getText()) - Integer.parseInt(booksReturned.getText())));
            
           
//            average penalty
            rs = statement.executeQuery("select avg(penalty) from records where penalty > 0");
            
            while(rs.next()){
               avgPenalty.setText(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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

        main = new javax.swing.JPanel();
        head = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        librarians = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        records = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        statistics = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        logs = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        contentPanels = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        adminLogout = new javax.swing.JLabel();
        libFirstnamelbl15 = new javax.swing.JLabel();
        todaysThought = new javax.swing.JLabel();
        libFirstnamelbl17 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        libFirstnamelbl19 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Librarians1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Librarians2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Librarians4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        librariansTabs = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        libFirstnamelbl = new javax.swing.JLabel();
        libFirstname = new javax.swing.JTextField();
        libFirstnamelbl1 = new javax.swing.JLabel();
        libLastname = new javax.swing.JTextField();
        libContactno = new javax.swing.JTextField();
        libFirstnamelbl2 = new javax.swing.JLabel();
        libFirstnamelbl3 = new javax.swing.JLabel();
        libEmailid = new javax.swing.JTextField();
        libFirstnamelbl4 = new javax.swing.JLabel();
        libAdd = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        libDob = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        libFirstnamelbl8 = new javax.swing.JLabel();
        rmEmail = new javax.swing.JTextField();
        libFirstnamelbl9 = new javax.swing.JLabel();
        removeLibBtn = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        rmDob = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        libFirstnamelbl10 = new javax.swing.JLabel();
        updateFname = new javax.swing.JTextField();
        libFirstnamelbl11 = new javax.swing.JLabel();
        updateLname = new javax.swing.JTextField();
        updateContact = new javax.swing.JTextField();
        libFirstnamelbl12 = new javax.swing.JLabel();
        libFirstnamelbl13 = new javax.swing.JLabel();
        updateEmail = new javax.swing.JTextField();
        libFirstnamelbl14 = new javax.swing.JLabel();
        libUpdateBtn = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        libFetchBtn = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        updateDob = new javax.swing.JFormattedTextField();
        tab3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        Librarians11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        Librarians12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        Librarians13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        recordsTabs = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        adminStudentsRecordTable = new javax.swing.JTable();
        adminstudentSearchCombo = new javax.swing.JComboBox<>();
        adminstudentSearch = new javax.swing.JTextField();
        adminstudentSearchBtn = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        adminBooksRecordTable = new javax.swing.JTable();
        adminbooksearchBtn = new javax.swing.JLabel();
        adminbookSearch = new javax.swing.JTextField();
        adminbookSearchCombo = new javax.swing.JComboBox<>();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        adminLibSearch = new javax.swing.JTextField();
        adminLibSearchBtn = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminRecordTable = new javax.swing.JTable();
        adminLibSearchCombo = new javax.swing.JComboBox<>();
        tab4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        totalStudents = new javax.swing.JLabel();
        totalBooks = new javax.swing.JLabel();
        booksIssued = new javax.swing.JLabel();
        totalLib = new javax.swing.JLabel();
        booksReturned = new javax.swing.JLabel();
        booksReissued = new javax.swing.JLabel();
        booksNotReturned = new javax.swing.JLabel();
        avgPenalty = new javax.swing.JLabel();
        chart = new com.vishal.chart.Chart();
        tab5 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        Librarians21 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        Librarians22 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        recordsTabs1 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jPanel30 = new javax.swing.JPanel();
        libFirstnamelbl30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main.setBackground(new java.awt.Color(255, 153, 153));
        main.setPreferredSize(new java.awt.Dimension(1000, 650));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setBackground(new java.awt.Color(255, 153, 153));

        jLabel12.setBackground(new java.awt.Color(102, 0, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Library Management System");

        javax.swing.GroupLayout headLayout = new javax.swing.GroupLayout(head);
        head.setLayout(headLayout);
        headLayout.setHorizontalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                .addContainerGap())
        );
        headLayout.setVerticalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        main.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        menu.setBackground(new java.awt.Color(37, 36, 34));

        home.setBackground(new java.awt.Color(204, 197, 185));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        librarians.setBackground(new java.awt.Color(204, 197, 185));
        librarians.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                librariansMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Librarians");

        javax.swing.GroupLayout librariansLayout = new javax.swing.GroupLayout(librarians);
        librarians.setLayout(librariansLayout);
        librariansLayout.setHorizontalGroup(
            librariansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(librariansLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        librariansLayout.setVerticalGroup(
            librariansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, librariansLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        records.setBackground(new java.awt.Color(204, 197, 185));
        records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordsMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Records");

        javax.swing.GroupLayout recordsLayout = new javax.swing.GroupLayout(records);
        records.setLayout(recordsLayout);
        recordsLayout.setHorizontalGroup(
            recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        recordsLayout.setVerticalGroup(
            recordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statistics.setBackground(new java.awt.Color(204, 197, 185));
        statistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statisticsMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Statistics");

        javax.swing.GroupLayout statisticsLayout = new javax.swing.GroupLayout(statistics);
        statistics.setLayout(statisticsLayout);
        statisticsLayout.setHorizontalGroup(
            statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statisticsLayout.setVerticalGroup(
            statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        logs.setBackground(new java.awt.Color(204, 197, 185));
        logs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logsMouseClicked(evt);
            }
        });
        logs.setVisible(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Logs");

        javax.swing.GroupLayout logsLayout = new javax.swing.GroupLayout(logs);
        logs.setLayout(logsLayout);
        logsLayout.setHorizontalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logsLayout.setVerticalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(librarians, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(records, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(librarians, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(records, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        main.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 590));

        tab1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));

        adminLogout.setBackground(new java.awt.Color(102, 0, 51));
        adminLogout.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        adminLogout.setForeground(new java.awt.Color(255, 153, 153));
        adminLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminLogout.setText("Log Out");
        adminLogout.setOpaque(true);
        adminLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLogoutMouseClicked(evt);
            }
        });

        libFirstnamelbl15.setBackground(new java.awt.Color(204, 102, 255));
        libFirstnamelbl15.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        libFirstnamelbl15.setForeground(new java.awt.Color(204, 102, 255));
        libFirstnamelbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl15.setText("Today's Quote :");

        todaysThought.setBackground(new java.awt.Color(204, 102, 255));
        todaysThought.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        todaysThought.setForeground(new java.awt.Color(255, 255, 255));
        todaysThought.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        libFirstnamelbl17.setBackground(new java.awt.Color(204, 102, 255));
        libFirstnamelbl17.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        libFirstnamelbl17.setForeground(new java.awt.Color(204, 102, 255));
        libFirstnamelbl17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl17.setText("Date : ");

        date.setBackground(new java.awt.Color(204, 102, 255));
        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        date.setPreferredSize(new java.awt.Dimension(200, 33));

        time.setBackground(new java.awt.Color(204, 102, 255));
        time.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        time.setPreferredSize(new java.awt.Dimension(200, 33));

        libFirstnamelbl19.setBackground(new java.awt.Color(204, 102, 255));
        libFirstnamelbl19.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        libFirstnamelbl19.setForeground(new java.awt.Color(204, 102, 255));
        libFirstnamelbl19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl19.setText("Time : ");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(641, Short.MAX_VALUE)
                .addComponent(adminLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(libFirstnamelbl15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(todaysThought, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(libFirstnamelbl17)
                            .addComponent(libFirstnamelbl19))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(libFirstnamelbl15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(todaysThought, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(libFirstnamelbl17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libFirstnamelbl19))
                .addGap(353, 353, 353)
                .addComponent(adminLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        contentPanels.addTab("tab1", tab1);

        tab2.setBackground(new java.awt.Color(0, 102, 153));

        jPanel1.setBackground(new java.awt.Color(37, 36, 34));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 49));

        Librarians1.setBackground(new java.awt.Color(204, 197, 185));
        Librarians1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians1MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add");

        javax.swing.GroupLayout Librarians1Layout = new javax.swing.GroupLayout(Librarians1);
        Librarians1.setLayout(Librarians1Layout);
        Librarians1Layout.setHorizontalGroup(
            Librarians1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        Librarians1Layout.setVerticalGroup(
            Librarians1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        Librarians2.setBackground(new java.awt.Color(204, 197, 185));
        Librarians2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Remove");

        javax.swing.GroupLayout Librarians2Layout = new javax.swing.GroupLayout(Librarians2);
        Librarians2.setLayout(Librarians2Layout);
        Librarians2Layout.setHorizontalGroup(
            Librarians2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Librarians2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        Librarians2Layout.setVerticalGroup(
            Librarians2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        Librarians4.setBackground(new java.awt.Color(204, 197, 185));
        Librarians4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians4MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Update");

        javax.swing.GroupLayout Librarians4Layout = new javax.swing.GroupLayout(Librarians4);
        Librarians4.setLayout(Librarians4Layout);
        Librarians4Layout.setHorizontalGroup(
            Librarians4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        Librarians4Layout.setVerticalGroup(
            Librarians4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(Librarians1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Librarians2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Librarians4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Librarians4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Librarians2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Librarians1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        librariansTabs.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(51, 51, 51));

        libFirstnamelbl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl.setText("Firstname :");

        libFirstname.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libFirstnamelbl1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl1.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl1.setText("Lastname :");

        libLastname.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libContactno.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libFirstnamelbl2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl2.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl2.setText("Contact No :");

        libFirstnamelbl3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl3.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl3.setText("email ID :");

        libEmailid.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libFirstnamelbl4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl4.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl4.setText("DOB :");

        libAdd.setBackground(new java.awt.Color(204, 197, 185));
        libAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libAddMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Add");

        javax.swing.GroupLayout libAddLayout = new javax.swing.GroupLayout(libAdd);
        libAdd.setLayout(libAddLayout);
        libAddLayout.setHorizontalGroup(
            libAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, libAddLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(24, 24, 24))
        );
        libAddLayout.setVerticalGroup(
            libAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(libAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        try {
            libDob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        libDob.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        libDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libDobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(259, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(libFirstnamelbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(libLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(libFirstnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(libFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(libFirstnamelbl3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(libFirstnamelbl4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(libEmailid, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(libDob, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(libFirstnamelbl2)
                                .addGap(18, 18, 18)
                                .addComponent(libContactno, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(229, 229, 229))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(libAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libContactno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libEmailid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libDob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(libAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        librariansTabs.addTab("tab2", jPanel6);

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setForeground(new java.awt.Color(51, 51, 51));

        libFirstnamelbl8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl8.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl8.setText("email ID :");

        rmEmail.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libFirstnamelbl9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl9.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl9.setText("DOB :");

        removeLibBtn.setBackground(new java.awt.Color(204, 197, 185));
        removeLibBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeLibBtnMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Remove");

        javax.swing.GroupLayout removeLibBtnLayout = new javax.swing.GroupLayout(removeLibBtn);
        removeLibBtn.setLayout(removeLibBtnLayout);
        removeLibBtnLayout.setHorizontalGroup(
            removeLibBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeLibBtnLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        removeLibBtnLayout.setVerticalGroup(
            removeLibBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeLibBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        try {
            rmDob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        rmDob.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rmDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmDobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(removeLibBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(359, 359, 359))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(libFirstnamelbl8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(libFirstnamelbl9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rmDob, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(238, 238, 238))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmDob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeLibBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        librariansTabs.addTab("tab2", jPanel9);

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setForeground(new java.awt.Color(51, 51, 51));

        libFirstnamelbl10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl10.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl10.setText("Firstname :");

        updateFname.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libFirstnamelbl11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl11.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl11.setText("Lastname :");

        updateLname.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        updateContact.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libFirstnamelbl12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl12.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl12.setText("Contact No :");

        libFirstnamelbl13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl13.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl13.setText("email ID :");

        updateEmail.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        libFirstnamelbl14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl14.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl14.setText("DOB :");

        libUpdateBtn.setBackground(new java.awt.Color(204, 197, 185));
        libUpdateBtn.setEnabled(false);
        libUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libUpdateBtnMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Update");

        javax.swing.GroupLayout libUpdateBtnLayout = new javax.swing.GroupLayout(libUpdateBtn);
        libUpdateBtn.setLayout(libUpdateBtnLayout);
        libUpdateBtnLayout.setHorizontalGroup(
            libUpdateBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(libUpdateBtnLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel15)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        libUpdateBtnLayout.setVerticalGroup(
            libUpdateBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, libUpdateBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        libFetchBtn.setBackground(new java.awt.Color(102, 102, 102));
        libFetchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libFetchBtnMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Fetch");

        javax.swing.GroupLayout libFetchBtnLayout = new javax.swing.GroupLayout(libFetchBtn);
        libFetchBtn.setLayout(libFetchBtnLayout);
        libFetchBtnLayout.setHorizontalGroup(
            libFetchBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(libFetchBtnLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel19)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        libFetchBtnLayout.setVerticalGroup(
            libFetchBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        try {
            updateDob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        updateDob.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        updateDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(libFirstnamelbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateLname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(libFirstnamelbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateFname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(libFirstnamelbl12)
                        .addGap(18, 18, 18)
                        .addComponent(updateContact, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(libFirstnamelbl13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(libFirstnamelbl14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateDob, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(libFetchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(libUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateFname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateLname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateContact, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(libFetchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(libFirstnamelbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libFirstnamelbl14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateDob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(libUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        librariansTabs.addTab("tab2", jPanel10);

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
            .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab2Layout.createSequentialGroup()
                    .addComponent(librariansTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(543, 543, 543))
            .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                    .addGap(0, 62, Short.MAX_VALUE)
                    .addComponent(librariansTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        contentPanels.addTab("tab2", tab2);

        tab3.setBackground(new java.awt.Color(0, 102, 153));

        jPanel12.setBackground(new java.awt.Color(37, 36, 34));
        jPanel12.setPreferredSize(new java.awt.Dimension(800, 49));

        Librarians11.setBackground(new java.awt.Color(204, 197, 185));
        Librarians11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians11MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Students");

        javax.swing.GroupLayout Librarians11Layout = new javax.swing.GroupLayout(Librarians11);
        Librarians11.setLayout(Librarians11Layout);
        Librarians11Layout.setHorizontalGroup(
            Librarians11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians11Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        Librarians11Layout.setVerticalGroup(
            Librarians11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        Librarians12.setBackground(new java.awt.Color(204, 197, 185));
        Librarians12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians12MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Books");

        javax.swing.GroupLayout Librarians12Layout = new javax.swing.GroupLayout(Librarians12);
        Librarians12.setLayout(Librarians12Layout);
        Librarians12Layout.setHorizontalGroup(
            Librarians12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Librarians12Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        Librarians12Layout.setVerticalGroup(
            Librarians12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        Librarians13.setBackground(new java.awt.Color(204, 197, 185));
        Librarians13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians13MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Librarians");

        javax.swing.GroupLayout Librarians13Layout = new javax.swing.GroupLayout(Librarians13);
        Librarians13.setLayout(Librarians13Layout);
        Librarians13Layout.setHorizontalGroup(
            Librarians13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        Librarians13Layout.setVerticalGroup(
            Librarians13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(Librarians11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Librarians12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(Librarians13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Librarians13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Librarians12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Librarians11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        recordsTabs.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setForeground(new java.awt.Color(51, 51, 51));

        adminStudentsRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(adminStudentsRecordTable);
        adminStudentsRecordTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        adminStudentsRecordTable.getTableHeader().setResizingAllowed(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        adminstudentSearchCombo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        adminstudentSearchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "student_id", "firstname", "lastname" }));

        adminstudentSearch.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        adminstudentSearchBtn.setBackground(new java.awt.Color(153, 153, 153));
        adminstudentSearchBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        adminstudentSearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        adminstudentSearchBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminstudentSearchBtn.setText("Search");
        adminstudentSearchBtn.setOpaque(true);
        adminstudentSearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminstudentSearchBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminstudentSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(adminstudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adminstudentSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminstudentSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adminstudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminstudentSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        recordsTabs.addTab("tab3", jPanel14);

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.setForeground(new java.awt.Color(51, 51, 51));

        jScrollPane2.setEnabled(false);

        adminBooksRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(adminBooksRecordTable);
        adminBooksRecordTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        adminBooksRecordTable.getTableHeader().setResizingAllowed(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        adminbooksearchBtn.setBackground(new java.awt.Color(153, 153, 153));
        adminbooksearchBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        adminbooksearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        adminbooksearchBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminbooksearchBtn.setText("Search");
        adminbooksearchBtn.setOpaque(true);
        adminbooksearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminbooksearchBtnMouseClicked(evt);
            }
        });

        adminbookSearch.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        adminbookSearchCombo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        adminbookSearchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "book_id", "book_name" }));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminbookSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(adminbookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adminbooksearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminbooksearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adminbookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminbookSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        recordsTabs.addTab("tab3", jPanel22);

        jPanel27.setBackground(new java.awt.Color(51, 51, 51));
        jPanel27.setForeground(new java.awt.Color(51, 51, 51));

        adminLibSearch.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        adminLibSearchBtn.setBackground(new java.awt.Color(153, 153, 153));
        adminLibSearchBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        adminLibSearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        adminLibSearchBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminLibSearchBtn.setText("Search");
        adminLibSearchBtn.setOpaque(true);
        adminLibSearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLibSearchBtnMouseClicked(evt);
            }
        });

        adminRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(adminRecordTable);
        adminRecordTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        adminRecordTable.getTableHeader().setResizingAllowed(false);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        adminLibSearchCombo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        adminLibSearchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "firstname", "lastname", "email_id" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(0, 186, Short.MAX_VALUE)
                        .addComponent(adminLibSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(adminLibSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adminLibSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminLibSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adminLibSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminLibSearchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        recordsTabs.addTab("tab3", jPanel26);

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
            .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab3Layout.createSequentialGroup()
                    .addComponent(recordsTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(543, 543, 543))
            .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                    .addGap(0, 62, Short.MAX_VALUE)
                    .addComponent(recordsTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        contentPanels.addTab("tab3", tab3);

        tab4.setBackground(new java.awt.Color(0, 102, 153));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student feedbacks : ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total students");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText(" : ");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Total books");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" : ");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Books issued");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText(" : ");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total librarians");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText(" : ");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Average penalty");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Books reissued");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Books not returned");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Books returned");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText(" : ");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText(" : ");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText(" : ");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText(" : ");

        totalStudents.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalStudents.setForeground(new java.awt.Color(255, 255, 255));
        totalStudents.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalStudents.setPreferredSize(new java.awt.Dimension(150, 33));

        totalBooks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalBooks.setForeground(new java.awt.Color(255, 255, 255));
        totalBooks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalBooks.setPreferredSize(new java.awt.Dimension(150, 33));

        booksIssued.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        booksIssued.setForeground(new java.awt.Color(255, 255, 255));
        booksIssued.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        booksIssued.setPreferredSize(new java.awt.Dimension(150, 33));

        totalLib.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalLib.setForeground(new java.awt.Color(255, 255, 255));
        totalLib.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalLib.setPreferredSize(new java.awt.Dimension(150, 33));

        booksReturned.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        booksReturned.setForeground(new java.awt.Color(255, 255, 255));
        booksReturned.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        booksReturned.setPreferredSize(new java.awt.Dimension(150, 33));

        booksReissued.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        booksReissued.setForeground(new java.awt.Color(255, 255, 255));
        booksReissued.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        booksReissued.setPreferredSize(new java.awt.Dimension(150, 33));

        booksNotReturned.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        booksNotReturned.setForeground(new java.awt.Color(255, 255, 255));
        booksNotReturned.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        booksNotReturned.setPreferredSize(new java.awt.Dimension(150, 33));

        avgPenalty.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avgPenalty.setForeground(new java.awt.Color(255, 255, 255));
        avgPenalty.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        avgPenalty.setPreferredSize(new java.awt.Dimension(150, 33));

        chart.setPreferredSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel34))
                                        .addGap(37, 37, 37))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(booksReissued, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(booksReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(221, 221, 221))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalLib, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(booksIssued, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(avgPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(booksNotReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(totalBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(totalLib, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(booksIssued, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(booksNotReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avgPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(booksReissued, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(booksReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        contentPanels.addTab("tab4", tab4);

        tab5.setBackground(new java.awt.Color(0, 102, 153));

        jPanel20.setBackground(new java.awt.Color(37, 36, 34));
        jPanel20.setPreferredSize(new java.awt.Dimension(800, 49));

        Librarians21.setBackground(new java.awt.Color(204, 197, 185));
        Librarians21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians21MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Monthly");

        javax.swing.GroupLayout Librarians21Layout = new javax.swing.GroupLayout(Librarians21);
        Librarians21.setLayout(Librarians21Layout);
        Librarians21Layout.setHorizontalGroup(
            Librarians21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians21Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        Librarians21Layout.setVerticalGroup(
            Librarians21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        Librarians22.setBackground(new java.awt.Color(204, 197, 185));
        Librarians22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Librarians22MouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Yearly");

        javax.swing.GroupLayout Librarians22Layout = new javax.swing.GroupLayout(Librarians22);
        Librarians22.setLayout(Librarians22Layout);
        Librarians22Layout.setHorizontalGroup(
            Librarians22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Librarians22Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        Librarians22Layout.setVerticalGroup(
            Librarians22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Librarians22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(Librarians21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(Librarians22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Librarians22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Librarians21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        recordsTabs1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        recordsTabs1.addTab("tab3", jPanel21);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setForeground(new java.awt.Color(51, 51, 51));

        jComboBox10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        libFirstnamelbl30.setBackground(new java.awt.Color(153, 153, 153));
        libFirstnamelbl30.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        libFirstnamelbl30.setForeground(new java.awt.Color(255, 255, 255));
        libFirstnamelbl30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libFirstnamelbl30.setText("View");
        libFirstnamelbl30.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(libFirstnamelbl30, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libFirstnamelbl30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        recordsTabs1.addTab("tab2", jPanel29);

        javax.swing.GroupLayout tab5Layout = new javax.swing.GroupLayout(tab5);
        tab5.setLayout(tab5Layout);
        tab5Layout.setHorizontalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
            .addGroup(tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab5Layout.createSequentialGroup()
                    .addComponent(recordsTabs1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        tab5Layout.setVerticalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(543, 543, 543))
            .addGroup(tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab5Layout.createSequentialGroup()
                    .addContainerGap(62, Short.MAX_VALUE)
                    .addComponent(recordsTabs1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        contentPanels.addTab("tab3", tab5);
        tab5.setVisible(false);

        main.add(contentPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 800, 630));

        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        contentPanels.setSelectedIndex(0);
        DateTimeFormatter timef = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        LocalTime localTime = LocalTime.now();
        time.setText(timef.format(localTime));        // TODO add your handling code here:
    }//GEN-LAST:event_homeMouseClicked

    private void librariansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_librariansMouseClicked
        contentPanels.setSelectedIndex(1);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_librariansMouseClicked

    private void recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordsMouseClicked
        contentPanels.setSelectedIndex(2);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_recordsMouseClicked

    private void statisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsMouseClicked
        contentPanels.setSelectedIndex(3);
        chart.start();
        
    }//GEN-LAST:event_statisticsMouseClicked

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
        contentPanels.setSelectedIndex(4);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_logsMouseClicked

    private void Librarians1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians1MouseClicked
librariansTabs.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_Librarians1MouseClicked

    private void Librarians2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians2MouseClicked
librariansTabs.setSelectedIndex(1);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_Librarians2MouseClicked

    private void Librarians4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians4MouseClicked
       librariansTabs.setSelectedIndex(2);        // TODO add your handling code here:
 // TODO add your handling code here:
    }//GEN-LAST:event_Librarians4MouseClicked

    private void Librarians11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians11MouseClicked
recordsTabs.setSelectedIndex(0); 
    
    
        adminStudentsRecordTable.setModel(new DefaultTableModel());;
        adminbookSearchCombo.setSelectedIndex(0);
        adminbookSearch.setText("");
        try {
//                lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, contact_no, email_id, dob from librarians where ? = ?");
//                lms.pstmt.setString(1, key);
//                lms.pstmt.setString(2, value);
            
                lms.pstmt = lms.connection.prepareStatement("select sr_no, firstname,lastname, student_id, contact_no,email_id,dob from students");
            
            
            
            lms.rs = lms.pstmt.executeQuery();
            ResultSetMetaData rsmd = lms.rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel)adminStudentsRecordTable.getModel();
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for(int i = 0; i<cols; i++){
                colName[i] = rsmd.getColumnName(i+1);
            }
            
            model.setColumnIdentifiers(colName);
            String sr_no, firstname,lastname,student_id, contact_no,email_id,dob;
            if(!lms.rs.next()){
                JOptionPane.showMessageDialog (null, "No data found");
            }
            else{
                do{
                    sr_no = lms.rs.getString(1);
                    firstname = lms.rs.getString(2);
                    lastname = lms.rs.getString(3);
                    student_id = lms.rs.getString(4);
                    contact_no = lms.rs.getString(5);
                    email_id = lms.rs.getString(6);
                    dob = lms.rs.getString(7);
                    String sname = firstname + lastname;
                    String[] row = {sr_no, firstname,lastname,student_id, contact_no,email_id,dob};
                    model.addRow(row);
                }while(lms.rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Librarians11MouseClicked

    private void Librarians12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians12MouseClicked
       recordsTabs.setSelectedIndex(1);
       
        adminBooksRecordTable.setModel(new DefaultTableModel());
        String key =  adminbookSearchCombo.getSelectedItem().toString();
        String value = adminbookSearch.getText();
        adminbookSearchCombo.setSelectedIndex(0);
        adminbookSearch.setText("");
        try {
                lms.pstmt = lms.connection.prepareStatement("select Book_id, Book_name, Author, Publication, isbn_no,Category,Quantity from books ");
            lms.rs = lms.pstmt.executeQuery();
            ResultSetMetaData rsmd = lms.rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel)adminBooksRecordTable.getModel();
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for(int i = 0; i<cols; i++){
                colName[i] = rsmd.getColumnName(i+1);
                
            }
            
            model.setColumnIdentifiers(colName);
            String Book_id, Book_name, Author, Publication, isbn_no,Category,Quantity;
            if(!lms.rs.next()){
                JOptionPane.showMessageDialog (null, "No data found");
            }
            else{
                do{
                    Book_id = lms.rs.getString(1);
                    Book_name = lms.rs.getString(2);
                    Author = lms.rs.getString(3);
                    Publication = lms.rs.getString(4);
                    isbn_no = lms.rs.getString(5);
                    Category = lms.rs.getString(6);
                    Quantity = lms.rs.getString(7);
                    
                    String[] row = {Book_id, Book_name, Author, Publication, isbn_no,Category,Quantity};
                    model.addRow(row);
                }while(lms.rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_Librarians12MouseClicked

    private void Librarians13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians13MouseClicked
    recordsTabs.setSelectedIndex(2);
    
    adminRecordTable.setModel(new DefaultTableModel());
    
    try {
            lms.rs = lms.statement.executeQuery("select firstname, lastname, contact_no, email_id, dob from librarians");
            ResultSetMetaData rsmd = lms.rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel)adminRecordTable.getModel();
            
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            
            for(int i = 0; i<cols; i++){
                colName[i] = rsmd.getColumnName(i+1);
                
            }
            model.setColumnIdentifiers(colName);
            
            String firstname, lastname, contact_no, email_id, dob;
            while(lms.rs.next()){
                firstname = lms.rs.getString(1);
                lastname = lms.rs.getString(2);
                contact_no = lms.rs.getString(3);
                email_id = lms.rs.getString(4);
                dob = lms.rs.getString(5);
                String[] row = {firstname, lastname, contact_no, email_id, dob};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_Librarians13MouseClicked

    private void libAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libAddMouseClicked
        
        String fname = libFirstname.getText();
        String lname = libLastname.getText();
        String contact = libContactno.getText();
        String email = libEmailid.getText();
        String dobTemp = libDob.getText();
        String d = dobTemp.substring(6,10) + "-" + dobTemp.substring(3,5) + "-" + dobTemp.substring(0,2);
        Date dob = Date.valueOf(d);
        try {
            lms.pstmt = lms.connection.prepareStatement("insert into librarians values(null,?,?,?,?,?)");
            lms.pstmt.setString(1,fname);
            lms.pstmt.setString(2, lname);
            lms.pstmt.setString(3, contact);
            lms.pstmt.setString(4, email);
            lms.pstmt.setDate(5, dob);
            
            int ra = lms.pstmt.executeUpdate();
            if(ra > 0){
                libFirstname.setText("");
                libLastname.setText("");
                libContactno.setText("");
                libEmailid.setText("");
                libDob.setText("");
                JOptionPane.showMessageDialog (null, "Data Inserted Successfully");
            }
            else{
                JOptionPane.showMessageDialog (null, "Error Occured");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_libAddMouseClicked

    private void libUpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libUpdateBtnMouseClicked

        String fname = updateFname.getText();
        String lname = updateLname.getText();
        String contact = updateContact.getText();
        String email = updateEmail.getText();
        String dobTemp = updateDob.getText();
        String d = dobTemp.substring(6,10) + "-" + dobTemp.substring(3,5) + "-" + dobTemp.substring(0,2);
        Date dob = Date.valueOf(d);
        try {
            lms.pstmt = lms.connection.prepareStatement("update librarians set firstname = ?, lastname = ?, contact_no = ?, dob = ? where email_id = ? ");
            lms.pstmt.setString(1,fname);
            lms.pstmt.setString(2, lname);
            lms.pstmt.setString(3, contact);
            lms.pstmt.setDate(4, dob);
            lms.pstmt.setString(5, email);
            
            int ra = lms.pstmt.executeUpdate();
            if(ra > 0){
                updateFname.setText("");
                updateLname.setText("");
                updateContact.setText("");
                updateEmail.setText("");
                updateDob.setText("");
                JOptionPane.showMessageDialog (null, "Data Updated Successfully");
            }
            else{
                JOptionPane.showMessageDialog (null, "Error Occured");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_libUpdateBtnMouseClicked

    private void removeLibBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeLibBtnMouseClicked
        String email = rmEmail.getText();
        String dobTemp = rmDob.getText();
        String d = dobTemp.substring(6,10) + "-" + dobTemp.substring(3,5) + "-" + dobTemp.substring(0,2);
        Date dob = Date.valueOf(d);
        try {
            lms.pstmt = lms.connection.prepareStatement("delete from librarians where email_id = ? and dob = ?");
            lms.pstmt.setString(1,email);
            lms.pstmt.setDate(2, dob);
            
            int ra = lms.pstmt.executeUpdate();
            if(ra > 0){
                rmEmail.setText("");
                rmDob.setText("");
                JOptionPane.showMessageDialog (null, "Data Deleted Successfully");
            }
            else{
                JOptionPane.showMessageDialog (null, "Error Occured");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeLibBtnMouseClicked

    private void libFetchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libFetchBtnMouseClicked
        String email = updateEmail.getText();
        try {
            lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, dob, contact_no from librarians where email_id = ? ");
            lms.pstmt.setString(1,email);
            lms.rs = lms.pstmt.executeQuery();
            if(!lms.rs.next()){
                JOptionPane.showMessageDialog (null, "No data found");
            }
            else{
                do{
                    String fname = lms.rs.getString(1);
                    String lname = lms.rs.getString(2);
                    String dob_temp = lms.rs.getString(3);
                    String dob = dob_temp.substring(8,10) + "/" +dob_temp.substring(5,7) + "/" +dob_temp.substring(0,4);
                    System.out.println(dob);
                    String contact = lms.rs.getString(4);
                    updateFname.setText(fname);
                    updateLname.setText(lname);
                    updateContact.setText(contact);
                    updateDob.setText(dob);
                            
                }while(lms.rs.next()); 
                
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_libFetchBtnMouseClicked

    private void Librarians21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Librarians21MouseClicked

    private void Librarians22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Librarians22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Librarians22MouseClicked

    private void updateDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateDobActionPerformed

    private void rmDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rmDobActionPerformed

    private void libDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libDobActionPerformed

    private void adminLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLogoutMouseClicked
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_adminLogoutMouseClicked

    private void adminLibSearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLibSearchBtnMouseClicked
        adminRecordTable.setModel(new DefaultTableModel());
        String key =  adminLibSearchCombo.getSelectedItem().toString();
        String value = adminLibSearch.getText();
        adminLibSearchCombo.setSelectedIndex(0);
        adminLibSearch.setText("");
        try {
//                lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, contact_no, email_id, dob from librarians where ? = ?");
//                lms.pstmt.setString(1, key);
//                lms.pstmt.setString(2, value);
            if(key.equals("firstname")){
                lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, contact_no, email_id, dob from librarians where firstname = ?");
                lms.pstmt.setString(1, value);
            }
            else if(key.equals("lastname")){
                lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, contact_no, email_id, dob from librarians where lastname = ?");
                lms.pstmt.setString(1, value);
            }
            else if(key.equals("email_id")){
                lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, contact_no, email_id, dob from librarians where email_id = ?");
                lms.pstmt.setString(1, value);
            }
            
            lms.rs = lms.pstmt.executeQuery();
            ResultSetMetaData rsmd = lms.rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel)adminRecordTable.getModel();
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for(int i = 0; i<cols; i++){
                colName[i] = rsmd.getColumnName(i+1);
                
            }
            
            model.setColumnIdentifiers(colName);
            String firstname, lastname, contact_no, email_id, dob;
            if(!lms.rs.next()){
                JOptionPane.showMessageDialog (null, "No data found");
            }
            else{
                do{
                    firstname = lms.rs.getString(1);
                    lastname = lms.rs.getString(2);
                    contact_no = lms.rs.getString(3);
                    email_id = lms.rs.getString(4);
                    dob = lms.rs.getString(5);
                    String[] row = {firstname, lastname, contact_no, email_id, dob};
                    model.addRow(row);
                }while(lms.rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adminLibSearchBtnMouseClicked

    private void adminbooksearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminbooksearchBtnMouseClicked
       
        adminBooksRecordTable.setModel(new DefaultTableModel());
        String key =  adminbookSearchCombo.getSelectedItem().toString();
        String value = adminbookSearch.getText();
        adminbookSearchCombo.setSelectedIndex(0);
        adminbookSearch.setText("");
        try {
//                lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, contact_no, email_id, dob from librarians where ? = ?");
//                lms.pstmt.setString(1, key);
//                lms.pstmt.setString(2, value);
            if(key.equals("book_id")){
                lms.pstmt = lms.connection.prepareStatement("select Book_id, Book_name, Author, Publication, isbn_no,Category,Quantity from books where Book_id = ?");
                lms.pstmt.setString(1, value);
            }
            else if(key.equals("book_name")){
                lms.pstmt = lms.connection.prepareStatement("select Book_id, Book_name, Author, Publication, isbn_no,Category,Quantity from books where Book_name = ?");
                lms.pstmt.setString(1, value);
            }
            
            
            lms.rs = lms.pstmt.executeQuery();
            ResultSetMetaData rsmd = lms.rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel)adminBooksRecordTable.getModel();
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for(int i = 0; i<cols; i++){
                colName[i] = rsmd.getColumnName(i+1);
                
            }
            
            model.setColumnIdentifiers(colName);
            String Book_id, Book_name, Author, Publication, isbn_no,Category,Quantity;
            if(!lms.rs.next()){
                JOptionPane.showMessageDialog (null, "No data found");
            }
            else{
                do{
                    Book_id = lms.rs.getString(1);
                    Book_name = lms.rs.getString(2);
                    Author = lms.rs.getString(3);
                    Publication = lms.rs.getString(4);
                    isbn_no = lms.rs.getString(5);
                    Category = lms.rs.getString(6);
                    Quantity = lms.rs.getString(7);
                    
                    String[] row = {Book_id, Book_name, Author, Publication, isbn_no,Category,Quantity};
                    model.addRow(row);
                }while(lms.rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }//GEN-LAST:event_adminbooksearchBtnMouseClicked

    private void adminstudentSearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminstudentSearchBtnMouseClicked
        
        adminStudentsRecordTable.setModel(new DefaultTableModel());;
        String key =  adminstudentSearchCombo.getSelectedItem().toString();
        String value = adminstudentSearch.getText();
        adminstudentSearchCombo.setSelectedIndex(0);
        adminstudentSearch.setText("");
        
        try {
//                lms.pstmt = lms.connection.prepareStatement("select firstname, lastname, contact_no, email_id, dob from librarians where ? = ?");
//                lms.pstmt.setString(1, key);
//                lms.pstmt.setString(2, value);
            if(key.equals("student_id")){
                lms.pstmt = lms.connection.prepareStatement("select sr_no, firstname,lastname, student_id, contact_no,email_id,dob from students where student_id = ?");
                lms.pstmt.setString(1, value);
            }
            else if(key.equals("firstname")){
                lms.pstmt = lms.connection.prepareStatement("select sr_no, firstname,lastname, student_id, contact_no,email_id,dob from students where firstname = ?");
                lms.pstmt.setString(1, value);
            }
            else if(key.equals("lastname")){
                lms.pstmt = lms.connection.prepareStatement("select sr_no, firstname,lastname, student_id, contact_no,email_id, dob from students where lastname = ?");
                lms.pstmt.setString(1, value);
            }
            
            
            lms.rs = lms.pstmt.executeQuery();
            ResultSetMetaData rsmd = lms.rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel)adminStudentsRecordTable.getModel();
            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for(int i = 0; i<cols; i++){
                colName[i] = rsmd.getColumnName(i+1);
            }
            
            model.setColumnIdentifiers(colName);
            String sr_no, firstname,lastname,student_id, contact_no,email_id,dob;
            if(!lms.rs.next()){
                JOptionPane.showMessageDialog (null, "No data found");
            }
            else{
                do{
                    sr_no = lms.rs.getString(1);
                    firstname = lms.rs.getString(2);
                    lastname = lms.rs.getString(3);
                    student_id = lms.rs.getString(4);
                    contact_no = lms.rs.getString(5);
                    email_id = lms.rs.getString(6);
                    dob = lms.rs.getString(7);
                    String[] row = {sr_no, firstname,lastname, student_id, contact_no,email_id,dob};
                    model.addRow(row);
                }while(lms.rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adminstudentSearchBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Librarians1;
    private javax.swing.JPanel Librarians11;
    private javax.swing.JPanel Librarians12;
    private javax.swing.JPanel Librarians13;
    private javax.swing.JPanel Librarians2;
    private javax.swing.JPanel Librarians21;
    private javax.swing.JPanel Librarians22;
    private javax.swing.JPanel Librarians4;
    private javax.swing.JTable adminBooksRecordTable;
    private javax.swing.JTextField adminLibSearch;
    private javax.swing.JLabel adminLibSearchBtn;
    private javax.swing.JComboBox<String> adminLibSearchCombo;
    private javax.swing.JLabel adminLogout;
    private javax.swing.JTable adminRecordTable;
    private javax.swing.JTable adminStudentsRecordTable;
    private javax.swing.JTextField adminbookSearch;
    private javax.swing.JComboBox<String> adminbookSearchCombo;
    private javax.swing.JLabel adminbooksearchBtn;
    private javax.swing.JTextField adminstudentSearch;
    private javax.swing.JLabel adminstudentSearchBtn;
    private javax.swing.JComboBox<String> adminstudentSearchCombo;
    private javax.swing.JLabel avgPenalty;
    private javax.swing.JLabel booksIssued;
    private javax.swing.JLabel booksNotReturned;
    private javax.swing.JLabel booksReissued;
    private javax.swing.JLabel booksReturned;
    private com.vishal.chart.Chart chart;
    private javax.swing.JTabbedPane contentPanels;
    private javax.swing.JLabel date;
    private javax.swing.JPanel head;
    private javax.swing.JPanel home;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel libAdd;
    private javax.swing.JTextField libContactno;
    private javax.swing.JFormattedTextField libDob;
    private javax.swing.JTextField libEmailid;
    private javax.swing.JPanel libFetchBtn;
    private javax.swing.JTextField libFirstname;
    private javax.swing.JLabel libFirstnamelbl;
    private javax.swing.JLabel libFirstnamelbl1;
    private javax.swing.JLabel libFirstnamelbl10;
    private javax.swing.JLabel libFirstnamelbl11;
    private javax.swing.JLabel libFirstnamelbl12;
    private javax.swing.JLabel libFirstnamelbl13;
    private javax.swing.JLabel libFirstnamelbl14;
    private javax.swing.JLabel libFirstnamelbl15;
    private javax.swing.JLabel libFirstnamelbl17;
    private javax.swing.JLabel libFirstnamelbl19;
    private javax.swing.JLabel libFirstnamelbl2;
    private javax.swing.JLabel libFirstnamelbl3;
    private javax.swing.JLabel libFirstnamelbl30;
    private javax.swing.JLabel libFirstnamelbl4;
    private javax.swing.JLabel libFirstnamelbl8;
    private javax.swing.JLabel libFirstnamelbl9;
    private javax.swing.JTextField libLastname;
    private javax.swing.JPanel libUpdateBtn;
    private javax.swing.JPanel librarians;
    private javax.swing.JTabbedPane librariansTabs;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel main;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel records;
    private javax.swing.JTabbedPane recordsTabs;
    private javax.swing.JTabbedPane recordsTabs1;
    private javax.swing.JPanel removeLibBtn;
    private javax.swing.JFormattedTextField rmDob;
    private javax.swing.JTextField rmEmail;
    private javax.swing.JPanel statistics;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    private javax.swing.JLabel time;
    private javax.swing.JLabel todaysThought;
    private javax.swing.JLabel totalBooks;
    private javax.swing.JLabel totalLib;
    private javax.swing.JLabel totalStudents;
    private javax.swing.JTextField updateContact;
    private javax.swing.JFormattedTextField updateDob;
    private javax.swing.JTextField updateEmail;
    private javax.swing.JTextField updateFname;
    private javax.swing.JTextField updateLname;
    // End of variables declaration//GEN-END:variables
}
