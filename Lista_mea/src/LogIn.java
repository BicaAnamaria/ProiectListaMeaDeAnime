import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;



import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.JButton;
import java.sql.*;
import java.awt.Toolkit;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblParola;
	private JButton button = new JButton("Autentificare");
	java.sql.Connection conn;
	static String email;
	static String user;
	public static String email1;
	static String i;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
		initComponent();

		
	
	}

	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 536);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 102, 102));
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(LogIn.class.getResource("/images/e5b0ccb6a3d446cb6af30c13c6a93aef.jpg")));
		int nr=1;
		//Button button = new Button("LogIn");
		
		/*button.setOnMouseClicked(e -> {
			String email = emailField.getText();
			String pass = passField.getText();
			/*if(DBOperations.checkLogin(email, pass) == true)
				primaryStage.setScene((new UserMenu()).openUserMenu(primaryStage,windowWidth, windowHeight,email));
			else {
				successfulOperation.setTextFill(Color.RED);
				successfulOperation.setText("Date de logare invalide");
			}
				
		});*/
		
		
		button.setFont(new Font("Engravers MT", Font.PLAIN, 20));
		button.setForeground(SystemColor.textHighlight);
		
		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Engravers MT", Font.PLAIN, 17));
		
		textField_1 = new JPasswordField();
		textField_1.setBackground(new Color(224, 255, 255));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		
		lblParola = new JLabel("Parola");
		lblParola.setForeground(SystemColor.textHighlight);
		lblParola.setFont(new Font("Engravers MT", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Inapoi");
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		
	
		
		JButton btnSchimbareParola = new JButton("Schimbare Parola");
		btnSchimbareParola.setForeground(SystemColor.textHighlight);
		btnSchimbareParola.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 475, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblParola, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
										.addGap(118))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
										.addGap(120))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSchimbareParola)
								.addGap(18)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addGap(101)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblParola, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSchimbareParola, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(42))
		);
		contentPane.setLayout(gl_contentPane);
		email = textField.getText();
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				java.sql.Connection conn;
				email= textField.getText();
				email1= email;
				System.out.println(email1);
				System.out.println(email);
				String email1 = textField.getText();
				String parola = textField_1.getText();
				try {
					if(email1!="" && parola!="") {
			        Class.forName("org.h2.Driver").newInstance();
			        conn =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					PreparedStatement st = ((java.sql.Connection) conn).prepareStatement("SELECT EMAIL, PAROLA FROM LOG WHERE EMAIL = ? AND PAROLA =?");
					st.setString(1, email1);
					st.setString(2,parola);
					ResultSet rez = st.executeQuery();
					
					
					// extrage data
					rez.next(); // itereaza peste liniile obtinute
					String getEmail = rez.getString(1);
					String getPassword = rez.getString(2);
					System.out.println(email + " " + parola);
					if(getEmail.equals(email) && getPassword.equals(parola)) {
						System.out.println("logare cu succes!");
						
					}
					
					System.out.println("-+-"+ email);
					String anul = "SELECT * FROM SING2  ";
					 java.sql.Connection conn1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					 Statement st1 = conn.createStatement();
				     ResultSet rs = st1.executeQuery(anul);
					 while(rs.next()) {
						 System.out.println(rs.getString(4));
						}
					
					
					
					dispose();
			        new Lista1().setVisible(true);
					JOptionPane.showMessageDialog(null, "Te-ai logat");}
					else {
						JOptionPane.showMessageDialog(null, "Email sau parola gresite");
					}
					
				} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					System.out.println("logare esuata");
					JOptionPane.showMessageDialog(null, "Email sau parola gresite");
					e1.printStackTrace();
				}
				
				
				
				 
					
			    try {
			    	 Class.forName("org.h2.Driver").newInstance();
				     conn =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				     PreparedStatement st1 =  ((java.sql.Connection) conn).prepareStatement("SELECT * FROM SING2 WHERE EMAIL = ?");
				     st1.setString(1, email);
				     ResultSet rez1 = st1.executeQuery();
					 ResultSetMetaData data = st1.getMetaData();
					 while(rez1.next()) {
						 email = rez1.getString(1);
						 user = rez1.getString(2);}
			    	
			    }catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					System.out.println("logare esuata");
					JOptionPane.showMessageDialog(null, "Email sau parola gresite");
					e1.printStackTrace();
				}
				
				
			}});

		btnNewButton.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //setVisible(false);
		    	dispose();
		        new Principal().setVisible(true); // Main Form to show after the Login Form..
		    }
		});
		
		btnSchimbareParola.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //setVisible(false);
		    	dispose();
		        new SchimbareParola().setVisible(true); // Main Form to show after the Login Form..
		    }
		});
		

		
	}
	/*public String getEmail() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String s1 = textField.getText();
		java.sql.Connection conn2;
		conn2 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		String s = "SELECT EMAIL FROM LOGIN ";
		Statement stmt = conn2.createStatement(); 
		System.out.print(s1);
		return s1;
		
	}*/
}
