package ru.stqa.evil_deeds.sandbox;

public class MyFirstProgram
{
    public static void main(String[] args)
    {
        hello("world");
        hello("user");
        hello("Alexei");

        double l = 5;
        System.out.println("Square's area with side length " + l + " = " + area(l));

        double a = 4;
        double b = 6;
        System.out.println("Rectangle's area with sides lengths " + a + " and " + b + " = " + area(a, b));
    }

    public static void hello(String somebody)
    {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double area(double len)
    {
        return len * len;
    }

    public static double area(double a, double b)
    {
        return a * b;
    }
}