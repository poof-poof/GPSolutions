package task2;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    public static final String INVALID_DATA = "Invalid data!!!";
    public static final String DIVISION_BY_ZERO = "Division by zero!!!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("\\d[a-zA-z]+|\\d\\s\\d");
        String expression;
        System.out.println("Enter the expression:");
        expression = sc.nextLine();
        if (!p.matcher(expression).find()){

        }else
            System.out.println(INVALID_DATA);
    }
}
