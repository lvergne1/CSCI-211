/*
 * Unit 7 Database Connectivity
 * CSCI 112
 * Last modified 3/30/16 @ 10:30 AM
 * @author Leo Vergnetti
 */
package databaseconn;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *DatabaseConn is a class with 3 methods, main, and two query methods to query a
 * database.  The first method saves the query result to a .csv file.  The second
 * prints the result neatly to the console. 
 */
public class DatabaseConn {

    /* Main method is entry point of the program.  It first connects to the 
     * database ,and reports to the user when it is connected.  Then it creates
     * a statement for the cnnection which it passes to both of the other 
     * methods in the class.
     */
    public static void main(String[] args)
                throws SQLException, ClassNotFoundException, FileNotFoundException {
        //connect to the database
        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://68.178.216.151/CWHDemo","student","Student%123");
        //output connection status
        System.out.println("connected!");
        
        //create statement object for this connection
        Statement s = conn.createStatement();
        selectAll(s);       //query database and write result to csv file
        selectSome(s);      //query database for online classes and print to console
  
        conn.close();   //close connection
        System.out.println("Connection Closed");
    }//endmain
//**************************************************************************
    /*
     * selectAll method queries database for the crn, subject, course, section,
     * days, and time from the table fall2014. It creates a file (fall2014.csv)
     * and using saves the result of the query to this file.
     */
    public static void selectAll(Statement s)
                throws SQLException, ClassNotFoundException, FileNotFoundException{
        
        String queryString;     //String to hold an SQL Query
        ResultSet rs;           //The result set from an SQL query as a table
        File sqlResult = new File("SQLResult.csv"); //make file for result string
        
            //open printwriter on target file to print results
            PrintWriter outFile = new PrintWriter(sqlResult); 
            //query to return all rows and columns from table fall2014
            queryString = "SELECT crn, subject, course, section, days, time FROM fall2014 ORDER BY course";
            //send a statement executing query and saving result set
            rs = s.executeQuery(queryString);
        //print result to csv file
        while (rs.next()){
            //print to csv file using commas as delimiters
            outFile.println( rs.getString(1)+"," + rs.getString(2)+","+
                             rs.getString(3)+"," +rs.getString(4)+","+
                             rs.getString(5)+","+ rs.getString(6));
        }//end while
        outFile.close();    //close print writer
    }//end selectAll
//**************************************************************************
    /*
     * selectSome method queries the database for OA, CSCI, CIS classes in fall2014
     * that are available online.  the crn, subject, course and section is printed
     * in a formatted table to the console
     */
    public static void selectSome(Statement s)
                throws SQLException, ClassNotFoundException {
        String queryString;     //String to hold SQL Query
        ResultSet rs;           //the result set fromm sql query as a table
        
        //query to return all online csci classes from table fall 2014
        queryString = "SELECT crn, subject, course, section FROM fall2014 where time = 'dis'";
        
        //send statement excecuting query and saving result set
        rs = s.executeQuery(queryString);
        
        //ouptut queryString to the console
        System.out.println(queryString);
        //blankline 
       System.out.println();
        //print formatted table header with crn, subject, course, section
        System.out.printf("%-20s%-20s%-20s%-20s%n", "CRN","Subject","Course","Section");
        
        //print the results in a formatted table to the console.
        while (rs.next()){
            System.out.printf("%-20s%-20s%-20s%-20s%n", rs.getString(1), rs.getString(2),
                                                        rs.getString(3), rs.getString(4));
        }//end while
    }//end selectSome
//*****************************************************************************
}//endDatabaseConn
