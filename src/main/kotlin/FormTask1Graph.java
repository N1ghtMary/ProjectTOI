import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class FormTask1Graph extends JFrame{
    final int EDGESAMOUNT = 10;
    private JPanel panelTask1Graph;
    private JPanel panelRadioButtonDirectionGraph;
    private JRadioButton radioButtonDirectedGraph;
    private JRadioButton radioButtonUndirectedGraph;
    private JTextArea textAreaUserEdgeGraph;
    private JButton buttonCalculateGraphActs;
    private JLabel labelTest;
    private JComboBox comboBoxStartGraph;
    private JComboBox comboBoxEndGraph;
    private JLabel labelUserStartGraph;
    private JLabel labelUserEndGraph;
    private JButton buttonUserEdgesGraphWrite;
    private JScrollPane paneScrollForUserTable;
    private JTable tableUserEdgesGraph;
    private JLabel labelAdjList;
    private JScrollPane paneScrollAdjacencyList;
    private JLabel labelAdjMatrix;
    private JScrollPane paneScrollAdjacencyMatrix;
    private JTable tableAdjacencyMatrix;
    private JLabel labelIncidenceMatrix;
    private JScrollPane paneScrollIncidenceMatrix;
    private JTable tableIncidenceMatrix;
    private JList listAdjacencyList;
    private JPanel panelTitle;
    private JLabel labelTitle;
    private JButton buttonClear;
    private JTable tableUserEdgesCheck;

    public FormTask1Graph() {
        comboBoxEndGraph.setEditable(false);
        comboBoxStartGraph.setEditable(false);
        comboBoxStartGraph.addItem(1);
        comboBoxStartGraph.addItem(2);
        comboBoxStartGraph.addItem(3);
        comboBoxStartGraph.addItem(4);
        comboBoxStartGraph.addItem(5);

        comboBoxEndGraph.addItem(1);
        comboBoxEndGraph.addItem(2);
        comboBoxEndGraph.addItem(3);
        comboBoxEndGraph.addItem(4);
        comboBoxEndGraph.addItem(5);

        panelTask1Graph.setLayout(null);
        panelTask1Graph.setBounds(0,0,550,410);

        labelTitle.setText("ProjectTOI/Task1");
        labelTitle.setBounds(0,0,550,40);
        labelTitle.setSize(550,40);
        labelTitle.setBackground(new Color(50,50,50));
        labelTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTitle.setForeground(Color.white);
        labelTitle.setOpaque(true);
        panelTitle.setBackground(new Color(50,50,50));
        panelRadioButtonDirectionGraph.setLayout(null);
        panelRadioButtonDirectionGraph.setBounds(0,40,550,370);
        panelRadioButtonDirectionGraph.setBackground(new Color(49,56,102));

        radioButtonDirectedGraph.setBounds(5,0, 150, 30);
        radioButtonDirectedGraph.setBackground(new Color(49,56,102));
        radioButtonDirectedGraph.setFont(new Font("Roboto", Font.PLAIN, 14));
        radioButtonDirectedGraph.setForeground(Color.white);
        radioButtonDirectedGraph.setBorder(new MatteBorder(0, 0, 0, 1, new Color(125,113,216)));

        radioButtonUndirectedGraph.setBounds(5,25, 150, 30);
        radioButtonUndirectedGraph.setBackground(new Color(49,56,102));
        radioButtonUndirectedGraph.setFont(new Font("Roboto", Font.PLAIN, 14));
        radioButtonUndirectedGraph.setForeground(Color.white);
        radioButtonUndirectedGraph.setBorder(new MatteBorder(0, 0, 0, 1, new Color(125,113,216)));

        labelUserStartGraph.setBackground(new Color(125,113,216));
        labelUserStartGraph.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelUserStartGraph.setForeground(Color.white);
        labelUserStartGraph.setBounds(155,5,170,20);
        labelUserStartGraph.setText("Choose beginning");
        comboBoxStartGraph.setBackground(new Color(155,40,229));
        comboBoxStartGraph.setFont(new Font("Roboto", Font.PLAIN, 14));
        comboBoxStartGraph.setForeground(Color.white);
        comboBoxStartGraph.setBounds(155,30,190,20);

        labelUserEndGraph.setBackground(new Color(125,113,216));
        labelUserEndGraph.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelUserEndGraph.setForeground(Color.white);
        labelUserEndGraph.setBounds(355,5,170,20);
        labelUserEndGraph.setText("Choose ending");
        comboBoxEndGraph.setBackground(new Color(155,40,229));
        comboBoxEndGraph.setFont(new Font("Roboto", Font.PLAIN, 14));
        comboBoxEndGraph.setForeground(Color.white);
        comboBoxEndGraph.setBounds(355,30,190,20);

        buttonCalculateGraphActs.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonCalculateGraphActs.setText("Calculate");
        buttonCalculateGraphActs.setBounds(155,55,125,40);
        buttonCalculateGraphActs.setBackground(new Color(125,113,216));
        buttonCalculateGraphActs.setForeground(Color.white);
        buttonCalculateGraphActs.setVisible(true);

        buttonUserEdgesGraphWrite.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonUserEdgesGraphWrite.setText("Write edges");
        buttonUserEdgesGraphWrite.setBounds(285,55,125,40);
        buttonUserEdgesGraphWrite.setBackground(new Color(125,113,216));
        buttonUserEdgesGraphWrite.setForeground(Color.white);
        buttonUserEdgesGraphWrite.setVisible(true);

        buttonClear.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonClear.setText("Clear");
        buttonClear.setBounds(415,55,130,40);
        buttonClear.setBackground(new Color(125,113,216));
        buttonClear.setForeground(Color.white);
        buttonClear.setVisible(true);

        labelAdjList.setBackground(new Color(125,113,216));
        labelAdjList.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelAdjList.setForeground(Color.white);
        labelAdjList.setBounds(155,100,100,20);
        labelAdjList.setText("Adjacency list");

        listAdjacencyList.setFont(new Font("Roboto", Font.PLAIN, 14));
        listAdjacencyList.setBounds(260,100,285,80);
        listAdjacencyList.setBackground(new Color(125,113,216));
        listAdjacencyList.setForeground(Color.white);

        labelAdjMatrix.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelAdjMatrix.setBounds(155,185,100,30);
        labelAdjMatrix.setBackground(new Color(125,113,216));
        labelAdjMatrix.setForeground(Color.white);
        labelAdjMatrix.setText("<html>Adjacency matrix</html>");

        labelIncidenceMatrix.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelIncidenceMatrix.setBounds(155,280,100,30);
        labelIncidenceMatrix.setBackground(new Color(125,113,216));
        labelIncidenceMatrix.setForeground(Color.white);
        labelIncidenceMatrix.setText("<html>Incidence matrix</html>");

        DefaultTableModel modelUserEdgesGraph;
        modelUserEdgesGraph = new DefaultTableModel();
        Object[] columnUserEdgesGraph = {"Beginning","Ending"};
        final Object[] rowUserEdgesGraph = new Object[0];
        modelUserEdgesGraph.setColumnIdentifiers(columnUserEdgesGraph);
        tableUserEdgesGraph.setModel(modelUserEdgesGraph);
        tableUserEdgesGraph.setBackground(new Color(125,113,216));
        tableUserEdgesGraph.setForeground(Color.white);
        tableUserEdgesGraph.setFont(new Font("Roboto", Font.PLAIN, 14));
        tableUserEdgesGraph.setBounds(0,0, 145, 310);
        tableUserEdgesGraph.setGridColor(Color.white);
        paneScrollForUserTable.setBackground(new Color(125,113,216));
        paneScrollForUserTable.setBounds(5,55, 145, 310);
        paneScrollForUserTable.setForeground(new Color(125,113,216));
        paneScrollForUserTable.getVerticalScrollBar().setBackground(new Color(125,113,216));
        paneScrollForUserTable.getHorizontalScrollBar().setBackground(new Color(125,113,216));
        paneScrollForUserTable.getViewport().setBackground(new Color(125,113,216));

        DefaultListModel<String> modelAdjacencyList;
        modelAdjacencyList = new DefaultListModel<>();
        listAdjacencyList.setModel(modelAdjacencyList);

        DefaultTableModel modelAdjacencyMatrix;
        modelAdjacencyMatrix = new DefaultTableModel();
        Object[] columnAdjacencyMatrix = {"v1","v2","v3","v4","v5"};
        final Object[] rowAdjacencyMatrix = new Object[0];
        modelAdjacencyMatrix.setColumnIdentifiers(columnAdjacencyMatrix);
        tableAdjacencyMatrix.setModel(modelAdjacencyMatrix);

        tableAdjacencyMatrix.setBackground(new Color(125,113,216));
        tableAdjacencyMatrix.setForeground(Color.white);
        tableAdjacencyMatrix.setFont(new Font("Roboto", Font.PLAIN, 14));
        tableAdjacencyMatrix.setBounds(0,0, 285, 80);
        tableAdjacencyMatrix.setGridColor(Color.white);
        paneScrollAdjacencyMatrix.setBackground(new Color(125,113,216));
        paneScrollAdjacencyMatrix.setBounds(260,185, 285, 90);
        paneScrollAdjacencyMatrix.setForeground(new Color(125,113,216));
        paneScrollAdjacencyMatrix.getVerticalScrollBar().setBackground(new Color(125,113,216));
        paneScrollAdjacencyMatrix.getHorizontalScrollBar().setBackground(new Color(125,113,216));
        paneScrollAdjacencyMatrix.getViewport().setBackground(new Color(125,113,216));

        DefaultTableModel modelIncidenceMatrix;
        modelIncidenceMatrix = new DefaultTableModel();
        Object[] columnIncidenceMatrix = {"e1","e2","e3","e4","e5","e6","e7","e8","e9","e10"};
        final Object[] rowIncidenceMatrix = new Object[0];
        modelIncidenceMatrix.setColumnIdentifiers(columnIncidenceMatrix);
        tableIncidenceMatrix.setModel(modelIncidenceMatrix);

        tableAdjacencyMatrix.setBackground(new Color(125,113,216));
        tableAdjacencyMatrix.setForeground(Color.white);
        tableAdjacencyMatrix.setFont(new Font("Roboto", Font.PLAIN, 14));
        tableAdjacencyMatrix.setBounds(0,0, 285, 80);
        tableAdjacencyMatrix.setGridColor(Color.white);
        paneScrollIncidenceMatrix.setBackground(new Color(125,113,216));
        paneScrollIncidenceMatrix.setBounds(260,280, 285, 85);
        paneScrollIncidenceMatrix.setForeground(new Color(125,113,216));
        paneScrollIncidenceMatrix.getVerticalScrollBar().setBackground(new Color(125,113,216));
        paneScrollIncidenceMatrix.getHorizontalScrollBar().setBackground(new Color(125,113,216));
        paneScrollIncidenceMatrix.getViewport().setBackground(new Color(125,113,216));

        int[][] edgesGraphArray = new int[EDGESAMOUNT][2];
        List<List<Integer>> cities = new ArrayList<>();
        Stream stream = cities.stream();

        ListIterator li1= cities.listIterator();
        while(li1.hasNext()) {
            Object element = li1.next();

            //ListIterator li2 = element;
            //li1.set(element + "+");
        }
         buttonCalculateGraphActs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classCalculateGraphs calculateGraphs = new classCalculateGraphs();
                if(radioButtonUndirectedGraph.isSelected() && !radioButtonDirectedGraph.isSelected()) {
                    int typeGraphUndirected = 1;
                    int typeMatrixOutput = 0;
                    calculateGraphs.funFillTableModel(calculateGraphs.funCalculateAdjacencyMatrix(edgesGraphArray,typeGraphUndirected),
                            modelAdjacencyMatrix,typeMatrixOutput);
                    typeMatrixOutput++;
                    calculateGraphs.funFillTableModel(calculateGraphs.funCalculateIncidenceMatrix(edgesGraphArray,typeGraphUndirected,EDGESAMOUNT),
                            modelIncidenceMatrix,typeMatrixOutput);
                    calculateGraphs.funFillAdjacencyListModel(calculateGraphs.funCalculateAdjacencyList(edgesGraphArray,typeGraphUndirected,EDGESAMOUNT),
                            modelAdjacencyList);
                } else if(radioButtonDirectedGraph.isSelected() && !radioButtonUndirectedGraph.isSelected()){
                    int typeGraphDirected = 2;
                    int typeMatrixOutput = 0;
                    calculateGraphs.funFillTableModel(calculateGraphs.funCalculateAdjacencyMatrix(edgesGraphArray,typeGraphDirected),
                            modelAdjacencyMatrix,typeMatrixOutput);
                    typeMatrixOutput++;
                    calculateGraphs.funFillTableModel(calculateGraphs.funCalculateIncidenceMatrix(edgesGraphArray,typeGraphDirected,EDGESAMOUNT),
                            modelIncidenceMatrix,typeMatrixOutput);
                    calculateGraphs.funFillAdjacencyListModel(calculateGraphs.funCalculateAdjacencyList(edgesGraphArray,typeGraphDirected,EDGESAMOUNT),
                            modelAdjacencyList);
                }
            }
        });

        buttonUserEdgesGraphWrite.addActionListener(new ActionListener() {
            int countEdges = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                //do{
                if(countEdges<EDGESAMOUNT)
                {edgesGraphArray[countEdges][0] = (int) comboBoxStartGraph.getSelectedItem();
                edgesGraphArray[countEdges][1] = (int) comboBoxEndGraph.getSelectedItem();

                        modelUserEdgesGraph.addRow(new Object[]{edgesGraphArray[countEdges][0],edgesGraphArray[countEdges][1]});

                countEdges++;}
                else{
                    JOptionPane.showMessageDialog(null, "You cant enter more than 10 edges");
                }

            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                comboBoxStartGraph.setSelectedIndex(0);
                comboBoxEndGraph.setSelectedIndex(0);
                modelUserEdgesGraph.setRowCount(0);
                modelAdjacencyList.clear();
                modelIncidenceMatrix.setRowCount(0);
                modelAdjacencyMatrix.setRowCount(0);
                }
                catch (Exception everything)
                {
                    JOptionPane.showMessageDialog(buttonClear, "Something went wrong, try again never", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        radioButtonDirectedGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonDirectedGraph.isSelected())
                    radioButtonUndirectedGraph.setSelected(false);
            }
        });
        radioButtonUndirectedGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonUndirectedGraph.isSelected())
                    radioButtonDirectedGraph.setSelected(false);
            }
        });
    }

    public static void main(String[] args) {

    }

    public JPanel getPanelRadioButton() {
        return panelTask1Graph;
    }


}
