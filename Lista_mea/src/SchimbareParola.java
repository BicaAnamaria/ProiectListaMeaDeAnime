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
public class SchimbareParola extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblParola;
	private JButton button = new JButton("Salvare");
	java.sql.Connection conn=null;
	private JTextField textField_3;

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
	public SchimbareParola() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SchimbareParola.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 443);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 102, 102));
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		int nr=1;
		//Button button = new Button("LogIn");
	
		button.setIcon(new ImageIcon(SchimbareParola.class.getResource("/images/Paomedia-Small-N-Flat-Floppy.png")));
		
		
		button.setFont(new Font("Engravers MT", Font.PLAIN, 20));
		button.setForeground(SystemColor.textHighlight);
		
		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setBackground(new Color(102, 102, 102));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Engravers MT", Font.PLAIN, 17));
		
		textField_1 = new JPasswordField();
		textField_1.setBackground(new Color(224, 255, 255));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		
		lblParola = new JLabel("Parola Noua");
		lblParola.setBackground(new Color(0, 0, 0));
		lblParola.setForeground(SystemColor.textHighlight);
		lblParola.setFont(new Font("Engravers MT", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Inapoi");
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		
		JSeparator separator_1 = new JSeparator();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblParola, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(325, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(277, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(341, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblParola, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(button)
					.addGap(34)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				java.sql.Connection conn;
				try {
					Class.forName("org.h2.Driver").newInstance();
				} catch (InstantiationException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IllegalAccessException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String email= textField.getText();
				String parola = textField_1.getText();
				
				try {
					
			       
			        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			        PreparedStatement st2 = ((java.sql.Connection) conn).prepareStatement("SELECT EMAIL FROM LOG WHERE EMAIL = ? ");
					st2.setString(1, email);
					ResultSet rez1 = st2.executeQuery();
					PreparedStatement st = ((java.sql.Connection) conn).prepareStatement("UPDATE LOG SET PAROLA = ? WHERE EMAIL = ?");
					st.setString(1, parola);
					st.setString(2, email);
					st.execute();
					//rez.next();
					//st.executeUpdate();
					//st.close();
					
					PreparedStatement st1 = ((java.sql.Connection)  conn).prepareStatement("UPDATE SING2 SET PAROLA = ? WHERE EMAIL = ?");
					//System.out.println("dfffd");
					st1.setString(1, parola);
					st1.setString(2, email);
					
					st1.executeUpdate();
					//System.out.println("dfffd");
					st1.close();
					dispose();
			        new LogIn().setVisible(true);
					JOptionPane.showMessageDialog(null, "S-a salvat parola");
					
				} catch (SQLException  e1) {
					System.out.println("logare esuata");
					JOptionPane.showMessageDialog(null, "Nu s-a gasit contul");
					e1.printStackTrace();
				}
					
				
				
				
				
			}});
		btnNewButton.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //setVisible(false);
		    	dispose();
		        new LogIn().setVisible(true); // Main Form to show after the Login Form..
		    }
		});
		
	
	}
}
