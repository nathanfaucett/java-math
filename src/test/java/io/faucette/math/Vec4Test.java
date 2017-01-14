package io.faucette.math;


import static org.junit.Assert.*;
import org.junit.*;


public class Vec4Test {

    @Test
    public void testNewVec4() {
        Vec4 v = new Vec4(10f, 10f, 10f, 10f);
        assertEquals(v.x, 10f, Mathf.EPSILON);
        assertEquals(v.y, 10f, Mathf.EPSILON);
        assertEquals(v.z, 10f, Mathf.EPSILON);
        assertEquals(v.w, 10f, Mathf.EPSILON);
    }

    @Test
    public void testAdd() {
        Vec4 a = new Vec4(1f, 1f, 1f, 1f);
        Vec4 b = new Vec4(1f, 1f, 1f, 1f);
        a.add(b);
        assertEquals(2f, a.x, Mathf.EPSILON);
        assertEquals(2f, a.y, Mathf.EPSILON);
        assertEquals(2f, a.z, Mathf.EPSILON);
        assertEquals(2f, a.w, Mathf.EPSILON);
    }
    @Test
    public void testSub() {
        Vec4 a = new Vec4(1f, 1f, 1f, 1f);
        Vec4 b = new Vec4(1f, 1f, 1f, 1f);
        a.sub(b);
        assertEquals(0f, a.x, Mathf.EPSILON);
        assertEquals(0f, a.y, Mathf.EPSILON);
        assertEquals(0f, a.z, Mathf.EPSILON);
        assertEquals(0f, a.w, Mathf.EPSILON);
    }
    @Test
    public void testMul() {
        Vec4 a = new Vec4(2f, 2f, 2f, 2f);
        Vec4 b = new Vec4(2f, 2f, 2f, 2f);
        a.mul(b);
        assertEquals(4f, a.x, Mathf.EPSILON);
        assertEquals(4f, a.y, Mathf.EPSILON);
        assertEquals(4f, a.z, Mathf.EPSILON);
        assertEquals(4f, a.w, Mathf.EPSILON);
    }
    @Test
    public void testSMul() {
        Vec4 a = new Vec4(2f, 2f, 2f, 2f);
        a.smul(0.5f);
        assertEquals(1f, a.x, Mathf.EPSILON);
        assertEquals(1f, a.y, Mathf.EPSILON);
        assertEquals(1f, a.z, Mathf.EPSILON);
        assertEquals(1f, a.w, Mathf.EPSILON);
    }
    @Test
    public void testDiv() {
        Vec4 a = new Vec4(4f, 4f, 4f, 4f);
        Vec4 b = new Vec4(2f, 2f, 2f, 2f);
        a.div(b);
        assertEquals(2f, a.x, Mathf.EPSILON);
        assertEquals(2f, a.y, Mathf.EPSILON);
        assertEquals(2f, a.z, Mathf.EPSILON);
        assertEquals(2f, a.w, Mathf.EPSILON);
    }
    @Test
    public void testSDiv() {
        Vec4 a = new Vec4(2f, 2f, 2f, 2f);
        a.sdiv(2f);
        assertEquals(1f, a.x, Mathf.EPSILON);
        assertEquals(1f, a.y, Mathf.EPSILON);
        assertEquals(1f, a.z, Mathf.EPSILON);
        assertEquals(1f, a.w, Mathf.EPSILON);
    }

    @Test
    public void testDot() {
        Vec4 a = new Vec4(1f, 1f, 1f, 1f);
        Vec4 b = new Vec4(1f, 1f, 1f, 1f);
        assertEquals(4f, a.dot(b), Mathf.EPSILON);
    }
    @Test
    public void testLength() {
        Vec4 a = new Vec4(1f, 1f, 1f, 1f);
        assertEquals(Math.sqrt(4), a.length(), Mathf.EPSILON);
    }

    @Test
    public void testNormalize() {
        Vec4 a = new Vec4(1f, 1f, 1f, 1f);
        float length = a.normalize();
        assertEquals(Math.sqrt(4), length, Mathf.EPSILON);
        assertEquals(1f / length, a.x, Mathf.EPSILON);
        assertEquals(1f / length, a.y, Mathf.EPSILON);
        assertEquals(1f / length, a.z, Mathf.EPSILON);
        assertEquals(1f / length, a.w, Mathf.EPSILON);
    }

    @Test
    public void testInverse() {
        Vec4 a = new Vec4(1f, 1f, 1f, 1f);
        a.inverse();
        assertEquals(-1f, a.x, Mathf.EPSILON);
        assertEquals(-1f, a.y, Mathf.EPSILON);
        assertEquals(-1f, a.z, Mathf.EPSILON);
        assertEquals(-1f, a.w, Mathf.EPSILON);
    }

    @Test
    public void testMin() {
        Vec4 a = new Vec4();
        a.min(new Vec4(1f, 1f, 1f, 1f), new Vec4(-1f, -1f, -1f, -1f));
        assertEquals(new Vec4(-1f, -1f, -1f, -1f), a);
    }
    @Test
    public void testMax() {
        Vec4 a = new Vec4();
        a.max(new Vec4(1f, 1f, 1f, 1f), new Vec4(-1f, -1f, -1f, -1f));
        assertEquals(new Vec4(1f, 1f, 1f, 1f), a);
    }

    @Test
    public void testTransformMat2() {
        Vec4 a = new Vec4(0f, 1f, 2f, 3f);
        Mat2 m = new Mat2();

        m.rotate((float) (Math.PI / 2));
        a.transform(m);

        Vec4 b = new Vec4(-1f, 0f, 2f, 3f);
        assertEquals(b, a);
    }
    @Test
    public void testTransformMat32() {
        Vec4 a = new Vec4(0f, 1f, 2f, 3f);
        Mat32 m = new Mat32();

        m.translate(new Vec4(-1f, 0f, 0f, 0f));
        m.rotate((float) (Math.PI / 2));
        a.transform(m);

        Vec4 b = new Vec4(-2f, 0f, 2f, 3f);
        assertEquals(b, a);
    }

    @Test
    public void testToString() {
        assertEquals("Vec4(0.0, 1.0, 2.0, 3.0)", "" + new Vec4(0f, 1f, 2f, 3f));
    }
}
