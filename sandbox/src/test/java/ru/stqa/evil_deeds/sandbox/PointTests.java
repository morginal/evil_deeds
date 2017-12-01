package ru.stqa.evil_deeds.sandbox;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests
{
    @Test
    public void testDistance()
    {
        Point p1 = new Point(4, 6);
        Point p2 = new Point(2, 3);
        Assert.assertEquals(p1.distance(p1, p2), 3.605551275463989);

        Point p3 = new Point(1, 2);
        Point p4 = new Point(7, 9);
        Assert.assertEquals(p1.distance(p3, p4), 9.219544457292887);

        Point p5 = new Point(4, 6);
        Point p6 = new Point(2, 3);

        Assert.assertFalse(Boolean.valueOf(String.valueOf(p2.distance(p5, p6))));
        Assert.assertNotEquals(p1.distance(p5, p6), 3.605551275463980);
    }
}
