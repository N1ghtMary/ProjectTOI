import org.jetbrains.annotations.NotNull;

import javax.swing.table.DefaultTableModel;
import java.io.LineNumberInputStream;
import java.util.*;

public class classCompression {
    public static List<Node> nodeList = new ArrayList<>();
    public static HashMap<Character, Double> charProbabilityMap = new HashMap<>();
    public static class Node implements Comparable<Node>
    {
        char letter;
        double letterProbability;
        Node leftChild;
        Node rightChild;


        public Node(char letter, double letterProbability) {
            this.letter = letter;
            this.letterProbability = letterProbability;
        }

        public Node(Node left, Node right) {
            this.letterProbability = left.letterProbability + right.letterProbability;
            this.leftChild = left;
            this.rightChild = right;
        }

        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.letterProbability, other.letterProbability);
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
        Collections.sort(nodeList);
        //return nodeList;
    }

    public static Node buildTree() {
        if (nodeList.size() == 1) {
            return nodeList.get(0);
        }

        double totalProbability = 1.0;
        /*for (Node node : nodeList) {
            totalProbability += node.letterProbability;
        }*/

        double sectionProbability = 0.0;
        int index = 0;
        while (sectionProbability <= totalProbability / 2) {
            sectionProbability += nodeList.get(index).letterProbability;
            index++;
        }
        List<Node> leftNodes = nodeList.subList(0, index);
        List<Node> rightNodes = nodeList.subList(index, nodeList.size());
        PriorityQueue<Node> queue = new PriorityQueue<>(nodeList);
        while (queue.size()>1)
        {
            Node leftSubtree = queue.poll();
            Node rightSubtree = queue.poll();
            Node parent = new Node(leftSubtree,rightSubtree);
            queue.add(parent);
        }

        return queue.poll();
    }

    public static Node buildTree(List<Node> node) {
        if (nodeList.size() == 1) {
            return nodeList.get(0);
        }

        // Collections.sort(nodeList);

        double totalProbability = 1;
        /*for (Node node : nodes) {
            totalFrequency += node.letterProbability;
        }*/

        double sectionProbability = 0;
        int index = 0;
        while (sectionProbability <= totalProbability / 2) {
            sectionProbability += nodeList.get(index).letterProbability;
            index++;
        }

        List<Node> leftNodes = nodeList.subList(0, index);
        List<Node> rightNodes = nodeList.subList(index, nodeList.size());

        /* Node leftSubtree = buildTree(leftNodes);
        Node rightSubtree = buildTree(rightNodes);*/
        PriorityQueue<Node> queue = new PriorityQueue<>(node);
        while (queue.size()>1)
        {
            Node leftSubtree = queue.poll();
            Node rightSubtree = queue.poll();
            Node parent = new Node(leftSubtree,rightSubtree);
            queue.add(parent);
        }

        return queue.poll();
    }

     public static void buildShannonFanoMapCodes(Node node, String code, Map<Character, String> encodingMap) {
         if (node.isLeaf()) {
             encodingMap.put(node.letter, code);
             return;
         }
         buildShannonFanoMapCodes(node.leftChild, code + "0", encodingMap);
         buildShannonFanoMapCodes(node.rightChild, code + "1", encodingMap);

     }
     static Map<Character, String> buildShannonFanoMap(Node rootNode) {
        Map<Character, String> encodingMap = new HashMap<>();
        buildShannonFanoMapCodes(rootNode, "", encodingMap);
        return encodingMap;
    }

    public static DefaultTableModel showWordCodeTableModel(DefaultTableModel modelResult, Map<Character, String> encodingMap) {
        for(Map.Entry<Character, String> entryNodes:encodingMap.entrySet())
        {
            modelResult.addColumn(entryNodes.getKey());
        }
        int column = 1;
        for(Map.Entry<Character, String> entryNodes:encodingMap.entrySet())
        {

            modelResult.setValueAt(entryNodes.getValue(),2, column);

            modelResult.setValueAt(entryNodes.getKey(), 0, column);
            column++;
        }
        column = 1;
        for(Map.Entry<Character, Double> entryProbabilities:charProbabilityMap.entrySet())
        {
            modelResult.setValueAt(entryProbabilities.getValue(),1, column);
            column++;
        }
        return modelResult;
        /*StringBuilder encodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encodedMessage.append(encodingMap.get(c));
        }
        return encodedMessage.toString();*/
    }


}
