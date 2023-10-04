import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JFrame{
    private JButton buttonTask1Graph;

    public JButton getButtonTask1Graph() {

        return buttonTask1Graph;
    }

    private JPanel panelMain;
    private JButton buttonTask2Tree;
    private JPanel formPanel;

    public FormMain() {
        //FormMain formMain = new FormMain();
        setSize(700,500);
        setBounds(10,10,700,600);
        formPanel.setBounds(0,0,550,410);
        panelMain.setBounds(0,0,550,410);
        buttonTask1Graph.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonTask2Tree.setText("2");
        buttonTask2Tree.setBounds(480,106,60,60);
        buttonTask2Tree.setBorder(new RoundedBorder(20));
        buttonTask2Tree.setBackground(new Color(125,113,216));
        buttonTask2Tree.setFont(new Font("Roboto", Font.PLAIN, 24));
        buttonTask2Tree.setForeground(Color.white);
        buttonTask2Tree.setVisible(true);
        pack();
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
        buttonTask2Tree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FormTask2Tree task2= new FormTask2Tree();
                JFrame task2Frame = new JFrame("Main");
                task2Frame.setContentPane(new FormTask2Tree().getmainPanel());
                task2Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                task2Frame.pack();
                task2Frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        //JFrame mainFrame = new JFrame("Main");
        //JButton buttonTask2Tree = new JButton("2");
        new FormMain();
        /*FormMain mainFrame = new FormMain();


        mainFrame.setContentPane(new FormMain().panelMain);
        mainFrame.setSize(700,500);
        mainFrame.setBounds(10,10,700,600);
        mainFrame.setResizable(false);
        //mainFrame.getContentPane().add(buttonTask2Tree);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mainFrame.add(buttonTask2Tree);

        //mainFrame.pack();
        mainFrame.setVisible(true);*/
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}