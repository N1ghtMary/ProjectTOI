import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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

        textFieldInputString.setBackground(new Color(125,113,216));
        textFieldInputString.setForeground(Color.white);
        textFieldInputString.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldInputString.setCaretColor(new Color(50,50,50));
        textFieldInputString.setBounds(110,30, 435, 20);

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
        modelAlgorithmLZResult.addColumn("Dictionary (8)");
        modelAlgorithmLZResult.addColumn("Buffer (5)");
        modelAlgorithmLZResult.addColumn("Code");
        modelAlgorithmLZResult.addRow(new Object[]{"Dictionary (8)","Buffer (5)","Code"});

        tableResult.setModel(modelAlgorithmLZResult);
        tableResult.setBackground(new Color(125,113,216));
        tableResult.setForeground(Color.white);
        tableResult.setFont(new Font("Roboto", Font.PLAIN, 14));
        tableResult.setBounds(5,105, 540, 260);
        tableResult.setGridColor(Color.white);
    }

    public static void main(String[] args) {
        new FormTask4AlgorithmLZ();
    }

    public Container getmainPanel() {
        return mainPanel;
    }
}
