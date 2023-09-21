import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormTask1Graph extends JFrame{
    final int EDGESAMOUNT = 10;
    private JPanel panelTask1Graph;
    private JPanel panelRadioButtonDirectionGraph;
    private JPanel panelUserEdgeGraph;
    private JRadioButton radioButtonDirectedGraph;
    private JRadioButton radioButtonUndirectedGraph;
    private JTextArea textAreaUserEdgeGraph;
    private JButton buttonCalculateGraphActs;
    private JLabel labelTest;
    private JComboBox comboBoxStartGraph;
    private JComboBox comboBoxEndGraph;
    private JLabel labelUserStartGraph;
    private JLabel labelUserEndGraph;
    private JPanel panelUserEdgesGraph;
    private JButton buttonUserEdgesGraphWrite;
    private JScrollPane paneScrollForUserTable;
    private JTable tableUserEdgesGraph;
    private JPanel panelGraphsActs;
    private JLabel labelAdjList;
    private JScrollPane paneScrollAdjacencyList;
    private JLabel labelAdjMatrix;
    private JScrollPane paneScrollAdjacencyMatrix;
    private JTable tableAdjacencyMatrix;
    private JLabel labelIncidenceMatrix;
    private JScrollPane paneScrollIncidenceMatrix;
    private JTable tableIncidenceMatrix;
    private JList listAdjacencyList;
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

        DefaultTableModel modelUserEdgesGraph;
        modelUserEdgesGraph = new DefaultTableModel();
        Object[] columnUserEdgesGraph = {"Beginning","Ending"};
        final Object[] rowUserEdgesGraph = new Object[0];
        modelUserEdgesGraph.setColumnIdentifiers(columnUserEdgesGraph);
        tableUserEdgesGraph.setModel(modelUserEdgesGraph);

        DefaultListModel<String> modelAdjacencyList;
        modelAdjacencyList = new DefaultListModel<>();
        listAdjacencyList.setModel(modelAdjacencyList);

        DefaultTableModel modelAdjacencyMatrix;
        modelAdjacencyMatrix = new DefaultTableModel();
        Object[] columnAdjacencyMatrix = {"v1","v2","v3","v4","v5"};
        final Object[] rowAdjacencyMatrix = new Object[0];
        modelAdjacencyMatrix.setColumnIdentifiers(columnAdjacencyMatrix);
        tableAdjacencyMatrix.setModel(modelAdjacencyMatrix);

        DefaultTableModel modelIncidenceMatrix;
        modelIncidenceMatrix = new DefaultTableModel();
        Object[] columnIncidenceMatrix = {"e1","e2","e3","e4","e5","e6","e7","e8","e9","e10"};
        final Object[] rowIncidenceMatrix = new Object[0];
        modelIncidenceMatrix.setColumnIdentifiers(columnIncidenceMatrix);
        tableIncidenceMatrix.setModel(modelIncidenceMatrix);

        int[][] edgesGraphArray = new int[EDGESAMOUNT][2];

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
    }

    public static void main(String[] args) {

    }

    public JPanel getPanelRadioButton() {
        return panelTask1Graph;
    }


}
