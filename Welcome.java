package bb.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Welcome extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Welcome.class.getResource("/bb/images/bb4.jpg")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("WELCOME\r\n");
		createGui();
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1590, 838);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 0));
		//contentPane.setPreferredSize(new Dimension(32767, 32767));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeTo = new JLabel("WELCOME  TO");
		lblWelcomeTo.setFont(new Font("Forte", Font.BOLD, 50));
		lblWelcomeTo.setForeground(Color.WHITE);
		lblWelcomeTo.setBounds(649, 75, 350, 55);
		contentPane.add(lblWelcomeTo);
		
		JLabel lblBloodBankManagement = new JLabel("BLOOD  BANK ");
		lblBloodBankManagement.setForeground(Color.WHITE);
		lblBloodBankManagement.setFont(new Font("Forte", Font.BOLD, 50));
		lblBloodBankManagement.setBounds(649, 175, 360, 55);
		contentPane.add(lblBloodBankManagement);
		
		JLabel lblManagementSystem = new JLabel(" MANAGEMENT  SYSTEM");
		lblManagementSystem.setFont(new Font("Forte", Font.BOLD, 50));
		lblManagementSystem.setForeground(Color.WHITE);
		lblManagementSystem.setBounds(514, 275, 650, 55);
		contentPane.add(lblManagementSystem);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Welcome.class.getResource("/bb/images/bb11m1.png")));
		label.setBounds(0, 0, 1700, 875);
		contentPane.add(label);
		
		JButton btnOwnerLogin = new JButton("LOGIN");
		btnOwnerLogin.addActionListener(this);
		btnOwnerLogin.setBackground(Color.WHITE);
		btnOwnerLogin.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnOwnerLogin.setForeground(Color.BLACK);
		btnOwnerLogin.setBounds(700, 550, 239, 70);
		contentPane.add(btnOwnerLogin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Login lgn=new Login();
		lgn.setVisible(true);
		
	}
}
