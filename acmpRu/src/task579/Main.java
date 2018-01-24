package task579;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k = 0,l = 0;
        int sumPos = 0;
        int sumUnPos = 0;
        n = sc.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++)
        {
            mas[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            if (mas[i] > 0 || mas[i] == 0) {
                k++;
                sumPos += mas[i];
            }
            else {
                l++;
                sumUnPos += Math.abs(mas[i]);
            }
        }


        PrintWriter ps = new PrintWriter(System.out);
        if (sumPos > sumUnPos || sumPos == sumUnPos) {
            ps.println(k);
            for (int i = 0; i < n; i++)
            {
                if (mas[i] > 0 || mas[i] == 0)
                    ps.print((i+1) + ((i == n-1) ? "" : " "));
            }
        } else {
            ps.println(l);
            for (int i = 0; i < n; i++)
            {
                if (mas[i] < 0)
                    ps.print((i+1) + ((i == n-1) ? "" : " "));
            }
        }
        ps.flush();
    }
}