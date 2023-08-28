import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {
	//Main method
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//object of StaffGUI class
        StaffGUI StaffInfoFrame = new StaffGUI();
        //set default close operation of frame when exit
        StaffInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make frame visible
        StaffInfoFrame.setVisible(true);
        //make connection to database
        OracleDatabase.Load(); 
}
}
