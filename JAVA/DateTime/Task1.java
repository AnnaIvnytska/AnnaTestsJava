package JAVA.DateTime;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;


/**
 * Created by ivnytska on 2/5/2016.
 */
public class Task1 {

    public static void main(String[] args) {
//        showMonthLength(2015);
//        showDatesOfMondays(2016, 9);
        checkIfFriday13(2016, 5, 13);
//        countDifference(2011, 02, 9);
//        showDateWithAnotherLocation();

    }

    /* 1)Написать метод который для указанного года выводит длину каждого месяца.
    (использовать Java 7)*/

    public static void showMonthLength(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        for (int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, i);
//            cal.set(Calendar.DATE, 1);

            int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println(days);
        }
    }

    /* 2)Написать метод который для указанного месяца и года выводит список дат
    которые выпадают на понедельник. (использовать Java 7)*/

    public static void showDatesOfMondays(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        int max_date = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//        for(int i = 0; i <= max_date/7; i++){
        while (cal.get(Calendar.MONTH) == month - 1) {
            System.out.println(cal.getTime());
            cal.get(Calendar.MONDAY);
            cal.add(Calendar.DAY_OF_WEEK, 7);//Прибавляем неделю
        }
    }

   /* 3)Написать метод который проверяет является ли указанная дата пятницей тринадцатого.
   (использовать Java 7)*/

    //Вопрос: как добавить к месяцу единицу, при выводе?

    public static void checkIfFriday13(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        Date friday = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
        System.out.println(simpleDateFormat.format(friday));

        if (cal.get(Calendar.DAY_OF_MONTH) == 13 && cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            System.out.println(friday + " is Friday 13!");
        } else
            System.out.println(friday + " is NOT Friday 13!");
    }

    /* 4)Написать метод который для указанной даты возвращает строку в
    которой написано сколько лет, месяцев, дней прошло с этой даты. Например “2 года, 1 месяц и 23 дня”
    (использовать Java 7)*/

    public static void countDifference(int year, int month, int day) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendarCurrent = Calendar.getInstance();
        Calendar calendarPast = Calendar.getInstance();

        calendarPast.set(Calendar.YEAR, year);
        calendarPast.set(Calendar.MONTH, month - 1);
        calendarPast.set(Calendar.DATE, day);

        long timeDiff = calendarCurrent.getTimeInMillis() - calendarPast.getTimeInMillis();

        System.out.println(dateFormat.format(calendarCurrent.getTime()));
        System.out.println(dateFormat.format(calendarPast.getTime()));

        System.out.println(timeDiff);

        try {
            long years = timeDiff / 31536000000L;
            long months = (timeDiff - (years * 31536000000L)) / 2591999000L;
            long days = (timeDiff - ((years * 31536000000L) + (months * 2592000000L))) / 86399000L;
            System.out.println(years + " years " + months + " months " + days + " days");


//            long diffSeconds = timeDiff / 1000 % 60;
//            long diffMinutes = timeDiff / (60 * 1000) % 60;
//            long diffHours = timeDiff / (60 * 60 * 1000) % 24;
//            long diffDays = timeDiff / ((24 * 60 * 60 * 1000) / 12) % 30;  //????
//            long diffMonth = timeDiff / ((24 * 60 * 60 * 1000) / 360) % 12;
//            long diffYears = timeDiff / (24 * 60 * 60 * 1000) / 360;
//
//            System.out.print(diffYears + " years, ");
//            System.out.print(diffMonth + " month, ");
//            System.out.print(diffDays + " days, ");
//            System.out.print(diffHours + " hours, ");
//            System.out.print(diffMinutes + " minutes, ");
//            System.out.print(diffSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* 5)Используя локаль для Канады, Германии, Пакистана и Вьетнама вывести текущую дату в полном
        формате используя Date-Time API Java 8 и возможности Java 7*/

    public static void showDateWithAnotherLocation() {

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String canadaTime = localDate.format(dateTimeFormatter1.withLocale(Locale.CANADA));
        String germanyTime = localDate.format(dateTimeFormatter1.withLocale(Locale.GERMANY));
        String pakistanTime = localDate.format(dateTimeFormatter1.withLocale(new Locale("en", "PK")));
        String vietnamTime = localDate.format(dateTimeFormatter1.withLocale(new Locale("vi", "VN")));
//        String vietnamTime = "";
//            Locale[] locales = SimpleDateFormat.getAvailableLocales();
//            for (Locale currloc : locales) {
//                if (currloc.getCountry().equals("VN")) {
//                    vietnamTime = localDate.format(dateTimeFormatter1.withLocale(currloc));
//                }
//            }

        System.out.println(canadaTime);
        System.out.println(germanyTime);
        System.out.println(pakistanTime);
        System.out.println(vietnamTime);
    }

}