package sort;

import sort.Sort;

public class InsertSort extends Sort {

    private int[] list;
    private int status = 0;

    public InsertSort(int[] list) {
        this.list = list;
    }

    public void insertSort(){
        int last,k;
        for (int i = 1; i < list.length; i++) {
            last = list[i];
            k = i;
            while ((k > i) && (list[k - 1] > last)){
                list[k] = list[k - 1];
                k--;
            }
            list[k] = last;
        }
    }

    @Override
    void swap(int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    @Override
    void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
    }

    @Override
    void add(int a) {
        if (status >= list.length){
            return;
        }
        list[status] = a;
        status++;
    }

    @Override
    void remove(int a) {

    }
}
