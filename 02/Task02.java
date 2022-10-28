// Реализовать алгоритм сортировки вставками

public class Task02 {
    public static void main(String[] args) {
        int[] arr = {102, 11, 74, 3, 591, 21};
        insertion_sort(arr);
        show_arr(arr);
    }

    public static void insertion_sort(int[] arr) {
        int i, j;
        int n = arr.length;
        for (i = 1; i < n; i++) {
            int swap = arr[i];
            for (j = i; j > 0 && swap < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = swap;
        }
    }
    
    static void show_arr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.printf("%d ", arr[i]);
        }
    }         
}
 