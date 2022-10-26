// Написать программу вычисления n-ого треугольного числа

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number n: ");
        int num = sc.nextInt();
        int res = triangular_num(num);
        System.out.println(res);
        sc.close();
    }
    
    public static int triangular_num(int n) {
        return (n*(n + 1))/2;
    
    }

}
