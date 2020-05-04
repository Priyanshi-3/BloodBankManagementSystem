

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

public class AddReceiverInfo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtphn;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtadd;
	private JTextField txtage;
	private JComboBox combobb,combotype;
	private JRadioButton rdmale,rdfemale;
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
					AddReceiverInfo frame = new AddReceiverInfo();
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
 	public AddReceiverInfo() {
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("ADD RECEIVER");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddDonorInfo.class.getResource("/bb/images/bb4.jpg")));
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
		
		JLabel lblDonorInformation = new JLabel("RECEIVER INFORMATION");
		lblDonorInformation.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		lblDonorInformation.setBackground(Color.RED);
		lblDonorInformation.setForeground(Color.WHITE);
		lblDonorInformation.setBounds(862, 29, 389, 64);
		contentPane.add(lblDonorInformation);
		
		JLabel lblPhone = new JLabel("PHONE NUMBER");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhone.setBackground(Color.RED);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(800, 180, 140, 30);
		contentPane.add(lblPhone);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setBackground(Color.RED);
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(800, 230, 140, 30);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBackground(Color.RED);
		lblEmail.setBounds(800, 280, 140, 30);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAddress.setBackground(Color.RED);
		lblAddress.setBounds(800, 330, 140, 30);
		contentPane.add(lblAddress);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAge.setBackground(Color.RED);
		lblAge.setBounds(800, 380, 140, 30);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblGender.setBackground(Color.RED);
		lblGender.setBounds(800, 430, 140, 30);
		contentPane.add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setForeground(Color.WHITE);
		lblBloodGroup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBloodGroup.setBackground(Color.RED);
		lblBloodGroup.setBounds(800, 480, 140, 30);
		contentPane.add(lblBloodGroup);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblType.setBackground(Color.RED);
		lblType.setBounds(800, 530, 140, 30);
		contentPane.add(lblType);
		
		txtphn = new JTextField();
		txtphn.setBounds(1100, 180, 140, 30);
		contentPane.add(txtphn);
		txtphn.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(1100, 230, 140, 30);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(1100, 280, 140, 30);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtadd = new JTextField();
		txtadd.setBounds(1100, 330, 140, 30);
		contentPane.add(txtadd);
		txtadd.setColumns(10);
		
		txtage = new JTextField();
		txtage.setBounds(1100, 380, 140, 30);
		contentPane.add(txtage);
		txtage.setColumns(10);
		
		rdmale = new JRadioButton("MALE");
		gendergroup.add(rdmale);
		rdmale.setBounds(1100, 430, 60, 30);
		contentPane.add(rdmale);
		
		rdfemale = new JRadioButton("FEMALE");
		gendergroup.add(rdfemale);
		rdfemale.setBounds(1170, 430, 75, 30);
		contentPane.add(rdfemale);
		
		combobb = new JComboBox();
		combobb.setModel(new DefaultComboBoxModel(new String[] {"Select Blood Group", "A", "B", "AB", "O"}));
		combobb.setBounds(1100, 480, 140, 30);
		contentPane.add(combobb);
		
		combotype = new JComboBox();
		combotype.setModel(new DefaultComboBoxModel(new String[] {"Select Blood Type", "POSITIVE", "NEGATIVE"}));
		combotype.setBounds(1100, 530, 140, 30);
		contentPane.add(combotype);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSubmit.setBounds(910, 630, 180, 50);
		contentPane.add(btnSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int age;
		String name = txtname.getText();
		String address=txtadd.getText();
		String email = txtemail.getText();
		String bb=(String) combobb.getSelectedItem();
		String type=(String) combotype.getSelectedItem();
		String tage=txtage.getText();
		if(tage.isEmpty()==false)
		{
			age=Integer.parseInt(tage);
		}
		else 
		{
			age=0;
		}
		String phoneno = txtphn.getText();
		int ct=0;
		for(int i=0;i<phoneno.length();i++)
		{
			char c=phoneno.charAt(i);
			if(c>='0' && c<='9')
				ct++;
		}
		String gendertype="";
		
					if(rdmale.isSelected())
					{
							gendertype=	rdmale.getText();
					}
		
					else if(rdfemale.isSelected())
					{
							gendertype=	rdfemale.getText();
					}
					
		

				 if (name.isEmpty() ||  phoneno.isEmpty() || gendertype.isEmpty() || address.isEmpty() || bb.compareTo("Select Blood Group")==0 || type.compareTo("Select Blood Type")==0 || age==0)
			{
						JOptionPane.showMessageDialog(this, "ENTER INFORMATION");
			}
				 else if(ct!=phoneno.length() || ct!=10)
					{
						JOptionPane.showMessageDialog(this, "PHONE NUMBER IS INVALID","ERROR",JOptionPane.ERROR_MESSAGE);
					}
		else

		{

			try {
				//(workerid, name, phoneno,gender)
				String strinsert = "insert into  receiverinfo values(?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(strinsert);// dbms compiler will compile query->ps
				
				ps.setString(1, phoneno);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, address);
				ps.setInt(5,age);
				ps.setString(6,gendertype );
				ps.setString(7,bb);
				ps.setString(8,type);
				//System.out.println(ps);

				int row = ps.executeUpdate();// insert/update//delete
				if (row > 0) {
					JOptionPane.showMessageDialog(this, "RECEIVER ADDED SUCCESSFULLY");
					this.dispose();
					Receive d=new Receive(phoneno,bb,type);
					d.setVisible(true);

					/*
					 * txtemail.setText(""); txtname.setText(""); txtphn.setText("");
					 * txtadd.setText(""); txtage.setText(""); rdmale.setText("");
					 * rdfemale.setText("");
					 */

				}

			} catch (SQLException se) {
				System.out.println(se);
			}

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
