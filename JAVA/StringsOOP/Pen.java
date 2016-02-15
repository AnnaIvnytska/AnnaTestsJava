package JAVA.StringsOOP;

/**
 * Created by ivnytska on 2/9/2016.
 * PEN
 *
 * Ручка расходуется равномерно 1.15% на символ.
 */
public class Pen extends Writer {

    private double rest = 100;
    public double getRest() {
        return this.rest;
    }


    @Override
    protected void write(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            rest = (rest * 0.9885);
//            System.out.println("Осталось " + String.format("%.2f", rest) + "% чернил ручки!");

            if (rest < 1) {
                System.out.println("Ручка закончилась! Но вы недописали " + (stringBuilder.length() - i) + " символов!");
                break;
            }
        }
        if(rest > 1){
        System.out.println("Остаток ручки: " +rest);}
    }

    @Override
    protected void erase(StringBuilder stringBuilder) {
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }
}
