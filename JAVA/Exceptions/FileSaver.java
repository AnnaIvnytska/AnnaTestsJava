package JAVA.Exceptions;

import exception.Save;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Created by ivnytska on 2/12/2016.
 * <p>
 * Реализовать интерфейс Save (смотри приатаченый файл learn-1.0-SNAPSHOT.jar) в котором есть только один метод save
 * предназначенный для сохранения строки в файл, который принимает два параметра: первый параметр - это стринга/текст
 * что будет сохранятся, второй параметр - это абсолютный путь к файлу в который будет сохранятся.
 * Если файл с таким именем не существует то его нужно будет создать.
 * Если файл с таким именем существует то выбросить исключение.
 */
public class FileSaver implements Save {
    public void save(String text, String file) {
        if (new File(file).exists()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Такой файл уже существует!");
            }
        } else {
            File f = new File(file);
            System.out.println("Новый файл создан, данные в него записаны!");
        }
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(text);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }