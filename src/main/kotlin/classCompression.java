import javax.swing.table.DefaultTableModel;
import java.util.*;

public class classCompression {

        public static List<NodeShannonFano> nodeListShannonFano = new ArrayList<>();
        public static List<NodeHuffman> nodeListHuffman = new ArrayList<>();
        public static HashMap<Character, Double> charProbabilityMap = new HashMap<>();
        public static Map<Character, String> encodingMapHuffman = new LinkedHashMap<Character, String>();

        public static class NodeShannonFano
        {
            char symbol;
            double letterProbability;
            String codeShannonFano = "";


            NodeShannonFano(char symbol, double probability) {
                this.symbol = symbol;
                this.letterProbability = probability;
            }



        }

        public static class NodeHuffman implements Comparable<NodeHuffman>
        {
            char symbol;
            double letterProbability;
            NodeHuffman leftChild;
            NodeHuffman rightChild;
            NodeHuffman(NodeHuffman left,NodeHuffman right) {
                this.letterProbability = left.letterProbability + right.letterProbability;
                this.leftChild = left;
                this.rightChild = right;
            }

            public NodeHuffman(char symbol, double letterProbability) {
                this.letterProbability=letterProbability;
                this.symbol=symbol;
            }

            @Override
            public int compareTo(NodeHuffman other) {
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
                nodeListShannonFano.add(new NodeShannonFano(entryNodes.getKey(),entryNodes.getValue()));
                nodeListHuffman.add(new NodeHuffman(entryNodes.getKey(),entryNodes.getValue()));
            }
            nodeListShannonFano.sort((probabilityLeft, probabilityRight)-> Double.compare( probabilityRight.letterProbability,probabilityLeft.letterProbability));
        }

        public static void addNode(Map<Character, Double> userProbability)
        {
            for(Map.Entry<Character, Double> entryUser:userProbability.entrySet())
            {
                nodeListShannonFano.add(new NodeShannonFano(entryUser.getKey(),entryUser.getValue()));
                nodeListHuffman.add(new NodeHuffman(entryUser.getKey(),entryUser.getValue()));
            }
            nodeListShannonFano.sort((probabilityLeft, probabilityRight)-> Double.compare( probabilityRight.letterProbability,probabilityLeft.letterProbability));
        }

        public static void buildTreeShannonFano() {
        Deque<List<NodeShannonFano>> dequeNodeList = new ArrayDeque<>();
        dequeNodeList.push(nodeListShannonFano);

        while (!dequeNodeList.isEmpty()) {
            List<NodeShannonFano> nodes = dequeNodeList.pop();
            int middle = divide(nodes);
            if (middle != -1) {
                List<NodeShannonFano> left = nodes.subList(0, middle + 1);
                List<NodeShannonFano> right = nodes.subList(middle + 1, nodes.size());
                for (NodeShannonFano node : left) {
                    node.codeShannonFano += "0";
                }
                for (NodeShannonFano node : right) {
                    node.codeShannonFano += "1";
                }
                dequeNodeList.push(right);
                dequeNodeList.push(left);
            }
        }
    }

        public static void buildTreeHuffman()
        {
            PriorityQueue<NodeHuffman> queueHuffman = new PriorityQueue<>((probabilityLeft, probabilityRight)-> Double.compare(probabilityLeft.letterProbability, probabilityRight.letterProbability));

            for (NodeHuffman entryNodeHuffman : nodeListHuffman) {
                queueHuffman.offer(new NodeHuffman(entryNodeHuffman.symbol,entryNodeHuffman.letterProbability));
            }

            //queueHuffman.addAll(nodeListHuffman);
            while (queueHuffman.size()>1)
            {
                NodeHuffman leftSubtree = queueHuffman.poll();
                NodeHuffman rightSubtree = queueHuffman.poll();
                NodeHuffman parent = new NodeHuffman(leftSubtree,rightSubtree);
                queueHuffman.offer(parent);
            }
            NodeHuffman rootHuffman= queueHuffman.poll();

            buildCodeHuffman(rootHuffman,"");
        }


        private static int divide(List<NodeShannonFano> nodeList) {
            if (nodeList.size() == 1) {
                return -1;
            }

            int middle = (nodeList.size()-1)/2;

            if(middle<=1) return 0;
            if(middle==2) return 1;
            int start = middle;
            int end=middle+1;
            double[] differenceSections = new double[nodeList.size()-1];
            double sectionFirst = nodeList.get(start).letterProbability;
            double sectionSecond = nodeList.get(end).letterProbability;
            while (start>=0 && end<=nodeList.size()-1 && end+1<=nodeList.size()-1 && start-1<nodeList.size()-1)
            {
                start--;
                sectionFirst += nodeList.get(start).letterProbability;
                end++;
                sectionSecond +=nodeList.get(end).letterProbability;

                differenceSections[start]=sectionFirst-sectionSecond;
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

        private static void buildCodeHuffman(NodeHuffman rootHuffman, String codeHuffman)
        {
            if (rootHuffman.symbol!=0) {
                encodingMapHuffman.put(rootHuffman.symbol, codeHuffman);
                return;
            }
            buildCodeHuffman(rootHuffman.leftChild, codeHuffman + "0");
            buildCodeHuffman(rootHuffman.rightChild, codeHuffman + "1");

        }

        public static DefaultTableModel showWordCodeTableModel(DefaultTableModel modelResult) {
            if(modelResult.getColumnCount()<nodeListShannonFano.size())
            {
                for(NodeShannonFano entryNodes:nodeListShannonFano)
                {
                    modelResult.addColumn(entryNodes.symbol);
                }
            }
            int column = 1;
            for(NodeShannonFano entryNodes:nodeListShannonFano)
            {
                modelResult.setValueAt(entryNodes.codeShannonFano,2, column);
                modelResult.setValueAt(entryNodes.symbol, 0, column);
                modelResult.setValueAt(entryNodes.letterProbability, 1, column);
                column++;
            }
            column = 1;
            for(Map.Entry<Character, String> entryHuffman:encodingMapHuffman.entrySet())
            {
                modelResult.setValueAt(entryHuffman.getValue(),3,column);
                column++;
            }
            return modelResult;
        }


}
