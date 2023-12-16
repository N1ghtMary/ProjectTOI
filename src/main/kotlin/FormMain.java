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
    private JButton buttonTask3Compression;
    private JButton buttonTask4AlgorithmLZ;
    private JPanel panelTitle;
    private JLabel labelTitle;
    private JLabel labelTitleTry2;
    private JLabel labelTextTask1;
    private JLabel labelTextTask2;
    private JLabel labelTextTask3;
    private JLabel labelTextTask4;

    public FormMain() {
        //FormMain formMain = new FormMain();
        formPanel.setBounds(0,0,550,410);
        //formPanel.setLayout(null);


        //setSize(700,500);
        //setBounds(10,10,700,600);
        //formPanel.setBounds(0,0,550,410);

        panelMain.setBounds(0,0,550,410);
        panelMain.setLayout(null);

        labelTitleTry2.setText("ProjectTOI/Main menu");
        labelTitleTry2.setBounds(0,0,550,40);
        labelTitleTry2.setSize(550,40);
        //labelTitleTry2.setBackground(new Color(50,50,50));
        labelTitleTry2.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTitleTry2.setForeground(Color.white);
        labelTitleTry2.setOpaque(true);

        buttonTask1Graph.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonTask1Graph.setText("1");
        buttonTask1Graph.setBounds(10,55,60,60);
        buttonTask1Graph.setBackground(new Color(125,113,216));
        buttonTask1Graph.setFont(new Font("Roboto", Font.PLAIN, 24));
        buttonTask1Graph.setForeground(Color.white);
        buttonTask1Graph.setVisible(true);

        labelTextTask1.setText("<html>Task 1. Directed and undirected graphs & Adjacency list, Adjacency matrix, Incidence matrix</html>");
        labelTextTask1.setBounds(90,55,450,40);
        labelTextTask1.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTextTask1.setForeground(Color.white);

        buttonTask2Tree.setText("2");
        buttonTask2Tree.setBounds(480,120,60,60);
        //buttonTask2Tree.setBorder(new RoundedBorder(20));
        buttonTask2Tree.setBackground(new Color(125,113,216));
        buttonTask2Tree.setFont(new Font("Roboto", Font.PLAIN, 24));
        buttonTask2Tree.setForeground(Color.white);
        buttonTask2Tree.setVisible(true);

        labelTextTask2.setText("<html>Task 2. Tree: Add node, Delete node, Search node, Depth First Search, Breadth First Search</html>");
        labelTextTask2.setBounds(10,120,450,40);
        labelTextTask2.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTextTask2.setForeground(Color.white);

        buttonTask3Compression.setText("3");
        buttonTask3Compression.setBounds(10,185,60,60);
        //buttonTask3Compression.setBorder(new RoundedBorder(20));
        buttonTask3Compression.setBackground(new Color(125,113,216));
        buttonTask3Compression.setFont(new Font("Roboto", Font.PLAIN, 24));
        buttonTask3Compression.setForeground(Color.white);
        buttonTask3Compression.setVisible(true);

        labelTextTask3.setText("<html>Task 3. Compression algorithms: Shannon-Fano, Huffman & Probabilities, Word</html>");
        labelTextTask3.setBounds(90,185,450,40);
        labelTextTask3.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTextTask3.setForeground(Color.white);

        buttonTask4AlgorithmLZ.setText("4");
        buttonTask4AlgorithmLZ.setBounds(480,250,60,60);
        //buttonTask4AlgorithmLZ.setBorder(new RoundedBorder(20));
        buttonTask4AlgorithmLZ.setBackground(new Color(125,113,216));
        buttonTask4AlgorithmLZ.setFont(new Font("Roboto", Font.PLAIN, 24));
        buttonTask4AlgorithmLZ.setForeground(Color.white);
        buttonTask4AlgorithmLZ.setVisible(true);

        labelTextTask4.setText("<html>Task 4. Compression algorithms: LZ77, LZ78, LZSS</html>");
        labelTextTask4.setBounds(10,250,450,40);
        labelTextTask4.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTextTask4.setForeground(Color.white);

        formPanel.repaint();
        pack();
        buttonTask1Graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormTask1Graph task1= new FormTask1Graph();
                JFrame task1Frame = new JFrame("ProjectTOI/Task1");
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
                JFrame task2Frame = new JFrame("ProjectTOI/Task2");
                task2Frame.setContentPane(new FormTask2Tree().getmainPanel());
                task2Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                task2Frame.pack();
                task2Frame.setVisible(true);
            }
        });
        buttonTask3Compression.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame task3Frame = new JFrame("ProjectTOI/Task3");
                task3Frame.setContentPane(new FormTask3Compression().getmainPanel());
                task3Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                task3Frame.pack();
                task3Frame.setVisible(true);
            }
        });
        buttonTask4AlgorithmLZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame task4Frame = new JFrame("ProjectTOI/Task4");
                task4Frame.setContentPane(new FormTask4AlgorithmLZ().getmainPanel());
                task4Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                task4Frame.pack();
                task4Frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new FormMain();
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
