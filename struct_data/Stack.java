package struct_data;

public class Stack {

    int max = 10;
    int[] stack = new int[max];
    int status = -1;

    public void push(int a){
        if (status >= (max - 1)) {
            System.out.println("Stack Overflow");
        }
        else {
            stack[++status] = a;
            System.out.println(a + " pushed into stack");
        }
    }

    public int pop(){
        if (status < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else{
            int x = stack[status--];
            return x;
        }
    }

    public int top(){
        return stack[status];
    }

    public int size(){
        return status;
    }

    public boolean isEmpty(){
        return (status <= 0);
    }

    public boolean isFull(){
        return status == max - 1;
    }

    public void print(){
        System.out.println();
        for (int i = 0; i <= status; i++) {
            System.out.print(stack[i] + " ");
        }
    }
}
