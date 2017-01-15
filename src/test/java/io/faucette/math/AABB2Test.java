package io.faucette.math;


import static org.junit.Assert.*;
import org.junit.*;


public class AABB2Test {
    @Test
    public void testNewAABB2() {
        AABB2 a = new AABB2();
        assertEquals(Float.POSITIVE_INFINITY, a.min.x, Mathf.EPSILON);
        assertEquals(Float.POSITIVE_INFINITY, a.min.y, Mathf.EPSILON);
        assertEquals(Float.NEGATIVE_INFINITY, a.max.x, Mathf.EPSILON);
        assertEquals(Float.NEGATIVE_INFINITY, a.max.y, Mathf.EPSILON);
    }

    @Test
    public void testClear() {
        AABB2 a = new AABB2(new Vec2(0f, 0f), new Vec2(0f, 0f));
        a.clear();
        assertEquals(Float.POSITIVE_INFINITY, a.min.x, Mathf.EPSILON);
        assertEquals(Float.POSITIVE_INFINITY, a.min.y, Mathf.EPSILON);
        assertEquals(Float.NEGATIVE_INFINITY, a.max.x, Mathf.EPSILON);
        assertEquals(Float.NEGATIVE_INFINITY, a.max.y, Mathf.EPSILON);
    }

    @Test
    public void testContains() {
        AABB2 a = new AABB2(new Vec2(-1f, -1f), new Vec2(1f, 1f));

        assertTrue(a.contains(new Vec2(1f, 1f)));
        assertTrue(a.contains(new Vec2(-1f, -1f)));
        assertTrue(a.contains(new Vec2(0f, 0f)));

        assertTrue(!a.contains(new Vec2(2f, 2f)));
        assertTrue(!a.contains(new Vec2(-2f, -2f)));
    }
    @Test
    public void testIntersects() {
        AABB2 a = new AABB2(new Vec2(0f, 0f), new Vec2(1f, 1f));
        AABB2 b = new AABB2(new Vec2(0.5f, 0.5f), new Vec2(1.5f, 1.5f));
        AABB2 c = new AABB2(new Vec2(1f, 1f), new Vec2(2f, 2f));
        AABB2 d = new AABB2(new Vec2(1.5f, 1.5f), new Vec2(2.5f, 2.5f));

        assertTrue(a.intersects(b));
        assertTrue(a.intersects(c));
        assertTrue(b.intersects(c));
        assertTrue(b.intersects(d));
        assertTrue(c.intersects(d));

        assertTrue(!a.intersects(d));
    }

    @Test
    public void testFromCenterSize() {
        AABB2 a = new AABB2();
        a.fromCenterSize(new Vec2(0f, 0f), new Vec2(2f, 2f));
        assertEquals(new Vec2(-1f, -1f), a.min);
        assertEquals(new Vec2(1f, 1f), a.max);
    }

    @Test
    public void testOverlap() {
        AABB2 a = new AABB2();
        AABB2 b = new AABB2();
        Vec2 out = new Vec2();

        a.fromCenterSize(new Vec2(0f, 0f), new Vec2(2f, 2f));

        b.fromCenterSize(new Vec2(1f, 0f), new Vec2(2f, 2f));
        a.overlap(out, b);
        assertEquals(new Vec2(1f, 0f), out);

        b.fromCenterSize(new Vec2(-1f, 0f), new Vec2(2f, 2f));
        a.overlap(out, b);
        assertEquals(new Vec2(-1f, 0f), out);

        b.fromCenterSize(new Vec2(0f, 1f), new Vec2(2f, 2f));
        a.overlap(out, b);
        assertEquals(new Vec2(0f, 1f), out);

        b.fromCenterSize(new Vec2(0f, -1f), new Vec2(2f, 2f));
        a.overlap(out, b);
        assertEquals(new Vec2(0f, -1f), out);
    }

    @Test
    public void testToString() {
        assertEquals("AABB2(Vec2(Infinity, Infinity), Vec2(-Infinity, -Infinity))", "" + new AABB2());
    }
}
