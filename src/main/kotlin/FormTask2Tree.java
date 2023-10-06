import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormTask2Tree {
    private JPanel mainPanel;
    private JLabel labelTitle;
    private JPanel panelTitle;
    private JPanel panelUserInterface;
    private JTextField textFieldAddNode;
    private JButton buttonAddNode;

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
        textFieldAddNode.setBackground(new Color(125,113,216));
        textFieldAddNode.setForeground(Color.white);
        textFieldAddNode.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldAddNode.setCaretColor(new Color(50,50,50));
        textFieldAddNode.setBounds(5,45, 85, 20);
        buttonAddNode.setBackground(new Color(125,113,216));
        buttonAddNode.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonAddNode.setForeground(Color.white);
        //textFieldAddNode.setSelectionColor(new Color(50,50,50));
        //textFieldAddNode.setSelectedTextColor(new Color(50,50,50));
        //panelTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
        mainPanel.repaint();
        buttonAddNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newNode = 0;
                try {
                    newNode = Integer.parseInt(textFieldAddNode.getText());
                } catch (Exception emptyTB) {
                    JOptionPane.showMessageDialog(buttonAddNode, "Enter any digit!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                classBinaryTree newElemBinaryTree = new classBinaryTree();
                newElemBinaryTree.addNode(newNode);
            }
        });
    }

    public static void main(String[] args) {
        new FormTask2Tree();
    }

    public Container getmainPanel() {
        return mainPanel;
    }
}
