package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JPanel homePanel;
    private JTextField buscaText;
    private JLabel buscarLabel;
    private JButton buscarButton;
    private JButton limparButton;

    public Home(String windowName) {
        super(windowName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(homePanel);
        this.pack();
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = buscaText.getText();
                (new Result(search)).setVisible(true);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscaText.setText("");
            }
        });
    }
}
