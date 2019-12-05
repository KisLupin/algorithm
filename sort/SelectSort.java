package sort;

import sort.Sort;

public class SelectSort extends Sort {

    private int[] list;
    private int status = 0;

    public SelectSort(int[] list) {
        this.list = list;
    }

    public void selectSort(){
        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < list.length; j++) {
                if (list[j] < list[min]){
                    min = j;
                    swap(i,min);
                }
            }
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
