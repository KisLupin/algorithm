package struct_data.graph;

public class StackX {

    private final int size = 20;
    private  int[] st;
    private  int top;

    public StackX() {
        st = new int[size];
        top = -1;
    }

    public void push(int k){
        st[++top] = k;
    }

    public int pop(){
        return st[top--];
    }

    public int peek(){
        return st[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }
}
