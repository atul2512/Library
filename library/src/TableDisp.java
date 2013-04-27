import java.awt.*;


import javax.swing.*;



public class TableDisp extends JFrame {

	private JPanel pBook = new JPanel ();
	private JScrollPane scroller;
	private JTable table;
	public TableDisp(JTable j)
	{
	super("Table Display");
	//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		setSize(700,300);
		setLocation(100,300);
		pBook.setLayout (null);
		table=j;
		scroller = new JScrollPane (table);	//Adding Table to ScrollPane.
		scroller.setBounds (20, 50, 460, 200);	//Aligning ScrollPane.
		pBook.add(scroller);
		getContentPane().add (pBook, BorderLayout.CENTER);
		setVisible(true);
	}
	
}