import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JFrame{
    private JButton buttonTask1Graph;
    private JPanel panelMain;


   /* public void Main(){
        setTitle("LRTOI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }*/

    public FormMain() {

        buttonTask1Graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormTask1Graph task1= new FormTask1Graph();
                JFrame task1Frame = new JFrame("Main");
                task1Frame.setContentPane(new FormTask1Graph().getPanelRadioButton());
                task1Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // mainFrame.setSize(600, 400);
                task1Frame.pack();
                task1Frame.setVisible(true);
                //task1.setVisible(true);
                //dispose();
            }
        });
    }

    public static void main(String[] args) {
       // new FormMain();
        JFrame mainFrame = new JFrame("Main");
        mainFrame.setContentPane(new FormMain().panelMain);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // mainFrame.setSize(600, 400);
        mainFrame.pack();
        mainFrame.setVisible(true);

       // new Main();
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}