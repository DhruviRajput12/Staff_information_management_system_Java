import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StaffGUI extends JFrame {
	// GUI Components
	//Creating Base panel(OuterPanel) for all component
    private JPanel OutterPanel;
    
    //Information Panel for Labels and TextFields
    private JPanel InformationPanel;
    
    private JLabel lblID;
    private JTextField tfID;
    
    private JLabel lblLastName;
    private JTextField tfLastName;
    
    private JLabel lblFirstName;
    private JTextField tfFirstName;
    
    private JLabel lblMI;
    private JTextField tfMI;
    
    private JLabel lblAddress;
    private JTextField tfAddress;
    
    private JLabel lblCity;
    private JTextField tfCity;
    
    private JLabel lblState;
    private JTextField tfState;
    
    private JLabel lblTelPhone;
    private JTextField tfTelPhone;
    
    private JLabel lblEmail;
    private JTextField tfEmail;

    // Buttons
    private JPanel ButtonPanel;
    private JButton btnView;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnClear;

    //Display Massage
    private JLabel displayLabel;

    // Constructor
    public StaffGUI(){
        setSize(600, 300);
        CreatePanel();
    }
  //****************************************************************************************************************
    
    // Method for creating the Panel
    private void CreatePanel() {
        //Border Layout 
        OutterPanel = new JPanel();
        OutterPanel.setLayout(new BorderLayout());
       
        //Inside Panel 1
        // Creating InformationPanel
        InformationPanel = new JPanel();
        InformationPanel.setBorder(new TitledBorder(new EtchedBorder(), "Staff Information"));
        InformationPanel.setLayout(new GridLayout(9,2));
        
        // Initializing components and adding it to panel
        lblID = new JLabel("ID ");
        InformationPanel.add(lblID);
        
        tfID = new JTextField(20);
        InformationPanel.add(tfID);
        
        lblLastName = new JLabel("Last Name");
        InformationPanel.add(lblLastName);
        
        tfLastName = new JTextField(20);
        InformationPanel.add(tfLastName);
        
        lblFirstName = new JLabel("First Name");
        InformationPanel.add(lblFirstName);
	    
        tfFirstName = new JTextField(15);
        InformationPanel.add(tfFirstName);
	    
        lblMI = new JLabel("MI");
        InformationPanel.add(lblMI);
	    
        tfMI = new JTextField(4);
        InformationPanel.add(tfMI);
	    
        lblAddress = new JLabel("Address");
        InformationPanel.add(lblAddress);
		
        tfAddress = new JTextField(20);
        InformationPanel.add(tfAddress);
        
        lblCity = new JLabel("City");
        InformationPanel.add(lblCity);
		
        tfCity = new JTextField(20);
        InformationPanel.add(tfCity);
		
        lblState = new JLabel("State");
        InformationPanel.add(lblState);
		
        tfState = new JTextField(4);
        InformationPanel.add(tfState);
		
        lblTelPhone = new JLabel("Telephone");
        InformationPanel.add(lblTelPhone);
		
        tfTelPhone = new JTextField(15);
        InformationPanel.add(tfTelPhone);
		
        lblEmail = new JLabel("Email");
        InformationPanel.add(lblEmail);
		
        tfEmail = new JTextField(20);
        InformationPanel.add(tfEmail);
        
        //##########################################################################################################
        // Creating ButtonPanel 
        ButtonPanel = new JPanel();
        // Call for methods to create buttons and Adding components to Panel
        CreateViewButton();
        ButtonPanel.add(btnView);
        
        CreatebtnInsert();
        ButtonPanel.add(btnInsert);
        
        CreatebtnUpdate();
        ButtonPanel.add(btnUpdate);
        
        CreatebtnClear();
        ButtonPanel.add(btnClear);
                 
      //############################################################################################################
                    
        // Adding sub-panels to main panel
        OutterPanel.add(InformationPanel, BorderLayout.NORTH);
        OutterPanel.add(ButtonPanel, BorderLayout.CENTER);
       // Adding main panel to InformationPanel
        add(OutterPanel);

    }
    
    //For Staff Information Label
    public JLabel getDisplayLabel() {
		return displayLabel;
	}

	public void setDisplayLabel(JLabel displayLabel) {
		this.displayLabel = displayLabel;
	}

   
    
    //************************************************************************************************************
 
     private void CreateViewButton() {
        btnView = new JButton("View");
        
        class ViewListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    View();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        // Creating listener object
        ActionListener listener = new ViewListener();
        btnView.addActionListener(listener);
    }
     
     //View() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     public void View() throws SQLException {
          String id = tfID.getText();
         // Validation check for id field
         if(id.length()!=9)
             JOptionPane.showMessageDialog(null, "ID is should be 9 Digits Only!");
        
         String[] staffInfo = OracleDatabase.View(id);
         
         // Displaying fetched data into text fields
         tfLastName.setText(staffInfo[1]);
         tfFirstName.setText(staffInfo[2]);
         tfMI.setText(staffInfo[3]);
         tfAddress.setText(staffInfo[4]);
         tfCity.setText(staffInfo[5]);
         tfState.setText(staffInfo[6]);
         tfTelPhone.setText(staffInfo[7]);
         tfEmail.setText(staffInfo[8]);
     }

    //*********************************************************************************************************
     
    private void CreatebtnInsert() {
        btnInsert = new JButton("Insert");
     
        class InsertListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Insert();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        //listener object
        ActionListener listener = new InsertListener();
        btnInsert.addActionListener(listener);
    }
    
  //Insert() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void Insert() throws SQLException {
        // Read User Input
        String id = tfID.getText();
        String lname = tfLastName.getText();
        String fname = tfFirstName.getText();
        String mi = tfMI.getText();
        String address = tfAddress.getText();
        String city = tfCity.getText();
        String state = tfState.getText();
        String telephone = tfTelPhone.getText();
        String email = tfEmail.getText();

        // Validation check
        //Using length() and equals() 
        // for ID field
        if(id.length()!=9){
            JOptionPane.showMessageDialog(null, "ID is required and should be 9 Characters!");}
        // for MI field
        if(mi.length()!=1 && !mi.equals("")){
            JOptionPane.showMessageDialog(null, "MI filed is for Male of Female, so it should be M/F Only!");}
        // for State field
        if(state.length()!=2 && !state.equals("")){
            JOptionPane.showMessageDialog(null, "State should be 2 Characters Only!");}
        // for TelPhone field
        if(telephone.length()!=10 && !telephone.equals("")){
            JOptionPane.showMessageDialog(null, "Telphone should not be more than 10 digits!");}
        //for email field
        if(!isValidEmailid(email, email)) {
        	JOptionPane.showMessageDialog(null,"Invalid Email Id");
        }
       
        //insert statement on database
        OracleDatabase.Insert(id, lname, fname, mi, address, city, state, telephone, email);
    }
    
   //**********************************************************************************************************
    
    private void CreatebtnUpdate() {
       btnUpdate = new JButton("Update");
       // Creating Action listener 
        class UpdateListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Update();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        ActionListener listener = new UpdateListener();
        btnUpdate.addActionListener(listener);
    }

    //Update() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void Update() throws SQLException {
        // Read input from User
        String id = tfID.getText();
        String lname = tfLastName.getText();
        String fname = tfFirstName.getText();
        String mi = tfMI.getText();
        String address = tfAddress.getText();
        String city = tfCity.getText();
        String state = tfState.getText();
        String telephone = tfTelPhone.getText();
        String email = tfEmail.getText();

        // Validation check on all the field
        if (id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter id to Update!");
        }
        
        if(mi.length()!=1 && !mi.equals("")){
            JOptionPane.showMessageDialog(null, "mi should be M or F!");}
      
        if(state.length()!=2 && !state.equals("")){
            JOptionPane.showMessageDialog(null, "State should be only 2 Characters!");}
      
        if(telephone.length()!=10 && !telephone.equals("")){
            JOptionPane.showMessageDialog(null, "TelPhone No should be 10 digits!");}
        
        if(!isValidEmailid(email, email)) {
        	JOptionPane.showMessageDialog(null,"Invalid Email Id");
        }
       //Update statement on database
        OracleDatabase.Update(id, lname, fname, mi, address, city, state, telephone, email);
    }
    
    //*******************************************************************************************************************
    private void CreatebtnClear() {
        // Initializing component
        btnClear = new JButton("Clear");
        // When you click on the button, program perform some event
        // We need to implement Action Listener and use of inner class
        class ClearListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear();
            }
        }
        // Creating listener object
        ActionListener listener = new ClearListener();
        // Register object of Action Listener with a source(field)
        btnClear.addActionListener(listener);
    }

    //empty all the fields
    //Clear() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void Clear(){
        tfID.setText("");
        tfLastName.setText("");
        tfFirstName.setText("");
        tfMI.setText("");
        tfAddress.setText("");
        tfCity.setText("");
        tfState.setText("");
        tfTelPhone.setText("");
        tfEmail.setText("");
    }
    //*********************************************************************************************************
    
    //Method for validating email id
    private boolean isValidEmailid(String str, String regexPattern) {
    	
        regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if(str.matches(regexPattern)) {
		return true;
        }
        else {
        return false;
        }  
	}
}


