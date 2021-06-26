package gui.sorting;

import javax.swing.*;

public class Runtable {
    public static void main(String[] args) {
        JFrame gambar = new JFrame("Aplikasi Pengurutan Data");
        gambar.setContentPane(new table().getRootPanel());
        gambar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gambar.setSize(700,450);
        gambar.setLocationRelativeTo(null);
        gambar.setVisible(true);
    }
}
