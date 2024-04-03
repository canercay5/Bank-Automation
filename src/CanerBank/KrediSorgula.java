package CanerBank;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class KrediSorgula {

	private JFrame frame;
	private JTextField maas;
	private JTextField yas;
	private JTextField sigorta;

	public KrediSorgula() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Kredi Sorgulama");
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblmaas = new JLabel("Maaş Bilgisi");
		lblmaas.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaas.setBounds(10, 11, 119, 30);
		frame.getContentPane().add(lblmaas);
		
		JLabel lblYa = new JLabel("Yaş");
		lblYa.setHorizontalAlignment(SwingConstants.CENTER);
		lblYa.setBounds(10, 57, 119, 30);
		frame.getContentPane().add(lblYa);
		
		JLabel lblsigorta = new JLabel("Sigorta Durumu");
		lblsigorta.setHorizontalAlignment(SwingConstants.CENTER);
		lblsigorta.setBounds(10, 98, 119, 30);
		frame.getContentPane().add(lblsigorta);
		
		JLabel lblpuan = new JLabel("Kredi Paunı");
		lblpuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblpuan.setBounds(10, 139, 119, 30);
		frame.getContentPane().add(lblpuan);
		
		maas = new JTextField();
		maas.setBounds(139, 11, 119, 30);
		frame.getContentPane().add(maas);
		maas.setColumns(10);
		
		yas = new JTextField();
		yas.setColumns(10);
		yas.setBounds(139, 57, 119, 30);
		frame.getContentPane().add(yas);
		
		sigorta = new JTextField();
		sigorta.setColumns(10);
		sigorta.setBounds(139, 98, 119, 30);
		frame.getContentPane().add(sigorta);
		
		JLabel lblis = new JLabel("Çalışıyor mu?");
		lblis.setHorizontalAlignment(SwingConstants.CENTER);
		lblis.setBounds(10, 180, 119, 30);
		frame.getContentPane().add(lblis);
		
		JCheckBox evet = new JCheckBox("Evet");
		evet.setBounds(139, 184, 61, 23);
		frame.getContentPane().add(evet);
		
		JLabel puanyesil = new JLabel("112");
		puanyesil.setForeground(Color.GREEN);
		puanyesil.setHorizontalAlignment(SwingConstants.CENTER);
		puanyesil.setBounds(139, 139, 119, 30);
		frame.getContentPane().add(puanyesil);
		
		JLabel kırmızı = new JLabel("Alınabilecek maksimum kredi miktarı: ");
		kırmızı.setForeground(Color.RED);
		kırmızı.setBackground(Color.RED);
		kırmızı.setBounds(10, 233, 317, 30);
		frame.getContentPane().add(kırmızı);
		
		JButton sorgu = new JButton("SORGULA");
		sorgu.setBounds(337, 229, 89, 23);
		frame.getContentPane().add(sorgu);
		
		sorgu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int maks = Integer.parseInt(maas.getText())*12 - Integer.parseInt(yas.getText())*100 + 
						Integer.parseInt(puanyesil.getText())*100;
				kırmızı.setText("Alınabilecek maksimum kredi miktarı: " + maks + " TL");
				
			}
		});	
		frame.setVisible(true);
		
	}
}
