public class classBinaryTree {
     class Node
    {
        int value;
        Node leftChild;
        Node rightChild;
        Node previous;
        Node(int value)
        {
            this.value = value;
            /*leftChild = null;
            rightChild = null;*/
        }
    }

    Node root = null;

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
}
