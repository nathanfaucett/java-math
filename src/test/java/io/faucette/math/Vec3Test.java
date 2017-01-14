package io.faucette.math;


import static org.junit.Assert.*;
import org.junit.*;


public class Vec3Test {

    @Test
    public void testNewVec3() {
        Vec3 v = new Vec3(10f, 10f, 10f);
        assertEquals(v.x, 10f, Mathf.EPSILON);
        assertEquals(v.y, 10f, Mathf.EPSILON);
        assertEquals(v.z, 10f, Mathf.EPSILON);
    }

    @Test
    public void testAdd() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        Vec3 b = new Vec3(1f, 1f, 1f);
        a.add(b);
        assertEquals(2f, a.x, Mathf.EPSILON);
        assertEquals(2f, a.y, Mathf.EPSILON);
        assertEquals(2f, a.z, Mathf.EPSILON);
    }
    @Test
    public void testSub() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        Vec3 b = new Vec3(1f, 1f, 1f);
        a.sub(b);
        assertEquals(0f, a.x, Mathf.EPSILON);
        assertEquals(0f, a.y, Mathf.EPSILON);
        assertEquals(0f, a.z, Mathf.EPSILON);
    }
    @Test
    public void testMul() {
        Vec3 a = new Vec3(2f, 2f, 2f);
        Vec3 b = new Vec3(2f, 2f, 2f);
        a.mul(b);
        assertEquals(4f, a.x, Mathf.EPSILON);
        assertEquals(4f, a.y, Mathf.EPSILON);
        assertEquals(4f, a.z, Mathf.EPSILON);
    }
    @Test
    public void testSMul() {
        Vec3 a = new Vec3(2f, 2f, 2f);
        a.smul(0.5f);
        assertEquals(1f, a.x, Mathf.EPSILON);
        assertEquals(1f, a.y, Mathf.EPSILON);
        assertEquals(1f, a.z, Mathf.EPSILON);
    }
    @Test
    public void testDiv() {
        Vec3 a = new Vec3(4f, 4f, 4f);
        Vec3 b = new Vec3(2f, 2f, 2f);
        a.div(b);
        assertEquals(2f, a.x, Mathf.EPSILON);
        assertEquals(2f, a.y, Mathf.EPSILON);
        assertEquals(2f, a.z, Mathf.EPSILON);
    }
    @Test
    public void testSDiv() {
        Vec3 a = new Vec3(2f, 2f, 2f);
        a.sdiv(2f);
        assertEquals(1f, a.x, Mathf.EPSILON);
        assertEquals(1f, a.y, Mathf.EPSILON);
        assertEquals(1f, a.z, Mathf.EPSILON);
    }

    @Test
    public void testDot() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        Vec3 b = new Vec3(1f, 1f, 1f);
        assertEquals(3f, a.dot(b), Mathf.EPSILON);
    }
    @Test
    public void testLength() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        assertEquals(Math.sqrt(3), a.length(), Mathf.EPSILON);
    }

    @Test
    public void testNormalize() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        float length = a.normalize();
        assertEquals(Math.sqrt(3), length, Mathf.EPSILON);
        assertEquals(1f / length, a.x, Mathf.EPSILON);
        assertEquals(1f / length, a.y, Mathf.EPSILON);
        assertEquals(1f / length, a.z, Mathf.EPSILON);
    }

    @Test
    public void testInverse() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        a.inverse();
        assertEquals(-1f, a.x, Mathf.EPSILON);
        assertEquals(-1f, a.y, Mathf.EPSILON);
        assertEquals(-1f, a.z, Mathf.EPSILON);
    }

    @Test
    public void testMin() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        a.min(new Vec3(-1f, -1f, -1f));
        assertEquals(new Vec3(-1f, -1f, -1f), a);
    }
    @Test
    public void testMax() {
        Vec3 a = new Vec3(1f, 1f, 1f);
        a.max(new Vec3(-1f, -1f, -1f));
        assertEquals(new Vec3(1f, 1f, 1f), a);
    }

    @Test
    public void testTransformMat2() {
        Vec3 a = new Vec3(0f, 1f, 2f);
        Mat2 m = new Mat2();

        m.rotate((float) (Math.PI / 2));
        a.transform(m);

        Vec3 b = new Vec3(-1f, 0f, 2f);
        assertEquals(b, a);
    }
    @Test
    public void testTransformMat32() {
        Vec3 a = new Vec3(0f, 1f, 1f);
        Mat32 m = new Mat32();

        m.translate(new Vec3(-1f, 0f, 1f));
        m.rotate((float) (Math.PI / 2));
        a.transform(m);

        Vec3 b = new Vec3(-2f, 0f, 1f);
        assertEquals(b, a);
    }

    @Test
    public void testToString() {
        assertEquals("Vec3(0.0, 1.0, 2.0)", "" + new Vec3(0f, 1f, 2f));
    }
}
