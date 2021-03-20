

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.html.ImageView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;

import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelListener;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.AbstractButton;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import java.awt.TextField;

public class Lista1 extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	JButton btnNewButton_2;
	//String[] col = { "Nume", "Episoade", "Terminat?", "Gen", "An", "Site", "Comentarii"};
	DefaultTableModel model;
	ArrayList<Anime> anime = new ArrayList<Anime>();
	int nr1 ;
	static int nrn ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Lista1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista1.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1368, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 JPanel Pane = new JPanel();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(137, 109, 1217, 624);
		
		model = new DefaultTableModel();
		table = new JTable(null);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Engravers MT", Font.PLAIN, 11));
		table.setBackground(new Color(204, 255, 255));
		table.setForeground(Color.black);
		//final Object[] row = new Object[0]; 
	//	model.setColumnIdentifiers(col);
		table.setModel(model);
		
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
		table.setRowSorter(rowSorter);
		
		
		
		//contentPane.add(table);
		
		
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Lista mea de anime");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBounds(12, 12, 500, 25);
		lblNewLabel.setFont(new Font("Engravers MT", Font.PLAIN, 25));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setPreferredSize(new Dimension(500, 25));
		lblNewLabel.setMaximumSize(new Dimension(60, 25));
		
		JButton btnNewButton = new JButton("IESIRE");
		btnNewButton.setForeground(new Color(0, 0, 139));
		btnNewButton.setBounds(12, 390, 99, 26);
		
		JButton btnNewButton_1 = new JButton("ADAUGA");
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setBounds(12, 165, 99, 26);
		
		btnNewButton_2 = new JButton("MODIFICA");
		btnNewButton_2.setForeground(new Color(0, 0, 139));
		btnNewButton_2.setBounds(12, 220, 99, 26);
		
		JButton btnNewButton_3 = new JButton("STERGE");
		btnNewButton_3.setForeground(new Color(0, 0, 139));
		btnNewButton_3.setBounds(12, 276, 99, 26);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(scrollPane_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
		
		JTextField textField = new JTextField();
		textField.setBackground(new Color(240, 255, 255));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(137, 66, 575, 22);
		contentPane.add(textField);
		
		JButton btnNewButton_4 = new JButton("CAUTARE");
		btnNewButton_4.setForeground(new Color(0, 0, 139));
		btnNewButton_4.setBounds(748, 66, 99, 22);
		contentPane.add(btnNewButton_4);
		
		JButton btnModifica = new JButton("GEN");
		btnModifica.setForeground(new Color(0, 0, 139));
		btnModifica.setBounds(12, 333, 99, 26);
		contentPane.add(btnModifica);
		
		JButton btnInformatii = new JButton("INFORMATII");
		btnInformatii.setFont(new Font("Dialog", Font.BOLD, 10));
		btnInformatii.setForeground(new Color(0, 0, 139));
		btnInformatii.setBounds(12, 109, 99, 26);
		contentPane.add(btnInformatii);
		
		String text = textField.getText();
		if(text.trim().length() ==0) {
			rowSorter.setRowFilter(null);
		}
		else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
		}
		
		/*table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtnumar.setText(model.getValueAt(i, 0).toString());
				textPane_1.setText(model.getValueAt(i, 1).toString());
				textPane_2.setText(model.getValueAt(i, 2).toString());
				textPane_3.setText(model.getValueAt(i, 3).toString());
				textPane_4.setText(model.getValueAt(i, 4).toString());
				textPane_5.setText(model.getValueAt(i, 5).toString());
				textPane_6.setText(model.getValueAt(i, 6).toString());
			}
		});*/
		
		//String s = getEmail();
		
			
		
		try {
			 Class.forName("org.h2.Driver").newInstance();
			java.sql.Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			String email = LogIn.email;
			System.out.println("---"+email);
			/*String nr = "SELECT * FROM SINGIN WHERE EMAIL = 'email'";
			java.sql.Statement st5 = conn.createStatement();
			ResultSet rez = ((java.sql.Statement) st5).executeQuery(nr);
			 while(rez.next()) {
				 
				 nr1 = rez.getString(3);
				 System.out.println("---------"+nr1);
			 }*/
			
			
			String email3 = LogIn.email;
			String anul1 = "SELECT * FROM SING2 WHERE EMAIL = email3 ";
			
			 Statement stn = conn.createStatement();
		     ResultSet rsn = stn.executeQuery("SELECT * FROM SING2  ");
		     
		     ResultSetMetaData resultMeta = (ResultSetMetaData) rsn.getMetaData();
		     
		     while (rsn.next()) {
	                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
	                	if(rsn.getObject(2).equals(email)) {
	                		System.out.println(rsn.getObject(4));
	                		String s = String.valueOf( rsn.getObject(4));
	                		System.out.println(s);
	                		nr1 = Integer.parseInt(s);
	                		nrn =  nr1;
	                		System.out.println("nr1 = "+nr1);
	                		System.out.println("nrn = "+nr1);
	                		break;
	                	}
	                }
	                  //  System.out.print("\t" + rsn.getObject(i).toString() + "\t |");
	                }

		   
			 
			 
			
			
			String Lista = new String("CREATE TABLE IF NOT EXISTS "
					+ "nr1"+ Lista1.nrn+"( NUME VARCHAR(100), \r\n" + 
					"EPISOADE INT,\r\n" + 
					"TERMINAT BOOLEAN, \r\n" + 
					"GEN VARCHAR(100), \r\n" + 
					"AN INT , \r\n" + 
					"SITE VARCHAR(100), \r\n" + 
					"COMENTARII VARCHAR(100), \r\n" + 
					"C VARCHAR(100), \r\n PRIMARY KEY(NUME));");
			
			
			
			Statement st = conn.createStatement();
			st.executeUpdate(Lista);
			
			
				String an =String.valueOf( "SELECT NUME, EPISOADE, TERMINAT,GEN,An, SITE, COMENTARII,C FROM nr1"+nrn+"  ORDER BY NUME;");
				Statement st1 = (Statement) conn.createStatement();
				ResultSet rs = ((java.sql.Statement) st1).executeQuery(an);
				ResultSetMetaData data = rs.getMetaData();
				String[] row = new String[8];
			    for (int i = 1; i < data.getColumnCount(); i++) {
			            row[i] = data.getColumnName(i);
			            System.out.println(data.getColumnName(i));
			            model.addColumn(row[i]);
			           
			            
			           
			        }    
			    while (rs.next()) {
		               Object[] str  = new String[] {rs.getString(1)};
		               row[0] = rs.getString(1);
		               row[1] = rs.getString(2);
		               row[2] = rs.getString(3);
		               row[3] = rs.getString(4);
		               row[4] = rs.getString(5);
		               row[5] = rs.getString(6);
		               row[6] = rs.getString(7);
		             
		               model.addRow( row);}
				Anime anime1;
			/*	while(rs.next()) {
					//anime1 = new Anime(rs.getString(textField.getText()), rs.getInt(Integer.parseInt(choice_1.getSelectedItem()),
					             //  rs.getBoolean(checkbox.getState()),rs.getString(choice.getSelectedItem()),rs.getString(textField_2.getText()),rs.getString(textField_4.getText()),rs.getString(textField_5.getText()));
				
					anime1 = new Anime(rs.getString("nume"),rs.getInt("episoade"),rs.getBoolean("terminat"),rs.getString("gen"),rs.getInt("an"),rs.getString("site"),rs.getString("comentarii"));
				
					anime.add(anime1);
				}
				System.out.print(anime);*/
			
			
		}catch (SQLException  e1) {
			
			e1.printStackTrace();
		}
		
	//	Object [] row = new Object[7];
		btnNewButton_1.addActionListener(new ActionListener() { //adauga
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Adauga().setVisible(true);
				
			}});
		
		
		 btnNewButton_3.addActionListener(new ActionListener() { //sterge
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int i = table.getSelectedRow();
					if(i == -1) JOptionPane.showMessageDialog(null, "Nu ai selectat randul");
					else {
					String[] options = {"Da", "Nu"};
			        int answ = JOptionPane.showOptionDialog(null, "Sigur vrei sa stergi??", "Accepta stergerea", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			        if (answ == 0) {
					
					System.out.println(i);
					String val = (String) table.getValueAt(i, 0);
					String delRow = String.valueOf("delete from nr1"+nrn+"where nume=")+val;
					String email3 = LogIn.email;
					try {
						
						Class.forName("org.h2.Driver").newInstance();
						java.sql.Connection conn1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					     
						 Statement stn = conn1.createStatement();
					     ResultSet rsn = stn.executeQuery("SELECT * FROM SING2  ");
					     
					     ResultSetMetaData resultMeta = (ResultSetMetaData) rsn.getMetaData();
					     
					     while (rsn.next()) {
				                for (int i1 = 1; i1 <= resultMeta.getColumnCount(); i1++) {
				                	if(rsn.getObject(2).equals(email3)) {
				                		System.out.println(rsn.getObject(4));
				                		//nr1=Integer.parseInt( (String) rsn.getObject(4));
				                		String s = String.valueOf( rsn.getObject(4));
				                		nr1 = Integer.parseInt(s);
				                		nrn =  nr1;
				                		System.out.println("nr1 = "+nr1);
				                		System.out.println("nrn = "+nr1);
				                		break;
				                	}
				                }}
						String nr = "SELECT NR FROM SING2 WHERE EMAIL = 'email'";
						java.sql.Statement st5 = conn1.createStatement();
						ResultSet rez = ((java.sql.Statement) st5).executeQuery(nr);
						 while(rez.next()) {
							 
							 String nr1 = rez.getString(1);
							 System.out.println(nr1);
						 }
						java.sql.PreparedStatement st = ((java.sql.Connection) conn1).prepareStatement(String.valueOf("DELETE FROM nr1"+Lista1.nrn+" WHERE NUME =?"));
						st.setString(1, val);
						st.executeUpdate();
						
						
						
						dispose();
						new Lista1().setVisible(true);
					
					} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "Nu ai selectat randul");
						e1.printStackTrace();
					}
					
					
			        }
			        
				}}
				
			});
		 btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i == -1) JOptionPane.showMessageDialog(null, "Nu ai selectat randul");
				else {
				dispose();
				new Modifica().setVisible(true);}
				
			}
		});
		
		 btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
		        new Principal().setVisible(true);
				
			}
		});
		 
		 btnNewButton_4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String text  = textField.getText();
					DefaultTableModel mod = (DefaultTableModel) table.getModel();
					try {
						Class.forName("org.h2.Driver").newInstance();
						java.sql.Connection conn1 = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
						String email3 = LogIn.email;
						/*String nr = "SELECT NR FROM SINGIN WHERE EMAIL = 'email'";
						java.sql.Statement st5 = conn1.createStatement();
						ResultSet rez = ((java.sql.Statement) st5).executeQuery(nr);
						 while(rez.next()) {
							 
							 String nr1 = rez.getString(1);
							 
						 }*/
						 Statement stn = conn1.createStatement();
					     ResultSet rsn = stn.executeQuery("SELECT * FROM SING2  ");
					     
					     ResultSetMetaData resultMeta = (ResultSetMetaData) rsn.getMetaData();
					     String nr2 = "";
					     while (rsn.next()) {
				                for (int i1 = 1; i1 <= resultMeta.getColumnCount(); i1++) {
				                	if(rsn.getObject(2).equals(email3)) {
				                		System.out.println(rsn.getObject(4));
				                		String s = String.valueOf( rsn.getObject(4));
				                		nr1 = Integer.parseInt(s);
				                		nrn =  nr1;
				                		break;
				                	}
				                }
				                  //  System.out.print("\t" + rsn.getObject(i).toString() + "\t |");
				                }
						nr1 = SingIn.current;
						 System.out.println("NR! = "+nr1);
						java.sql.PreparedStatement st = ((java.sql.Connection) conn1).prepareStatement(String.valueOf("SELECT * FROM nr1"+nrn+" WHERE NUME ='text%'"));
						
						ResultSet rs = st.executeQuery();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					if(text.trim().length() ==0) {
						rowSorter.setRowFilter(null);
					}
					else {
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
					}
					
				}
			});
				

		 btnModifica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
			        try {
			        	dispose();
						new Gen().setVisible(true);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		 
		 btnInformatii.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
			        dispose();
					new Info().setVisible(true);
				}
			});
		
	       
		
	    
	
	
	}

	public static String getNume() {
		int i = table.getSelectedRow();
		String val = String.valueOf( table.getValueAt(i, 0));
			return val;
	}
	public static String getEp() {
		int i = table.getSelectedRow();
		String val = String.valueOf( table.getValueAt(i, 1));
		return val;
	}
	public static String getTerm() {
		int i = table.getSelectedRow();
		String val =  String.valueOf(table.getValueAt(i, 2));
		return val;
	}
	public static String getGen() {
		int i = table.getSelectedRow();
		String val = (String) table.getValueAt(i, 3);
			return val;
	}
	public static String getAn() {
		int i = table.getSelectedRow();
		String val = String.valueOf(table.getValueAt(i, 4));
			return val;
	}
	
	public static String getSite() {
		int i = table.getSelectedRow();
		String val = (String) table.getValueAt(i, 5);
			return val;
	}
	public static String getCom() {
		int i = table.getSelectedRow();
		String val = (String) table.getValueAt(i, 6);
		return val;
	}
}
