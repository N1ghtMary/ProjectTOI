import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Node
{
    int value;
    Node leftChild;
    Node rightChild;
    Node previous;
    Node(int value, Node rightChild, Node leftChild)
    {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }
    Node(int value)
    {
        this.value = value;
    }
}

public class classBinaryTree {

    Node root;

   /* public void addNode(int value) {
        root = new Node(value);
        addNode(value, root);
    }*/

    public void addNode(int value)
    {
        if(root == null)
        {
            root = new Node(value);
            root.leftChild = null;
            root.rightChild = null;
            root.previous = null;

        }
        else
        {
            Node currentNode = root;
            while (currentNode != null)
            {
                if(value < currentNode.value)
                {
                    if(currentNode.leftChild == null)
                    {
                        Node newNode = new Node(value);
                        newNode.leftChild = null;
                        newNode.rightChild = null;
                        newNode.previous = currentNode;
                        currentNode.leftChild = newNode;
                        break;
                    }
                    else
                    {
                        currentNode = currentNode.leftChild;
                    }
                }
                else
                {
                    if(currentNode.rightChild == null)
                    {
                        Node newNode = new Node(value);
                        newNode.leftChild = null;
                        newNode.rightChild = null;
                        newNode.previous = currentNode;
                        currentNode.rightChild = newNode;
                        break;
                    }
                    else
                    {
                        currentNode = currentNode.rightChild;
                    }
                }
            }
        }

    }

    public DefaultListModel depthFirstSearchInOrder(DefaultListModel modelBinaryTreeSearch)
    {
        if (root == null) return null;
        Stack<Node> stackTree = new Stack<>();
        Node currentNode = root;
       // stackTree.push(root);
        while (currentNode != null || !stackTree.empty())
        {
            if (currentNode !=  null)
            {

                stackTree.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            //currentNode = stackTree.pop();
            else
            {
                currentNode = stackTree.pop();
                modelBinaryTreeSearch.addElement(currentNode.value);
                currentNode = currentNode.rightChild;
            }

            //currentNode = currentNode.rightChild;
            /*while (!stackTree.empty()) {
                Node node = stackTree.pop();
                if (node.leftChild != null) {
                    stackTree.push(node.leftChild);
                }
                if (node.rightChild != null) {
                    stackTree.push(node.rightChild);
                }
            }*/
        }
        return modelBinaryTreeSearch;
    }

    public DefaultListModel breadthFirstSearchLvlOrder(DefaultListModel modelBinaryTreeSearch)
    {
        if (root == null) return null;
        Queue queueTree = new LinkedList();
        queueTree.add(root);
        while (!queueTree.isEmpty())
        {
            Node currentNode = (Node) queueTree.poll();
            modelBinaryTreeSearch.addElement(currentNode.value);
            if(currentNode.leftChild != null)
            {
                queueTree.add(currentNode.leftChild);
            }
            if(currentNode.rightChild != null)
            {
                queueTree.add(currentNode.rightChild);
            }
        }
        return  modelBinaryTreeSearch;
    }

    public void searchNode(int value)
    {

    }

    public void deleteNode(int value)
    {

    }
}
