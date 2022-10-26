// Реализовать алгоритм пирамидальной сортировки (HeapSort)

public class Task02 {
    
    public void heap_sort(int[] arr)
    {
        int n = arr.length;
 
        for (int i = n/2 - 1; i >= 0; i--) {
            heap(arr, n, i);
        }
 
        for (int i = n-1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heap(arr, i, 0);
        }
    }
 
    void heap(int[] arr, int n, int i)
    {
        int max_num = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
 
        if (left < n && arr[left] > arr[max_num])
            max_num = left;
 
        if (right < n && arr[right] > arr[max_num])
            max_num = right;
 
        if (max_num != i) {
            int temp = arr[i];
            arr[i] = arr[max_num];
            arr[max_num] = temp;
 
            heap(arr, n, max_num);
        }
    }
 
    static void show_arr(int[] arr)
    {
        int n = arr.length;
 
        for (int i = 0; i < n; ++i) {
            System.out.printf("%d ", arr[i]);
        }
    }
 
    public static void main(String args[])
    {
        int[] arr = {102, 11, 74, 3, 591, 21};
        Task02 sort_arr = new Task02();
        sort_arr.heap_sort(arr);
        show_arr(arr);
    }
    
}
