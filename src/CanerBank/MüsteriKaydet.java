package CanerBank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MüsteriKaydet {

	private JFrame frame;
	private JTextField tcno;
	private JTextField dogum;
	private JTextField ad;
	private JTextField soyad;
	private JTextField adres;
	private JTextField sifre;
	private JTextField telefn;

	public MüsteriKaydet() throws Exception {
		initialize();
	}
	
	private void initialize() throws Exception {
		frame = new JFrame("Müşteri Kayıt Ekranı");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(300, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labeltc = new JLabel("TC Kimlik Numarası:");
		labeltc.setBounds(10, 11, 118, 20);
		frame.getContentPane().add(labeltc);
		
		JLabel lblIsim = new JLabel("İsim:");
		lblIsim.setBounds(10, 42, 118, 20);
		frame.getContentPane().add(lblIsim);
		
		JLabel lblNewLabel_1_1 = new JLabel("Soyisim:");
		lblNewLabel_1_1.setBounds(10, 73, 118, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Doğum Tarihi: (gg.aa.yy)");
		lblNewLabel_1_1_1.setBounds(10, 104, 129, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Adres:");
		lblNewLabel_1_1_1_1.setBounds(10, 135, 118, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Şifre:");
		lblNewLabel_1_1_1_1_1.setBounds(10, 166, 118, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		tcno = new JTextField();
		tcno.setForeground(Color.WHITE);
		tcno.setBackground(Color.BLACK);
		tcno.setBounds(138, 11, 96, 20);
		frame.getContentPane().add(tcno);
		tcno.setColumns(30);
		
		dogum = new JTextField();
		dogum.setForeground(Color.WHITE);
		dogum.setBackground(Color.BLACK);
		dogum.setColumns(10);
		dogum.setBounds(138, 104, 96, 20);
		frame.getContentPane().add(dogum);
		
		ad = new JTextField();
		ad.setForeground(Color.WHITE);
		ad.setBackground(Color.BLACK);
		ad.setColumns(20);
		ad.setBounds(138, 42, 96, 20);
		frame.getContentPane().add(ad);
		
		soyad = new JTextField();
		soyad.setForeground(Color.WHITE);
		soyad.setBackground(Color.BLACK);
		soyad.setColumns(20);
		soyad.setBounds(138, 73, 96, 20);
		frame.getContentPane().add(soyad);
		
		adres = new JTextField();
		adres.setForeground(Color.WHITE);
		adres.setBackground(Color.BLACK);
		adres.setColumns(50);
		adres.setBounds(138, 135, 96, 20);
		frame.getContentPane().add(adres);
		
		sifre = new JTextField();
		sifre.setForeground(Color.WHITE);
		sifre.setBackground(Color.BLACK);
		sifre.setColumns(4);
		sifre.setBounds(138, 166, 96, 20);
		frame.getContentPane().add(sifre);
		

		JLabel tlfn = new JLabel("Telefon");
		tlfn.setBounds(10, 197, 118, 20);
		frame.getContentPane().add(tlfn);
		
		JLabel lastText = new JLabel();
		lastText.setForeground(Color.RED);
		lastText.setBackground(Color.BLACK);
		lastText.setHorizontalAlignment(SwingConstants.CENTER);
		lastText.setBounds(244, 107, 182, 48);
		frame.getContentPane().add(lastText);
		
		JButton kaydet = new JButton("Kaydet");
		kaydet.setForeground(Color.WHITE);
		kaydet.setBackground(Color.BLACK);
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Müsteri müs1 = new Müsteri();
				
				müs1.tckno = Long.parseLong(tcno.getText());
				müs1.password = Integer.parseInt(sifre.getText());
				müs1.name = ad.getText();
				müs1.surname = soyad.getText();
				müs1.adress = adres.getText();
				müs1.birth = dogum.getText();
				müs1.balance = 0;
				müs1.telefon = telefn.getText();
				
				String db = "db.txt";
				DataBase db4 = new DataBase();
				db4.insert( müs1.tckno, müs1.password, müs1.name,müs1.surname, müs1.adress, müs1.birth, 0,müs1.telefon);
				lastText.setText("Müşteri Başarıyla kaydedildi.");
			
			}
			
		
		});
		kaydet.setBounds(138, 229, 89, 23);
		frame.getContentPane().add(kaydet);
		
		
		telefn = new JTextField();
		telefn.setForeground(Color.WHITE);
		telefn.setBackground(Color.BLACK);
		telefn.setColumns(4);
		telefn.setBounds(138, 197, 96, 20);
		frame.getContentPane().add(telefn);
		

		
		frame.setVisible(true);
		//******************************************************************		
	}
}
