import javax.swing.table.DefaultTableModel;
import java.util.*;

public class classCompression {

    public static List<Node> nodeList = new ArrayList<>();
    public static HashMap<Character, Double> charProbabilityMap = new HashMap<>();
    public static Map<Character, Double> sortedMap = new LinkedHashMap<Character, Double>();

    public static class Node
    {
        char symbol;
        double probability;
        String code = "";

        Node(char symbol, double probability) {
            this.symbol = symbol;
            this.probability = probability;
        }
    }

    public static void addNode(String userWord)
    {

        for(char letter:userWord.toCharArray())
        {
            charProbabilityMap.put(letter, charProbabilityMap.getOrDefault(letter,0.0)+1.0/(userWord.length()));
        }

        for(Map.Entry<Character, Double> entryNodes:charProbabilityMap.entrySet())
        {
            nodeList.add(new Node(entryNodes.getKey(),entryNodes.getValue()));
        }
       nodeList.sort((probabilityLeft, probabilityRight)-> Double.compare( probabilityRight.probability,probabilityLeft.probability));
    }

    public static void buildTree() {
        Deque<List<Node>> stack = new ArrayDeque<>();
        stack.push(nodeList);

        while (!stack.isEmpty()) {
            List<Node> nodes = stack.pop();
            int mid = divide(nodes);
            if (mid != -1) {
                List<Node> left = nodes.subList(0, mid + 1);
                List<Node> right = nodes.subList(mid + 1, nodes.size());
                for (Node node : left) {
                    node.code += "0";
                }
                for (Node node : right) {
                    node.code += "1";
                }
                stack.push(right);
                stack.push(left);
            }
        }
    }
        static int divide(List<Node> nodeList) {
        if (nodeList.size() == 1) {
            return -1;
        }

        int middle = (nodeList.size()-1)/2;

        if(middle<=1) return 0;
        if(middle==2) return 1;
        int start = middle+1;
        int end=middle+2;
        double[] differenceSections = new double[nodeList.size()-1];
        double sectionFirst = nodeList.get(start).probability;
        double sectionSecond = nodeList.get(end).probability;
        while (start>=0 && end<=nodeList.size()-1 && end+1<=nodeList.size()-1 && start-1<nodeList.size()-1)
        {
            differenceSections[start]=sectionFirst-sectionSecond;
            sectionFirst += nodeList.get(start - 1).probability;
            sectionSecond +=nodeList.get(end+1).probability;
            start--;
            end++;
        }
        double tmpMin=0;
        for(int i=0;i<differenceSections.length;i++)
        {
            if(differenceSections[i]<tmpMin) {
                start = i;
                tmpMin=differenceSections[i];
            }
        }
        return start;
    }
    public static DefaultTableModel showWordCodeTableModel(DefaultTableModel modelResult) {
        for(Node entryNodes:nodeList)
        {
            modelResult.addColumn(entryNodes.symbol);
        }
        int column = 1;
        for(Node entryNodes:nodeList)
        {
            modelResult.setValueAt(entryNodes.code,2, column);
            modelResult.setValueAt(entryNodes.symbol, 0, column);
            modelResult.setValueAt(entryNodes.probability, 1, column);
            column++;
        }
        return modelResult;
    }


}
