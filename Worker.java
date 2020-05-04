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

public class Worker extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Worker frame = new Worker();
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
	public Worker() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("WORKER LOGIN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Worker.class.getResource("/bb/images/bb4.jpg")));
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
		
		JButton btnDonation = new JButton("DONATION  OF  BLOOD  BAGS");
		btnDonation.addActionListener(this);
		btnDonation.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btnDonation.setBorder(null);
		btnDonation.setForeground(Color.RED);
		btnDonation.setBackground(Color.WHITE);
		btnDonation.setBounds(550, 155, 500, 100);
		contentPane.add(btnDonation);
		
		JButton btnRequest = new JButton("REQUEST  FOR  BLOOD  BAGS");
		btnRequest.addActionListener(this);
		btnRequest.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btnRequest.setBorder(null);
		btnRequest.setForeground(Color.RED);
		btnRequest.setBackground(Color.WHITE);
		btnRequest.setBounds(550, 480, 500, 100);
		contentPane.add(btnRequest);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label.setBounds(500, 155, 50, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_1.setBounds(500, 205, 50, 50);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_2.setBounds(500, 105, 50, 50);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_3.setBounds(500, 255, 50, 50);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_4.setBounds(500, 430, 50, 50);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_5.setBounds(500, 480, 50, 50);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_6.setBounds(500, 530, 50, 50);
		contentPane.add(label_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel.setBounds(500, 580, 50, 50);
		contentPane.add(lblNewLabel);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_7.setBounds(550, 105, 50, 50);
		contentPane.add(label_7);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_1.setBounds(600, 105, 50, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_2.setBounds(650, 105, 50, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_8.setBounds(700, 105, 50, 50);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_9.setBounds(750, 105, 50, 50);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_10.setBounds(800, 105, 50, 50);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_11.setBounds(850, 105, 50, 50);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_12.setBounds(900, 105, 50, 50);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_13.setBounds(950, 105, 50, 50);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_14.setBounds(1000, 105, 50, 50);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_15.setBounds(1050, 155, 50, 50);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_16.setBounds(1050, 105, 50, 50);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_17.setBounds(1050, 205, 50, 50);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_18.setBounds(1050, 255, 50, 50);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_19.setBounds(1000, 255, 50, 50);
		contentPane.add(label_19);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_3.setBounds(950, 255, 50, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_20.setBounds(900, 255, 50, 50);
		contentPane.add(label_20);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_4.setBounds(850, 255, 50, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_21.setBounds(800, 255, 50, 50);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_22.setBounds(750, 255, 50, 50);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_23.setBounds(700, 255, 50, 50);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_24.setBounds(650, 255, 50, 50);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_25.setBounds(600, 255, 50, 50);
		contentPane.add(label_25);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_5.setBounds(550, 255, 50, 50);
		contentPane.add(lblNewLabel_5);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_26.setBounds(550, 430, 50, 50);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_27.setBounds(600, 430, 50, 50);
		contentPane.add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_28.setBounds(650, 430, 50, 50);
		contentPane.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_29.setBounds(700, 430, 50, 50);
		contentPane.add(label_29);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_30.setBounds(750, 430, 50, 50);
		contentPane.add(label_30);
		
		JLabel label_31 = new JLabel("");
		label_31.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_31.setBounds(800, 430, 50, 50);
		contentPane.add(label_31);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_6.setBounds(850, 430, 50, 50);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_7.setBounds(900, 430, 50, 50);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_8.setBounds(950, 430, 50, 50);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_9.setBounds(1000, 430, 50, 50);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_10.setBounds(1050, 430, 50, 50);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_11.setBounds(1050, 480, 50, 50);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_12.setBounds(1050, 530, 50, 50);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_13.setBounds(1050, 580, 50, 50);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_14.setBounds(1000, 580, 50, 50);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_15.setBounds(950, 580, 50, 50);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		lblNewLabel_16.setBounds(900, 580, 50, 50);
		contentPane.add(lblNewLabel_16);
		
		JLabel label_32 = new JLabel("");
		label_32.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_32.setBounds(850, 580, 50, 50);
		contentPane.add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_33.setBounds(800, 580, 50, 50);
		contentPane.add(label_33);
		
		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_34.setBounds(750, 580, 50, 50);
		contentPane.add(label_34);
		
		JLabel label_35 = new JLabel("");
		label_35.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_35.setBounds(700, 580, 50, 50);
		contentPane.add(label_35);
		
		JLabel label_36 = new JLabel("");
		label_36.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_36.setBounds(650, 580, 50, 50);
		contentPane.add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_37.setBounds(600, 580, 50, 50);
		contentPane.add(label_37);
		
		JLabel label_38 = new JLabel("");
		label_38.setIcon(new ImageIcon(Worker.class.getResource("/bb/images/bb10m3.jpg")));
		label_38.setBounds(550, 580, 50, 50);
		contentPane.add(label_38);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String captiom=e.getActionCommand();
		if(captiom.equals("DONATION  OF  BLOOD  BAGS"))
		{
			Donor dbb=new Donor();
			dbb.setVisible(true);
			JOptionPane.showMessageDialog(this,"WELCOME DONOR");
		}
		if(captiom.equals("REQUEST  FOR  BLOOD  BAGS"))
		{
			Receiver rec=new Receiver();
			rec.setVisible(true);
			JOptionPane.showMessageDialog(this,"WELCOME RECEIVER");
		}
		
	}

}
