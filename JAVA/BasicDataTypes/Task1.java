package JAVA.BasicDataTypes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by ivnytska on 2/4/2016.
 */

/*    Создать com.nixsolutions.Arrays со статическим методом sort который на вход будет получать массив целых чисел (int).
     В методе реализовать сортировку методом пузырька. Исходный массив не должен изменяться методом.

     Написать программу
     которая будет в цикле (20 раз) создать массив размером 10000 из случайных целых чисел состоящих от -100 до 100,
     и запускать сортировку пузырьком и метод сортировки из класса java.util.Arrays.

     При каждой итерации замерять
     время выполнения сортировки каждым способом и результаты складывать в двумерный массив. После окончания цикла
     вывести среднее для значений, полученных каждым методом сортировки. */


public class Task1 {

    public static void main(String[] args) {
        int[] bigArr = new int[10000];
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = -101 + ((int) (Math.random() * (100 - (-101)) + 1));
        }
        long[][] resArr = new long[20][2];
        int[] newCloneArr1 = Arrays.copyOf(bigArr, bigArr.length);
        int[] newCloneArr2 = Arrays.copyOf(bigArr, bigArr.length);
        for (int i = 0; i < 20; i++) {
            {
                long start = System.nanoTime();
                Arrays.sort(newCloneArr1);
                long end = System.nanoTime();
                resArr[i][0] = end - start;

                long start2 = System.nanoTime();
                sort(newCloneArr2);
                long end2 = System.nanoTime();
                resArr[i][1] = end2 - start2;
            }
        }

        double res1 = 0;
        for (int i = 0; i < 20; i++) {
            int summ = 0;
            summ += resArr[i][0];
            res1 = summ / resArr.length;
        }

        double res2 = 0;
        for (int i = 0; i < 20; i++) {
            int summ = 0;
            summ += resArr[i][1];
            res2 = summ / resArr.length;
        }

        System.out.println(res1 + " " + res2);
    }

    public static int[] sort(int[] arrInt) {
        for (int i = 0; i < arrInt.length - 1; i++) {
            for (int j = 0; j < arrInt.length - 1 - j; j++) {
                if (arrInt[j] < arrInt[j + 1]) {
                    int a = arrInt[j];
                    arrInt[j] = arrInt[j + 1];
                    arrInt[j + 1] = a;
                }
            }
        }
        return arrInt;
    }
}
