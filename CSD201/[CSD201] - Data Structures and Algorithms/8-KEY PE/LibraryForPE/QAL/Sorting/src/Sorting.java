
import java.io.PrintWriter;


public class Sorting {
    
    void swap(int []a, int i, int j){
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
    //1. Selection sort 0(n^2)
    void selection(int []a, int n){
        for (int i = 0; i < n -1; i++) {
            //tìm i trong đoạn i + 1 đến n
            int imin = i+1;
            for (int j = i+1; j < n; j++) {
                if(a[j] < a[imin]) imin = j;
            }
            if(a[i] > a[imin])  swap(a, i, imin);
        }
    }
    //2. Insertion sort    
    void insertion(int []a, int n){
        for (int i = 0; i < n; i++) {
            int x = a[i], j=i;
            while(j > 0 && x < a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = x;
        }
    }
    //3. bouble sort
    void bouble(int []a, int n){
        boolean sorted = true;
        do{
            sorted = true;
            for (int i = 0; i < n-1; i++) {
                if(a[i] > a[i+1]);
                swap(a, i, i+1);
                sorted = false;
            }
        }while(!sorted);
    }
    //4. Quick sort 0(nlogn)
    // 44 75 23 43 55 12 64 77 33
    // 44 33 23 43 55 12 64 77 75
    // 44 33 23 43 12 55 64 77 75
    // 12 33 23 43 44 55 64 77 75
    int partition(int []a, int low, int high){
        int i = low; int j = high;
        int pivot = a[i];
        while (i < j){
            while(i < high && a[i] <= pivot) i++;
            while(j > low && a[j] >= pivot) j--;
            if(i < j){
                swap(a, i, j);i++; j--;
            }
        }
        swap(a, low, j);
        return j;
    }
    void quick(int []a, int low, int high){
        if(low <= high){
            int k = partition(a, low, high);
            quick(a, low, k -1);
            quick(a, k +1, high);
        }
    }
   
    //5. merger sort 0(nlogn)
    void merge(int []a,int low, int mid, int high){
        int []b = new int[a.length];
        //copy a to b
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        //star merging
        int i = low, j = mid + 1;
        int k = low;
        while(i < mid && j < high){
            if (b[i] < b[j]) a[k] = b[i++];
            else a[k] = b[j++];
            k++;
        }
        while(i <= mid) a[k++] = b[i++];
        while(j < high) a[k++] = b[j++];
    }
    void mergesort(int []a, int low, int high){
        if(low < high){
            int k = (low + high)/2;
            mergesort(a, low, k);
            mergesort(a, k+1, high);
            merge(a, low, k, high);
        }
    }
    
    //save sorted array to a file
    void save(int []a, int n)throws Exception {
        PrintWriter pw = new PrintWriter("data.file");
        for (int i = 0; i < n; i++) {
            pw.write(a[i]+"\n");
        }
        pw.close();
    }
    
}
