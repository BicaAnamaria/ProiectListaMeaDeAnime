import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JButton;


public class Info extends JFrame {	
	ArrayList<String> lista ;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
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
					Lista1 frame = new Lista1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

		
	
	
		public Info() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(Lista1.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, 487, 419);
			JPanel contentPane = new JPanel();
			contentPane.setBackground(new Color(224, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
	
			
			
			JTextField txtBineAiVenit = new JTextField();
			txtBineAiVenit.setEditable(false);
			txtBineAiVenit.setFont(new Font("Engravers MT", Font.PLAIN, 12));
			txtBineAiVenit.setText("Bine ai venit, ");
			txtBineAiVenit.setBackground(new Color(224, 255, 255));
			txtBineAiVenit.setBounds(24, 45, 129, 21);
			getContentPane().add(txtBineAiVenit);
		//	txtBineAiVenit.setColumns(10);
			txtBineAiVenit.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			JTextField txtEmail = new JTextField();
			txtEmail.setEditable(false);
			txtEmail.setFont(new Font("Engravers MT", Font.PLAIN, 12));
			txtEmail.setText("Email:");
			txtEmail.setBackground(new Color(224, 255, 255));
			txtEmail.setBounds(24, 98, 67, 21);
			getContentPane().add(txtEmail);
			txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			JTextField txtNumarDeAnime = new JTextField();
			txtNumarDeAnime.setEditable(false);
			txtNumarDeAnime.setFont(new Font("Engravers MT", Font.PLAIN, 12));
			txtNumarDeAnime.setText("Numar de anime terminate:");
		//	txtNumarDeAnime.setColumns(10);
			
			txtNumarDeAnime.setBackground(new Color(224, 255, 255));
			txtNumarDeAnime.setBounds(24, 156, 251, 21);
			getContentPane().add(txtNumarDeAnime);
			txtNumarDeAnime.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			JTextField txtNumarDeAnime_1 = new JTextField();
			txtNumarDeAnime_1.setEditable(false);
			txtNumarDeAnime_1.setFont(new Font("Engravers MT", Font.PLAIN, 12));
			txtNumarDeAnime_1.setText("Numar de anime in curs de terminare:");
		//	txtNumarDeAnime_1.setColumns(10);
			txtNumarDeAnime_1.setBackground(new Color(224, 255, 255));
			txtNumarDeAnime_1.setBounds(24, 221, 349, 21);
			getContentPane().add(txtNumarDeAnime_1);
			txtNumarDeAnime_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			JTextField txtNumarTotalDe = new JTextField();
			txtNumarTotalDe.setEditable(false);
			txtNumarTotalDe.setFont(new Font("Engravers MT", Font.PLAIN, 12));
			txtNumarTotalDe.setText("Numar total de episoade:");
		//	txtNumarTotalDe.setColumns(10);
			txtNumarTotalDe.setBackground(new Color(224, 255, 255));
			txtNumarTotalDe.setBounds(24, 279, 242, 21);
			txtNumarTotalDe.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			getContentPane().add(txtNumarTotalDe);
			
			
			JTextField textField = new JTextField();
			textField.setEditable(false);
			textField.setFont(new Font("Arial", Font.PLAIN, 12));
			textField.setColumns(10);
			textField.setBackground(new Color(224, 255, 255));
			textField.setBounds(91, 99, 129, 20);
			String email = LogIn.email1;
			System.out.println(LogIn.email1);
			textField.setText(email);
			textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			getContentPane().add(textField);
			
			JTextField textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setFont(new Font("Arial", Font.PLAIN, 12));
			textField_1.setColumns(10);
			textField_1.setBackground(new Color(224, 255, 255));
			textField_1.setBounds(152, 46, 106, 20);
			textField.setText(LogIn.user);
			textField_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			getContentPane().add(textField_1);
			
			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setText((String) null);
			textField_3.setFont(new Font("Arial", Font.PLAIN, 12));
			textField_3.setColumns(10);
			textField_3.setBackground(new Color(224, 255, 255));
			textField_3.setBounds(278, 157, 49, 20);
			textField_3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			contentPane.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setEditable(false);
			textField_4.setText((String) null);
			textField_4.setFont(new Font("Arial", Font.PLAIN, 12));
			textField_4.setColumns(10);
			textField_4.setBackground(new Color(224, 255, 255));
			textField_4.setBounds(375, 222, 49, 20);
			textField_4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			contentPane.add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setEditable(false);
			textField_5.setText((String) null);
			textField_5.setFont(new Font("Arial", Font.PLAIN, 12));
			textField_5.setColumns(10);
			textField_5.setBackground(new Color(224, 255, 255));
			textField_5.setBounds(267, 280, 49, 20);
			textField_5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			contentPane.add(textField_5);
			lista = new ArrayList<String>();
			 try {
				email = LogIn.email;
				lista.add(email);
				
				
		    	 Class.forName("org.h2.Driver").newInstance();
			   /*  java.sql.Connection conn =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			     PreparedStatement st1 =  ((java.sql.Connection) conn).prepareStatement("SELECT * FROM SING WHERE EMAIL ='email'");
			     ResultSet rez1 = st1.executeQuery();
				 ResultSetMetaData data = st1.getMetaData();*/
				 String anul = "SELECT * FROM SING2 WHERE EMAIL ='email' ";
				 java.sql.Connection conn1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				 java.sql.Statement st1 = conn1.createStatement();
			     ResultSet rs = ((java.sql.Statement) st1).executeQuery(anul);
				 while(rs.next()) {
					 System.out.println(rs.getString(2)+rs.getString(1));
					lista.add(rs.getString(2));
					lista.add(rs.getString(1));}
				 
				 String count1 = String.valueOf("SELECT COUNT(*) FROM nr1"+Lista1.nrn+" WHERE TERMINAT = true");
				 java.sql.Statement  st2 =   conn1.createStatement();
				 ResultSet rs1 = ((java.sql.Statement) st1).executeQuery(count1);
				 while(rs1.next()) {
				 lista.add(rs1.getString(1));}
				 
				 String count2 = String.valueOf("SELECT COUNT(*) FROM nr1"+Lista1.nrn+" WHERE TERMINAT = false");
				 java.sql.Statement  st3 =   conn1.createStatement();
				 ResultSet rs2 = ((java.sql.Statement) st3).executeQuery(count2);
				 while(rs2.next()) {
				 lista.add(rs2.getString(1));}
				 
				 String count3 = String.valueOf("SELECT SUM(EPISOADE) FROM nr1"+Lista1.nrn);
				 java.sql.Statement  st4 =   conn1.createStatement();
				 ResultSet rs3 = ((java.sql.Statement) st4).executeQuery(count3);
				 while(rs3.next()) {
				 lista.add(rs3.getString(1));}
		    	
		    }catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				System.out.println("logare esuata");
				JOptionPane.showMessageDialog(null, "Email sau parola gresite");
				e1.printStackTrace();
			}
			 textField_5.setText(lista.get(lista.size()-1));
			 textField_4.setText(lista.get(lista.size()-2));
			 textField_3.setText(lista.get(lista.size()-3));
			 textField_1.setText(lista.get(lista.size()-4));
			 
			 JButton btnNewButton = new JButton("INAPOI");
			 btnNewButton.setForeground(new Color(0, 0, 139));
			 btnNewButton.setFont(new Font("Engravers MT", Font.PLAIN, 10));
			 btnNewButton.setBounds(366, 351, 85, 21);
			 contentPane.add(btnNewButton);
			 for(String s:lista) {
				 System.out.println(s);
				 
				 
				 
				 
			 }
			 
			 btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						dispose();
						new Lista1().setVisible(true);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
		
		}
}

