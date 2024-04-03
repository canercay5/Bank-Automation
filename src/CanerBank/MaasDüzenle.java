package CanerBank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MaasDüzenle {

	private JFrame frame;
	private JTextField tc;
	private JTextField maas;
	private JLabel lblYeniMaa;
	private JLabel sonuc;

	public MaasDüzenle() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton güncelle = new JButton("Güncelle");
		güncelle.setForeground(Color.WHITE);
		güncelle.setBackground(Color.BLACK);
		güncelle.setBounds(132, 152, 172, 40);
		frame.getContentPane().add(güncelle);
		
		tc = new JTextField();
		tc.setBounds(132, 50, 172, 40);
		frame.getContentPane().add(tc);
		tc.setColumns(10);
		
		maas = new JTextField();
		maas.setColumns(10);
		maas.setBounds(132, 101, 172, 40);
		frame.getContentPane().add(maas);
		
		JLabel lblNewLabel = new JLabel("T.C. Numarası:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(2, 48, 120, 40);
		frame.getContentPane().add(lblNewLabel);
		
		lblYeniMaa = new JLabel("Yeni Maaş");
		lblYeniMaa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYeniMaa.setBounds(12, 101, 120, 40);
		frame.getContentPane().add(lblYeniMaa);
		
		sonuc = new JLabel("");
		sonuc.setForeground(Color.RED);
		sonuc.setHorizontalAlignment(SwingConstants.CENTER);
		sonuc.setBounds(12, 203, 414, 32);
		frame.getContentPane().add(sonuc);
		
		güncelle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase per1 = new DataBase();
				per1.changeSalary(Long.parseLong(tc.getText()), Integer.parseInt(maas.getText()));
				sonuc.setText("Başarıyla Güncellendi");
				
			}
		});
	}
}
