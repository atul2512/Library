/*
 * FirstPage.java
 *
 * Created on August 17, 2006, 5:44 PM
 */

/**
 *
 * @author  mukesh
 */
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.*;
public class FirstPage1 extends javax.swing.JFrame {
    
    /** Creates new form FirstPage1 */
    public FirstPage1() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton(new ImageIcon("logo.gif"));

        getContentPane().setLayout(null);
		setForeground(new java.awt.Color(0, 153, 204));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WELCOME");
       
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CENTERAL LIBRARY ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 180, 500, 110);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 36));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELCOME TO THE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 130, 430, 70);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 48));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BITS PILANI");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 250, 410, 110);

        
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 10, 87, 99);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButton1.setForeground(new java.awt.Color(102, 102, 0));
        jButton1.setText("ENTER");
		jButton1.addActionListener(new ActionListener(){
  			public void actionPerformed(ActionEvent evt)
			{
				    setVisible(false);
					LogPage lpp=new LogPage();
	
            }
        });
		
		
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 400, 210, 50);

        pack();
		setSize(800,600);
		setLocation(50,50);
		
		setVisible(true);
		
		
    }// </editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FirstPage1 fpp=new FirstPage1();
				
            }
        });
    }
    
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
	private javax.swing.JButton jButton2;
    // End of variables declaration
    
}




































































































































