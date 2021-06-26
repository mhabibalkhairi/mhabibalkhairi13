package gui.sorting;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class table {
    private JTextField textJumlah;
    private JTextField textAngka;
    private JButton urutkanButton;
    private JButton keluarButton;
    private JTable tableAngka;
    private JPanel rootPanel;
    private DefaultTableModel tableModel;
    private boolean tambahkan = false;

    public JPanel getRootPanel() {
        return rootPanel;
    }
    public table() {
        this.initComponents();
        urutkanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel model = (DefaultTableModel) tableAngka.getModel();
                String input = textAngka.getText();
                int jumlah = Integer.parseInt(textJumlah.getText());
                String[] xlt = input.split(",");
                if (textJumlah.getText().length()>3){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Data Terlalu Banyak \n Maksimal Input : 999",
                            "PERHATIAN!!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (xlt.length > jumlah || xlt.length < jumlah){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Jumlah Angka Tidak Sesuai Limit yang DiInput",
                            "PERHATIAN!!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!tambahkan) {
                    for (int i = 0; i < jumlah; i++) {
                        model.addRow(new Object[]{});
                    }
                    tambahkan = true;
                }
                int a = 0;
                for (int i : Urutan.getAsce(input, jumlah)){
                    model.setValueAt(i, a, 0);
                    a++;
                }
                int b = 0;
                for (int i : Urutan.getDesc(input, jumlah)){
                    model.setValueAt(i, b, 1);
                    b++;
                }
            }
        });

        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    private void initComponents() {
        Object[] tableColom = {
                "Ascending",
                "Descending"
        };
        Object[][] iniData = {

        };
        tableModel = new DefaultTableModel(iniData, tableColom);
        tableAngka.setModel(tableModel);
        tableAngka.setAutoCreateRowSorter(true);
        tableAngka.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
}