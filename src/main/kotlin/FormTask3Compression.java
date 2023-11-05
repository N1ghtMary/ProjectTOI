import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FormTask3Compression {
    private JPanel mainPanel;
    private JPanel panelTitle;
    private JLabel labelTitle;
    private JPanel panelUserInterface;
    private JRadioButton radioButtonWord;
    private JRadioButton radioButtonProbability;
    private JTextField textFieldWord;
    private JTable tableResult;
    private JButton buttonCompress;

    public FormTask3Compression()
    {
        mainPanel.setBounds(0,0,450,410);

        labelTitle.setText("ProjectTOI/Task3");
        labelTitle.setBounds(0,0,550,40);
        labelTitle.setSize(550,40);
        labelTitle.setBackground(new Color(50,50,50));
        labelTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTitle.setForeground(Color.white);
        panelTitle.setBackground(new Color(50,50,50));

        panelUserInterface.setBackground(new Color(49,56,102));
        panelUserInterface.setLayout(null);

        radioButtonWord.setBounds(5,5, 100, 20);
        radioButtonWord.setBackground(new Color(49,56,102));
        radioButtonWord.setFont(new Font("Roboto", Font.PLAIN, 14));
        radioButtonWord.setForeground(Color.white);

        radioButtonProbability.setBounds(110,5, 100, 20);
        radioButtonProbability.setBackground(new Color(49,56,102));
        radioButtonProbability.setFont(new Font("Roboto", Font.PLAIN, 14));
        radioButtonProbability.setForeground(Color.white);

        textFieldWord.setBackground(new Color(125,113,216));
        textFieldWord.setForeground(Color.white);
        textFieldWord.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldWord.setCaretColor(new Color(50,50,50));
        textFieldWord.setBounds(215,5, 330, 20);
        textFieldWord.setVisible(false);

        DefaultTableModel modelCompressionResult = new DefaultTableModel();
        modelCompressionResult.addColumn("X");
        modelCompressionResult.addRow(new Object[]{"X"});
        modelCompressionResult.addRow(new Object[]{"P (0-1)"});
        modelCompressionResult.addRow(new Object[]{"Shannon-Fano"});
        modelCompressionResult.addRow(new Object[]{"Huffman"});

        tableResult.setModel(modelCompressionResult);
        tableResult.setBackground(new Color(125,113,216));
        tableResult.setForeground(Color.white);
        tableResult.setFont(new Font("Roboto", Font.PLAIN, 14));
        tableResult.setBounds(5,30, 330, 335);
        tableResult.setGridColor(Color.white);

        buttonCompress.setBackground(new Color(125,113,216));
        buttonCompress.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonCompress.setForeground(Color.white);
        buttonCompress.setBounds(340,30,205,50);
        buttonCompress.setText("Compress");

        radioButtonWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonWord.isSelected())
                {
                    radioButtonProbability.setSelected(false);
                    textFieldWord.setVisible(true);
                }
            }
        });
        radioButtonProbability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonProbability.isSelected())
                {
                    radioButtonWord.setSelected(false);
                    textFieldWord.setVisible(false);
                }
            }
        });
        buttonCompress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // modelCompressionResult.setColumnCount(0);
                String userWord=textFieldWord.getText().toLowerCase();
                classCompression.addNode(userWord);
                classCompression.buildTree();
               // classCompression.Node root = classCompression.buildTree();
                //Map<Character, String> encodingMap = classCompression.buildShannonFanoMap(root);
                classCompression.showWordCodeTableModel(modelCompressionResult);
               /* double[] letterProbabilityArray = new double[charCountMap.size()];
                int index = 0;
                for(Map.Entry<Character, Integer> entryProbability:charCountMap.entrySet())
                {
                    double calculationLetterProbability = (double) entryProbability.getValue()/userWord.length();
                    letterProbabilityArray[index++] = calculationLetterProbability;
                }*/
            }
        });
    }

    public static void main(String[] args) {
        new FormTask3Compression();
    }

    public Container getmainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
