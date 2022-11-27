import java.util.Random;

public class Task04 {

    public static void main(String[] args) {
        int[] array = randomArray(9, 73);
        print(array);
        array = quickSort(array, 0, array.length - 1);
        print(array);
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return arr;

        int i = start;
        int j = end;
        int middle = i - (i - j) / 2;

        while (i < j) {
            while ((i < middle) && (arr[i] <= arr[middle]))
                i++;
            while ((j > middle) && (arr[j] >= arr[middle]))
                j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == middle)
                    middle = j;
                else if (j == middle)
                    middle = i;
            }
        }
        quickSort(arr, start, middle);
        quickSort(arr, middle + 1, end);
        return arr;
    }

    static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static int[] randomArray(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(bound);
        }
        return array;
    }
}
