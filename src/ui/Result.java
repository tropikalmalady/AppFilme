package ui;

import model.Client;
import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {
    private JPanel resultPanel;
    private JLabel infosLabel;
    private JLabel plotLabel;
    private JLabel posterLabel;
    public String plotTeste;

    public Result(String search) {
        super("Resultado da busca");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(resultPanel);
        String raw = Client.searchMovie(search);
        String splitted[] = new String[5];
        splitted = raw.split(";");
        infosLabel.setText("<html>Título: " + splitted[0] + "<br>Diretor: " + splitted[1] + "<br>Ano: " + splitted[2] + "</html>");
        plotLabel.setText("<html>" + splitted[3] + "</html>");
        posterLabel.setText("<html><img src='" + splitted[4] + "'/></html>");
        this.pack();
    }
}