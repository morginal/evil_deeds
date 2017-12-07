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
        Point p3 = new Point(7, 9);
        
        Assert.assertEquals(p1.distance(p2), 3.605551275463989);
        Assert.assertEquals(p1.distance(p3), 4.242640687119285);
        Assert.assertNotEquals(p1.distance(p2), 3.605551275463980);
        Assert.assertFalse(Boolean.valueOf(String.valueOf(p2.distance(p2))));
    }
}
