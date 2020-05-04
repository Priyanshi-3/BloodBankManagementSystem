package bb.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bb.dbtask.CrudOperation;

public class UpdateWorker extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtphn;
	private Connection con;
	private PreparedStatement ps;
	private ButtonGroup gender;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWorker frame = new UpdateWorker();
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
	public UpdateWorker() {
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateWorker.class.getResource("/bb/images/bb4.jpg")));
		setTitle("UPDATE WORKER");
		createGui();
	}
	public void createGui()
	{
		gender=new ButtonGroup();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WorkerLogin.class.getResource("/bb/images/bb15m1.png")));
		lblNewLabel.setBounds(0, -29, 332, 861);
		contentPane.add(lblNewLabel);
		
		JLabel lblWorkerId = new JLabel("WORKER ID");
		lblWorkerId.setBackground(new Color(240, 240, 240));
		lblWorkerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblWorkerId.setForeground(Color.RED);
		lblWorkerId.setBounds(700, 200, 125, 30);
		contentPane.add(lblWorkerId);
		
		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnSubmit.setBackground(new Color(240, 240, 240));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBounds(870, 550, 150, 50);
		contentPane.add(btnSubmit);
		
		txtid = new JTextField();
		txtid.setBounds(1000, 200, 175, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhoneNo.setForeground(Color.RED);
		lblPhoneNo.setBounds(700, 360, 125, 30);
		contentPane.add(lblPhoneNo);
		
		txtphn = new JTextField();
		txtphn.setBounds(1000, 360, 175, 30);
		contentPane.add(txtphn);
		txtphn.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//String name = txtname.getText();

		String id = txtid.getText();

		try {
			    String strupdate="update worker set phoneno=? where workerid=?";
				ps=con.prepareStatement(strupdate);
				String phone=txtphn.getText();
			/*
			 * String name=txtname.getText(); String gendertype="";
			 * 
			 * if(rdMale.isSelected()) { gendertype= rdMale.getText(); }
			 * 
			 * if(rdFemale.isSelected()) { gendertype= rdFemale.getText(); }
			 */
				ps.setString(1, phone);
			/*
			 * ps.setString(2, name); ps.setString(3, gendertype);
			 */
				ps.setString(2, id);
			int rw=	ps.executeUpdate();
			
			if(rw>0)
			{
				JOptionPane.showMessageDialog(this,"RECORD UPDATED");
				this.dispose();
				//JOptionPane.showMessageDialog(this, "REcordUpdated","updation",JOptionPane.QUESTION_MESSAGE );
			}
					
				}
				catch(SQLException se) {System.out.println(se);}
					
				}
				
				
				
				
				
		
	}

