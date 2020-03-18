public class Linked_List {
    public Node head;

    public void insertFirst(int n){
        Node new_node = new Node(n);
        if (head == null)
        {
            head = new Node(n);
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null) last = last.next;
        last.next = new_node;
        return;
    }

    public void add(int n){
        Node new_node = new Node(n);
        new_node.next = head;
        head = new_node;
    }

    public void insert(int data, int n){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        if (n == 1){
            temp.next = head;
            head = temp;
            return;
        }
        Node temp2 = head;
        for (int i = 0; i < n-2 ; i++) {
            temp2 = temp2.next;
        }
        temp.next = temp2.next;
        temp2.next = temp;
    }

    public void delete(int pos){
        Node temp = head;
        if (pos == 1){
            head = temp.next;
            return;
        }
        for (int i = 0; i < pos - 2; i++) {
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = temp2.next;
    }

    public void reverse(){
        Node current, pre, next;
        current = head;
        pre = null;
        while (current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;
    }

    public void insertAtHead(int n){
        Node newNode = getNewNode(n);
        if (head == null){
            head = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public Node getNewNode(int n){
        Node newNode = new Node();
        newNode.data = n;
        newNode.next = null;
        newNode.prev = null;
        return newNode;
    }

    public void print(){
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
