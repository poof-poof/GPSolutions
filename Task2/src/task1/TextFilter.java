package task1;

import java.util.Scanner;
import java.util.Vector;

public class TextFilter {
    static Vector<String> textLines = new Vector<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        String argument;
        System.out.print("Enter argument: ");
        argument = sc.nextLine();
        System.out.println("Text lines:");
        while (true){
            line = sc.nextLine();
            if (line.isEmpty())
                break;
            textLines.add(line);
        }
    }
}
