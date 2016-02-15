package JAVA.StringsOOP;

/**
 * Created by ivnytska on 2/9/2016.
 * PENCIL
 *
 * Карандаш при написание 1го символа уменьшает остаток на 0,95%
 * и его нужно затачивать 3% после написания каждых 20 символов.
 */
public class Pencil extends Writer {

    private double rest = 100;
    public double getRest() {
        return this.rest;
    }


    @Override
    protected void write(StringBuilder stringBuilder) {
        for (int i = 1; i < stringBuilder.length(); i++) {

            rest = rest * 0.95;
//            System.out.println(String.format("Остаток карандаша: " + "%.2f", rest));
            if ((i % 20) == 0) {
                rest = rest * 0.97;
//                System.out.println("Карандаш заточен! Осталось " + String.format("%.2f", rest) + "% карандаша!");
            }
            if (rest < 1) {
                System.out.println("Карандаш закончился! Но вы недописали " + (stringBuilder.length() - i) + " символов!");
                break;
            }
        }
        if(rest > 1){
        System.out.println("Остаток карандаша: " + rest);}
    }

    @Override
    protected void erase(StringBuilder stringBuilder) {
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }


}