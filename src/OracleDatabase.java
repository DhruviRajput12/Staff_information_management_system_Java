import javax.swing.*;
import java.sql.*;
import java.util.Objects;

public class OracleDatabase {
	//Making Private objects
    private static Connection conn;
    private static PreparedStatement preStat;
    private static Statement stat;

  //****************************************************************************************************************
    //Creating connection to database
  //****************************************************************************************************************
    public static void Load() throws ClassNotFoundException, SQLException { 
    	//Making Connection To Database
    	//Handled ClassNotFoundException
        // 1. Load driver
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			System.out.println("Drivers are Loaded");
			
        // 2. Create connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01496176","oracle");
			System.out.println("Database is Connected");
        
        // 3. Create Statement
			stat = conn.createStatement();
    }
    
  //****************************************************************************************************************
    //Checking id at the time of fetching data from database
    private static boolean CheckForId(String id) throws SQLException {
        String idSelect = "SELECT id FROM staff";
        ResultSet rs = stat.executeQuery(idSelect);
        while (rs.next()){
            if (Objects.equals(id, rs.getString("id")))
            {
                return true;
            }
        }
        return false;
    }
  //****************************************************************************************************************

    public static void Insert(String id, String lastname, String firstname, String mi, String address, String city, String state, String telephone, String email) throws SQLException {
        // Check if particular ID exists in table or not
        if(CheckForId(id))
        {
            JOptionPane.showMessageDialog(null, "That ID already Exists. ID should be unique!");
        }
        
        //if id does not exits in database then perform Insert query on database
        String sqlInsert = "INSERT INTO staff (id, lastname, firstname, mi, address, city, state, telephone, email)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Creating prepared statement
        preStat = conn.prepareStatement(sqlInsert);
       
        preStat.setString(1, id);
        preStat.setString(2, lastname);
        preStat.setString(3, firstname);
        preStat.setString(4, mi);
        preStat.setString(5, address);
        preStat.setString(6, city);
        preStat.setString(7, state);
        preStat.setString(8, telephone);
        preStat.setString(9, email);
        // Execute Statement
        preStat.executeUpdate();
    }
    
  //****************************************************************************************************************
    
      public static String[] View(String id) throws SQLException {
        // Check if ID exists in table 
        if(!CheckForId(id))
        {
            JOptionPane.showMessageDialog(null, "This ID does not exist in database, Please Try Agian!");
        }
        
      String[]  staffInfo = new String[9];
        
      // SQL select statement
      String selectRow = "SELECT * FROM staff WHERE id= " + id;
      ResultSet rs = stat.executeQuery(selectRow);
        
      // Updating the row
        while (rs.next()) {
            for (int i = 0; i < staffInfo.length; i++) {
                staffInfo[i] = rs.getString(i + 1);
            }
        }
      return staffInfo;
    }
    
  //****************************************************************************************************************
      public static void Update(String id, String lastname, String firstname, String mi, String address, String city, String state, String telephone, String email) throws SQLException {
         
          if(!CheckForId(id))
          {
              JOptionPane.showMessageDialog(null, "That ID does not exist. Could not Update!");
          }
          
          String update = "UPDATE staff SET ";
          if (!lastname.equals(""))
          {
              update += "lastname=\'" + lastname + "\',";
          }
          if (!firstname.equals(""))
          {
              update += "firstname=\'" + firstname + "\',";
          }
          if (!mi.equals(""))
          {
              update += "mi=\'" + mi + "\',";
          }
          if (!address.equals(""))
          {
              update += "address=\'" + address + "\',";
          }
          if (!city.equals(""))
          {
              update += "city=\'" + city + "\',";
          }
          if (!state.equals(""))
          {
              update += "state=\'" + state + "\',";
          }
          if (!telephone.equals(""))
          {
              update += "telephone=\'" + telephone + "\',";
          }
          if (!email.equals(""))
          {
              update += "email=\'" + email + "\',";
          }
          
          update = update.substring(0, update.length() - 1); 
          update += " WHERE id= ?";
          System.out.println(update);
          preStat = conn.prepareStatement(update);
          preStat.setString(1, id);
          preStat.executeUpdate();
      }

    //****************************************************************************************************************

}
