package CamadaNegocios;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TableDisplay extends JFrame {
   private Connection connection;
   private JTable table;

   public TableDisplay()
   {
      // The URL specifying the Books database to which
      // this program connects using JDBC to connect to a
      // Microsoft ODBC database.
      String url = "jdbc:odbc:Books";
      String username = "anonymous";
      String password = "guest";

      // Load the driver to allow connection to the database
      try {
	 Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );

	 connection = DriverManager.getConnection(
	    url, username, password );
      }
      catch ( ClassNotFoundException cnfex ) {
	 System.err.println(
	    "Failed to load JDBC/ODBC driver." );
	 cnfex.printStackTrace();
	 System.exit( 1 );  // terminate program
      }
      catch ( SQLException sqlex ) {
	 System.err.println( "Unable to connect" );
	 sqlex.printStackTrace();
      }

      getTable();

      setSize( 450, 150 );
      show();
   }

   private void getTable()
   {
      Statement statement;
      ResultSet resultSet;

      try {
	 String query = "SELECT * FROM Authors";

	 statement = connection.createStatement();
	 resultSet = statement.executeQuery( query );
	 displayResultSet( resultSet );
	 statement.close();
      }
      catch ( SQLException sqlex ) {
	 sqlex.printStackTrace();
      }
   }

   private void displayResultSet( ResultSet rs )
      throws SQLException
   {
      // position to first record
      boolean moreRecords = rs.next();

      // If there are no records, display a message
      if ( ! moreRecords ) {
	 JOptionPane.showMessageDialog( this,
	    "ResultSet contained no records" );
	 setTitle( "No records to display" );
	 return;
      }

      setTitle( "Authors table from Books" );

      Vector columnHeads = new Vector();
      Vector rows = new Vector();

      try {
	 // get column heads
	 ResultSetMetaData rsmd = rs.getMetaData();

	 for ( int i = 1; i <= rsmd.getColumnCount(); ++i )
	    columnHeads.addElement( rsmd.getColumnName( i ) );

	 // get row data
	 do {
	    rows.addElement( getNextRow( rs, rsmd ) );
	 } while ( rs.next() );

	 // display table with ResultSet contents
	 table = new JTable( rows, columnHeads );
      }
      catch ( SQLException sqlex ) {
	 sqlex.printStackTrace();
      }
   }

   private Vector getNextRow( ResultSet rs,
			      ResultSetMetaData rsmd )
       throws SQLException
   {
      Vector currentRow = new Vector();

      for ( int i = 1; i <= rsmd.getColumnCount(); ++i )
	 switch( rsmd.getColumnType( i ) ) {
	    case Types.VARCHAR:
		  currentRow.addElement( rs.getString( i ) );
	       break;
	    case Types.INTEGER:
		  currentRow.addElement(
		     new Long( rs.getLong( i ) ) );
	       break;
	    default:
	       System.out.println( "Type was: " +
		  rsmd.getColumnTypeName( i ) );
	 }

      return currentRow;
   }

   public void shutDown()
   {
      try {
	 connection.close();
      }
      catch ( SQLException sqlex ) {
	 System.err.println( "Unable to disconnect" );
	 sqlex.printStackTrace();
      }
   }

   public static void main( String args[] )
   {
      final TableDisplay app = new TableDisplay();

      app.addWindowListener(
	 new WindowAdapter() {
	    public void windowClosing( WindowEvent e )
	    {
	       app.shutDown();
	       System.exit( 0 );
	    }
	 }
      );
   }
}

/**************************************************************************
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
