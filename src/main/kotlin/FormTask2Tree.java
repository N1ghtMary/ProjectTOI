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
    private JList listDepthFirstSearch;
    private JButton buttonShowDepthFirstSearch;
    private JButton buttonShowBreadthFirstSearch;
    private JButton buttonSearchNode;
    private JButton buttonDeleteNode;

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
        panelUserInterface.setLayout(null);

        textFieldAddNode.setBackground(new Color(125,113,216));
        textFieldAddNode.setForeground(Color.white);
        textFieldAddNode.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldAddNode.setCaretColor(new Color(50,50,50));
        textFieldAddNode.setBounds(120,5, 170, 20);

        buttonAddNode.setBackground(new Color(125,113,216));
        buttonAddNode.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonAddNode.setForeground(Color.white);
        buttonAddNode.setBounds(120,32,170,50);
        buttonShowDepthFirstSearch.setBackground(new Color(125,113,216));
        buttonShowDepthFirstSearch.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonShowDepthFirstSearch.setForeground(Color.white);
        buttonShowDepthFirstSearch.setBounds(120,203,170,50);
        buttonShowBreadthFirstSearch.setBackground(new Color(125,113,216));
        buttonShowBreadthFirstSearch.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonShowBreadthFirstSearch.setForeground(Color.white);
        buttonShowBreadthFirstSearch.setBounds(120,260,170,50);
        buttonDeleteNode.setBackground(new Color(125,113,216));
        buttonDeleteNode.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonDeleteNode.setForeground(Color.white);
        buttonDeleteNode.setBounds(120,89,170,50);
        buttonSearchNode.setBackground(new Color(125,113,216));
        buttonSearchNode.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonSearchNode.setForeground(Color.white);
        buttonSearchNode.setBounds(120,146,170,50);

        listDepthFirstSearch.setFont(new Font("Roboto", Font.PLAIN, 14));
        listDepthFirstSearch.setForeground(Color.white);
        listDepthFirstSearch.setBackground(new Color(125,113,216));
        listDepthFirstSearch.setBounds(410,5,135,360);
        DefaultListModel<Integer> modelBinaryTreeSearch;
        modelBinaryTreeSearch = new DefaultListModel<>();
        listDepthFirstSearch.setModel(modelBinaryTreeSearch);

        mainPanel.repaint();
        classBinaryTree actionBinaryTree = new classBinaryTree();

        buttonAddNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newNode = 0;
                try {
                    newNode = Integer.parseInt(textFieldAddNode.getText());
                } catch (Exception emptyTB) {
                    JOptionPane.showMessageDialog(buttonAddNode, "Enter any digit!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                actionBinaryTree.addNode(newNode);
            }
        });
        buttonShowDepthFirstSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelBinaryTreeSearch.clear();
                actionBinaryTree.depthFirstSearchInOrder(modelBinaryTreeSearch);
            }
        });
        buttonShowBreadthFirstSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelBinaryTreeSearch.clear();
                actionBinaryTree.breadthFirstSearchLvlOrder(modelBinaryTreeSearch);
            }
        });
        buttonDeleteNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int deleteNode = 0;
                try {
                    deleteNode = Integer.parseInt(textFieldAddNode.getText());
                } catch (Exception emptyTB) {
                    JOptionPane.showMessageDialog(buttonAddNode, "Enter any digit!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                boolean successOrNot = actionBinaryTree.deleteNode(deleteNode);
                if(successOrNot) JOptionPane.showMessageDialog(buttonAddNode, "Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(buttonAddNode, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonSearchNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int searchNode = 0;
                try {
                    searchNode = Integer.parseInt(textFieldAddNode.getText());
                } catch (Exception emptyTB) {
                    JOptionPane.showMessageDialog(buttonAddNode, "Enter any digit!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                boolean successOrNot = actionBinaryTree.searchNode(searchNode);
                if(successOrNot) JOptionPane.showMessageDialog(buttonAddNode, "Founded!", "Success", JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(buttonAddNode, "No such value", "Success", JOptionPane.ERROR_MESSAGE);
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
