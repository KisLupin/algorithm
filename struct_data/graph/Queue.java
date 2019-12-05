package struct_data.graph;

public class Queue {
    private final int size = 20;
    private int[] queArr;
    private int front;
    private int rear;

    public Queue(){
        queArr = new int[size];
        front = 0;
        rear = -1;
    }

    public void insert(int k){
        if (rear < size-1){
            queArr[++rear] = k;
        }
        if (rear == size -1){
            rear = -1;
            return;
        }
    }

    public int remove(){
        int temp = queArr[front++];
        if (front == size){
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty(){
        return (rear+1 == front || front+size-1 == rear);
    }
}
