package JAVA.StringsOOP;

/**
 * Created by ivnytska on 2/9/2016.
 * Базовый абстрактный класс
 */

public abstract class Writer {
    protected abstract void write(StringBuilder stringBuilder);

    protected abstract void erase(StringBuilder stringBuilder);

    protected double rest;

    public abstract double getRest();

}
