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
        while (currentNode != null || !stackTree.empty())
        {
            if (currentNode !=  null)
            {
                stackTree.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            else
            {
                currentNode = stackTree.pop();
                modelBinaryTreeSearch.addElement(currentNode.value);
                currentNode = currentNode.rightChild;
            }
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

    public boolean searchNode(int value)
    {

        if (root == null) return false;
        if (root.value == value) return true;
        Node currentNode = root;

        while (currentNode != null)
        {
            if(currentNode.value == value) return true;
            else if (currentNode.value > value) currentNode = currentNode.leftChild;
            else currentNode = currentNode.rightChild;
        }
        return false;
    }

    public boolean deleteNode(int value)
    {
        Node deletedNode = root;
        Node parentNode = root;

        boolean isLeftChild = true;

        while (deletedNode.value != value)
        {
            parentNode = deletedNode;
            if(value < deletedNode.value)
            {
                isLeftChild = true;
                deletedNode = deletedNode.leftChild;
            }
            else
            {
                isLeftChild = false;
                deletedNode = deletedNode.rightChild;
            }
            if(deletedNode == null) return false;

        }

        if(deletedNode.leftChild == null && deletedNode.rightChild == null)
        {
            if(deletedNode == root) root = null;
            else if(isLeftChild) parentNode.leftChild = null;
            else parentNode.rightChild = null;
        }
        else if(deletedNode.rightChild == null)
        {
            if(deletedNode == root) root = deletedNode.leftChild;
            else if(isLeftChild) parentNode.leftChild = deletedNode.leftChild;
            else parentNode.rightChild = deletedNode.leftChild;
        }
        else if(deletedNode.leftChild == null)
        {
            if(deletedNode == root) root = deletedNode.rightChild;
            else if (isLeftChild) parentNode.rightChild = deletedNode.rightChild;
            else parentNode.rightChild = deletedNode.leftChild;
        }
        else
        {
            Node replacedNode = getReplacementNode(deletedNode);
            if(deletedNode == root) root = replacedNode;
            else if(isLeftChild) parentNode.leftChild = replacedNode;
            else parentNode.rightChild = replacedNode;
            replacedNode.leftChild = deletedNode.leftChild;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode)
    {
        Node replacedParentNode = replacedNode;
        Node replacedTmpNode = replacedNode;
        Node currentNode = replacedNode.rightChild;
        while (currentNode != null)
        {
            replacedParentNode = replacedTmpNode;
            replacedTmpNode = currentNode;
            currentNode = currentNode.leftChild;
        }
        if(replacedTmpNode != replacedNode.rightChild)
        {
            replacedParentNode.leftChild = replacedTmpNode.rightChild;
            replacedTmpNode.rightChild = replacedNode.rightChild;
        }
        return  replacedTmpNode;
    }
}
