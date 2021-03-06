/*
 * userdata.java
 *
 * Created on August 19, 2006, 9:28 PM
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
import java.util.*;
import java.io.*;

public class NewBook extends javax.swing.JFrame {
    
    /** Creates new form userdata */
    public NewBook() {
	
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">
    private void initComponents() {
        book_no = new javax.swing.JLabel();
        book_name = new javax.swing.JLabel();
        auther_name = new javax.swing.JLabel();
        subject_name = new javax.swing.JLabel();
        about_book = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bookno = new javax.swing.JTextField();
        bookname = new javax.swing.JTextField();
        auther = new javax.swing.JTextField();
        subject = new javax.swing.JTextField();
        aboutbook = new javax.swing.JTextField();
        addbook = new javax.swing.JButton();
        finish = new javax.swing.JButton();

        getContentPane().setLayout(null);

       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEW BOOK");
        setFont(new java.awt.Font("Arial", 1, 14));
        book_no.setFont(new java.awt.Font("Tahoma", 1, 14));
        book_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        book_no.setText("BOOK Id No:");
        book_no.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(book_no);
        book_no.setBounds(80, 70, 150, 30);

        book_name.setFont(new java.awt.Font("Tahoma", 1, 14));
        book_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        book_name.setText("BOOK NAME");
        book_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(book_name);
        book_name.setBounds(80, 110, 150, 30);

        auther_name.setFont(new java.awt.Font("Tahoma", 1, 14));
        auther_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        auther_name.setText("AUTHER");
        auther_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(auther_name);
        auther_name.setBounds(80, 160, 150, 30);

        subject_name.setFont(new java.awt.Font("Tahoma", 1, 14));
        subject_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subject_name.setText("SUB/CATEGORY");
        subject_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(subject_name);
        subject_name.setBounds(80, 210, 150, 30);

        about_book.setFont(new java.awt.Font("Tahoma", 1, 14));
        about_book.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_book.setText("ABOUT THE BOOK");
        about_book.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(about_book);
      //  about_book.setBounds(30, 260, 160, 25);

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ADD THE BOOK'S DETAILS");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 30, 420, 20);

        bookno.setFont(new java.awt.Font("Tahoma", 1, 14));
        getContentPane().add(bookno);
        bookno.setBounds(270, 70, 160, 30);

        bookname.setFont(new java.awt.Font("Tahoma", 1, 14));
        getContentPane().add(bookname);
        bookname.setBounds(270, 110, 160, 30);

        auther.setFont(new java.awt.Font("Tahoma", 1, 14));
        getContentPane().add(auther);
        auther.setBounds(270, 160, 160, 30);

        subject.setFont(new java.awt.Font("Tahoma", 1, 14));
        getContentPane().add(subject);
        subject.setBounds(270, 210, 160, 30);

        aboutbook.setFont(new java.awt.Font("Tahoma", 1, 14));
        getContentPane().add(aboutbook);
       // aboutbook.setBounds(210, 260, 400, 25);

        addbook.setFont(new java.awt.Font("Tahoma", 1, 14));
        addbook.setText("ADD BOOK");
		addbook.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
			if( bookno.getText().equals(""))
					{
					JOptionPane.showMessageDialog((Component) null, "Plese Enter \n the book detail ", "Login Error", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
					 addbooks();
					
					}
				   
	
            }
        });
        getContentPane().add(addbook);
        addbook.setBounds(490, 70, 110, 40);

        finish.setFont(new java.awt.Font("Tahoma", 1, 14));
        finish.setText("FINISH");
		finish.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
				    setVisible(false);
					//AdminPage app=new AdminPage();
	
            }
        });
        getContentPane().add(finish);
        finish.setBounds(490, 130, 110, 40);

        pack();
		setSize(630,335);
		setVisible(true);
		setLocation(200,200);
    }// </editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        NewBook nb=new NewBook();
    }
    
    // Variables declaration - do not modify
    private javax.swing.JLabel about_book;
    private javax.swing.JTextField aboutbook;
    private javax.swing.JButton addbook;
    private javax.swing.JTextField auther;
    private javax.swing.JLabel auther_name;
    private javax.swing.JLabel book_name;
    private javax.swing.JLabel book_no;
    private javax.swing.JTextField bookname;
    private javax.swing.JTextField bookno;
    private javax.swing.JButton finish;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField subject;
    private javax.swing.JLabel subject_name;
    // End of variables declaration
    
	
	void addbooks()
		{
				Connection con=null;
				String url="jdbc:odbc:BITSLibrary";
				Statement st=null;
				
			  try
			  {
					
					String bk_no =bookno.getText();
					bk_no =  bk_no.trim();
					
					String bk_name=bookname.getText();
					bk_no=bk_no.trim();
					
					String sub=subject.getText();
					sub=sub.trim();
					
					String at=auther.getText();
					at=at.trim();
					
					String det=aboutbook.getText();
					det=det.trim();
				
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					
			   		con=DriverManager.getConnection(url);
					
			   		st = con.createStatement();
					cdate dd=new cdate();
	          System.out.println(cdate.todaydatee.toString());
	System.out.println(bk_no);
	String qq="Insert into bk values ('"+bk_no+"','"+bk_name+"','"+at+"','"+sub+"','na',0,'na',0,'na','na','na')";
	//String qq="Insert into books values ('"+bk_no+"','"+bk_name+"','"+sub+"','"+at+"','"+det+"')";
	//String qqq="Insert into bookcopy values ('"+bk_no+"','free','user','"+cdate.todaydatee.toString()+"','"+cdate.returndate.toString()+"')";
				int ii=st.executeUpdate(qq);
				//int iii=st.executeUpdate(qqq);
				
				if(ii>0)
				{
					bookno.setText("");
					bookname.setText("");
					subject.setText("");
					auther.setText("");
					aboutbook.setText("");
					JOptionPane.showMessageDialog((Component) null, "books added", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			    }
					else
					{
					
				JOptionPane.showMessageDialog((Component) null, "SORRY try again", "Error", JOptionPane.INFORMATION_MESSAGE);
						
					}
					//rs.close();
						st.close();
						con.close();			
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
