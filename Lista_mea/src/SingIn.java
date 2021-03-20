import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SingIn extends JFrame {

	public static char[] email1;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	java.sql.Connection conni  =null;
	java.sql.Connection connec =null;
	static int i ;
	boolean tr = true;
	static int current;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingIn frame = new SingIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SingIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SingIn.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(true);
		setBounds(100, 100, 632, 675);
		//setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreareCont = new JButton("CREARE CONT");
		btnCreareCont.setBounds(130, 526, 355, 65);
	//	button.setBackground(new Color(224, 255, 255));
	//	button.setBackground(SystemColor.controlHighlight);
		btnCreareCont.setForeground(SystemColor.textHighlight);
		btnCreareCont.setFont(new Font("Engravers MT", Font.PLAIN, 20));
		
		contentPane.add(btnCreareCont);
		
		
		textField = new JTextField();
		textField.setBounds(44, 63, 511, 59);
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(224, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 151, 511, 2);
		
		JLabel lblNewLabel = new JLabel("Nume Utilizator");
		lblNewLabel.setBounds(44, 15, 279, 37);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Engravers MT", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		contentPane.add(separator);
		contentPane.add(btnCreareCont);
		
		JLabel lblParola = new JLabel("Email");
		lblParola.setBounds(44, 173, 156, 48);
		lblParola.setForeground(SystemColor.textHighlight);
		lblParola.setFont(new Font("Engravers MT", Font.PLAIN, 17));
		lblParola.setBackground(SystemColor.activeCaption);
		contentPane.add(lblParola);
		
		textField_1 = new JTextField();
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField_1.setBounds(44, 225, 511, 59);
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(224, 255, 255));
		contentPane.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(44, 316, 511, 2);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("Parola");
		label.setBounds(44, 346, 156, 48);
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Engravers MT", Font.PLAIN, 17));
		label.setBackground(SystemColor.activeCaption);
		contentPane.add(label);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(44, 404, 511, 53);
		textField_2.setForeground(new Color(0, 0, 0));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(224, 255, 255));
		contentPane.add(textField_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(44, 489, 511, 2);
		contentPane.add(separator_2);
		
		JButton btnNewButton = new JButton("Inapoi");
		btnNewButton.setBounds(517, 607, 85, 21);
		btnNewButton.setForeground(SystemColor.textHighlight);
		//btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		contentPane.add(btnNewButton);
		
		String LOGIN = new String("CREATE TABLE IF NOT EXISTS "
				+ "LOG ( EMAIL VARCHAR(100) NOT NULL, \r\n" + 
				"PAROLA VARCHAR(100) NOT NULL, \r\n PRIMARY KEY(EMAIL));");
		String SING = new String("CREATE TABLE IF NOT EXISTS "
				+ "SING2 (USER VARCHAR(100) NOT NULL UNIQUE, \r\n"+
				" EMAIL VARCHAR(100) NOT NULL, \r\n"+
				"  PAROLA VARCHAR(100) NOT NULL, \r\n"+
				" NR BIGINT AUTO_INCREMENT, \r\n PRIMARY KEY(EMAIL));");
		
		try {
			java.sql.Connection conn =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			Statement s1 = conn.createStatement();
			s1.executeUpdate(LOGIN);
			s1.executeUpdate(SING);
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		try {
			Class.forName("org.h2.Driver").newInstance();
			java.sql.Connection conn1 =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			
			Statement s = conn1.createStatement();
			ResultSet ss = s.executeQuery("SELECT MAX(NR) FROM SING2");
			while(ss.next()) {
				i = ss.getInt(1);
				i++;
				System.out.println("i = "+i);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		btnCreareCont.addActionListener(new ActionListener() 
		{
			
		    public void actionPerformed(ActionEvent e) {
		    	
		    	java.sql.Connection conni = null  ;
		    	Connection conn2;
				String email= textField_1.getText();
				String parola = textField_2.getText();
				String user = textField.getText();
				
    			
				
				while(tr == true) {
		    	try {
		    			Class.forName("org.h2.Driver").newInstance();
		    			conn2 =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		    			
		    			if(email!="" && parola!="" && user!="") {
		    			//s.executeUpdate(SING);
		    			conni = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		    			// Prepared Statement pentru inserare
		    			PreparedStatement st = ((java.sql.Connection) conni).prepareStatement("INSERT INTO SING2  VALUES (?,?,?,?)");
		    			PreparedStatement st1 = ((java.sql.Connection) conni).prepareStatement("INSERT INTO LOG  VALUES (?,?)");
		    			st.setString(1, user);
		    			st.setString(2,  email);
		    			st.setString(3, parola);
		    			st.setInt(4, i);
		    			
		    			st1.setString(1, email);
		    			st1.setString(2, parola);
		    			
		    			current = i;
		    			
		    			st.executeUpdate();
		    			st1.executeUpdate();
		    			tr =false; 
		    			
		    			System.out.println("cont adaugat!");
		    			dispose();
				        new Principal().setVisible(true);
				        JOptionPane.showMessageDialog(null, "Cont adaugat");}
		    			else
		    				JOptionPane.showMessageDialog(null, "Nu s-a adaugat contul");
		    			
		    		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
		    			System.out.println("nu s-a adaugat contul");
		    			e1.printStackTrace();
		    			 JOptionPane.showMessageDialog(null, "Nu s-a adaugat contul");
		    			 new LogIn().setVisible(true);
		    		}}
		    	
				// verifica unicitatea username - sa nu fie mai multi utilzatori cu acelasi nume, desi username nu e cheie primara
				try {
					Class.forName("org.h2.Driver").newInstance();
	    			connec =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					// Prepared Statement pentru inserare
					PreparedStatement st = connec.prepareStatement("SELECT USER FROM SING WHERE USER = ?");
					st.setString(1, user);
					ResultSet rez = st.executeQuery();
				
						
					
				} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e2) {
					System.out.println("nu s-a adaugat contul");
					e2.printStackTrace();
				
				}
		}
		    
		});	
		
		btnNewButton.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //setVisible(false);
		    	dispose();
		        new Principal().setVisible(true); // Main Form to show after the Login Form..
		    }
		});	
	}
	
	/*public String getUSER() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver").newInstance();
		Connection conn2 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		String s = "SELECT USER FROM SING WHERE EMAIL = ";
		return s;
		
	}*/
}
