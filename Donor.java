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
import javax.swing.border.EmptyBorder;

public class Donor extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donor frame = new Donor();
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
	public Donor() {
		setTitle("DONATION OF BLOOD BAGS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Donor.class.getResource("/bb/images/bb4.jpg")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("DELETE DONOR");
		btnDelete.addActionListener(this);
		btnDelete.setBorder(null);
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnDelete.setBounds(686, 550, 250, 86);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE DONOR");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBorder(null);
		btnUpdate.setBounds(686, 350, 250, 86);
		contentPane.add(btnUpdate);
		
		JButton btnAdd = new JButton("ADD  DONOR");
		btnAdd.addActionListener(this);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnAdd.setBorder(null);
		btnAdd.setBounds(686, 150, 250, 86);
		contentPane.add(btnAdd);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Donor.class.getResource("/bb/images/bb6m2.jpg")));
		label.setBounds(600, 150, 86, 86);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Donor.class.getResource("/bb/images/bb6m2.jpg")));
		label_1.setBounds(600, 350, 86, 86);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Donor.class.getResource("/bb/images/bb6m2.jpg")));
		label_2.setBounds(600, 550, 86, 86);
		contentPane.add(label_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		if(caption.equals("ADD  DONOR"))
		{
			AddDonorInfo di=new AddDonorInfo();
			di.setVisible(true);
			 
			//JOptionPane.showMessageDialog(this,"DONOR ADDED SUCCESSFULLY");
		}
		else if(caption.equals("UPDATE DONOR"))
		{
			UpdateDonorInfo di=new UpdateDonorInfo();
			di.setVisible(true);
			//JOptionPane.showMessageDialog(this,"DONOR RECORD UPDATED SUCCESSFULLY");
		}
		else if(caption.equals("DELETE DONOR"))
		{
			DeleteDonorInfo di=new DeleteDonorInfo();
			di.setVisible(true);
			//JOptionPane.showMessageDialog(this,"DONOR REMOVED SUCCESSFULLY");
		}
	}
}
