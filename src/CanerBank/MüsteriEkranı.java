package CanerBank;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MüsteriEkranı {

	private JFrame frame;

	public MüsteriEkranı(Long tclong, int pswrd) {
		initialize(tclong, pswrd);
	}

	private void initialize(Long tclong, int pswrd) {
		DataBase müsteri1 = new DataBase();
		frame = new JFrame("Müşteri Ekranı");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(400, 200, 620, 374);
		frame.getContentPane().setLayout(null);
		JOptionPane sorgu = new JOptionPane();
		
		JButton para_yatır = new JButton("Para Yatır");
		para_yatır.setBackground(Color.BLACK);
		para_yatır.setForeground(Color.WHITE);
		para_yatır.setBounds(10, 11, 216, 42);
		frame.getContentPane().add(para_yatır);
		para_yatır.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yatır = sorgu.showInputDialog("Yatırılacak Para Miktarını Giriniz: ");
				int oldBalance = müsteri1.getBalance(tclong);
				int para = Integer.parseInt(yatır);

				müsteri1.changeBalance(tclong, para+oldBalance);

				sorgu.showMessageDialog(null, "Para yatırıldı. Toplam:" +müsteri1.getBalance(tclong));
			}
		});
		
		
		JButton bakiye = new JButton("Bakiye Sorgula");
		bakiye.setBackground(Color.BLACK);
		bakiye.setForeground(Color.WHITE);
		bakiye.setBounds(10, 64, 216, 42);
		frame.getContentPane().add(bakiye);
		bakiye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu.showMessageDialog(null, "Bakiye: "+ müsteri1.getBalance(tclong) + " TL");
				
			}
		});
		
		JButton fatura1 = new JButton("Fatura Ödeme");
		fatura1.setBackground(Color.BLACK);
		fatura1.setForeground(Color.WHITE);
		fatura1.setBounds(10, 117, 216, 42);
		frame.getContentPane().add(fatura1);
		fatura1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fatura ft = new Fatura(tclong);
			}
		});
		
		
		JButton borc = new JButton("Borç Ödeme");
		borc.setBackground(Color.BLACK);
		borc.setForeground(Color.WHITE);
		borc.setBounds(10, 170, 216, 42);
		frame.getContentPane().add(borc);
		borc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String öde = sorgu.showInputDialog("Ödemek istediğiniz miktarı giriniz: ");
				int blnc = müsteri1.getBalance(tclong);
				müsteri1.changeBalance(tclong, Integer.parseInt(öde)+blnc);
				sorgu.showMessageDialog(null, "Güncel Bakiye: "+müsteri1.getBalance(tclong));
			}
		});
		
		
		JButton para_cek = new JButton("Para Çek");
		para_cek.setBackground(Color.BLACK);
		para_cek.setForeground(Color.WHITE);
		para_cek.setBounds(360, 11, 216, 42);
		frame.getContentPane().add(para_cek);
		para_cek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cek = sorgu.showInputDialog("Çekilecek Para Miktarını Giriniz: ");
				int para = Integer.parseInt(cek);
				int oldBalance = müsteri1.getBalance(tclong);
				müsteri1.changeBalance(tclong, oldBalance - para);
				
				sorgu.showMessageDialog(null, "Para çekildi. Toplam:" +cek);
			}
		});
		
		
		JButton transfer = new JButton("Para Transferi");
		transfer.setBackground(Color.BLACK);
		transfer.setForeground(Color.WHITE);
		transfer.setBounds(360, 64, 216, 42);
		frame.getContentPane().add(transfer);
		transfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gönder = sorgu.showInputDialog("Yatırılacak Para Miktarını Giriniz: ");
				String gönder1 = sorgu.showInputDialog("Yatırılacak hesap no giriniz:");
				int blnc = müsteri1.getBalance(tclong) - Integer.parseInt(gönder);
				müsteri1.changeBalance(tclong, blnc);
				sorgu.showMessageDialog(null, "Para yatırıldı. Kalan:" +blnc);
			}
		});
		
		
		JButton döviz = new JButton("Döviz Al-Sat");
		döviz.setBackground(Color.BLACK);
		döviz.setForeground(Color.WHITE);
		döviz.setBounds(360, 117, 216, 42);
		frame.getContentPane().add(döviz);
		döviz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu.showMessageDialog(null, "Doviz işlemleri geçici süre askıya alındı...");
			}
		});
		
		
		JButton kredi = new JButton("Kredi Başvurusu");
		kredi.setBackground(Color.BLACK);
		kredi.setForeground(Color.WHITE);
		kredi.setBounds(360, 170, 216, 42);
		frame.getContentPane().add(kredi);
		kredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kredi = sorgu.showInputDialog("Çekmek istediğiniz para miktarını giriniz.");
				müsteri1.insertCredit(tclong, Integer.parseInt(kredi), false);
				sorgu.showMessageDialog(null, "Yönetici onayı bekleniyor.Birkaç saat sürebilir.");
			}
		});
		
		
		JButton sınav = new JButton("Eğitim-Sınav Ödemeleri");
		sınav.setBackground(Color.BLACK);
		sınav.setForeground(Color.WHITE);
		sınav.setBounds(10, 223, 216, 42);
		frame.getContentPane().add(sınav);
		sınav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu.showMessageDialog(null, "Ödeme gerektiren sınav mevcut değil.");
			}
		});
		
		
		JButton sifre_degis = new JButton("Şifre Değiştir");
		sifre_degis.setBackground(Color.BLACK);
		sifre_degis.setForeground(Color.WHITE);
		sifre_degis.setBounds(360, 223, 216, 42);
		frame.getContentPane().add(sifre_degis);
		
		JButton exit = new JButton("ÇIKIŞ YAP");
		exit.setBackground(Color.BLACK);
		exit.setForeground(new Color(255, 0, 0));
		exit.setBounds(233, 287, 120, 50);
		frame.getContentPane().add(exit);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		sifre_degis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sif = sorgu.showInputDialog("Yeni şifreyi giriniz.");
				müsteri1.updatePassword(tclong, Integer.parseInt(sif));
				sorgu.showMessageDialog(null, "Şifre Başarıyla güncellendi.");
			}
		});
		
		frame.setVisible(true);
	}
}
