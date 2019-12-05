package sort;

public class BubbleSort extends Sort {

    private int[] form;
    private int status = 0;

    public BubbleSort(int[] form) {
        this.form = form;
    }

    public void bubbleSort(){
        for (int i = form.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (form[j] > form[j+1]){
                    swap(j, j+1);
                }
            }
        }
    }

    @Override
    void swap(int a, int b) {
        int temp = form[a];
        form[a] = form[b];
        form[b] = temp;
    }

    @Override
    void print() {
        for (int i = 0; i < form.length; i++) {
            System.out.print(form[i]+" ");
        }
    }

    @Override
    void add(int a) {
        if (status >= form.length){
            return;
        }
        form[status] = a;
        status++;
    }

    @Override
    void remove(int a) {

    }
}
