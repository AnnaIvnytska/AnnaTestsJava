package JAVA.Strings;

/**
 * Created by ivnytska on 2/4/2016.
 */
public class Task2 {
    //Написать программу которая вычисляет инициалы, на основе полных Фамилии Имени Отчества,
    // пример Мирон Богданович Маркевич = МБМ.

    public static void main(String[] args) {
        String surname = "Ивницкая";
        String name = "Анна";
        String middleName = "Владимировна";

        String s = surname.substring(0, 1);
        String n = name.substring(0, 1);
        String m = middleName.substring(0, 1);
        String abrev = s + n + m;

        System.out.println(surname + " " + name + " " + middleName + " = " + abrev);
    }
}