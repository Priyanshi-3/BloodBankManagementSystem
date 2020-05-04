package bb.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import bb.dbtask.*;

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

public class WorkerLogin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtphn;
	private JRadioButton rdmale,rdfemale;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private ButtonGroup gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerLogin frame = new WorkerLogin();
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
	public WorkerLogin() {
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WorkerLogin.class.getResource("/bb/images/bb4.jpg")));
		setTitle("WORKER LOGIN");
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
		lblWorkerId.setBounds(700, 130, 125, 30);
		contentPane.add(lblWorkerId);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnSubmit.setBackground(new Color(240, 240, 240));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBounds(870, 550, 150, 50);
		contentPane.add(btnSubmit);
		
		txtid = new JTextField();
		txtid.setBounds(1000, 130, 175, 30);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setForeground(Color.RED);
		lblName.setBounds(720, 230, 125, 30);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(1000, 230, 175, 30);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhoneNo.setForeground(Color.RED);
		lblPhoneNo.setBounds(700, 330, 125, 30);
		contentPane.add(lblPhoneNo);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGender.setForeground(Color.RED);
		lblGender.setBounds(710, 430, 125, 30);
		contentPane.add(lblGender);
		
		txtphn = new JTextField();
		txtphn.setBounds(1000, 330, 175, 30);
		contentPane.add(txtphn);
		txtphn.setColumns(10);
		
		rdmale = new JRadioButton("MALE");
		gender.add(rdmale);
		rdmale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdmale.setForeground(new Color(0, 0, 0));
		rdmale.setBounds(1000, 430, 70, 30);
		contentPane.add(rdmale);
		
		rdfemale = new JRadioButton("FEMALE");
		gender.add(rdfemale);
		rdfemale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdfemale.setBounds(1085, 430, 90, 30);
		contentPane.add(rdfemale);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id=txtid.getText();
		String name=txtname.getText();
		String phone=txtphn.getText();
		//int ct=0;
		//for(int i=0;i<phone.length();i++)
		//{
			//char c=phone.charAt(i);
			//if(c>='0' && c<='9')
				//ct++;
		//}
		String gendertype="";
		if(rdmale.isSelected())
		{
			gendertype=rdmale.getText();
		}
		else if(rdfemale.isSelected())
		{
			gendertype=rdfemale.getText();
		}
		try {
			
			String strsql="select * from worker where workerid=?";
				ps=con.prepareStatement(strsql);
				ps.setString(1, id);
				//System.out.println(ps);
				rs=ps.executeQuery();
			if(rs.next()==true)
				
			{
					String phonenumber=	rs.getString("phoneno");
					String wname=rs.getString("name");
					String wgender=	rs.getString("gender");
					//txtp.setText(phonenumber);
					//lblphoneno.setText(phonenumber);
					//if(ct!=phone.length() || ct!=10)
					//{
						//JOptionPane.showMessageDialog(this, "PHONE NUMBER IS INVALID","ERROR",JOptionPane.ERROR_MESSAGE);
					//}
					if(name.compareTo(wname)==0 && phone.compareTo(phonenumber)==0 && gendertype.compareTo(wgender)==0)
					{
						JOptionPane.showMessageDialog(this,"WELCOME "+name);
						Worker wker=new Worker();
						wker.setVisible(true); 
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "INFORMATION ENTERD IS WRONG","ERROR",JOptionPane.ERROR_MESSAGE);
						
					}
					
					
				
			}
				
			else
			{
				JOptionPane.showMessageDialog(this, "INFORMATION ENTERD IS WRONG","ERROR",JOptionPane.ERROR_MESSAGE);
				
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
			
			
			
		}

		}

