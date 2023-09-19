import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormTask1Graph extends JFrame{
    private JPanel panelTask1Graph;
    private JPanel panelRadioButtonDirectionGraph;
    private JPanel panelUserEdgeGraph;
    private JRadioButton radioButtonDirected;
    private JRadioButton radioButtonUndirectedGraph;
    private JTextArea textAreaUserEdgeGraph;
    private JButton buttonReadUserEdgeGraph;
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
    private JTable tableAdjacencyList;
    private JLabel labelAdjMatrix;
    private JScrollPane paneScrollAdjacencyMatrix;
    private JTable tableAdjacencyMatrix;
    private JLabel labelIncidenceMatrix;
    private JScrollPane paneScrollIncidenceMatrix;
    private JTable tableIncidenceMatrix;
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
        Object[] column = {"Beginning","Ending"};
        final Object[] row = new Object[4];
        modelUserEdgesGraph.setColumnIdentifiers(column);
        tableUserEdgesGraph.setModel(modelUserEdgesGraph);
        //paneScrollForUserTable.setViewportView(tableUserEdgesGraph);

         buttonReadUserEdgeGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = textAreaUserEdgeGraph.getText();
                int[][] userEdgeGraph = new int[0][0];
                for(int i = 0; i<userText.length(); i++)
                {
                    for(int j = 0; j<2 ; j++)
                    {
                      //  userEdgeGraph[i][j]= Arrays.stream(userText.split("\\n")).toArray();
                    }
                }
                if(radioButtonDirected.isSelected()) {
                    textAreaUserEdgeGraph.setText("Hey");
                } else {
                    labelTest.setText("Not Hey");
                }
            }
        });
        int[][] edgesGraphArray = new int[10][2];
        //tableUserEdgesCheck.setAutoCreateColumnsFromModel(true);
        //tableUserEdgesCheck.getAutoResizeMode();
        //tableUserEdgesCheck.addColumn(2);
        buttonUserEdgesGraphWrite.addActionListener(new ActionListener() {
            int countEdges = 0;
            //String[] columnNames = {"Beginning", "Ending"};
            //JTable table = tableUserEdgesCheck;
            //DefaultTableModel model = (DefaultTableModel)table.getModel();

            @Override
            public void actionPerformed(ActionEvent e) {
                //do{
                if(countEdges<10)
                {edgesGraphArray[countEdges][0] = (int) comboBoxStartGraph.getSelectedItem();
                edgesGraphArray[countEdges][1] = (int) comboBoxEndGraph.getSelectedItem();
                //tableUserEdgesCheck.setValueAt(edgesGraphArray[countEdges][0],countEdges,1);
                //tableUserEdgesCheck.setValueAt(edgesGraphArray[countEdges][1],countEdges++,2);
                //labelTest.setText(String.valueOf(countEdges));
                //JList<Integer> listShowArray = list1;
                //DefaultListModel<Integer> model = new DefaultListModel<>();

               // for(int i = 0; i< edgesGraphArray.length;i++)
                //{
                  //  for(int j = 0; j< edgesGraphArray.length;j++) {
                        modelUserEdgesGraph.addRow(new Object[]{edgesGraphArray[countEdges][0],edgesGraphArray[countEdges][1]});
                    //model.setValueAt(, countEdges, 1);
                    //tableUserEdgesGraph.setValueAt(edgesGraphArray[countEdges][0],countEdges,0);
                    //tableUserEdgesCheck.setValueAt(edgesGraphArray[countEdges][1],countEdges,1);
                    //}
                //}
                    //JFrame frame = new JFrame();
                    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //FormTask1Graph frame = new FormTask1Graph();
                    //tableUserEdgesCheck.getModel();
                    //frame.getContentPane().add(new JScrollPane(tableUserEdgesCheck));
                    //frame.pack();
                   // frame.setVisible(true);
               // tableUserEdgesCheck = new JTable(model);


                    //FormTask1Graph frame = new FormTask1Graph();
                    //JTable table = new JTable(edgesGraphArray.length, edgesGraphArray[0].length);
                    /*for (int i = 0; i < edgesGraphArray.length; i++) {
                        for (int j = 0; j < edgesGraphArray[i].length; j++) {
                            tableUserEdgesGraph.setValueAt(edgesGraphArray[i][j], i, j);
                        }
                    }*/

                    //frame.add(new JScrollPane(tableUserEdgesCheck));
                    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //frame.pack();
                    //frame.setVisible(true);
                countEdges++;}
                else{
                    JOptionPane.showMessageDialog(null, "You cant enter more than 10 edges");
                }
                //}
                //while(countEdges <10);

            }
        });
    }

    public static void main(String[] args) {
     /*   // new FormMain();
        JFrame task1Frame = new JFrame("Main");
        task1Frame.setContentPane(new FormTask1Graph().panelRadioButton);
        task1Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // mainFrame.setSize(600, 400);
        task1Frame.pack();
        task1Frame.setVisible(true);

        // new Main();*/
    }

    public JPanel getPanelRadioButton() {
        return panelTask1Graph;
    }


}
