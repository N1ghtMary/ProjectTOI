import javax.swing.JFrame

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