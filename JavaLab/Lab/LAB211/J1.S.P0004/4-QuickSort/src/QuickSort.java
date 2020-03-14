
public class QuickSort {
    
    int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * divide array to 2 part by middle pivot
     * @param left: pivot left
     * @param right: pivot right
     * @return position of pivot left
     */
    int partition(int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    /**
     * sort array by quick sort algorithm
     * @param left: pivot left
     * @param right: pivot right
     */
    void quickSort(int left, int right) {
        int index = partition(left, right);
        if (left < index - 1) {
            quickSort(left, index - 1);
        }
        if (index < right) {
            quickSort(index, right);
        }
    }
}
