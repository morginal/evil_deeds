package ru.stqa.evil_deeds.sandbox;

public class MyFirstProgram
{
    public static void main(String[] args)
    {
//        hello("world");
//        hello("user");
//        hello("Alexei");

        Square s = new Square(5);
        System.out.println("Square's area with side " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Rectangle's area with sides " + r.a + " and " + r.b + " = " + s.area());

        Point p1 = new Point(4, 6);
        Point p2 = new Point(2, 3);

        System.out.println(distance(p1, p2));
        System.out.println(p1.distance(p2));

    }

    public static void hello(String somebody)
    {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double distance(Point p1, Point p2)
    {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }
}
