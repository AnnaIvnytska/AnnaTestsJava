package JAVA.StringsOOP;

/**
 * Created by ivnytska on 2/9/2016.
 */
public class Main {
    public static void main(String[] args) {
        Writer pencil = new Pencil();
        Writer pen = new Pen();
        Writer feltPen = new FeltPen();

        StringBuilder sb = new StringBuilder();
        sb.append("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
//        pencil.write(sb);
//        pen.write(sb);
//        feltPen.write(sb);

        /* а) создания массива рандомных пишущих средств размером в 10 элементов и подготовка их к работе.*/

        Writer[] arr = {pen, pencil, feltPen};
        Writer[] writerArray = new Writer[10];

        for (int i = 0; i < writerArray.length; i++) {
            int j = (int) (Math.random() * (arr.length));
            //            writerArray[i] = arr[j];
            switch (j) {
                case 0:
                    writerArray[i] = new Pen();
                    break;
                case 1:
                    writerArray[i] = new Pencil();
                    break;
                case 2:
                    writerArray[i] = new FeltPen();
                    break;
            }
        }

        for (int i = 0; i < writerArray.length; i++) {
            System.out.println(writerArray[i]);
        }

        for (int i = 0; i < writerArray.length; i++) {
            writerArray[i].write(sb);

        }

        /* c) сортировка устройств по остатку пишущего средства в %.*/

        for (int i = writerArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (writerArray[j].getRest() > writerArray[j + 1].getRest()) {
                    Writer tmp = writerArray[j];
                    writerArray[j] = writerArray[j + 1];
                    writerArray[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < writerArray.length; i++) {
            System.out.println(writerArray[i] + " остаток: " + writerArray[i].getRest());
        }
    }
}