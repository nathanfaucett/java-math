package io.faucette.math;


import static org.junit.Assert.*;
import org.junit.*;


public class MathfTest {
    @Test
    public void testEquals() {
        assertTrue(Mathf.equals(1d, Math.PI / Math.PI));
        assertTrue(Mathf.equals(1f, Math.PI / Math.PI));
    }

    @Test
    public void testClosestPOT() {
        assertEquals(4, Mathf.closestPOT(3));
        assertEquals(16, Mathf.closestPOT(10));
        assertEquals(1024, Mathf.closestPOT(900));
    }

    @Test
    public void testIsPOT() {
        assertTrue(Mathf.isPOT(2));
        assertTrue(Mathf.isPOT(16));
        assertTrue(Mathf.isPOT(1024));
        assertTrue(Mathf.isPOT(4294967296l));

        assertTrue(!Mathf.isPOT(3));
        assertTrue(!Mathf.isPOT(17));
        assertTrue(!Mathf.isPOT(1025));
        assertTrue(!Mathf.isPOT(4294967295l));
    }

    @Test
    public void testDirectionRadian() {
        assertEquals(Mathf.Direction.RIGHT, Mathf.directionRadian(0d));
        assertEquals(Mathf.Direction.UP_RIGHT, Mathf.directionRadian(Math.PI / 4d));
        assertEquals(Mathf.Direction.UP, Mathf.directionRadian(Math.PI / 2d));
        assertEquals(Mathf.Direction.UP_LEFT, Mathf.directionRadian(Math.PI * (3d/4d)));
        assertEquals(Mathf.Direction.LEFT, Mathf.directionRadian(Math.PI));
        assertEquals(Mathf.Direction.LEFT, Mathf.directionRadian(-Math.PI));
        assertEquals(Mathf.Direction.DOWN_LEFT, Mathf.directionRadian(Math.PI * (5d/4d)));
        assertEquals(Mathf.Direction.DOWN, Mathf.directionRadian(Math.PI * (3d/2d)));
        assertEquals(Mathf.Direction.DOWN_RIGHT, Mathf.directionRadian(Math.PI * (7d/4d)));
    }
}
