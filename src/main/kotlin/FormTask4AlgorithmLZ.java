import javax.swing.*;
import java.awt.*;

public class FormTask4AlgorithmLZ {

    private JPanel mainPanel;
    private JPanel panelTitle;
    private JLabel labelTitle;

    public FormTask4AlgorithmLZ()
    {
        mainPanel.setBounds(0,0,450,410);

        labelTitle.setText("ProjectTOI/Task3");
        labelTitle.setBounds(0,0,550,40);
        labelTitle.setSize(550,40);
        labelTitle.setBackground(new Color(50,50,50));
        labelTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTitle.setForeground(Color.white);
        panelTitle.setBackground(new Color(50,50,50));
    }

    public static void main(String[] args) {
        new FormTask4AlgorithmLZ();
    }

    public Container getmainPanel() {
        return mainPanel;
    }
}
