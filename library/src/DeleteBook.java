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
public class DeleteBook extends javax.swing.JFrame {
    
    /** Creates new form NewAccount */
    public DeleteBook() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bookno = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        finish = new javax.swing.JButton();

        getContentPane().setLayout(null);

       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DETAIL OF NEW USER");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("BOOK No:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 70, 150, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DELETE BOOK");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 20, 300, 20);

        bookno.setFont(new java.awt.Font("Tahoma", 0, 14));
        getContentPane().add(bookno);
        bookno.setBounds(250, 70, 140, 20);

        update.setText("DELETE");
        update.setToolTipText("cklick to delete book");
		update.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
				   if(bookno.getText().equals(""))
					{
					JOptionPane.showMessageDialog((Component) null, "Plese Enter \n the account no ", "Login Error", JOptionPane.ERROR_MESSAGE);
					}
					else{
					 delbookdetails();
					
					}
	
	
            }
        });
        getContentPane().add(update);
        update.setBounds(200, 120, 80, 30);

        finish.setText("FINISH");
        finish.setToolTipText("click to return");
		finish.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
				    setVisible(false);
					//AdminPage app=new AdminPage();
	
            }
        });
        getContentPane().add(finish);
        finish.setBounds(310, 120, 80, 30);

        pack();
		setSize(500,225);
		setVisible(true);
		setLocation(200,200);
    }// </editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        DeleteBook db=new DeleteBook();
    }
    
    // Variables declaration - do not modify
    private javax.swing.JTextField bookno;
    private javax.swing.JButton finish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton update;
    // End of variables declaration
	
	void delbookdetails()
		{
				Connection con=null;
				String url="jdbc:odbc:NitLibrary";
				Statement st=null;
				
			  try
			  {
					
					String delbok =  bookno.getText();
						   delbok =  delbok.trim();
				
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					
			   		con=DriverManager.getConnection(url);
					
			   		st = con.createStatement();
					
	
				int ii=st.executeUpdate("delete * From books Where bokno='"+delbok+"'");
				
				
				if(ii>0)
				{
					bookno.setText("");
					JOptionPane.showMessageDialog((Component) null, "THE booK \n"+delbok+" \nDELETED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			    }
					else
					{
					bookno.setText("");
				JOptionPane.showMessageDialog((Component) null, "THE Book DOESn't exist", "Error", JOptionPane.INFORMATION_MESSAGE);
						
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
			  finally{
			  con=null;
			  }
		}

    
}
