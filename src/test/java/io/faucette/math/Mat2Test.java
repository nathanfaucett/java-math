package io.faucette.math;


import static org.junit.Assert.*;
import org.junit.*;


public class Mat2Test {
    @Test
    public void testNewMat2() {
        Mat2 m = new Mat2();
        assertEquals(m, new Mat2());
    }

    @Test
    public void testMul() {
        Mat2 a = new Mat2();
        Mat2 b = new Mat2();
        a.mul(b);
        assertEquals(a, b);
    }
    @Test
    public void testSMul() {
        Mat2 a = new Mat2();
        a.smul(10);
        assertEquals(a, new Mat2(
            10f, 0f,
            0f, 10f
        ));
    }
    @Test
    public void testInverse() {
        Mat2 a = new Mat2();
        a.inverse();
        assertEquals(a, new Mat2());
    }
    @Test
    public void testIdentity() {
        Mat2 a = new Mat2();
        a.identity();
        assertEquals(a, new Mat2());
    }

    @Test
    public void testSetRotation() {
        Mat2 m = new Mat2();

        m.setRotation((float) (Math.PI / 2));

        assertEquals(new Mat2(
            0f, -1f,
            1f, 0f
        ), m);
    }
    @Test
    public void testGetRotation() {
        Mat2 m = new Mat2();

        m.setRotation((float) (Math.PI / 2));
        assertEquals((float) (Math.PI / 2), m.getRotation(), Mathf.EPSILON);
    }

    @Test
    public void testRotate() {
        Mat2 m = new Mat2();

        m.rotate((float) (Math.PI / 2));
        assertEquals(new Mat2(
            0f, -1f,
            1f, 0f
        ), m);

        m.rotate((float) (Math.PI / 2));
        assertEquals(new Mat2(
            1f, 0f,
            0f, 1f
        ), m);
    }
    @Test
    public void testScale() {
        Mat2 m = new Mat2();

        m.scale(new Vec2(2, 2));
        assertEquals(new Mat2(
            2f, 0f,
            0f, 2f
        ), m);
    }

    @Test
    public void testToString() {
        assertEquals((
            "Mat2[1.0, 0.0,\n" +
            "     0.0, 1.0]"
        ), "" + new Mat2());
    }
}
