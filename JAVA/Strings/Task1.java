package JAVA.Strings;

/**
 * Created by ivnytska on 2/3/2016.
 */
public class Task1 {
//    1. Есть два литерала “Java”, “forever”, напишите несколько способов
// соединить эти строки так чтобы получилось “Java forever”.

    public static void main(String[] args) {
        String java = "JAVA";
        String forever = "forever";

        String s1 = java + " " + forever;
        String s2 = java.concat(" ").concat(forever);

        StringBuilder sb = new StringBuilder();
        sb.append(java).append(" ").append(forever);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println( sb.toString());
    }
}