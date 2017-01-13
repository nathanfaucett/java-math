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
        assertEquals(Mathf.directionRadian(0d), Mathf.Direction.RIGHT);
        assertEquals(Mathf.directionRadian(Math.PI / 4d), Mathf.Direction.UP_RIGHT);
        assertEquals(Mathf.directionRadian(Math.PI / 2d), Mathf.Direction.UP);
        assertEquals(Mathf.directionRadian(Math.PI * (3d/4d)), Mathf.Direction.UP_LEFT);
        assertEquals(Mathf.directionRadian(Math.PI), Mathf.Direction.LEFT);
        assertEquals(Mathf.directionRadian(-Math.PI), Mathf.Direction.LEFT);
        assertEquals(Mathf.directionRadian(Math.PI * (5d/4d)), Mathf.Direction.DOWN_LEFT);
        assertEquals(Mathf.directionRadian(Math.PI * (3d/2d)), Mathf.Direction.DOWN);
        assertEquals(Mathf.directionRadian(Math.PI * (7d/4d)), Mathf.Direction.DOWN_RIGHT);
    }
}
