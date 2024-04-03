package CanerBank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.Color;

public class PersonelEkranı {

	private JFrame frame;
	private JTable tableMüs;

	
	public PersonelEkranı() {
		initialize();
	}

	private void initialize() {
		DataBase müsteri1 = new DataBase();
		frame = new JFrame("Personel Ekranı");
		frame.setBounds(100, 100, 742, 400);
		
		JButton kaydet = new JButton("Müşteri Kaydet");
		kaydet.setBounds(222, 283, 132, 69);
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MüsteriKaydet müs1 = new MüsteriKaydet();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(kaydet);
		
		JButton sil = new JButton("Müşteri Sil");
		sil.setBounds(400, 283, 132, 69);
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MüsteriSil mtr1 = new MüsteriSil();
			}
		});
		frame.getContentPane().add(sil);
		
		JButton mtrekran = new JButton("Müşteri Ekranı");
		mtrekran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogMüsteri permüs1 = new LogMüsteri(frame);
			}
		});
		mtrekran.setBounds(43, 283, 132, 69);
		frame.getContentPane().add(mtrekran);
		
		JButton kredi_sor = new JButton("Kredi Sorgula");
		kredi_sor.setBounds(43, 11, 132, 76);
		kredi_sor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KrediSorgula sorgu1 = new KrediSorgula();
			}
		});
		frame.getContentPane().add(kredi_sor);
		
		JButton raporla = new JButton("Raporlama");
		raporla.setBounds(222, 11, 132, 76);
		raporla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Raporlama rapor = new Raporlama();
			}
		});
		frame.getContentPane().add(raporla);
		
		JButton perbil = new JButton("Personel Bilgileri");
		perbil.setBounds(400, 11, 132, 76);
		frame.getContentPane().add(perbil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 708, 174);
		frame.getContentPane().add(scrollPane);
		
		
		perbil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelBilgileri per1 = new PersonelBilgileri();
			}
		});
		

        String[][] customerData = müsteri1.getAllCustomers();
        int i = 0;
        while (i < customerData.length)  {
			customerData[i][3] = "*";
			customerData[i][4] = "*";
			customerData[i][6] = "*";
			i++;
		}
        DefaultTableModel tableModel = new DefaultTableModel(customerData, new String[]{
                "TCKNO", "Name", "Surname", "Birth", "Address", "Balance", "Password", "Telefon"
        });

		tableMüs = new JTable(tableModel);
		tableMüs.setEnabled(false);
		scrollPane.setViewportView(tableMüs);
		
		JButton cık = new JButton("Çıkış Yap");
		cık.setForeground(new Color(255, 51, 0));
		cık.setBounds(605, 306, 113, 46);
		frame.getContentPane().add(cık);
		
		cık.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JButton back = new JButton("Giriş Ekranına Dön");
		back.setForeground(new Color(102, 255, 51));
		back.setBounds(570, 11, 148, 34);
		frame.getContentPane().add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LogPersonel m1 = new LogPersonel(frame);
				
			}
		});
		
		frame.setVisible(true);

		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
