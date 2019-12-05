package sort;

import sort.Sort;

public class QuickSort extends Sort {

    private int[] list;
    private int status = 0;

    public QuickSort(int[] list) {
        this.list = list;
    }

    void merge(int start, int median, int end)
    {
        int i, j, k;
        int n1 = median - start + 1;
        int n2 =  end - median;
        int[] L = new int[10];
        int[] R = new int[10];
        for (i = 0; i < n1; i++)
            L[i] = list[start + i];
        for (j = 0; j < n2; j++)
            R[j] = list[median + 1+ j];
        i = 0;
        j = 0;
        k = start;

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                list[k] = L[i];
                i++;
            }
            else
            {
                list[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            list[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            list[k] = R[j];
            j++;
            k++;
        }
    }

    public void quickSort(int start, int end)
    {
        if (start < end)
        {
            int m = start+(end-start)/2;
            quickSort(start, m);
            quickSort(m+1, end);
            merge(start, m, end);
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
            System.out.print(list[i] + " ");
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

    public void quickSort2(int left, int right){
        int size = right - left;
        if (size <= 3) manualSort(left, right);
        else {
            int median = median(left, right);
            int part = partitionIt(left, right, median);
            quickSort2(left, part -1);
            quickSort2(part +1, right);
        }
    }

    private int partitionIt(int left, int right, int pivot) {
        int leftPtr = left-1;
        int rightPtr = right+1;
        while (leftPtr < right && list[++leftPtr]<pivot);
        while (rightPtr > left && list[--right]>pivot);
        if (leftPtr >= rightPtr){

        }
        else {
            swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    private int median(int left, int right) {
        int centre = (left+right)/2;
        if (list[left] > list[centre]) swap(left,centre);
        if (list[left] > list[right]) swap(left,right);
        if (list[centre] > list[right]) swap(centre,right);
        swap(centre, right-1);
        return list[right -1];
    }

    private void manualSort(int left, int right){
        int size = right - left + 1;
        switch (size){
            case 0:
            case 1:
                break;
            case 2:
                if (list[left] > list[right]) swap(left, right);
                break;
            default:
                if (list[left] > list[right -1]) swap(left,right -1);
                if (list[left] > list[right]) swap(left,right);
                if (list[right -1] > list[right]) swap(right -1,right);
                break;
        }
    }

}
