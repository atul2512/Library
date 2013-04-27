/*
 * MemberPage.java
 *
 * Created on September 6, 2006, 12:01 AM
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
public class issue extends javax.swing.JFrame {
    
    /** Creates new form MemberPage */
    public issue() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">
    private void initComponents() {
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ISSUE = new javax.swing.JButton();
        FINISH = new javax.swing.JButton();
        USERID = new javax.swing.JTextField();
        BOOKNO = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ISSUE BOOK");
        setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("MEMBERS ID NO :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 60, 160, 30);

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("BOOK ID NO :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 100, 180, 30);

        ISSUE.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        ISSUE.setText("ISSUE");
		ISSUE.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
		issuebook();
            }
        });
        ISSUE.setToolTipText("C LIC TO LOG OUT");
        getContentPane().add(ISSUE);
        ISSUE.setBounds(450, 60, 90, 30);

        FINISH.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        FINISH.setText("FINISH");
		FINISH.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
				    setVisible(false);
			}
        });
        FINISH.setToolTipText("CLICK TO LOG OUT");
        getContentPane().add(FINISH);
        FINISH.setBounds(450, 100, 90, 30);

        USERID.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16));
        getContentPane().add(USERID);
        USERID.setBounds(240, 60, 140, 30);

        BOOKNO.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16));
        getContentPane().add(BOOKNO);
        BOOKNO.setBounds(240, 100, 140, 30);

        pack();
		setSize(600,225);
		setVisible(true);
		setLocation(200,200);
    }// </editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       issue iu=new issue();
    }
    
    // Variables declaration - do not modify
    private javax.swing.JTextField BOOKNO;
    private javax.swing.JButton FINISH;
    private javax.swing.JButton ISSUE;
    private javax.swing.JTextField USERID;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
	int count=0;
	int jj,jjj;
	int ii,iii;	
int da,mont,year;
String todate;
int da1,mont1,year1;
String redate;	
int pp,ppp;	
    // End of variables declaration
	
	public void issuebook(){
	{
				Connection con=null;
				String url="jdbc:odbc:BITSLibrary";
				Statement st=null;
				
			  try
			  {
					
					String issbook =  BOOKNO.getText();
						   issbook =  issbook.trim();
					String userroll=  USERID.getText();
						   userroll=  userroll.trim();
				
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					
			   		con=DriverManager.getConnection(url);
					
			   		st = con.createStatement();
		GregorianCalendar g=new GregorianCalendar();
        int da=g.get(Calendar.DAY_OF_MONTH);
			int mont=g.get(Calendar.MONTH);
				int year=g.get(Calendar.YEAR);
				todate=da+"-"+mont+"-"+year;
				System.out.println(todate);
				
			g.add(Calendar.DAY_OF_MONTH,21);
        int da1=g.get(Calendar.DAY_OF_MONTH);
			int mont1=g.get(Calendar.MONTH);
				int year1=g.get(Calendar.YEAR);
				redate=da1+"-"+mont1+"-"+year1;
				System.out.println(redate);
				
		ResultSet ss=st.executeQuery("Select Statuss from bk where bookid= '"+issbook+"'");
				while(ss.next()){
				jjj=ss.getInt(1);
				System.out.println(jjj);
				}	
if(jjj==1)
{
JOptionPane.showMessageDialog((Component) null, "THE BOOK HAS BEEN ISSUED", "Error", JOptionPane.ERROR_MESSAGE);
}	
else{			
			
		ResultSet rsss=st.executeQuery("Select noofbookstaken from userdata where useridno= '"+userroll+"'");
				while(rsss.next()){
				jj=rsss.getInt(1);
				}	
					System.out.println(jj);
			
	if(jj>3){
	JOptionPane.showMessageDialog((Component) null, "You have already taken Four books", "Error", JOptionPane.INFORMATION_MESSAGE);
	}
	else{
	ii=st.executeUpdate("UPDATE bk SET bissueto='"+userroll+"' where bookid='"+issbook+"'");
	iii=st.executeUpdate("UPDATE bk SET Statuss='1' where bookid='"+issbook+"'");
	pp=st.executeUpdate("UPDATE bk SET issueddate='"+todate+"' where bookid='"+issbook+"'");
	ppp=st.executeUpdate("UPDATE bk SET returndate='"+redate+"' where bookid='"+issbook+"'");
	if(ii>0)
				{
				jj++;
	//System.out.println(jj);
	int kk=st.executeUpdate("UPDATE userdata SET noofbookstaken = '"+jj+"' where useridno='"+userroll+"'");
					BOOKNO.setText("");
					USERID.setText("");
					JOptionPane.showMessageDialog((Component) null, "THE booK \n"+issbook+" \nissued to \n"+userroll+"", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
			    }
					else
					{
					//BOOKNO.setText("");
				JOptionPane.showMessageDialog((Component) null, "You have already taken Four books", "Error", JOptionPane.INFORMATION_MESSAGE);
						
					}
	}
	}
	//JOptionPane.showMessageDialog((Component) null, "THE booK \n"+issbook+" \nissued to \n"+userroll+"", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
	

	
				
				
					
					
				
					
					
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
}
