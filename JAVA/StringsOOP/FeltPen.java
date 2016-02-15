package JAVA.StringsOOP;

import java.io.BufferedReader;

/**
 * Created by ivnytska on 2/9/2016.
 * Felt Pen
 * <p>
 * Маркер расходуется неравномерно, первые 20 символов 1% на символ, 21й-40й символ 1.09% и далее 1.21%.
 */
public class FeltPen extends Writer {
    private double rest = 100;

    public double getRest() {
        return this.rest;
    }


    @Override
    protected void write(StringBuilder stringBuilder) {
        for (int i = 1; i < stringBuilder.length(); i++) {
            if (i <= 20) {
                rest = (rest * 0.99);
//                System.out.println(String.format("Остаток фломастера: " + "%.2f", rest) + " написанно до 20");

            }
            if (i >= 21 && i <= 40) {
                rest = (rest * 0.9891);
//                System.out.println(String.format("Остаток фломастера: " + "%.2f", rest) + " написанно от 20 до 40");
            }
            if (i >= 41) {
                rest = (rest * 0.9879);
//                System.out.println(String.format("Остаток фломастера: " + "%.2f", rest) + " написанно от 40");
            }
            if (rest < 1) {
                System.out.println("Фломастер закончился! Но вы недописали " + (stringBuilder.length() - i) + " символов!");
                break;
            }
        }
        if(rest > 1){
        System.out.println("Остаток фломастера: " + rest);}
    }

    @Override
    protected void erase(StringBuilder stringBuilder) {
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
