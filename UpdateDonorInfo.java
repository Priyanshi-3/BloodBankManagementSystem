package bb.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import bb.dbtask.*;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UpdateDonorInfo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtphn;
	private JTextField txtemail;
	private JTextField txtadd;
	private Connection con;
	private PreparedStatement ps;
	private ButtonGroup gendergroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDonorInfo frame = new UpdateDonorInfo();
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
	public UpdateDonorInfo() {
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("UPDATE DONOR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateDonorInfo.class.getResource("/bb/images/bb4.jpg")));
		createGui();
	}
	public void createGui()
	{
		gendergroup=new ButtonGroup();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddDonorInfo.class.getResource("/bb/images/bb12m2.png")));
		label.setBounds(0, -16, 495, 835);
		contentPane.add(label);
		
		JLabel lblDonorInformation = new JLabel("DONOR INFORMATION");
		lblDonorInformation.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		lblDonorInformation.setBackground(Color.RED);
		lblDonorInformation.setForeground(Color.WHITE);
		lblDonorInformation.setBounds(862, 100, 389, 64);
		contentPane.add(lblDonorInformation);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBackground(Color.RED);
		lblEmail.setBounds(800, 370, 140, 30);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("PHONE NUMBER");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhone.setBackground(Color.RED);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(800, 270, 140, 30);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAddress.setBackground(Color.RED);
		lblAddress.setBounds(800, 470, 140, 30);
		contentPane.add(lblAddress);
		
		txtphn = new JTextField();
		txtphn.setBounds(1100, 270, 140, 30);
		contentPane.add(txtphn);
		txtphn.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(1100, 370, 140, 30);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtadd = new JTextField();
		txtadd.setBounds(1100, 470, 140, 30);
		contentPane.add(txtadd);
		txtadd.setColumns(10);
		
		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSubmit.setBounds(910, 630, 180, 50);
		contentPane.add(btnSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//int age;
		//String name = txtname.getText();
		String address=txtadd.getText();
		String email = txtemail.getText();
		//String bb=(String) combobb.getSelectedItem();
		/*
		 * String type=(String) combotype.getSelectedItem(); String
		 * tage=txtage.getText(); if(tage.isEmpty()==false) {
		 * age=Integer.parseInt(tage); } else { age=0; }
		 */
		String phoneno = txtphn.getText();
		/*
		 * String gendertype="";
		 * 
		 * if(rdmale.isSelected()) { gendertype= rdmale.getText(); }
		 * 
		 * else if(rdfemale.isSelected()) { gendertype= rdfemale.getText(); }
		 */		
					//String name = txtname.getText();

					//String id = txtid.getText();
					if(phoneno.isEmpty())
					{
						JOptionPane.showMessageDialog(this,"ENTER A CORRECT PHONE NUMBER");
					}
					else
					{
					try {
						    String strupdate="update donorinfo set email=?,address=? where phoneno=?";
							ps=con.prepareStatement(strupdate);
			/*
			 * String phone=txtphn.getText(); String name=txtname.getText(); String
			 * gendertype="";
			 * 
			 * if(rdMale.isSelected()) { gendertype= rdMale.getText(); }
			 * 
			 * if(rdFemale.isSelected()) { gendertype= rdFemale.getText(); }
			 */	
							ps.setString(1, email);
							ps.setString(2, address);
							ps.setString(3,phoneno);
						int rw=	ps.executeUpdate();
						
						if(rw>0)
						{
							JOptionPane.showMessageDialog(this,"RECORD UPDATED SUCCESSFULLY");
							this.dispose();
							//JOptionPane.showMessageDialog(this, "REcordUpdated","updation",JOptionPane.QUESTION_MESSAGE );
						}
								
							}
							catch(SQLException se) {System.out.println(se);}
					finally {

						try {
							if (ps != null)
								ps.close();
						} catch (SQLException se) {
							System.out.println(se);
						}

					}
 
								
							}
							
	}	
							
							
							
					
				}