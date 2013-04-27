import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class ListMembers extends JFrame{

	private JPanel pBook = new JPanel ();
	private JTable table;
	private JScrollPane jsp;
	private Object data1[][];
	private Container c;
	private JButton ok;
	int row=0;
	public ListMembers() {

		//super (Title, Resizable, Closable, Maximizable, Iconifiable)
		pBook.setLayout (null);
		ok = new JButton ("ok");
		ok.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
					listmem();
					}
					
        });
		ok.setBounds (25, 175, 125, 25);
		pBook.add(ok);
	
		getContentPane().add (pBook, BorderLayout.CENTER);
		setSize(400,400);
	setVisible (true);	
	setLocation(200,200);
	
	
		
		}
		
		
		public void listmem(){
		
		
				Connection con=null;
				String url="jdbc:odbc:BITSLibrary";
				Statement st=null;
				try {	
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			      con=DriverManager.getConnection(url);
				st = con.createStatement();
				
					String q,bavl,bisr;
					
					
		ResultSet rss=st.executeQuery("SELECT * FROM userdata ");
		while(rss.next()){
		row++;
		}
			System.out.println(row);	
				
				data1=new Object[row][7];
				System.out.println("hai");
				Object[] Colheads={"useridno","username","gender","department","course","semester","NO_BOOK_TAKEN"};
			ResultSet rs = st.executeQuery ("SELECT * FROM userdata ");	//Executing the Query.
			
				for(int i1=0;i1<row;i1++)
				{
						rs.next();
						for(int j1=0;j1<7;j1++)
						{
						
							data1[i1][j1]=rs.getString(j1+1);
							
						}
						System.out.println();
						
				}
				table=new JTable(data1,Colheads);
				int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
				int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
				
				jsp=new JScrollPane(table,v,h);
				TableDisp td=new TableDisp(table);
			
				
				}
				catch(Exception sqlex) {
					
					//	JOptionPane.showMessageDialog (this, "Some prob Found.");
				
				}
			
			

		}		
		
	
	
	public static void main(String[] args){
	
	ListMembers lmm=new ListMembers();
	
	
	}	
}

