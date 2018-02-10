package task2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    public static final String INVALID_DATA = "Invalid data!!!";
    public static final String DIVISION_BY_ZERO = "Division by zero!!!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("[^0-9^+\\-*/(),.\\s]|\\d\\s\\d");
        String expression;
        System.out.println("Enter the expression:");
        expression = sc.nextLine();
        if (!p.matcher(expression).find()){
            expression = expression.replace(",",".");
            expression = expression.replace(" ","");
            MatchParser mp = new MatchParser();
            try {
                System.out.println("Result: " + mp.Parse(expression));
            }catch (ArithmeticException e){
                System.out.println(DIVISION_BY_ZERO);
            }catch (Exception e){
                System.out.println(e);
            }
        }else
            System.out.println(INVALID_DATA);
    }
}
