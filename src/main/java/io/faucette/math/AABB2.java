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

    public static AABB2 union(AABB2 out, AABB2 a, AABB2 b) {

        Vec2.min(out.min, a.min, b.min);
        Vec2.max(out.max, a.max, b.max);

        return out;
    }
    public AABB2 union(AABB2 other) { return AABB2.union(this, this, other); }

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

    public static Vec2 overlap(Vec2 out, AABB2 a, AABB2 b) {
        Vec2 amin = a.min;
        Vec2 bmin = b.min;
        Vec2 amax = a.max;
        Vec2 bmax = b.max;
        float nx;
        float ny;

        if ((amax.x + amin.x) * 0.5f > (bmax.x + bmin.x) * 0.5f) {
            nx = -1f;
        } else {
            nx = 1f;
        }

        if ((amax.y + amin.y) * 0.5f > (bmax.y + bmin.y) * 0.5f) {
            ny = -1f;
        } else {
            ny = 1f;
        }

        float dx0 = amax.x - bmin.x;
        float dx1 = bmax.x - amin.x;
        float dx = dx0;
        if (Math.abs(dx1) < Math.abs(dx0)) {
            dx = dx1;
        }

        float dy0 = amax.y - bmin.y;
        float dy1 = bmax.y - amin.y;
        float dy = dy0;
        if (Math.abs(dy1) < Math.abs(dy0)) {
            dy = dy1;
        }

        if (Math.abs(dx) < Math.abs(dy)) {
            dy = 0f;
        } else {
            dx = 0f;
        }

        out.x = dx * nx;
        out.y = dy * ny;

        return out;
    }
    public Vec2 overlap(Vec2 out, AABB2 other) {
        return AABB2.overlap(out, this, other);
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
