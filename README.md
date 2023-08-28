## Staff Information Management Java GUI Program

This Java GUI program manages staff information using a database. The program allows for viewing, inserting, and updating staff records. It utilizes a MySQL database and consists of four main files: `StaffGUI.java`, `OracleDatabase.java`, `DatabaseInfo.java`, and `Main.java`.

### Files and Functionality

1. **StaffGUI.java**:
   - Handles GUI design using labels, text fields, and buttons.
   - Implements validation for input fields (email, telephone, state, etc.).
   - Provides methods for button functionality (insert, view, update).

2. **OracleDatabase.java**:
   - Establishes a connection between Java and MySQL.
   - Performs SQL queries for various operations.
   - Ensures uniqueness of IDs and validates user inputs.
   
3. **DatabaseInfo.java**:
   - Contains information required to establish a database connection.

4. **Main.java**:
   - Contains the main class for the program.

### GUI Design

The GUI is designed using a grid layout and features three panels to organize components effectively. The GUI includes labels, text fields, and buttons for various actions such as insertion, viewing, and updating.

### Database Connection and Validation

1. Establishes a connection with the MySQL database.
2. Validates user input for uniqueness of IDs and valid email addresses.
3. Implements pattern matching for email and telephone number formats.
4. Validates state field inputs based on specific criteria.

### Functionality Highlights

- **Insertion**: Checks for unique IDs and inserts data into the database.
- **Viewing**: Fetches staff information based on a provided ID and displays it.
- **Updating**: Updates staff information with user-modified data.
- **Validation**: Ensures data integrity by validating fields before performing actions.
- **Error Handling**: Provides descriptive error messages for invalid inputs.

### Usage

1. Run `Main.java` to launch the program.
2. Use the GUI to perform actions like insertion, viewing, and updating staff records.
3. Ensure proper data validation for fields such as email, telephone, and state.

### Notes

- Be cautious when updating or deleting records, as these actions may modify the database irreversibly.
- Remember that database security and validation are critical to maintaining data integrity.

### Conclusion

This Java GUI program effectively manages staff information using a MySQL database. It offers user-friendly functionality for inserting, viewing, and updating records while incorporating essential data validation and database connection features.
