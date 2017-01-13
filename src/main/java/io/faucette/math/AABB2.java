package io.faucette.math;


public class AABB2 {
    public Vec2 min;
    public Vec2 max;


    public AABB2(Vec2 min, Vec2 max) {
        this.min = min;
        this.max = max;
    }

    public AABB2() {
        this(
            new Vec2(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
            new Vec2(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY)
        );
    }

    public static AABB2 clear(AABB2 out) {
        out.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        out.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        return out;
    }
    public AABB2 clear() { return AABB2.clear(this); }

    public static AABB2 copy(AABB2 out, AABB2 other) {
        out.min.copy(other.min);
        out.max.copy(other.max);
        return out;
    }
    public AABB2 copy(AABB2 other) { return AABB2.copy(this, other); }

    public static boolean contains(AABB2 out, Vec2 point) {
        return !(
            point.x < out.min.x || point.x > out.max.x ||
            point.y < out.min.y || point.y > out.max.y
        );
    }
    public boolean contains(Vec2 point) { return AABB2.contains(this, point); }

    public static boolean intersects(AABB2 a, AABB2 b) {
        return !(
            b.max.x < a.min.x || b.min.x > a.max.x ||
            b.max.y < a.min.y || b.min.y > a.max.y
        );
    }
    public boolean intersects(AABB2 other) { return AABB2.intersects(this, other); }

    public static AABB2 fromCenterSize(AABB2 out, Vec2 center, Vec2 size) {
        float hx = size.x * 0.5f;
        float hy = size.y * 0.5f;

        out.min.x = center.x - hx;
        out.min.y = center.y - hy;
        out.max.x = center.x + hx;
        out.max.y = center.y + hy;

        return out;
    }
    public AABB2 fromCenterSize(Vec2 center, Vec2 size) {
        return AABB2.fromCenterSize(this, center, size);
    }

    public static boolean equals(AABB2 a, AABB2 b) {
        return !(
            !Vec2.equals(a.min, b.min) ||
            !Vec2.equals(a.max, b.max)
        );
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof AABB2) {
            return AABB2.equals(this, (AABB2) other);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return (
            "AABB2(" + min.toString() + ", " + max.toString() + ")"
        );
    }
}
