import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormTask4AlgorithmLZ {

    private JPanel mainPanel;
    private JPanel panelTitle;
    private JLabel labelTitle;
    private JPanel panelUserInterface;
    private JRadioButton radioButtonLZ77;
    private JRadioButton radioButtonLZSS;
    private JTextField textFieldInputString;
    private JTable tableResult;
    private JButton buttonCompress;
    private JLabel labelEnterString;
    private JButton buttonClear;
    private JRadioButton radioButtonLZ78;
    private JScrollPane panelScrollTable;
    private JLabel labelWindowSize;
    private JLabel labelBufferSize;
    private JTextField textFieldWindowSize;
    private JTextField textFieldBufferSize;

    public FormTask4AlgorithmLZ()
    {
        mainPanel.setBounds(0,0,550,410);

        labelTitle.setText("ProjectTOI/Task4");
        labelTitle.setBounds(0,0,550,40);
        labelTitle.setSize(550,40);
        labelTitle.setBackground(new Color(50,50,50));
        labelTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelTitle.setForeground(Color.white);
        panelTitle.setBackground(new Color(50,50,50));

        panelUserInterface.setBackground(new Color(49,56,102));
        panelUserInterface.setLayout(null);

        radioButtonLZ77.setBounds(10,10, 90, 30);
        radioButtonLZ77.setBackground(new Color(49,56,102));
        radioButtonLZ77.setFont(new Font("Roboto", Font.PLAIN, 14));
        radioButtonLZ77.setForeground(Color.white);
        radioButtonLZ77.setBorder(new MatteBorder(0, 0, 0, 1, new Color(125,113,216)));

        radioButtonLZSS.setBounds(10,40, 90, 30);
        radioButtonLZSS.setBackground(new Color(49,56,102));
        radioButtonLZSS.setFont(new Font("Roboto", Font.PLAIN, 14));
        radioButtonLZSS.setForeground(Color.white);
        radioButtonLZSS.setBorder(new MatteBorder(0, 0, 0, 1, new Color(125,113,216)));

        radioButtonLZ78.setBounds(10,70, 90, 30);
        radioButtonLZ78.setBackground(new Color(49,56,102));
        radioButtonLZ78.setFont(new Font("Roboto", Font.PLAIN, 14));
        radioButtonLZ78.setForeground(Color.white);
        radioButtonLZ78.setBorder(new MatteBorder(0, 0, 0, 1, new Color(125,113,216)));

        labelEnterString.setBackground(new Color(125,113,216));
        labelEnterString.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelEnterString.setForeground(Color.white);
        labelEnterString.setBounds(110,5,200,20);
        labelEnterString.setText("Enter string for compression");

        labelWindowSize.setBackground(new Color(125,113,216));
        labelWindowSize.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelWindowSize.setForeground(Color.white);
        labelWindowSize.setBounds(330,5,105,20);
        labelWindowSize.setText("Window size");

        labelBufferSize.setBackground(new Color(125,113,216));
        labelBufferSize.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelBufferSize.setForeground(Color.white);
        labelBufferSize.setBounds(440,5,105,20);
        labelBufferSize.setText("Buffer size");

        textFieldInputString.setBackground(new Color(125,113,216));
        textFieldInputString.setForeground(Color.white);
        textFieldInputString.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldInputString.setCaretColor(new Color(50,50,50));
        textFieldInputString.setBounds(110,30, 215, 20);

        textFieldBufferSize.setBackground(new Color(125,113,216));
        textFieldBufferSize.setForeground(Color.white);
        textFieldBufferSize.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldBufferSize.setCaretColor(new Color(50,50,50));
        textFieldBufferSize.setBounds(440,30, 105, 20);
        textFieldBufferSize.setEditable(false);

        textFieldWindowSize.setBackground(new Color(125,113,216));
        textFieldWindowSize.setForeground(Color.white);
        textFieldWindowSize.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldWindowSize.setCaretColor(new Color(50,50,50));
        textFieldWindowSize.setBounds(330,30, 105, 20);
        textFieldWindowSize.setEditable(false);

        buttonCompress.setBackground(new Color(125,113,216));
        buttonCompress.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonCompress.setForeground(Color.white);
        buttonCompress.setBounds(110,55,215,45);
        buttonCompress.setText("Compress");

        buttonClear.setBackground(new Color(125,113,216));
        buttonClear.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonClear.setForeground(Color.white);
        buttonClear.setBounds(330,55,215,45);
        buttonClear.setText("Clear");

        DefaultTableModel modelAlgorithmLZResult = new DefaultTableModel();

        tableResult.setModel(modelAlgorithmLZResult);
        tableResult.setBackground(new Color(125,113,216));
        tableResult.setForeground(Color.white);
        tableResult.setFont(new Font("Roboto", Font.PLAIN, 14));
        tableResult.setBounds(5,105, 540, 260);
        tableResult.setGridColor(Color.white);

        panelScrollTable.setBackground(new Color(125,113,216));
        panelScrollTable.setBounds(5,105, 540, 260);
        panelScrollTable.setForeground(new Color(125,113,216));
        panelScrollTable.getVerticalScrollBar().setBackground(new Color(125,113,216));
        panelScrollTable.getHorizontalScrollBar().setBackground(new Color(125,113,216));
        panelScrollTable.getViewport().setBackground(new Color(125,113,216));


        radioButtonLZ77.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonLZ77.isSelected())
                {
                    radioButtonLZ78.setSelected(false);
                    radioButtonLZSS.setSelected(false);
                    textFieldBufferSize.setEditable(true);
                    labelBufferSize.setText("Buffer size");
                    textFieldWindowSize.setEditable(true);
                    labelWindowSize.setText("Window size");
                }
            }
        });
        radioButtonLZSS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonLZSS.isSelected())
                {
                    radioButtonLZ78.setSelected(false);
                    radioButtonLZ77.setSelected(false);
                    textFieldBufferSize.setEditable(true);
                    labelBufferSize.setText("Buffer size");
                    textFieldWindowSize.setEditable(true);
                    labelWindowSize.setText("Window size");
                }
            }
        });
        radioButtonLZ78.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonLZ78.isSelected())
                {
                    radioButtonLZSS.setSelected(false);
                    radioButtonLZ77.setSelected(false);
                    textFieldBufferSize.setEditable(false);
                    labelBufferSize.setText("");
                    textFieldWindowSize.setEditable(true);
                    labelWindowSize.setText("Window size");
                }
            }
        });
        buttonCompress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonLZ77.isSelected())
                {
                    modelAlgorithmLZResult.setRowCount(0);
                    modelAlgorithmLZResult.setColumnCount(0);
                    modelAlgorithmLZResult.addColumn("Window");
                    modelAlgorithmLZResult.addColumn("Buffer");
                    modelAlgorithmLZResult.addColumn("Code");
                    String inputUser=textFieldInputString.getText();
                    int MAX_WINDOW_SIZE = Integer.parseInt(textFieldWindowSize.getText());
                    int MAX_BUFFER_SIZE = Integer.parseInt(textFieldBufferSize.getText());
                    classAlgorithmLZ.algorithmLZ77(inputUser, MAX_BUFFER_SIZE, MAX_WINDOW_SIZE);
                    classAlgorithmLZ.printOutput(modelAlgorithmLZResult, modelAlgorithmLZResult.getColumnCount());
                }
                if(radioButtonLZSS.isSelected())
                {
                    modelAlgorithmLZResult.setRowCount(0);
                    modelAlgorithmLZResult.setColumnCount(0);
                    modelAlgorithmLZResult.addColumn("Window");
                    modelAlgorithmLZResult.addColumn("Buffer");
                    modelAlgorithmLZResult.addColumn("Code");
                    modelAlgorithmLZResult.addColumn("Lenght");
                    String inputUser=textFieldInputString.getText();
                    int MAX_WINDOW_SIZE = Integer.parseInt(textFieldWindowSize.getText());
                    int MAX_BUFFER_SIZE = Integer.parseInt(textFieldBufferSize.getText());
                    classAlgorithmLZ.algorithmLZSS(inputUser, MAX_BUFFER_SIZE, MAX_WINDOW_SIZE);
                    classAlgorithmLZ.printOutput(modelAlgorithmLZResult, modelAlgorithmLZResult.getColumnCount());
                }
                if(radioButtonLZ78.isSelected())
                {
                    modelAlgorithmLZResult.setRowCount(0);
                    modelAlgorithmLZResult.setColumnCount(0);
                    modelAlgorithmLZResult.addColumn("Window");
                    modelAlgorithmLZResult.addColumn("Code");
                    modelAlgorithmLZResult.addColumn("Position");
                    String inputUser=textFieldInputString.getText();
                }
            }
        });
    }

    public static void main(String[] args) {
        new FormTask4AlgorithmLZ();
    }

    public Container getmainPanel() {
        return mainPanel;
    }
}
