package JAVA.BasicDataTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by ivnytska on 2/4/2016.
 */

/*2. Написать программу которая будет просить пользователя вводить числа с плавающей точкой и выводить на экран
        введенное значение в экспоненциальном виде, если оно было введено в нормальном виде и, наоборот,
        выводить в нормальном если число было введено в экспоненциальном виде.*/

public class Task2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число с плавающей точкой: ");
        Formatter fmt = new Formatter();

        String aaa = reader.readLine();
        double a = Double.parseDouble(aaa);
        if (aaa.contains("e") || aaa.contains("E")) {
//        if(aaa.equals(String.valueOf(bigDecimal))){
            fmt.format("%f ", a);
        } else {
            fmt.format("%e ", a);
        }
        System.out.println(fmt);
    }
}
