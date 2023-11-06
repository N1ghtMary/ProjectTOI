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
    private JLabel labelEnterAmountOfLetters;
    private JTextField textFieldAmountOfColumns;
    private JButton buttonAddColumn;

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
        tableResult.setBounds(5,85, 540, 275);
        tableResult.setGridColor(Color.white);

        buttonCompress.setBackground(new Color(125,113,216));
        buttonCompress.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonCompress.setForeground(Color.white);
        buttonCompress.setBounds(410,30,135,50);
        buttonCompress.setText("Compress");

        labelEnterAmountOfLetters.setBackground(new Color(125,113,216));
        labelEnterAmountOfLetters.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelEnterAmountOfLetters.setForeground(Color.white);
        labelEnterAmountOfLetters.setBounds(5,30,165,50);
        labelEnterAmountOfLetters.setText("Enter amount of symbols");

        textFieldAmountOfColumns.setBackground(new Color(125,113,216));
        textFieldAmountOfColumns.setForeground(Color.white);
        textFieldAmountOfColumns.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldAmountOfColumns.setCaretColor(new Color(50,50,50));
        textFieldAmountOfColumns.setBounds(165,45, 100, 20);
        textFieldAmountOfColumns.setEditable(false);

        buttonAddColumn.setBackground(new Color(125,113,216));
        buttonAddColumn.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonAddColumn.setForeground(Color.white);
        buttonAddColumn.setBounds(270,30,135,50);
        buttonAddColumn.setText("Add symbols");

        radioButtonWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonWord.isSelected())
                {
                    radioButtonProbability.setSelected(false);
                    textFieldWord.setVisible(true);
                    textFieldAmountOfColumns.setEditable(false);
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
                    textFieldAmountOfColumns.setEditable(true);
                }
            }
        });
        buttonCompress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if(textFieldWord.isVisible())
                {
                    String userWord=textFieldWord.getText().toLowerCase();
                    classCompression.addNode(userWord);
                    classCompression.buildTreeShannonFano();
                    classCompression.buildTreeHuffman();
                    classCompression.showWordCodeTableModel(modelCompressionResult);
                }
                if(textFieldAmountOfColumns.isEditable())
                {
                     Map<Character, Double> userProbability = new HashMap<>();
                     double countProbabilities=0;
                     for(int i = 1; i < modelCompressionResult.getColumnCount(); i++)
                     {
                         char keyUserProbability = modelCompressionResult.getValueAt(0,i).toString().charAt(0);
                         double valueUserProbability = Double.parseDouble(modelCompressionResult.getValueAt(1,i).toString());
                         countProbabilities+=valueUserProbability;
                         userProbability.put(keyUserProbability, valueUserProbability);
                     }
                     if(countProbabilities<=1) {
                         classCompression.addNode(userProbability);
                         classCompression.buildTreeShannonFano();
                         classCompression.buildTreeHuffman();
                         classCompression.showWordCodeTableModel(modelCompressionResult);
                     }
                     else JOptionPane.showMessageDialog(buttonCompress, "P > 1!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
                catch (Exception everything)
                {
                    JOptionPane.showMessageDialog(buttonCompress, "Not right now", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        buttonAddColumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < Integer.parseInt(textFieldAmountOfColumns.getText()); i++) {
                        modelCompressionResult.addColumn("" + i);
                        modelCompressionResult.setValueAt(i + 1, 0, i + 1);
                    }
                }
                catch (Exception everything)
                {
                    JOptionPane.showMessageDialog(buttonAddColumn, "Not a number", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
