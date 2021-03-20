

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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
import java.awt.Choice;

public class Gen extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	//String[] col = { "Nume", "Episoade", "Terminat?", "Gen", "An", "Site", "Comentarii"};
	DefaultTableModel model;
	ArrayList<Anime> anime = new ArrayList<Anime>();

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
					Gen frame = new Gen();
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
	public Gen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista1.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1368, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 JPanel Pane = new JPanel();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 109, 1332, 624);
		
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
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(scrollPane_1);
		
		Choice choice = new Choice();
		choice.setBackground(new Color(224, 255, 255));
		choice.setFont(new Font("Engravers MT", Font.PLAIN, 15));
		choice.setBounds(12, 65, 428, 18);
		contentPane.add(choice);
		choice.add("");
		
		JButton btnNewButton = new JButton("INAPOI");
		btnNewButton.setFont(new Font("Engravers MT", Font.PLAIN, 10));
		btnNewButton.setForeground(new Color(0, 0, 139));
		btnNewButton.setBounds(1259, 65, 85, 21);
		contentPane.add(btnNewButton);
		
		
		try {
			
			
			
			java.sql.Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			Statement st = conn.createStatement();
		
			
			
				String an = String.valueOf("SELECT * FROM nr1"+Lista1.nrn+" GROUP BY NUME");
				Statement st1 = (Statement) conn.createStatement();
				ResultSet rs = ((java.sql.Statement) st1).executeQuery(an);
				ResultSetMetaData data = rs.getMetaData();
				String[] row = new String[8];
			    for (int i = 1; i < data.getColumnCount(); i++) {
			            row[i] = data.getColumnName(i);
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
				
			    ArrayList<String> lista = new ArrayList<>();
	        	String anul = "SELECT NUME FROM GEN GROUP BY NUME ";
				java.sql.Statement st2 = conn.createStatement();
		        ResultSet rs1 = ((java.sql.Statement) st2).executeQuery(anul);
		        while (rs1.next()) {
		        	lista.add(rs1.getString(1));
		        	
		        	
		        }
		        lista.stream().distinct().collect(Collectors.toList());
		        for(String s:lista) {
		        	choice.add(s);
		        }
		        
		    //    choice.clear();
			
		}catch (SQLException  e1) {
			
			e1.printStackTrace();
		}
		choice.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
			
			    
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			    
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				String text = choice.getSelectedItem();
			
				if(text.trim().length() ==0) {
					rowSorter.setRowFilter(null);
				}
				else {
					text = choice.getSelectedItem();
					System.out.println(text);
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
				}
			    
				
			}
			
		});
		
		
		
	
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					dispose();
					new Lista1().setVisible(true);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
	
	
	}
}
