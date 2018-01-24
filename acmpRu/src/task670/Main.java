package task670;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<String> arr = new Vector<>();
        for (int i = 1; i <= 100000; i++)
            arr.add(Integer.toString(i));
        dellNumber(arr);
        int N;
        N = sc.nextInt();
        N--;
        PrintWriter ps = new PrintWriter(System.out);
        ps.println(arr.get(N));
        ps.flush();
    }
    static void dellNumber(Vector<String> vector){
        String[] buf = new String[vector.size()];
        vector.toArray(buf);
        for (int i = 10; i < 99;i++){
            if (buf[i].substring(0,1).equals(buf[i].substring(1,2)))
                buf[i] = "0";
        }
        for (int i = 99; i < 999; i++){
                if (buf[i].substring(0,1).equals(buf[i].substring(1,2)) || buf[i].substring(0,1).equals(buf[i].substring(2,3)) ||
                    buf[i].substring(1,2).equals(buf[i].substring(2,3)))
                    buf[i] = "0";
        }
        for (int i = 999; i < 9999; i++){
                if (buf[i].substring(0,1).equals(buf[i].substring(1,2)) || buf[i].substring(0,1).equals(buf[i].substring(2,3)) ||
                        buf[i].substring(0,1).equals(buf[i].substring(3,4)) || buf[i].substring(1,2).equals(buf[i].substring(2,3)) ||
                        buf[i].substring(1,2).equals(buf[i].substring(3,4)) || buf[i].substring(2,3).equals(buf[i].substring(3,4)))
                    buf[i] = "0";
        }
        for (int i = 9999; i < 100000; i++){
            if (buf[i].substring(0,1).equals(buf[i].substring(1,2)) || buf[i].substring(0,1).equals(buf[i].substring(2,3)) ||
                    buf[i].substring(0,1).equals(buf[i].substring(3,4)) || buf[i].substring(0,1).equals(buf[i].substring(4,5))||
                    buf[i].substring(1,2).equals(buf[i].substring(2,3)) || buf[i].substring(1,2).equals(buf[i].substring(3,4))||
                    buf[i].substring(1,2).equals(buf[i].substring(4,5)) || buf[i].substring(2,3).equals(buf[i].substring(3,4))||
                    buf[i].substring(2,3).equals(buf[i].substring(4,5)) || buf[i].substring(3,4).equals(buf[i].substring(4,5)))
                buf[i] = "0";
        }
        vector.removeAllElements();
        for (int i = 0; i < buf.length; i++){
            if (!buf[i].equals("0"))
                vector.add(buf[i]);
        }
    }
}