import javax.swing.*;
import java.awt.*;

public class FormTask2Tree {
    private JPanel mainPanel;
    private JLabel labelTitle;
    private JPanel panelTitle;
    private JPanel panelUserInterface;

    public FormTask2Tree()
    {
        mainPanel.setBounds(0,0,450,410);
        labelTitle.setText("ProjectTOI/Task2");
        labelTitle.setBounds(0,0,550,40);
        labelTitle.setSize(550,40);
        labelTitle.setBackground(new Color(50,50,50));
        labelTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTitle.setForeground(Color.white);
        panelTitle.setBackground(new Color(50,50,50));
        panelUserInterface.setBackground(new Color(49,56,102));
        //panelTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        new FormTask2Tree();
    }

    public Container getmainPanel() {
        return mainPanel;
    }
}
