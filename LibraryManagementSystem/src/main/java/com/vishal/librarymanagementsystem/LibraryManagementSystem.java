package com.vishal.librarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LibraryManagementSystem {
    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet rs = null;
    public static PreparedStatement pstmt = null;
    public static Date currentDate = null;
    public static Time currentTime = null;
    
    public static int penalty(Date issueDate, Date curDate, int reIssue,int penalty){
        Date startDate = issueDate; // Set start date
        Date endDate   = curDate;// Set end date

        long duration  = endDate.getTime() - startDate.getTime();

//        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
//        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
//        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
        long dateDiff = TimeUnit.MILLISECONDS.toDays(duration);
//        System.out.println("difference : " + dateDiff);
//        int dateDiff = curDate - issueDate - (reIssue * 8);
        int penFlag = 0;
        int dateFlag = 0;
        int penaltyIncrement = 0;
        
        for(int j = 1; j <= penalty; j += 20){
            if(penalty % 20 == 0){
                penFlag++;
            }
        }
        // System.out.println("penflag : " + penFlag);
        
        for(int i = 1; i <= dateDiff; i++){
            if(i%8 == 0){
//                System.out.println("i : " + i);
                dateFlag++;
            }
        }
        if(penFlag != dateFlag){
            penaltyIncrement = ((dateFlag - penFlag) * 20);
        }
        
        // System.out.println("dateFlag : " + dateFlag);
        
        
        return penaltyIncrement;
    }
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("\n@created_by_vishal_bhangare :)");
        
        Login login = new Login();
        login.setVisible(false);
        Loading welcome = new Loading();
        welcome.setVisible(true);
        try{
            for(int i = 0; i<=100;i++){
                Thread.sleep(10);
                welcome.ProgressBar.setValue(i);
            }
        }
        catch(Exception e){}
        welcome.setVisible(false);
        login.setVisible(true);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DbConnection.connect();
            System.out.println("Connection established");
            
            
//            System.out.println(connection);
            statement = connection.createStatement();
            statement.execute("SET time_zone = '+05:30';");        
            rs = statement.executeQuery("SELECT CURDATE(),CURTIME()");     //,CURTIME()
            while (rs.next()) {                                    //0123456789
                currentDate = rs.getDate(1); 
                currentTime = rs.getTime(2);
            }
                     
            pstmt = connection.prepareStatement("select issue_date, student_id, book_id,penalty, reissue,sr_no from records where return_date is NULL");
            rs = pstmt.executeQuery();
            while (rs.next()) {                                    //0123456789
                String studentId = rs.getString(2);
                String bookId = rs.getString(3);
                int penalty = rs.getInt(4);
                int reissue = rs.getInt(5);
                int sr_no = rs.getInt(6);
                
                Date issueDateT = rs.getDate(1);
                Date curDateT = currentDate;
                
                int penaltyIncrement = penalty(issueDateT, curDateT, reissue, penalty);
//                System.out.println("Penalty for : " + sr_no + " is " + penaltyIncrement);
                if(penaltyIncrement > 0){
                    pstmt = connection.prepareStatement("update records set penalty = penalty + ? where sr_no = ? and student_id = ? and book_id = ? and return_date is NULL");
                    
                    pstmt.setInt(1, penaltyIncrement);
                    pstmt.setInt(2, sr_no);
                    pstmt.setString(3,studentId);
                    pstmt.setString(4,bookId);
                    int ra = pstmt.executeUpdate();
//                    if(ra > 1){
//                        System.out.println("rows affected " + ra);
//                    }
                    penaltyIncrement = 0;
                    
                }
//                else{
//                    System.out.println("No penalty");
//                }
//                System.out.println("----------------");
//                System.out.println("----------------");
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog (null, "Error!!!" );
            System.out.println("Error ---> ");
            System.out.println(e);
        }
        System.out.println("["+currentDate +"]["+currentTime+"]");
    }
}
