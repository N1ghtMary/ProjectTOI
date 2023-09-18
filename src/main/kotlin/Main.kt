import java.awt.EventQueue
import java.awt.GridBagConstraints.BASELINE
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import javax.swing.*

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    //println("Program arguments: ${args.joinToString()}")

    // new FormMain();
    val mainFrame = JFrame("Main")
    mainFrame.contentPane = FormMain().panelMain
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    // mainFrame.setSize(600, 400);
    // mainFrame.setSize(600, 400);
    mainFrame.pack()
    mainFrame.isVisible = true

}

class FormTask1 : FormTask1Graph()
{
    lateinit var panelTask1Graph: JPanel
    lateinit var buttonReadUserEdgeGraph: JButton
    lateinit var radioButtonDirected:JRadioButton
    lateinit var textAreaUserEdgeGraph: JTextArea
    lateinit var labelTest: JLabel
    override fun getPanelRadioButton(): JPanel {
        if(radioButtonDirected.isSelected) {
            textAreaUserEdgeGraph.text ="Hey"
        } else {
            labelTest.text = "Not hey"
        }
        //buttonReadUserEdgeGraph.cli

        return super.getPanelRadioButton()

    }

}




