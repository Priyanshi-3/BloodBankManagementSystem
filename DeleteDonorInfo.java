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

public class DeleteDonorInfo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtadd;
	private JTextField txtage;
	private JComboBox<String>combophn;
	private JRadioButton rdmale,rdfemale;
	private Connection con;
	private PreparedStatement ps,pscombo,psdelete;
	private ResultSet rscombo,rs;
	private ButtonGroup gendergroup;
	private JTextField txtbg;
	private JTextField txtype;

	/**
	 * Launch the application.
	 */
	public void fillcombo()
	 {
		 try
		 {
			 String strsql="select phoneno from donorinfo";
			 pscombo=con.prepareStatement(strsql);
			 rscombo=pscombo.executeQuery(); 
			 while(rscombo.next()==true)
			 {
				String phn=rscombo.getString("phoneno");
				combophn.addItem(phn);
			 }
		 }
		 catch(SQLException se) {System.out.println(se);}
		 finally {
			 try {
				 if(rscombo!=null)rscombo.close();
				 if(pscombo!=null)pscombo.close();
			 }
			 catch(SQLException se)
			 {
				 System.out.println(se);
			 }
		 }
	 }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDonorInfo frame = new DeleteDonorInfo();
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
	public DeleteDonorInfo() {
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("DELETE DONOR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteDonorInfo.class.getResource("/bb/images/bb4.jpg")));
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
		
		txtname = new JTextField();
		txtname.setEditable(false);
		txtname.setBounds(1100, 230, 180, 30);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setEditable(false);
		txtemail.setBounds(1100, 280, 180, 30);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtadd = new JTextField();
		txtadd.setEditable(false);
		txtadd.setBounds(1100, 330, 180, 30);
		contentPane.add(txtadd);
		txtadd.setColumns(10);
		
		txtage = new JTextField();
		txtage.setEditable(false);
		txtage.setBounds(1100, 380, 180, 30);
		contentPane.add(txtage);
		txtage.setColumns(10);
		
		rdmale = new JRadioButton("  MALE");
		gendergroup.add(rdmale);
		rdmale.setEnabled(false);
		rdmale.setBounds(1100, 430, 80, 30);
		contentPane.add(rdmale);
		
		rdfemale = new JRadioButton("  FEMALE");
		gendergroup.add(rdfemale);
		rdfemale.setEnabled(false);
		rdfemale.setBounds(1190, 430, 95, 30);
		contentPane.add(rdfemale);
		
		JButton btnSubmit = new JButton("DELETE");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSubmit.setBounds(910, 630, 180, 50);
		contentPane.add(btnSubmit);
		
		combophn = new JComboBox();
		combophn.setModel(new DefaultComboBoxModel(new String[] {"SELECT PHONE NUMBER"}));
		combophn.setBounds(1100, 180, 180, 30);
		fillcombo();
		contentPane.add(combophn);
		
		txtbg = new JTextField();
		txtbg.setEditable(false);
		txtbg.setForeground(Color.BLACK);
		txtbg.setBackground(Color.LIGHT_GRAY);
		txtbg.setBounds(1100, 480, 180, 30);
		contentPane.add(txtbg);
		txtbg.setColumns(10);
		
		txtype = new JTextField();
		txtype.setEditable(false);
		txtype.setForeground(Color.BLACK);
		txtype.setBackground(Color.LIGHT_GRAY);
		txtype.setBounds(1100, 530, 180, 30);
		contentPane.add(txtype);
		txtype.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
String phone=(String)combophn.getSelectedItem();//getselecteditem is used to select items from combo box
		
		if(phone.equalsIgnoreCase("SELECT PHONE NUMBER"))
		{
			
			JOptionPane.showMessageDialog(this, "PLEASE SELECT A VALID PHONE NUMBER");
		}
		else
		{
			try {
				
				String strsql="select * from donorinfo where phoneno=?";
					ps=con.prepareStatement(strsql);
					ps.setString(1, phone);
					//System.out.println(ps);
					rs=ps.executeQuery();
				if(rs.next()==true)
					
				{
						String email=	rs.getString("email");
						String name=rs.getString("name");
						String gender=rs.getString("gender");
						String address=rs.getString("address");
						int age=rs.getInt("age");
						String bgroup=rs.getString("bloodgroup");
						String type=rs.getString("type");
						txtemail.setText(email);
						txtname.setText(name);
						txtadd.setText(address);
						txtage.setText(String.valueOf(age));
						
						
						if(gender.compareTo("MALE")==0)
						{
							rdmale.setSelected(true);
						}
						else if(gender.compareTo("FEMALE")==0)
						{
							rdfemale.setSelected(true);
						}
						txtbg.setText(bgroup);
						txtype.setText(type);
						
					
				}
			}
			catch(SQLException se)
			{
				
				System.out.println(se);
			}

			finally {
				
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					
				}
				catch(SQLException se) {System.out.println(se);}
			}

			int option=JOptionPane.showConfirmDialog(this,"ARE YOU SURE YOU WANT TO DELETE THIS DONOR");
			//System.out.println(option);
			if(option==0)
			{
				try {
					String strdelete="delete from donorinfo where phoneno=?";
					psdelete=con.prepareStatement(strdelete);
					psdelete.setString(1,phone);
					int row=psdelete.executeUpdate();
					if(row>0)
						JOptionPane.showMessageDialog(this, "DONOR DELETED");
					combophn.removeAllItems();
					combophn.addItem("SELECT PHONE NUMBER");
					fillcombo();
					this.dispose();
				}
				catch(SQLException se) {System.out.println(se);}
				finally {
					 try {
						 
						 if(psdelete!=null)psdelete.close();
					 
					 }
					 catch(SQLException se)
					 {
						 System.out.println(se);}
					 }
		
	}
		}
	}
}
