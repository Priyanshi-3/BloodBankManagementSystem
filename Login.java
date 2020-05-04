package bb.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtype;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("LOGIN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/bb/images/bb4.jpg")));
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("USER  ID");
		lblUserId.setFont(new Font("Stencil", Font.BOLD, 18));
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setBounds(550, 150, 150, 40);
		contentPane.add(lblUserId);
		
		txtid = new JTextField();
		txtid.setBounds(850, 150, 200, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblUserPassword = new JLabel("USER  PASSWORD");
		lblUserPassword.setFont(new Font("Stencil", Font.BOLD, 18));
		lblUserPassword.setForeground(Color.WHITE);
		lblUserPassword.setBounds(515, 250, 170, 40);
		contentPane.add(lblUserPassword);
		
		JLabel lblUserType = new JLabel("USER  TYPE");
		lblUserType.setFont(new Font("Stencil", Font.BOLD, 18));
		lblUserType.setForeground(Color.WHITE);
		lblUserType.setBounds(540, 350, 150, 40);
		contentPane.add(lblUserType);
		
		txtype = new JTextField();
		txtype.setBounds(850, 350, 200, 30);
		contentPane.add(txtype);
		txtype.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSubmit.setBounds(710, 500, 180, 50);
		contentPane.add(btnSubmit);
		
		
		 JLabel label = new JLabel(""); label.setIcon(new
		 ImageIcon(Login.class.getResource("/bb/images/bb11m1.png")));
		 label.setBounds(0, 0, 1545, 809); contentPane.add(label);
 
		 txtpass = new JPasswordField();
		 txtpass.setBounds(850, 250, 200, 30);
		 contentPane.add(txtpass);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id=txtid.getText();
		String password=new String(txtpass.getPassword());
		String type=txtype.getText();
		if(id.isEmpty() && password.isEmpty() && type.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"data required");
		}
		else if(id.compareTo("owner")==0 && password.compareTo("owner")==0 && type.compareTo("owner")==0)
		{
			Owner owner=new Owner();
			owner.setVisible(true);
			JOptionPane.showMessageDialog(this,"WELCOME OWNER");
		}
		else if(id.compareTo("worker")==0 && password.compareTo("worker")==0 && type.compareTo("worker")==0)
		{
			WorkerLogin worker=new WorkerLogin();
			worker.setVisible(true);
			JOptionPane.showMessageDialog(this,"WELCOME WORKER");
		}
		else
		{
			JOptionPane.showMessageDialog(this,"ENTER CORRECT DETAILS","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		this.dispose();
	}
}
