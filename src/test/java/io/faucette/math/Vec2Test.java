package io.faucette.math;


import static org.junit.Assert.*;
import org.junit.*;


public class Vec2Test {

    @Test
    public void testNewVec2() {
        Vec2 v = new Vec2(10f, 10f);
        assertEquals(v.x, 10f, Mathf.EPSILON);
        assertEquals(v.y, 10f, Mathf.EPSILON);
    }

    @Test
    public void testAdd() {
        Vec2 a = new Vec2(1f, 1f);
        Vec2 b = new Vec2(1f, 1f);
        a.add(b);
        assertEquals(2f, a.x, Mathf.EPSILON);
        assertEquals(2f, a.y, Mathf.EPSILON);
    }
    @Test
    public void testSub() {
        Vec2 a = new Vec2(1f, 1f);
        Vec2 b = new Vec2(1f, 1f);
        a.sub(b);
        assertEquals(0f, a.x, Mathf.EPSILON);
        assertEquals(0f, a.y, Mathf.EPSILON);
    }
    @Test
    public void testMul() {
        Vec2 a = new Vec2(2f, 2f);
        Vec2 b = new Vec2(2f, 2f);
        a.mul(b);
        assertEquals(4f, a.x, Mathf.EPSILON);
        assertEquals(4f, a.y, Mathf.EPSILON);
    }
    @Test
    public void testSMul() {
        Vec2 a = new Vec2(2f, 2f);
        a.smul(0.5f);
        assertEquals(1f, a.x, Mathf.EPSILON);
        assertEquals(1f, a.y, Mathf.EPSILON);
    }
    @Test
    public void testDiv() {
        Vec2 a = new Vec2(4f, 4f);
        Vec2 b = new Vec2(2f, 2f);
        a.div(b);
        assertEquals(2f, a.x, Mathf.EPSILON);
        assertEquals(2f, a.y, Mathf.EPSILON);
    }
    @Test
    public void testSDiv() {
        Vec2 a = new Vec2(2f, 2f);
        a.sdiv(2f);
        assertEquals(1f, a.x, Mathf.EPSILON);
        assertEquals(1f, a.y, Mathf.EPSILON);
    }

    @Test
    public void testDot() {
        Vec2 a = new Vec2(1f, 1f);
        Vec2 b = new Vec2(1f, 1f);
        assertEquals(2f, a.dot(b), Mathf.EPSILON);
    }
    @Test
    public void testLength() {
        Vec2 a = new Vec2(1f, 1f);
        assertEquals(Math.sqrt(2), a.length(), Mathf.EPSILON);
    }

    @Test
    public void testNormalize() {
        Vec2 a = new Vec2(1f, 1f);
        float length = a.normalize();
        assertEquals(Math.sqrt(2), length, Mathf.EPSILON);
        assertEquals(1f / length, a.x, Mathf.EPSILON);
        assertEquals(1f / length, a.y, Mathf.EPSILON);
    }

    @Test
    public void testInverse() {
        Vec2 a = new Vec2(1f, 1f);
        a.inverse();
        assertEquals(-1f, a.x, Mathf.EPSILON);
        assertEquals(-1f, a.y, Mathf.EPSILON);
    }

    @Test
    public void testMin() {
        Vec2 a = new Vec2(1f, 1f);
        a.min(new Vec2(-1f, -1f));
        assertEquals(new Vec2(-1f, -1f), a);
    }
    @Test
    public void testMax() {
        Vec2 a = new Vec2(1f, 1f);
        a.max(new Vec2(-1f, -1f));
        assertEquals(new Vec2(1f, 1f), a);
    }

    @Test
    public void testAngle() {
        Vec2 a = new Vec2(0f, 1f);
        Vec2 b = new Vec2(-1f, 0f);
        float angle = a.angle(b);
        assertEquals(Math.PI / 2, angle, Mathf.EPSILON);
    }

    @Test
    public void testTransformAngle() {
        Vec2 a = new Vec2(0f, 1f);
        a.transform((float) (Math.PI / 2));

        Vec2 b = new Vec2(-1f, 0f);
        assertEquals(b, a);
    }
    @Test
    public void testTransformMat2() {
        Vec2 a = new Vec2(0f, 1f);
        Mat2 m = new Mat2();

        m.rotate((float) (Math.PI / 2));
        a.transform(m);

        Vec2 b = new Vec2(-1f, 0f);
        assertEquals(b, a);
    }
    @Test
    public void testTransformMat32() {
        Vec2 a = new Vec2(0f, 1f);
        Mat32 m = new Mat32();

        m.translate(new Vec2(-1f, 0f));
        m.rotate((float) (Math.PI / 2));
        a.transform(m);

        Vec2 b = new Vec2(-2f, 0f);
        assertEquals(b, a);
    }

    @Test
    public void testToString() {
        assertEquals("Vec2(0.0, 1.0)", "" + new Vec2(0f, 1f));
    }
}
