package task278;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        String t = sc.nextLine().toUpperCase();
        int check;
        boolean falseDna = false;
        check = s.length();
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            for (; j < t.length(); j++){
                if (s.charAt(i) != t.charAt(j)){
                    continue;
                }else if(i < j || i == j){
                    check--;
                    j++;
                    break;
                }else{
                    falseDna = true;
                    break;
                }
            }
            if (falseDna)
                break;
            else continue;
        }
        PrintWriter ps = new PrintWriter(System.out);
        if (check == 0)
            ps.println("YES");
        else
            ps.println("NO");
        ps.flush();
    }

}