package bb.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bb.dbtask.CrudOperation;
import java.sql.*;
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

public class DeleteWorker extends JFrame implements ActionListener{

	private JPanel contentPane;
	//private JTextField txtname;
	//private JTextField txtphn;
	private JComboBox<String>cmpid;
	private Connection con;
	private PreparedStatement ps,pscombo,psdelete;
	private ResultSet rs,rscombo;
	private JRadioButton rdmale,rdfemale;
	private JTextField txtname;
	private JTextField txtphn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWorker frame = new DeleteWorker();
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
	public void fillcombo()
	 {
		 try
		 {
			 String strsql="select workerid from worker";
			 pscombo=con.prepareStatement(strsql);
			 rscombo=pscombo.executeQuery();
			 while(rscombo.next()==true)
			 {
				String id=rscombo.getString("workerid");
				cmpid.addItem(id);
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
	public DeleteWorker() {
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteWorker.class.getResource("/bb/images/bb4.jpg")));
		setTitle("DELETE WORKER");
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
		
		JButton btnSubmit = new JButton("DELETE");
		btnSubmit.addActionListener(this );
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnSubmit.setBackground(new Color(240, 240, 240));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBounds(870, 550, 150, 50);
		contentPane.add(btnSubmit);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setForeground(Color.RED);
		lblName.setBounds(720, 230, 125, 30);
		contentPane.add(lblName);
		
		/*
		 * txtname = new JTextField(); txtname.setBounds(1000, 230, 175, 30);
		 * contentPane.add(txtname); txtname.setColumns(10);
		 */
		
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
		
		/*
		 * txtphn = new JTextField(); txtphn.setBounds(1000, 330, 175, 30);
		 * contentPane.add(txtphn); txtphn.setColumns(10);
		 */
		
		rdmale = new JRadioButton("MALE");
		rdmale.setEnabled(false);
		rdmale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdmale.setForeground(new Color(0, 0, 0));
		rdmale.setBounds(1000, 430, 70, 30);
		contentPane.add(rdmale);
		
		rdfemale = new JRadioButton("FEMALE");
		rdfemale.setEnabled(false);
		rdfemale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdfemale.setBounds(1085, 430, 90, 30);
		contentPane.add(rdfemale);
		
		cmpid = new JComboBox();
		cmpid.setModel(new DefaultComboBoxModel(new String[] {"SELECT WORKER ID"}));
		cmpid.setBounds(1000, 130, 175, 30);
		fillcombo();
		contentPane.add(cmpid);
		
		txtname = new JTextField();
		txtname.setEditable(false);
		txtname.setBounds(1000, 230, 175, 30);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtphn = new JTextField();
		txtphn.setEditable(false);
		txtphn.setBounds(1000, 330, 175, 30);
		contentPane.add(txtphn);
		txtphn.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String wid=(String)cmpid.getSelectedItem();//getselecteditem is used to select items from combo box
		
		if(wid.equalsIgnoreCase("SELECT WORKER ID"))
		{
			
			JOptionPane.showMessageDialog(this, "PLEASE SELECT A VALID WORKER ID");
		}
		else
		{
			try {
				
				String strsql="select * from worker where workerid=?";
					ps=con.prepareStatement(strsql);
					ps.setString(1, wid);
					//System.out.println(ps);
					rs=ps.executeQuery();
				if(rs.next()==true)
					
				{
						String phonenumber=	rs.getString("phoneno");
						String name=rs.getString("name");
						String gender=rs.getString("gender");
						txtphn.setText(phonenumber);
						txtname.setText(name);
						
						if(gender.compareTo("MALE")==0)
						{
							rdmale.setSelected(true);
						}
						else if(gender.compareTo("FEMALE")==0)
						{
							rdfemale.setSelected(true);
						}
						
						
					
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

				int option=JOptionPane.showConfirmDialog(this,"ARE YOU SURE YOU WANT TO DELETE THIS WORKER ID");
			//System.out.println(option);
			if(option==0)
			{
				try {
					String strdelete="delete from worker where workerid=?";
					psdelete=con.prepareStatement(strdelete);
					psdelete.setString(1,wid);
					int row=psdelete.executeUpdate();
					if(row>0)
						JOptionPane.showMessageDialog(this, "WORKER ID DELETED");
					cmpid.removeAllItems();
					cmpid.addItem("SELECT WORKER ID");
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

