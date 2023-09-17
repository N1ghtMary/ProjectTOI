import javax.swing.*;

public class FormTask1Graph extends JFrame{
    private JPanel panelTask1Graph;
    private JPanel panelRadioButtonDirectionGraph;
    private JPanel panelUserEdgeGraph;
    private JPanel panelResultMatrixGraph;
    private JRadioButton radioButtonDirected;
    private JRadioButton radioButtonUndirectedGraph;
    private JTextArea textAreaUserEdgeGraph;
    private JTable tableMatrixAdjacency;

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
