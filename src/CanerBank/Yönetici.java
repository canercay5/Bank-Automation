package CanerBank;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Yönetici {

	private JFrame frame;

	public Yönetici(JFrame fr) {
		initialize(fr);
	}

	private void initialize(JFrame fr) {
		DataBase db1 = new DataBase();
		frame = new JFrame("Yönetici Paneli.");
		frame.setBounds(100, 100, 450, 354);
		frame.getContentPane().setLayout(null);
		
		JButton mtr_gör = new JButton("Müşterileri Görüntüle");
		mtr_gör.setForeground(Color.WHITE);
		mtr_gör.setBackground(Color.BLACK);
		mtr_gör.setBounds(10, 11, 168, 51);
		frame.getContentPane().add(mtr_gör);
		
		mtr_gör.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MtrGor m1 = new MtrGor();
			}
		});
		
		JButton setMaas = new JButton("Maaş Düzenle");
		setMaas.setForeground(Color.WHITE);
		setMaas.setBackground(Color.BLACK);
		setMaas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaasDüzenle m1 = new MaasDüzenle();
			}
		});
		setMaas.setBounds(10, 73, 168, 51);
		frame.getContentPane().add(setMaas);
		
		JButton perSil = new JButton("Personel Sil");
		perSil.setForeground(Color.WHITE);
		perSil.setBackground(Color.BLACK);
		perSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonelSil p1 = new PersonelSil();
			}
		});
		perSil.setBounds(258, 135, 168, 51);
		frame.getContentPane().add(perSil);
		
		JButton perEkle = new JButton("Personel Ekle");
		perEkle.setForeground(Color.WHITE);
		perEkle.setBackground(Color.BLACK);
		perEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonelEkle per1 = new PersonelEkle();
			}
		});
		perEkle.setBounds(10, 135, 168, 51);
		frame.getContentPane().add(perEkle);
		
		JButton krediOnay = new JButton("Kredi Onayla");
		krediOnay.setForeground(Color.WHITE);
		krediOnay.setBackground(Color.BLACK);
		krediOnay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KrediOnayla k1 = new KrediOnayla();
			}
		});
		krediOnay.setBounds(258, 73, 168, 51);
		frame.getContentPane().add(krediOnay);
		
		JButton per_gör = new JButton("Personelleri Görüntüle");
		per_gör.setForeground(Color.WHITE);
		per_gör.setBackground(Color.BLACK);
		per_gör.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerGor p1 = new PerGor();
			}
		});
		per_gör.setBounds(258, 11, 168, 51);
		frame.getContentPane().add(per_gör);
		
		JButton raporOku = new JButton("Raporları Oku");
		raporOku.setForeground(Color.WHITE);
		raporOku.setBackground(Color.BLACK);
		raporOku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaporlarıOku r1 = new RaporlarıOku();
			}
		});
		raporOku.setBounds(10, 197, 168, 51);
		frame.getContentPane().add(raporOku);
		
		JButton feedbackBtn = new JButton("Feedbackler");
		feedbackBtn.setForeground(Color.WHITE);
		feedbackBtn.setBackground(Color.BLACK);
		feedbackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeedBack f1 = new FeedBack();
				
			}
		});
		feedbackBtn.setBounds(258, 197, 168, 51);
		frame.getContentPane().add(feedbackBtn);
		
		JButton back = new JButton("Giriş Ekranına Geri Dön");
		back.setBackground(Color.BLACK);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LogYönetici yönetici1 = new LogYönetici(fr);
			}
		});
		back.setForeground(new Color(102, 255, 51));
		back.setBounds(10, 283, 168, 23);
		frame.getContentPane().add(back);
		
		JButton cık = new JButton("Çıkış Yap");
		cık.setBackground(Color.BLACK);
		cık.setForeground(new Color(255, 51, 0));
		cık.setBounds(258, 283, 168, 23);
		frame.getContentPane().add(cık);
		
		cık.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
		
	}

}
