package io.faucette.math;


import static org.junit.Assert.*;
import org.junit.*;


public class Mat32Test {
    @Test
    public void testNewMat32() {
        Mat32 m = new Mat32();
        assertEquals(m, new Mat32());
    }

    @Test
    public void testMul() {
        Mat32 a = new Mat32();
        Mat32 b = new Mat32();
        a.mul(b);
        assertEquals(a, b);
    }
    @Test
    public void testSMul() {
        Mat32 a = new Mat32();
        a.smul(10);
        assertEquals(a, new Mat32(
            10f, 0f, 0f,
            0f, 10f, 0f
        ));
    }
    @Test
    public void testInverse() {
        Mat32 a = new Mat32();
        a.inverse();
        assertEquals(a, new Mat32());
    }
    @Test
    public void testIdentity() {
        Mat32 a = new Mat32();
        a.identity();
        assertEquals(a, new Mat32());
    }

    @Test
    public void testSetRotation() {
        Mat32 m = new Mat32();

        m.setRotation((float) (Math.PI / 2));

        assertEquals(new Mat32(
            0f, -1f, 0f,
            1f, 0f, 0f
        ), m);
    }
    @Test
    public void testGetRotation() {
        Mat32 m = new Mat32();

        m.setRotation((float) (Math.PI / 2));
        assertEquals((float) (Math.PI / 2), m.getRotation(), Mathf.EPSILON);
    }

    @Test
    public void testTranslate() {
        Mat32 m = new Mat32();

        m.translate(new Vec2(2f, 2f));
        assertEquals(new Mat32(
            1f, 0f, 2f,
            0f, 1f, 2f
        ), m);
    }
    @Test
    public void testRotate() {
        Mat32 m = new Mat32();

        m.rotate((float) (Math.PI / 2));
        assertEquals(new Mat32(
            0f, -1f, 0f,
            1f, 0f, 0f
        ), m);

        m.rotate((float) (Math.PI / 2));
        assertEquals(new Mat32(
            1f, 0f, 0f,
            0f, 1f, 0f
        ), m);
    }
    @Test
    public void testScale() {
        Mat32 m = new Mat32();

        m.scale(new Vec2(2, 2));
        assertEquals(new Mat32(
            2f, 0f, 0f,
            0f, 2f, 0f
        ), m);
    }

    @Test
    public void testOrthographic() {
        Mat32 m = new Mat32();

        m.orthographic(1, 1, -1, -1);
        assertEquals(new Mat32(
            1f, 0f, 0f,
            0f, 1f, 0f
        ), m);
    }

    @Test
    public void testToString() {
        assertEquals((
            "Mat32[1.0, 0.0, 0.0,\n" +
            "     0.0, 1.0, 0.0]"
        ), "" + new Mat32());
    }
}
