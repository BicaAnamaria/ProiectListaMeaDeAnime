import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/myanimelist-manga-online-chat-welcome.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 300, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn_1 = new JButton("Log In");
		btnLogIn_1.setForeground(SystemColor.textHighlight);
		btnLogIn_1.setFont(new Font("Engravers MT", Font.PLAIN, 25));
		btnLogIn_1.setBounds(62, 20, 263, 56);
		contentPane.add(btnLogIn_1);
			
		btnLogIn_1.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //setVisible(false);
		    	dispose();
		        new LogIn().setVisible(true); // Main Form to show after the Login Form..
		    }
		});	
		
		JButton btnSingIn = new JButton("Sing In");
		btnSingIn.setForeground(SystemColor.textHighlight);
		btnSingIn.setFont(new Font("Engravers MT", Font.PLAIN, 25));
		btnSingIn.setBounds(62, 100, 263, 49);
		contentPane.add(btnSingIn);
		
		btnSingIn.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //setVisible(false);
		    	dispose();
		        new SingIn().setVisible(true); // Main Form to show after the Login Form..
		    }
		});	
		 JButton quitButton = new JButton("QUIT");
		 quitButton.setForeground(SystemColor.textHighlight);
		 quitButton.setFont(new Font("Engravers MT", Font.PLAIN, 25));
	       quitButton.setBounds(132, 183, 126, 49);
	       quitButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent event) {
	               System.exit(0);
	          }
	       });

	       contentPane.add(quitButton);

	       setTitle("Principal");
	       setSize(402, 304);
	       setLocationRelativeTo(null);
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
