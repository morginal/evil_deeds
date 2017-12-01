package ru.stqa.evil_deeds.sandbox;

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
    }
}
