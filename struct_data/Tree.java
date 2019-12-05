package struct_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    public Node find(int key){
        Node current = root;
        while (current.iData != key){
            if (key < current.iData){
                current = current.left;
            }else current = current.right;
            if (current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(int id,double dd){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null){
            root = newNode;
        }else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (id < current.iData){
                    current = current.left;
                    if (current == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else {
                    current = current.right;
                    if (current == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean dekete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeft = true;
        while (current.iData != key){
            parent = current;
            if (key < current.iData){
                isLeft = true;
                current = current.left;
            }else {
                isLeft = false;
                current = current.right;
            }
            if (current == null){
                return false;
            }
        }
        if (current.left == null && current.right ==null){
            if (current == root){
                root = null;
            }
            if (isLeft){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if (current.right == null){
            if (current == root){
                root = current.left;
            }else if (isLeft){
                parent.left = current.left;
            }else parent.right = current.right;
        }else if (current.left == null){
            if (current == root){
                root = current.right;
            }else if (isLeft){
                parent.left = current.right;
            }else parent.right = current.right;
        }else {
            Node successor = getSuccessor(current);
            if (current == root){
                root =successor;
            }else if (isLeft){
                parent.left = successor;
            }else parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != delNode.right){
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                System.out.println("Preorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.println("Inorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.println("Postorder traversal: ");
                postOrder(root);
                break;
        }
    }

    private void preOrder(Node localRoot){
        if (localRoot != null){
            localRoot.displayNode();
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    private void inOrder(Node localRoot){
        if (localRoot != null){
            inOrder(localRoot.left);
            localRoot.displayNode();
            inOrder(localRoot.right);
        }
    }

    private void postOrder(Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            localRoot.displayNode();
        }
    }

    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("...................................................................................................");
        while (isRowEmpty==false){
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }
            while (!globalStack.isEmpty()){
                Node temp = (Node) globalStack.pop();
                if (temp != null){
                    System.out.println(temp.iData);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null){
                        isRowEmpty = false;
                    }
                }else {
//                    System.out.println("--");
                    localStack.push(null);
                    localStack.push(null);
                }
//                for (int i = 0; i < nBlanks*2-2; i++) {
//                    System.out.print(",");
//                }
            }
//            System.out.println();
//            nBlanks = 2;
            while (!localStack.isEmpty()){
                globalStack.push(localStack.pop());
            }
//            System.out.println("....................................................................................................");
        }
    }

    public void putText(String s){
        System.out.println(s);
        System.out.flush();
    }
    public String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public char getChar() throws IOException {
        return getString().charAt(0);
    }
    public int getInt() throws IOException {
        return Integer.parseInt(getString());
    }

}
