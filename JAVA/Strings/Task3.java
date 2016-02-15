package JAVA.Strings;

import java.util.Arrays;

/**
 * Created by ivnytska on 2/4/2016.
 */
public class Task3 {

    //3. Анагра́мма - литературный прием, состоящий в перестановке букв так, что в результате дает другое слово.
    // Пример, полковник - клоповник, покраснение - пенсионерка.
    // Написать программу которая будет определять являются ли две заданные строки
    // (строка может быть словосочетанием) анаграммами друг-друга.
    // Программа может игнорировать пробелы и знаки пунктуации.

    public static void main(String[] args) {
        checkAnagramm("полковник", "клоповник");
    }

    public static void checkAnagramm(String firstString, String secondString) {
        firstString.replace(" ", "").toLowerCase();
        secondString.replace(" ", "").toLowerCase();

        char[] firstChar = firstString.toCharArray();
        char[] secondChar = secondString.toCharArray();

        Arrays.sort(firstChar);
        Arrays.sort(secondChar);

        boolean a = true;
        if (firstChar.length == secondChar.length) {
            for (int i = 0; i < firstChar.length; i++) {
                if (firstChar[i] != (secondChar[i])) {
                    a = false;
                    break;
                }
            }
        } else {
            a = false;
        }
        if (a) {
            System.out.println(firstString + " and " + secondString + " are anagrams");

        } else {
            System.out.println(firstString + " and " + secondString + " are NOT anagrams");
        }
    }
}