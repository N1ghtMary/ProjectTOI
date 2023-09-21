import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JFrame{
    private JButton buttonTask1Graph;
    private JPanel panelMain;

    public FormMain() {

        buttonTask1Graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormTask1Graph task1= new FormTask1Graph();
                JFrame task1Frame = new JFrame("Main");
                task1Frame.setContentPane(new FormTask1Graph().getPanelRadioButton());
                task1Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                task1Frame.pack();
                task1Frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Main");
        mainFrame.setContentPane(new FormMain().panelMain);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}