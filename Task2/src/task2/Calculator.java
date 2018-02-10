package task2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
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
            methodTest(expression);
        }else
            System.out.println(INVALID_DATA);
    }

    static void methodTest(String exp){
       char[] buf = exp.toCharArray();
        System.out.println(exp);
       Pattern p = Pattern.compile("\\(.+|\\).+|.+\\)|.+\\(");
       Matcher m = p.matcher(exp);
       if (m.find()){
           System.out.println("Lashara");
       }else {
           p = Pattern.compile("\\d+\\.\\d+\\s\\^\\s\\d+|\\d+\\s\\^\\s\\d+|\\d+\\.\\d+\\^\\s\\d+|\\d+\\^\\s\\d+" +
                   "|\\d+\\.\\d+\\s\\^\\d+|\\d+\\s\\^\\d+|\\d+\\.\\d+\\^\\d+|\\d+\\^\\d+");
           m = p.matcher(exp);
           if (m.find()){
               String s = m.group();
               ArrayList<BigInteger> bi = new ArrayList<>();
               BigDecimal bd = null;
               try{
                   bi.add(new BigInteger((s.split(" ")[0])));
                   bi.add(new BigInteger((s.split(" ")[2])));
               }catch (NumberFormatException e){
                   bd = new BigDecimal(s.split(" ")[0]);
                   bi.add(new BigInteger((s.split(" ")[2])));
               }
               System.out.println("BI: " + ((bi != null) ? Arrays.toString(bi.toArray()) : "null"));
               System.out.println("BD: " + ((bd != null) ? bd.doubleValue() : "null"));
               System.out.println(s);
           }else{
               System.out.println("LOX");
           }

       }
//       for (int i = 0; i < buf.length; i++){
//           if (buf[i] == '('){
//
//           }
//       }
    }

    static BigDecimal sum(BigDecimal d1, BigDecimal d2){
        return d1.add(d2);
    }

    static  BigDecimal divide(BigDecimal d1, BigDecimal d2){
        return d1.divide(d2);
    }

    static BigDecimal multiply(BigDecimal d1, BigDecimal d2){
        return d1.multiply(d2);
    }

    static BigDecimal substruct(BigDecimal d1, BigDecimal d2){
        return d1.subtract(d2);
    }


}
