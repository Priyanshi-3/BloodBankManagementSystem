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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Donation extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtphn;
	private JTextField txtdate;
	private JTextField txtbags;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps,pselect,psupdate;
	private static String phone,bb,type,blood;
	private JTextField txtbb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donation frame = new Donation(phone,bb,type);
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
	public Donation(String phone,String blood,String type) {
		Donation.phone=phone;
		Donation.bb=blood;
		Donation.type=type;
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Donation.class.getResource("/bb/images/bb4.jpg")));
		setTitle("BLOOD DONATION");
		createGui();
		}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Donation.class.getResource("/bb/images/bb3.png")));
		label.setBounds(890, 0, 670, 820);
		contentPane.add(label);
		 
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setForeground(Color.RED);
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhoneNo.setBounds(150, 150, 125, 30);
		contentPane.add(lblPhoneNo);
		
		txtphn = new JTextField();
		txtphn.setEditable(false);
		txtphn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtphn.setText(phone);
		txtphn.setBounds(500, 150, 125, 30);
		contentPane.add(txtphn);
		txtphn.setColumns(10);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(Color.RED);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setBounds(170, 250, 125, 30);
		contentPane.add(lblDate);
		
		txtdate = new JTextField();
		txtdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdate.setBounds(500, 250, 125, 30);
		contentPane.add(txtdate);
		txtdate.setColumns(10);
		
		JLabel lblNoOfBags = new JLabel("NO OF BAGS");
		lblNoOfBags.setForeground(Color.RED);
		lblNoOfBags.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNoOfBags.setBounds(145, 350, 125, 30);
		contentPane.add(lblNoOfBags);
		
		txtbags = new JTextField();
		txtbags.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtbags.setBounds(500, 350, 125, 30);
		contentPane.add(txtbags);
		txtbags.setColumns(10);
		
		JLabel lblBloodGroups = new JLabel("BLOOD GROUP");
		lblBloodGroups.setForeground(Color.RED);
		lblBloodGroups.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBloodGroups.setBounds(130, 450, 160, 30);
		contentPane.add(lblBloodGroups);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnSubmit.setBounds(300, 620, 150, 50);
		contentPane.add(btnSubmit);
		
		txtbb = new JTextField();
		txtbb.setEditable(false);
		txtbb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		String t="";
		if(type.compareTo("POSITIVE")==0)
		{
			t="+";
		}
		else if(type.compareTo("NEGATIVE")==0)
		{
			t="-";
		}
		blood=bb+t;
		txtbb.setText(blood);
		txtbb.setBounds(475, 450, 180, 30);
		contentPane.add(txtbb);
		txtbb.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//String serialno=txtsn.getText();
		int nobags,sn,bbags=0,auto_id;
		
		/*
		 * if(serialno.isEmpty()==false) { sn=Integer.parseInt(serialno); } else { sn=0;
		 * }
		 */
		 
		//String phone=AddDonorInfo.txt.getText();
		/*int ct=0;
		for(int i=0;i<phone.length();i++)
		{
			char c=phone.charAt(i);
			if(c>='0' && c<='9')
				ct++;
		}*/
		
		String date=txtdate.getText();
		String bags=txtbags.getText();
		//System.out.println(bags+"-----0-----");
		if(bags.isEmpty()==false)
		{
			nobags=Integer.parseInt(bags);
		}
		else 
		{
			nobags=0;
		}
		//System.out.println(nobags+"-----1-----");
		//String blood=(String) combobg.getSelectedItem();
		/*if(ct!=phone.length() || ct!=10)
		{
			JOptionPane.showMessageDialog(this, "PHONE NUMBER IS INVALID","ERROR",JOptionPane.ERROR_MESSAGE);
		}*/
		if (date.isEmpty() || nobags==0)
			JOptionPane.showMessageDialog(this, "ENTER INFORMATION");

		else

		{

			try {
				//(workerid, name, phoneno,gender)
				String strinsert = "insert into  blooddonate(phoneno,date,noofbags,bloodgroup) values(?,?,?,?)";
				ps = con.prepareStatement(strinsert, PreparedStatement.RETURN_GENERATED_KEYS);// dbms compiler will compile query->ps
				
				ps.setString(1, phone);
				ps.setString(2, date);
				ps.setInt(3,nobags);
				ps.setString(4,blood );
				//ps.setString(7,bb);
				//ps.setString(8,type);
				//System.out.println(ps);
				int row = ps.executeUpdate();
				ResultSet res = ps.getGeneratedKeys();
				//while (res.next())
				//System.out.println("Generated key: " + res.getInt(1));
				// insert/update//delete
				if (row > 0) {
					JOptionPane.showMessageDialog(this, "DONATION DONE SUCCESSFULLY");
					//String bloodgroup=bb+"-"+type;
					this.dispose();
					String strsql="select * from bloodbags where bloodgroup=?";
					pselect = con.prepareStatement(strsql);


					
					//pselect=con.prepareStatement(strsql);
					pselect.setString(1, blood);
					//System.out.println(ps);
					rs=pselect.executeQuery();
					//pselect.executeUpdate();
				if(rs.next()==true)
					
				{
						bbags=rs.getInt("noofbags");
						//sn=rs.getInt("serialno");
						//System.out.println(sn +"-----2-----");
				}
						//txtp.setText(bags));
				
				

					/*
					 * this.dispose(); Donation d=new Donation(); d.setVisible(true);
					 */
					/*
					 * txtemail.setText(""); txtname.setText(""); txtphn.setText("");
					 * txtadd.setText(""); txtage.setText(""); rdmale.setText("");
					 * rdfemale.setText("");
					 */
				
				    String strupdate="update bloodbags set noofbags=? where bloodgroup=?";
					psupdate=con.prepareStatement(strupdate);
					int tot=bbags+nobags;
					//System.out.println(tot+"-----3-----");
	/*				
	 * String phone=txtphn.getText(); String name=txtname.getText(); String
	 * gendertype="";
	 * 
	 * if(rdMale.isSelected()) { gendertype= rdMale.getText(); }
	 * 
	 * if(rdFemale.isSelected()) { gendertype= rdFemale.getText(); }
	 */	
					psupdate.setInt(1,tot);
					psupdate.setString(2,blood);
					int rw=	psupdate.executeUpdate();
				
						/*
						 * if(rw>0) { JOptionPane.showMessageDialog(this,"RECORD UPDATED SUCCESSFULLY");
						 * this.dispose(); //JOptionPane.showMessageDialog(this,
						 * "REcordUpdated","updation",JOptionPane.QUESTION_MESSAGE ); }
						 */		
				
					
			}
			}catch (SQLException se) {
				System.out.println(se);
			}

			finally {

				try {
					if (pselect != null)
						pselect.close();
				} catch (SQLException se) {
					System.out.println(se);
				}

			}

		}
		
		
	}
}
