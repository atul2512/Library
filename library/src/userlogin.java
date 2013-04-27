/*
 * NewAccount.java
 *
 * Created on August 22, 2006, 10:55 PM
 */

/**
 *
 * @author  mukesh
 */
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
public class userlogin extends javax.swing.JFrame {

public static String student;
    
    /** Creates new form NewAccount */
    public userlogin() {
        initComponents();
    }
    
   
    
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        update = new javax.swing.JButton();
        finish = new javax.swing.JButton();

        getContentPane().setLayout(null);

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USER log");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("USER Id:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 60, 120, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("PASSWORD:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 120, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("USER LOGIN");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 20, 300, 20);

        userid.setFont(new java.awt.Font("Tahoma", 0, 14));
        getContentPane().add(userid);
        userid.setBounds(170, 60, 130, 20);

        password.setFont(new java.awt.Font("Tahoma", 0, 14));
        getContentPane().add(password);
        password.setBounds(170, 90, 130, 20);

        update.setText("LOGIN");
        update.setToolTipText("CLICK TO LOGIN");
		update.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
				    if( userid.getText().equals(""))
					{
					JOptionPane.showMessageDialog((Component) null, "Plese Enter \n login and password ", "Login Error", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
					//setVisible(false);
					//AdminPage ap=new AdminPage();
					verifyAdmLogin();
					
					}
					
					}
        });
        getContentPane().add(update);
        update.setBounds(340, 60, 80, 30);

        finish.setText("EXIT");
        finish.setToolTipText("CLICK TO EXIT");
		finish.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
				    setVisible(false);
					LogPage llp=new LogPage();
					}
        });
        getContentPane().add(finish);
        finish.setBounds(340, 100, 80, 30);

        pack();
		setSize(500,200);
		setVisible(true);
		setLocation(200,200);
    }// </editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        userlogin ad=new userlogin();
    }
    
    // Variables declaration - do not modify
    private javax.swing.JButton finish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton update;
    private javax.swing.JTextField userid;
    // End of variables declaration
    
	void verifyAdmLogin() 
		{
				Connection con=null;
				String url="jdbc:odbc:BITSLibrary";
				Statement st=null;
				
			  try
			  {
					
						 student=userid.getText();
						 student=student.trim();
					String val2 =  (String)password.getText();
						   val2 =  val2.trim();
					
					
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					
			   		con=DriverManager.getConnection(url);
					
			   		st = con.createStatement();
					
	
				ResultSet rs=st.executeQuery("Select Passwd from usernpasswd where UserId='"+student+"'");
				//ResultSetMetaData rmeta = rs.getMetaData();
				//Retrieving the Metadata from the resultset
				//int nCols = 0;
  				//nCols=rmeta.getColumnCount();
				//System.out.println(nCols);
				
				while(rs.next()){
					String user = rs.getString(1);
					System.out.println(user);
					
					boolean b=user.equals(val2);
					
				
				
					if(b)
					{
					setVisible(false);
					//UserPage aaa=new UserPage();
					MemberPage mp=new MemberPage();
					}
					 else
					{
					
						
						
						
						JOptionPane.showMessageDialog((Component) null, "Invalid Login name/password. Please enter again. ", "Login Error", JOptionPane.INFORMATION_MESSAGE);
						//setVisible(false);
						//userlogin ul=new userlogin();
					
						
					}
					
					}
				
					
					
			  }
			  catch(SQLException ex)
			   {
			    System.out.println("Unable to access the database");
			   }
			  catch(ClassNotFoundException ex)
			   {
			    System.out.println("Class not found");
			   }
			  catch(Exception ex)
			  {
               System.out.println("Exception raised is:"+ex);
			  }
			  
		}
		
	
}
