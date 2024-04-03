package CanerBank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FeedBack {

    private JFrame frame;
    private JTable table;

    public FeedBack() {
        initialize();
    }

    private void initialize() {
        DataBase db1 = new DataBase();
        frame = new JFrame();
        frame.setBounds(100, 100, 710, 377);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 686, 329);
        frame.getContentPane().add(scrollPane);

        // Verileri al
        List<String> anketVerileri = db1.getAnket();

        // Tablo modeli oluştur
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Puan");
        tableModel.addColumn("Feedback");

        // Verileri tabloya ekle
        for (String anketBilgisi : anketVerileri) {
            // Veriyi virgül ile ayır
            String[] parts = anketBilgisi.split(", ");

            // Puan sütununa sadece puan değerini, feedback sütununa tam feedback ekleyin
            String puan = parts[0].split(": ")[1];
            String feedback = anketBilgisi.substring(anketBilgisi.indexOf("Feedback: ") + 10);

            // Puan uzunluğunu kontrol et ve kısalt
            if (puan.length() > 3) {
                puan = puan.substring(0, 2) + "...";
            }

            tableModel.addRow(new Object[]{puan, feedback});
        }

        // Tabloyu oluştur ve modele bağla
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FeedBack();
    }
}
