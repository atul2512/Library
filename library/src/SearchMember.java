import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class SearchMember extends JFrame implements ActionListener {

	private JPanel pBook = new JPanel ();
	private JLabel lbSearch;
	private JRadioButton rb1,rb2;
	private JTextField txtSearch;
	private JButton btnFind, btnCancel;
	private int flag=0,rows=0;
	private Statement st;
	private String mname,mcat,search,mid;
	private JTable table;
	private Object data1[][];
	private Container c;
	private int bcnt;
	public SearchMember () {

		//super (Title, Resizable, Closable, Maximizable, Iconifiable)
		super ("Search Members");
		
		//Setting the Form's Labels.

		lbSearch = new JLabel ("Search Field");
		lbSearch.setForeground (Color.black);
		lbSearch.setBounds (15, 15, 100, 20);
		
		txtSearch = new JTextField ();
		txtSearch.setBounds (120, 15, 175, 25);
		
		
		btnFind = new JButton ("Find Member");
		btnFind.setBounds (25, 175, 125, 25);
		btnFind.addActionListener (this);
		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (165, 175, 125, 25);
		btnCancel.addActionListener (this);
		
		rb1=new JRadioButton("By Id");
		rb1.addActionListener(this);
		rb1.setBounds (15, 45, 100, 20);
		rb2=new JRadioButton("By Name");
		rb2.addActionListener(this);
		rb2.setBounds (15, 75, 100, 20);
		
		
		pBook.setLayout (null);
		pBook.add(lbSearch);
		pBook.add(txtSearch);
		pBook.add(btnFind);
		pBook.add(btnCancel);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		pBook.add(rb1);
		pBook.add(rb2);
		
		rb1.setSelected(true);
		getContentPane().add (pBook, BorderLayout.CENTER);

			
		}
	
	public void actionPerformed (ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj == btnFind) {		//If Find Button Pressed.

			if (txtSearch.getText().equals ("")) {
				JOptionPane.showMessageDialog (this, "Search Field not Provided.");
				txtSearch.requestFocus ();
			}
			else 
			{
				
				String mname1,id;
				int num,catid,bcnt1;
				
					boolean found = false;
				
				try {
			Connection con=null;	
				String url="jdbc:odbc:BITSLibrary";
				Statement st=null;
		
		try {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				    con=DriverManager.getConnection(url);
				st = con.createStatement();
				 
			      
			
				ResultSet rs;
			//}catch(Exception e){e.printStackTrace();}
					String bavl,text,tts;
					num=st.executeUpdate("Delete * from memsearch");
					System.out.println("mukesh");
					if(flag==0)
					{
						id=txtSearch.getText();
						System.out.println(id);
						rs=st.executeQuery("Select * from userdata where useridno="+id+"");
						rs.next();
						bavl=rs.getString("username");
						//catid=rs.getInt(7);
						//bcnt=rs.getInt(5);
						System.out.println(bavl);
					//	rs1=st.executeQuery("Select * from MeCat where Mcat="+catid+"");
					//	rs1.next();
					//	mcat=rs1.getString("CName");
						//bcnt1=rs1.getInt("Blmt");
						//rs3=st.executeQuery("Select * from Books where Mid="+id+"");
						//text="Name: "+bavl+"\n Category: "+mcat+"\n Books Held: "+bcnt+"\n Book Limit: "+bcnt1+"\n";
						//text+="Books Held:\n";
					/*	while(rs3.next())
						{
							tts=rs3.getString(2);
							text+=tts+"\n";
						}
						JOptionPane.showMessageDialog(this,text);
						txtSearch.setText("");
						txtSearch.requestFocus();*/
					}
					else
					{
					
					search=txtSearch.getText();
					search=search.toLowerCase();
					rs=st.executeQuery("Select * from userdata");
					while(rs.next())
					{
						
						mname=rs.getString(2);
						mid=rs.getString(1);
						//bcnt=rs.getInt(5);
						//catid=rs.getInt(7);
						if(flag==1)
						{
							mname1=mname.toLowerCase();
							if(mname1.equals(search)||(mname1.indexOf(search)!=-1))
							{
								//rs1=st.executeQuery("Select * from MeCat where Mcat="+catid+"");
								//rs1.next();
								//mcat=rs1.getString("CName");
								//bcnt1=rs1.getInt("Blmt");
								num=st.executeUpdate("insert into memsearch values("+mid+", '"+mname+"' )");
								rows++;
								found=true;
							}
						}
												
						}
					}
				}
				catch (Exception e){
				e.printStackTrace();
				//catch(SQLException sqlex) {
					if (found == false) {
						//JOptionPane.showMessageDialog (this, "Record not Found.");
					}
				}
				if(flag==1){
				try{
					data1=new Object[rows][2];
					
					Object[] Colheads={"Member Id","Name"};
					ResultSet rs2=st.executeQuery("Select * from memsearch");
				
					for(int i1=0;i1<rows;i1++)
					{
							rs2.next();
							for(int j1=0;j1<2;j1++)
							{
								data1[i1][j1]=rs2.getString(j1+1);
							}
					}
					table=new JTable(data1,Colheads);
					TableDisp td=new TableDisp(table);
					txtSearch.setText("");
					txtSearch.requestFocus();
				
					
					}
					catch(Exception e) {
					e.printStackTrace();
						if (found == false) {
							JOptionPane.showMessageDialog (this, "Some prob Found.");
						}
					}
				}
				
			}

		}		

		if (obj == btnCancel) {		//If Cancel Button Pressed Unload the From.

			setVisible (false);
			dispose();

		}
		
		if(obj==rb1)
		{
			flag=0;
		}
		if(obj==rb2)
		{
			flag=1;
		}
		
	}
	public static void main(String[] args){
	
	SearchMember sbb=new SearchMember();
	
	sbb.setSize(400,400);
	sbb.setVisible (true);	
	sbb.setLocation(200,200);
	
	
	}	
		
}
	
