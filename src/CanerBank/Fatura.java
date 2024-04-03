package CanerBank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Fatura {

	private JFrame frame;
	static int  elektrikb = 256;
	static int sub = 203;
	static int internetb = 123;
	static int telefonb = 125;
	
	public Fatura(Long tcno) {
		initialize(tcno);
	}

	private void initialize(long tcno) {
		DataBase müsteri1 = new DataBase();
		int blnc = müsteri1.getBalance(tcno);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton elektrik = new JButton("Elektrik Faturası: "+ elektrikb +" TL");
		elektrik.setBounds(10, 51, 416, 42);
		frame.getContentPane().add(elektrik);
		elektrik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				elektrik.setText("Elektrik Faturası: "+ 0 + " TL");
				müsteri1.changeBalance(tcno, blnc-elektrikb);
				
			}
		});
		
		JButton su = new JButton("Su faturası: "+ sub+" TL");
		su.setBounds(10, 104, 416, 42);
		frame.getContentPane().add(su);
		su.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				su.setText("Su faturası: "+ 0+ " TL");
				müsteri1.changeBalance(tcno, blnc-sub);
				
			}
		});
		
		JButton ınternet = new JButton("İnternet faturası: "+ internetb+" TL");
		ınternet.setBounds(10, 157, 416, 42);
		frame.getContentPane().add(ınternet);
		ınternet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ınternet.setText("İnternet faturası: "+ 0+" TL");
				müsteri1.changeBalance(tcno, blnc-internetb);
				
			}
		});
		
		JButton telefon = new JButton("Telefon Faturası: "+ telefonb+" TL");
		telefon.setBounds(10, 210, 416, 42);
		frame.getContentPane().add(telefon);
		telefon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telefon.setText("Telefon Faturası: "+ 0 + " TL");
				müsteri1.changeBalance(tcno, blnc-telefonb);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Ödemek İçin Üzerine Tıklayınız.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 416, 14);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
