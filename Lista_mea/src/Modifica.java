import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class Modifica extends JFrame {
	

	private JPanel contentPane;
	static JTextField textField;
	static JTextField textField_2;
	static JTextField textField_4;
	static JTextField textField_5;
	static Choice choice;
	static Choice choice_1;
	static Checkbox checkbox;
	String nr1="";
	String nrn="";
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
					Modifica frame = new Modifica();
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
	public Modifica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 300, 372);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new CompoundBorder(new CompoundBorder(), new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn_1 = new JButton("Modifica");
		btnLogIn_1.setForeground(SystemColor.textHighlight);
		btnLogIn_1.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnLogIn_1.setBounds(144, 369, 135, 30);
		contentPane.add(btnLogIn_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(248, 248, 255));
		textField.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		textField.setBounds(121, 22, 270, 21);
		contentPane.add(textField);
		
		
		Label label = new Label("Nume");
		label.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		label.setBounds(37, 22, 59, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Episoade");
		label_1.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		label_1.setBounds(37, 68, 59, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Terminat?");
		label_2.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		label_2.setBounds(37, 117, 59, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Gen");
		label_3.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		label_3.setBounds(37, 165, 59, 21);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(248, 248, 255));
		textField_2.setBounds(121, 217, 270, 21);
		contentPane.add(textField_2);
		
		Label label_4 = new Label("An");
		label_4.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		label_4.setBounds(37, 217, 59, 21);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Site");
		label_5.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		label_5.setBounds(37, 265, 59, 21);
		contentPane.add(label_5);
		
		Label label_6 = new Label("Comentarii");
		label_6.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		label_6.setBounds(37, 315, 74, 21);
		contentPane.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(248, 248, 255));
		textField_4.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		textField_4.setBounds(121, 265, 270, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(248, 248, 255));
		textField_5.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		textField_5.setBounds(121, 315, 270, 21);
		contentPane.add(textField_5);
		
		checkbox = new Checkbox("");
		checkbox.setBackground(new Color(248, 248, 255));
		checkbox.setBounds(121, 117, 25, 21);
		contentPane.add(checkbox);
		
		choice = new Choice();
		choice.setBackground(new Color(248, 248, 255));
		choice.setBounds(121, 168, 197, 18);
		contentPane.add(choice);
		
		JList list = new JList();
		list.setBounds(203, 94, -82, -22);
		contentPane.add(list);
		
		choice_1 = new Choice();
		choice_1.setBackground(new Color(248, 248, 255));
		choice_1.setBounds(121, 68, 74, 18);
		contentPane.add(choice_1);
		
		JButton btnIesire = new JButton("IESIRE");
		btnIesire.setForeground(SystemColor.textHighlight);
		btnIesire.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnIesire.setBounds(314, 414, 106, 21);
		contentPane.add(btnIesire);
		
		//choice.add("Actiune");
		
		for(int i=0;i<=5000;i++)
			choice_1.add(String.valueOf(i));
		
		choice_1.getAccessibleContext();
		choice_1.getSelectedItem();
		
		textField.setText(Lista1.getNume());
		
		choice_1.select(Lista1.getEp());
		
		checkbox.setState(Boolean.parseBoolean(Lista1.getTerm()));
		
		choice.select(Lista1.getGen());
		
		textField_2.setText(Lista1.getAn());
		textField_4.setText(Lista1.getSite());
		textField_5.setText(Lista1.getCom());
		
        try {
        	ArrayList<String> lista = new ArrayList<>();
        	String anul = "SELECT NUME FROM GEN GROUP BY NUME ";
			java.sql.Connection conn1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			java.sql.Statement st1 = conn1.createStatement();
	        ResultSet rs = ((java.sql.Statement) st1).executeQuery(anul);
	        while (rs.next()) {
	        
	        	lista.add(rs.getString(1));
	        	
	        	
	        }
	        lista.stream().distinct().collect(Collectors.toList());
	        for(String s:lista) {
	        	choice.add(s);
	        }
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			
			e2.printStackTrace();
		}
		
        
		
			
        btnLogIn_1.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //setVisible(false);
		    	
		    	/*textField.setText(Lista1.getNume());
			    choice_1.select(String.valueOf(Lista1.getEp()));
				checkbox.setState(Lista1.getTerm());
				choice.select(Lista1.getGen());
				textField_2.setText(String.valueOf(Lista1.getAn()));
				textField_4.setText(Lista1.getSite());
				textField_5.setText(Lista1.getCom());*/
		        try {
		        	Class.forName("org.h2.Driver").newInstance();
		        	String nume = textField.getText();
		        	int ep = Integer.parseInt(choice_1.getSelectedItem());
		        	boolean term = checkbox.getState();
		        	String gen = choice.getSelectedItem();
		        	int an = Integer.parseInt(textField_2.getText());
		        	String site =  textField_4.getText();
		        	String com =  textField_5.getText();
					java.sql.Connection conn1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					
					
				      //  java.sql.PreparedStatement st1 =  ((java.sql.Connection) conn1).prepareStatement("SELECT GEN FROM LISTA )");
					PreparedStatement st1 = conn1.prepareStatement(String.valueOf("SELECT NUME FROM NR1"+Lista1.nrn+" WHERE NUME = ?"));
					st1.setString(1, nume);
					ResultSet rez1 = st1.executeQuery();
					if(rez1.toString().contains("rows: 0")) {
						JOptionPane.showMessageDialog(null, "Numele nu se v-a modifica");
					}
					else {
						
						
					}
					java.sql.PreparedStatement st = ((java.sql.Connection) conn1).prepareStatement(String.valueOf("UPDATE nr1"+Lista1.nrn+" SET EPISOADE =?,TERMINAT =?, GEN =?, AN=?,SITE =?,COMENTARII=? WHERE NUME =?") );
				    
				    st.setInt(1, ep);
				    st.setBoolean(2, term);
				    st.setString(3, gen);
				    st.setInt(4, an);
				    st.setString(5, site);
				    st.setString(6, com);
				    st.setString(7, nume);
				    
				  
				    
				    //st.setString(7, null);
				    st.execute();
					dispose();
					new Lista1().setVisible(true);
					
				        
					
				} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				} // Main Form to show after the Login Form..
		    }
		});
        
        btnIesire.addActionListener(new ActionListener() {
			
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

	      
	       setSize(446, 485);
	       setLocationRelativeTo(null);
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	

	
	
}
