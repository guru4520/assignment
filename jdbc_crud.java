package jdbc;
import java.sql.*;
public class jdbc_crud {
	private static String jdbcUrl = "jdbc:mysql://localhost:3360/crud";
	private static String username = "root";
	private static String password = "admin123";

	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	private static final String CREATE_TABLE_SQL="CREATE TABLE crud.STUDENT ("
            + "STUDENT_NO INT(3) NOT NULL,"
            + "STUDENT_NAME TEXT(30) NOT NULL,"
            + "STUDENT_DOB DATE NOT NULL,"
            + "STUDENT_DOJ DATE NOT NULL,"
            + "PRIMARY KEY (STUDENT_NO))";
	private static final String INSERT_TABLE_SQL = "INSERT INTO crud.STUDENT" +
	        "  (STUDENT_NO, STUDENT_NAME, STUDENT_DOB, STUDENT_DOJ) VALUES " +
	        " (?, ?, ?, ?);";
	private static final String UPDATE_TABLE_SQL = "UPDATE STUDENT SET STUDENT_NAME = ?,STUDENT_DOB = ?,STUDENT_DOJ=? where STUDENT_NO = ?;";
	 private static final String SELECT_TABLE_SQL1 = "SELECT * FROM STUDENT WHERE STUDENT_NO =?";
	 private static final String SELECT_TABLE_SQL2 = "SELECT * FROM STUDENT";
	 private static final String DELETE_TABLE_SQL = "DELETE FROM STUDENT WHERE STUDENT_NO =?";
	public void createTable() {
	try {

		conn = DriverManager.getConnection(jdbcUrl, username, password);
	    stmt = conn.prepareStatement(CREATE_TABLE_SQL);
	    stmt.executeUpdate();

	System.out.println("Table created");

	} catch (SQLException e) {
	e.printStackTrace();
	} finally {
	try {
	// Close connection
	if (stmt != null) {
	  stmt.close();
	}
	if (conn != null) {
	  conn.close();
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
public void insertintoTable() {
	try {

		conn = DriverManager.getConnection(jdbcUrl, username, password);
	    stmt = conn.prepareStatement(INSERT_TABLE_SQL);
	    
            stmt.setInt(1, 4);
            stmt.setString(2, "Prasad");
            stmt.setString(3, "1999-06-11");
            stmt.setString(4, "2022-03-25");
            
            System.out.println(stmt);
            // Step 3: Execute the query or update query
            stmt.executeUpdate();
	System.out.println("Record Inserted");

	} catch (SQLException e) {
	e.printStackTrace();
	} finally {
	try {
	// Close connection
	if (stmt != null) {
	  stmt.close();
	}
	if (conn != null) {
	  conn.close();
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
public void updateTable() {
	try {

		conn = DriverManager.getConnection(jdbcUrl, username, password);
	    stmt = conn.prepareStatement(UPDATE_TABLE_SQL);
	    
            
            stmt.setString(1, "Anuja");
            stmt.setString(2, "1999-05-02");
            stmt.setString(3, "2022-03-30");
            stmt.setInt(4, 3);
            System.out.println(stmt);
            // Step 3: Execute the query or update query
            stmt.executeUpdate();
	System.out.println("Record Updated");

	} catch (SQLException e) {
	e.printStackTrace();
	} finally {
	try {
	// Close connection
	if (stmt != null) {
	  stmt.close();
	}
	if (conn != null) {
	  conn.close();
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
public void selectOneTable() {
	try {

		conn = DriverManager.getConnection(jdbcUrl, username, password);
	    stmt = conn.prepareStatement(SELECT_TABLE_SQL1);
	    
	    stmt.setInt(1, 1);
        System.out.println(stmt);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String dob = rs.getString(3);
            String doj = rs.getString(4);
            System.out.println("Student No.\t Student Name \t Date of Birth \t Date of Joining");
            System.out.println("\t"+id + "\t     " + name + "\t  " + dob + "\t    " + doj );
        }

	} catch (SQLException e) {
	e.printStackTrace();
	} finally {
	try {
	// Close connection
	if (stmt != null) {
	  stmt.close();
	}
	if (conn != null) {
	  conn.close();
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
public void selectAllTable() {
	try {

		conn = DriverManager.getConnection(jdbcUrl, username, password);
	    stmt = conn.prepareStatement(SELECT_TABLE_SQL2);
	    
        System.out.println(stmt);
        
        ResultSet rs = stmt.executeQuery();
        System.out.println("Student No.\t Student Name \t Date of Birth \t Date of Joining");
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String dob = rs.getString(3);
            String doj = rs.getString(4);
            System.out.println("\t"+id + "\t     " + name + "\t  " + dob + "\t    " + doj );
        }

	} catch (SQLException e) {
	e.printStackTrace();
	} finally {
	try {
	// Close connection
	if (stmt != null) {
	  stmt.close();
	}
	if (conn != null) {
	  conn.close();
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
public void DeleteOneTable() {
	try {

		conn = DriverManager.getConnection(jdbcUrl, username, password);
	    stmt = conn.prepareStatement(DELETE_TABLE_SQL);
	    
	    stmt.setInt(1, 1);
        System.out.println(stmt);
        
        int result = stmt.executeUpdate();
        System.out.println("Number of records affected :: " + result);
        

	} catch (SQLException e) {
	e.printStackTrace();
	} finally {
	try {
	// Close connection
	if (stmt != null) {
	  stmt.close();
	}
	if (conn != null) {
	  conn.close();
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
public static void main(String[] args) {

jdbc_crud j=new jdbc_crud();
//j.createTable();
//j.insertintoTable();
//j.updateTable();
//j.selectOneTable();
//j.selectAllTable();
j.DeleteOneTable();
}
}
